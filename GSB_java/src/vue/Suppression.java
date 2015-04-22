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

public class Suppression extends JPanel
{
	private JLabel lblNomPrenom;
	private JComboBox comboBoxNomPrenom;
	private JLabel lblIdentifiant;
	private JComboBox comboBoxIdentifiant;
	private JLabel lblRecherchePar;
	private List<Visiteur> utils;
	private List<Region> regions;
	private JFrame frame;
	private JButton buttonOkNp;
	private JButton buttonOkId;
	private ModeleVisiteur modeleUtil;
	private JOptionPane optionPane;
	private JDialog dialog;
	/**
	 * Create the panel.
	 */
	public Suppression(JFrame myFrame)
	{
		setLayout(null);
		Border paneEdge = BorderFactory.createEmptyBorder(0, 10, 10, 10);


		lblNomPrenom = new JLabel("Par Nom Prenom");
		lblNomPrenom.setBounds(32, 41, 119, 14);
		add(lblNomPrenom);

		comboBoxNomPrenom = new JComboBox();
		comboBoxNomPrenom.setEditable(true);
		comboBoxNomPrenom.setBounds(22, 66, 166, 20);
		AutoCompleteDecorator.decorate(comboBoxNomPrenom);
		add(comboBoxNomPrenom);

		lblIdentifiant = new JLabel("Par Identifiant");
		lblIdentifiant.setBounds(299, 41, 92, 14);
		add(lblIdentifiant);

		comboBoxIdentifiant = new JComboBox();
		comboBoxIdentifiant.setEditable(true);
		comboBoxIdentifiant.setBounds(299, 66, 92, 20);
		AutoCompleteDecorator.decorate(comboBoxIdentifiant);
		add(comboBoxIdentifiant);

		lblRecherchePar = new JLabel("Recherche");
		lblRecherchePar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRecherchePar.setBounds(22, 0, 200, 30);
		add(lblRecherchePar);

		buttonOkNp = new JButton("OK");
		buttonOkNp.setBounds(198, 65, 59, 23);
		add(buttonOkNp);

		buttonOkId = new JButton("OK");
		buttonOkId.setBounds(401, 65, 59, 23);
		add(buttonOkId);


		frame  = myFrame;
		remplirJCombo();


		buttonOkNp.addActionListener(new ActionListener(){

			private Object[] eventCache;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Visiteur visiteur = utils.get(comboBoxNomPrenom.getSelectedIndex());
				//Create and populate the panel.
				final ConsultModifVisiteur p1 = new ConsultModifVisiteur(visiteur,false);

				Object[] options = { "Supprimer", "Annuler" };
				int suppr = JOptionPane.showOptionDialog(null, p1, "Supprimer un visiteur",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
				if (suppr == 0)
				{
					int confirm = JOptionPane.showConfirmDialog(null,
							"Etes vous sur de vouloir supprimer ce visiteur", "Supprimer visiteur", JOptionPane.YES_NO_OPTION);
					if (confirm == 0)
					{
						if (AccesData.getFicheFraisRembourse(visiteur.getIdVisiteur()))
						{
							AccesData.deleteLogicalVisiteur(visiteur);
							JOptionPane.showConfirmDialog(null,
									"Le visiteur a bien ete supprime", "Supprimer visiteur", JOptionPane.CLOSED_OPTION);
							remplirJCombo();
							comboBoxNomPrenom.revalidate();
							comboBoxIdentifiant.revalidate();
						}
						else
						{
							JOptionPane.showConfirmDialog(null,
									"Toutes les fiches frais du visiteur n'ont pas ete rembourse\nLe visiteur ne peut etre supprime", "Supprimer visiteur", JOptionPane.CLOSED_OPTION);
						}
					}
				}
			}

		});

		buttonOkId.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				final Visiteur visiteur = utils.get(comboBoxIdentifiant.getSelectedIndex());
				//Create and populate the panel.
				final ConsultModifVisiteur p1 = new ConsultModifVisiteur(visiteur,false);


				Object[] options = { "Supprimer", "Annuler" };
				int suppr = JOptionPane.showOptionDialog(null, p1, "Supprimer un visiteur",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
				if (suppr == 0)
				{
					int confirm = JOptionPane.showConfirmDialog(null,
							"Etes vous sur de vouloir supprimer ce visiteur", "Supprimer visiteur", JOptionPane.YES_NO_OPTION);
					if (confirm == 0)
					{
						if (AccesData.getFicheFraisRembourse(visiteur.getIdVisiteur()))
						{
							AccesData.deleteLogicalVisiteur(visiteur);
							JOptionPane.showConfirmDialog(null,
									"Le visiteur a bien ete supprime", "Supprimer visiteur", JOptionPane.CLOSED_OPTION);
							remplirJCombo();
							comboBoxNomPrenom.revalidate();
							comboBoxIdentifiant.revalidate();
						}
						else
						{
							JOptionPane.showConfirmDialog(null,
									"Toutes les fiches frais du visiteur n'ont pas ete rembourse\nLe visiteur ne peut etre supprime", "Supprimer visiteur", JOptionPane.CLOSED_OPTION);
						}
					}
				}
			}

		});
	}
	private void remplirJCombo()
	{
		comboBoxNomPrenom.removeAllItems();
		comboBoxIdentifiant.removeAllItems();
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
