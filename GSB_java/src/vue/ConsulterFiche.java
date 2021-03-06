package vue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import com.metier.Region;
import com.metier.Visiteur;
import com.persistance.AccesData;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;

import layout.SpringUtilities;
import modele.ModeleVisiteur;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ConsulterFiche extends JPanel
{
	private JComboBox comboBoxRegion;
	private JLabel lblRegion;
	private JLabel lblNomPrenom;
	private JComboBox comboBoxNomPrenom;
	private JLabel lblIdentifiant;
	private JComboBox comboBoxIdentifiant;
	private JLabel lblRecherchePar;
	private List<Visiteur> utils;
	private List<Region> regions;
	private JButton buttonOkRegion;
	private JFrame frame;
	private JButton buttonOkNp;
	private JButton buttonOkId;
	private ModeleVisiteur modeleUtil;
	private List<Visiteur> VisiteurByRegion;
	private JTable table;
	private JOptionPane optionPane;
	private JDialog dialog;
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

		if (edit != true)
		{
		    lblRecherchePar = new JLabel("Recherche pour consultation");
		}
		else
		{
		    lblRecherchePar = new JLabel("Recherche pour modification");
		}
		lblRecherchePar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRecherchePar.setBounds(22, 0, 500, 30);
		add(lblRecherchePar);

		buttonOkRegion = new JButton("OK");
		buttonOkRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisiteurByRegion = AccesData.getVisiteurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
				modeleUtil = new ModeleVisiteur(VisiteurByRegion);
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
				table =(JTable) me.getSource();
				Point p = me.getPoint();
				int row = table.rowAtPoint(p);
				if (me.getClickCount() == 2) 
				{
					final Visiteur visiteur = VisiteurByRegion.get(row);
					//Create and populate the panel.
					final ConsultModifVisiteur p1 = new ConsultModifVisiteur(visiteur,edit);


					int suppr = -1;
	                if (edit == true)
	                {
	                    Object[] options = { "Modifier", "Annuler" };
	                    suppr = JOptionPane.showOptionDialog(null, p1, "Modifier un visiteur",
	                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	                            null, options, options[0]);
	                }
	                else
	                {
	                    Object[] options = { "OK" };
	                    suppr = JOptionPane.showOptionDialog(null, p1, "Consulter un visiteur",
	                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	                            null, options, options[0]);
	                }
	                if (suppr == 0 && edit == true)
	                {
	                    int confirm = JOptionPane.showConfirmDialog(null,
	                            "Etes vous sur de vouloir modifier ce visiteur", "Modifier visiteur", JOptionPane.YES_NO_OPTION);
	                    if (confirm == 0)
	                    {
	                        if(p1.getNom().equals("") || p1.getPrenom().equals("") || p1.getAdresse().equals("") || p1.getVille()==null || p1.getDateEmbauche() == null || p1.getRegion()== null || p1.getRegion() == null || p1.getDepartement() == null)
	                        {
	                            JOptionPane.showMessageDialog(frame, "Probleme lors de la saisie veuillez reverifie les information saisies.");
	                        }
	                        else
	                        {
	                            visiteur.setNomVisiteur(p1.getNom());
	                            visiteur.setPrenomVisiteur(p1.getPrenom());
	                            visiteur.setNumPort(p1.getPortable());
	                            visiteur.setNumFixe(p1.getFixe());
	                            visiteur.setAdressseRue(p1.getAdresse());
	                            visiteur.setVille(p1.getVille());
	                            visiteur.setCp(p1.getCp());
	                            visiteur.setDateEmbauche(p1.getDateEmbauche());
	                            visiteur.setRegion(p1.getRegion());
	                            visiteur.setDepartement(p1.getDepartement());
	                            AccesData.updateVisiteur(visiteur);
	                            VisiteurByRegion = AccesData.getVisiteurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
	                            modeleUtil = new ModeleVisiteur(VisiteurByRegion);
	                            table.setModel(modeleUtil);
	                            table.revalidate();
	                            remplirJCombo();
	                            JOptionPane.showMessageDialog(frame, "La mise a jour a bien ete effectues.");
	                        }
	                    }
	                }
				}
			}
		});

		buttonOkNp.addActionListener(new ActionListener(){

			private Object[] eventCache;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Visiteur visiteur = utils.get(comboBoxNomPrenom.getSelectedIndex());
				//Create and populate the panel.
				final ConsultModifVisiteur p1 = new ConsultModifVisiteur(visiteur,edit);
				int suppr = -1;
				if (edit == true)
				{
				    Object[] options = { "Modifier", "Annuler" };
				    suppr = JOptionPane.showOptionDialog(null, p1, "Modifier un visiteur",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
			                null, options, options[0]);
				}
				else
				{
				    Object[] options = { "OK" };
				    suppr = JOptionPane.showOptionDialog(null, p1, "Consulter un visiteur",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
				}
				if (suppr == 0 && edit == true)
                {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Etes vous sur de vouloir modifier ce visiteur", "Modifier visiteur", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0)
                    {
                        if(p1.getNom().equals("") || p1.getPrenom().equals("") || p1.getAdresse().equals("") || p1.getVille()==null || p1.getDateEmbauche() == null || p1.getRegion()== null || p1.getRegion() == null || p1.getDepartement() == null)
                        {
                            JOptionPane.showMessageDialog(frame, "Probleme lors de la saisie veuillez reverifie les information saisies.");
                        }
                        else
                        {
                            visiteur.setNomVisiteur(p1.getNom());
                            visiteur.setPrenomVisiteur(p1.getPrenom());
                            visiteur.setNumPort(p1.getPortable());
                            visiteur.setNumFixe(p1.getFixe());
                            visiteur.setAdressseRue(p1.getAdresse());
                            visiteur.setVille(p1.getVille());
                            visiteur.setCp(p1.getCp());
                            visiteur.setDateEmbauche(p1.getDateEmbauche());
                            visiteur.setRegion(p1.getRegion());
                            visiteur.setDepartement(p1.getDepartement());
                            AccesData.updateVisiteur(visiteur);
                            VisiteurByRegion = AccesData.getVisiteurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
                            modeleUtil = new ModeleVisiteur(VisiteurByRegion);
                            table.setModel(modeleUtil);
                            table.revalidate();
                            remplirJCombo();
                            JOptionPane.showMessageDialog(frame, "La mise a jour a bien ete effectues.");
                        }
                    }
                }
			}

		});

		buttonOkId.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				final Visiteur visiteur = utils.get(comboBoxIdentifiant.getSelectedIndex());
				System.out.println(visiteur);
				//Create and populate the panel.
				final ConsultModifVisiteur p1 = new ConsultModifVisiteur(visiteur,edit);

				int suppr = -1;
                if (edit == true)
                {
                    Object[] options = { "Modifier", "Annuler" };
                    suppr = JOptionPane.showOptionDialog(null, p1, "Modifier un visiteur",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                else
                {
                    Object[] options = { "OK" };
                    suppr = JOptionPane.showOptionDialog(null, p1, "Consulter un visiteur",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                if (suppr == 0 && edit == true)
                {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "Etes vous sur de vouloir modifier ce visiteur", "Modifier visiteur", JOptionPane.YES_NO_OPTION);
                    if (confirm == 0)
                    {
                        if(p1.getNom().equals("") || p1.getPrenom().equals("") || p1.getAdresse().equals("") || p1.getVille()==null || p1.getDateEmbauche() == null || p1.getRegion()== null || p1.getRegion() == null || p1.getDepartement() == null)
                        {
                            JOptionPane.showMessageDialog(frame, "Probleme lors de la saisie veuillez reverifie les information saisies.");
                        }
                        else
                        {
                            visiteur.setNomVisiteur(p1.getNom());
                            visiteur.setPrenomVisiteur(p1.getPrenom());
                            visiteur.setNumPort(p1.getPortable());
                            visiteur.setNumFixe(p1.getFixe());
                            visiteur.setAdressseRue(p1.getAdresse());
                            visiteur.setVille(p1.getVille());
                            visiteur.setCp(p1.getCp());
                            visiteur.setDateEmbauche(p1.getDateEmbauche());
                            visiteur.setRegion(p1.getRegion());
                            visiteur.setDepartement(p1.getDepartement());
                            AccesData.updateVisiteur(visiteur);
                            VisiteurByRegion = AccesData.getVisiteurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
                            modeleUtil = new ModeleVisiteur(VisiteurByRegion);
                            table.setModel(modeleUtil);
                            table.revalidate();
                            remplirJCombo();
                            JOptionPane.showMessageDialog(frame, "La mise a jour a bien ete effectues.");
                        }
                    }
                }
			}

		});
	}
	private void remplirJCombo()
	{
		comboBoxRegion.removeAllItems();
		comboBoxNomPrenom.removeAllItems();
		comboBoxIdentifiant.removeAllItems();
		regions = AccesData.getListRegion();
		for (Region r:regions)
		{
			comboBoxRegion.addItem(r.getLibelleRegion());
		}
		comboBoxRegion.setSelectedIndex(0);
		utils = AccesData.getListVisiteur();
		for (Visiteur u:utils)
		{
			comboBoxNomPrenom.addItem(u.getNomVisiteur()+" "+u.getPrenomVisiteur());
			comboBoxIdentifiant.addItem(u.getIdVisiteur());
		}
		comboBoxNomPrenom.setSelectedIndex(0);
		comboBoxIdentifiant.setSelectedIndex(0);
	}
}
