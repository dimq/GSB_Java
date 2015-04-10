package vue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.metier.Region;
import com.metier.Utilisateur;
import com.persistance.AccesData;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;

import layout.SpringUtilities;
import modele.ModeleUtilisateur;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ConsulterFiche extends JPanel
{
	JComboBox comboBoxRegion;
	JLabel lblRegion;
	JLabel lblNomPrenom;
	JComboBox comboBoxNomPrenom;
	JLabel lblIdentifiant;
	JComboBox comboBoxIdentifiant;
	JLabel lblRecherchePar;
	List<Utilisateur> utils;
	List<Region> regions;
	JButton buttonOkRegion;
	JFrame frame;
	JButton buttonOkNp;
	JButton buttonOkId;
	private ModeleUtilisateur modeleUtil;
	List<Utilisateur> utilisateurByRegion;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ConsulterFiche(JFrame myFrame,final boolean edit)
	{
		setLayout(null);
		Border paneEdge = BorderFactory.createEmptyBorder(0, 10, 10, 10);

		comboBoxRegion = new JComboBox();
		comboBoxRegion.setEditable(true);
		comboBoxRegion.setBounds(10, 66, 119, 20);
		AutoCompleteDecorator.decorate(comboBoxRegion);
		add(comboBoxRegion);



		lblRegion = new JLabel("Par Region");
		lblRegion.setBounds(32, 41, 92, 14);
		add(lblRegion);

		lblNomPrenom = new JLabel("Par Nom Prenom");
		lblNomPrenom.setBounds(257, 41, 119, 14);
		add(lblNomPrenom);

		comboBoxNomPrenom = new JComboBox();
		comboBoxNomPrenom.setEditable(true);
		comboBoxNomPrenom.setBounds(222, 66, 166, 20);
		AutoCompleteDecorator.decorate(comboBoxNomPrenom);
		add(comboBoxNomPrenom);

		lblIdentifiant = new JLabel("Par Identifiant");
		lblIdentifiant.setBounds(507, 41, 92, 14);
		add(lblIdentifiant);

		comboBoxIdentifiant = new JComboBox();
		comboBoxIdentifiant.setEditable(true);
		comboBoxIdentifiant.setBounds(490, 66, 92, 20);
		AutoCompleteDecorator.decorate(comboBoxIdentifiant);
		add(comboBoxIdentifiant);

		lblRecherchePar = new JLabel("Recherche");
		lblRecherchePar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRecherchePar.setBounds(22, 0, 200, 30);
		add(lblRecherchePar);

		buttonOkRegion = new JButton("OK");
		buttonOkRegion.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				System.out.println(AccesData.getUtilisateurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion()));
				utilisateurByRegion = AccesData.getUtilisateurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
				modeleUtil = new ModeleUtilisateur(utilisateurByRegion);
				table.setModel(modeleUtil);
				table.revalidate();

			}
		});
		buttonOkRegion.setBounds(142, 65, 59, 23);
		add(buttonOkRegion);

		buttonOkNp = new JButton("OK");
		buttonOkNp.setBounds(399, 65, 59, 23);
		add(buttonOkNp);

		buttonOkId = new JButton("OK");
		buttonOkId.setBounds(603, 65, 59, 23);
		add(buttonOkId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 99, 582, 134);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		frame  = myFrame;
		remplirJCombo();


		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table =(JTable) me.getSource();
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if (me.getClickCount() == 2) {

					//Create and populate the panel.
					ConsultModifVisiteur p1 = new ConsultModifVisiteur(utilisateurByRegion.get(row),edit,regions);

					

					JOptionPane.showConfirmDialog(null, p1, "Consultation fiche visiteur",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		buttonOkNp.addActionListener(new ActionListener(){

			private Object[] eventCache;

            @Override
			public void actionPerformed(ActionEvent arg0) {
				//Create and populate the panel.
				ConsultModifVisiteur p1 = new ConsultModifVisiteur(utils.get(comboBoxNomPrenom.getSelectedIndex()),edit,regions);

				

				JOptionPane.showConfirmDialog(null, p1, "Consultation fiche visiteur",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
			}
			
		});
		
		buttonOkId.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Create and populate the panel.
				ConsultModifVisiteur p1 = new ConsultModifVisiteur(utils.get(comboBoxIdentifiant.getSelectedIndex()),edit,regions);

				

				JOptionPane.showConfirmDialog(null, p1, "Consultation fiche visiteur",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
			}
			
		});
	}
	private void remplirJCombo()
	{
		regions = AccesData.getListRegion();
		for (Region r:regions)
		{
			comboBoxRegion.addItem(r.getLibelleRegion());
		}
		utils = AccesData.getListUtilisateur();
		for (Utilisateur u:utils)
		{
			comboBoxNomPrenom.addItem(u.getNomUtilisateur()+" "+u.getPrenomUtilisateur());
			comboBoxIdentifiant.addItem(u.getIdUtilisateur());
		}
	}
}
