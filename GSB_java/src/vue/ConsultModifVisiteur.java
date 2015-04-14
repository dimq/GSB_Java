package vue;

import java.beans.PropertyChangeEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import net.sourceforge.jcalendarbutton.JCalendarButton;

import com.metier.Region;
import com.metier.Utilisateur;

import layout.SpringUtilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConsultModifVisiteur extends JPanel {
	private static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	private boolean testPortable;
	private String nom;
	private String prenom;
	private String portable;
	private String fixe;
	private String adresse;
	private String cp;
	private String ville;
	private Region region;
	/**
	 * Create the panel.
	 * @return 
	 */
	public ConsultModifVisiteur(Utilisateur util,boolean edit,List<Region> regions) {
		
		
		SpringLayout springLayout = new SpringLayout();
		this.setLayout(springLayout);

		JLabel idVisiteur = new JLabel();
		idVisiteur.setText("Identifiant ");
		this.add(idVisiteur);
		JTextField textFieldId = new JTextField(10);
		textFieldId.setText(util.getIdUtilisateur());
		idVisiteur.setLabelFor(textFieldId);
		this.add(textFieldId);
		JLabel label = new JLabel();
		this.add(label);
		textFieldId.setEditable(false);


		JLabel nomVisiteur = new JLabel();
		nomVisiteur.setText("Nom ");
		this.add(nomVisiteur);
		JTextField textFieldNom = new JTextField(10);
		textFieldNom.setText(util.getNomUtilisateur());
		nomVisiteur.setLabelFor(textFieldNom);
		this.add(textFieldNom);
		JLabel label1 = new JLabel();
		this.add(label1);
		textFieldNom.setEditable(edit);
		nom = textFieldNom.getText();
		textFieldNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				nom = textFieldNom.getText();
			}
		});
				

		JLabel prenomVisiteur = new JLabel();
		prenomVisiteur.setText("Prenom ");
		this.add(prenomVisiteur);
		JTextField textFieldPrenom = new JTextField(10);
		textFieldPrenom.setText(util.getPrenomUtilisateur());
		prenomVisiteur.setLabelFor(textFieldPrenom);
		this.add(textFieldPrenom);
		JLabel label2 = new JLabel();
		this.add(label2);
		textFieldPrenom.setEditable(edit);
		prenom = textFieldPrenom.getText();
		textFieldPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				prenom = textFieldPrenom.getText();
			}
		});

		JLabel portableVisiteur = new JLabel();
		portableVisiteur.setText("Portable ");
		this.add(portableVisiteur);
		JTextField textFieldPortable = new JTextField(10);
		JLabel label3 = new JLabel();
		if (textFieldPortable.getText().length() == 10)
		{
			label3.setText("Bon numero");
			testPortable= true;
		}
		else
		{
			label3.setText("Mauvais numero");
			testPortable = false;
		}
		textFieldPortable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (textFieldPortable.getText().length() == 10)
				{
					label3.setText("Bon numero");
					testPortable = true;
				}
				else
					label3.setText("Mauvais numero");
					testPortable = false;
				}
		});
		textFieldPortable.setText(util.getNumPort());
		portableVisiteur.setLabelFor(textFieldPortable);
		this.add(textFieldPortable);
		this.add(label3);
		textFieldPortable.setEditable(edit);
		portable = textFieldPortable.getText();
		textFieldPortable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				portable = textFieldPortable.getText();
			}
		});

		JLabel telephoneVisiteur = new JLabel();
		telephoneVisiteur.setText("Telephone ");
		this.add(telephoneVisiteur);
		JTextField textFieldFixe = new JTextField(10);
		textFieldFixe.setText(util.getNumFixe());
		telephoneVisiteur.setLabelFor(textFieldFixe);
		this.add(textFieldFixe);
		JLabel label4 = new JLabel();
		this.add(label4);
		textFieldFixe.setEditable(edit);
		fixe = textFieldFixe.getText();
		textFieldFixe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fixe = textFieldFixe.getText();
			}
		});

		JLabel mailVisiteur = new JLabel();
		mailVisiteur.setText("Mail ");
		this.add(mailVisiteur);
		JTextField textFieldMail = new JTextField(10);
		textFieldMail.setText(util.getMailPro());
		mailVisiteur.setLabelFor(textFieldMail);
		this.add(textFieldMail);
		JLabel label5 = new JLabel();
		this.add(label5);
		textFieldMail.setEditable(false);

		JLabel adresseVisiteur = new JLabel();
		adresseVisiteur.setText("Adresse ");
		this.add(adresseVisiteur);
		JTextField textFieldAdresse = new JTextField(10);
		textFieldAdresse.setText(util.getAdressseRue());
		adresseVisiteur.setLabelFor(textFieldAdresse);
		this.add(textFieldAdresse);
		JLabel label6 = new JLabel();
		this.add(label6);
		textFieldAdresse.setEditable(edit);
		adresse = textFieldAdresse.getText();
		textFieldAdresse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				adresse = textFieldAdresse.getText();
			}
		});

		JLabel cpVisiteur = new JLabel();
		cpVisiteur.setText("Code Postal ");
		this.add(cpVisiteur);
		JTextField textFieldCp = new JTextField(10);
		textFieldCp.setText(util.getCp());
		cpVisiteur.setLabelFor(textFieldCp);
		this.add(textFieldCp);
		JLabel label7 = new JLabel();
		this.add(label7);
		textFieldCp.setEditable(edit);
		cp = textFieldCp.getText();
		textFieldCp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				cp = textFieldCp.getText();
			}
		});

		JLabel villeVisiteur = new JLabel();
		villeVisiteur.setText("Ville ");
		this.add(villeVisiteur);
		JTextField textFieldVille = new JTextField(10);
		textFieldVille.setText(util.getVille());
		villeVisiteur.setLabelFor(textFieldVille);
		this.add(textFieldVille);
		JLabel label8 = new JLabel();
		this.add(label8);
		textFieldVille.setEditable(edit);
		ville = textFieldVille.getText();
		textFieldVille.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ville = textFieldVille.getText();
			}
		});

		JLabel dateVisiteur = new JLabel();
		dateVisiteur.setText("Date d'embauche ");
		this.add(dateVisiteur);
		final JTextField textFieldDate = new JTextField(10);
		textFieldDate.setText(util.getDateEmbauche().toLocaleString());
		textFieldDate.setEditable(false);
		dateVisiteur.setLabelFor(textFieldDate);
		this.add(textFieldDate);
		JCalendarButton calendar = new JCalendarButton();
		calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
			    //System.out.println(evt.getNewValue());
				if (evt.getNewValue() instanceof Date){
					Date date = (Date) evt.getNewValue();
					System.out.println("Date : " + date.toString());
					String dateString = dateFormat.format(date);
					Date dat = null;
					textFieldDate.setText(dateString);
				}
			}
		});
		this.add(calendar);

		JLabel regionVisiteur = new JLabel();
		regionVisiteur.setText("Region ");
		this.add(regionVisiteur);

		JComboBox comboFieldRegion = new JComboBox();
		for (Region r:regions)
		{
			comboFieldRegion.addItem(r.getLibelleRegion());
		}
		comboFieldRegion.setSelectedIndex(regions.get(util.getRegion().getIdRegion()).getIdRegion()-2);
		comboFieldRegion.setEnabled(edit);
		AutoCompleteDecorator.decorate(comboFieldRegion);
		regionVisiteur.setLabelFor(comboFieldRegion);
		this.add(comboFieldRegion);
		JLabel label10 = new JLabel();
		this.add(label10);
		region = regions.get(comboFieldRegion.getSelectedIndex());
		comboFieldRegion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				region = regions.get(comboFieldRegion.getSelectedIndex());
			}
		});
		

		//Lay out the panel.
		SpringUtilities.makeCompactGrid(this,
				11, 3, //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		
		
	}
	public String getNom()
	{
		return nom;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public String getPortable()
	{
		return portable;
	}
	public String getFixe()
	{
		return fixe;
	}
	public String getAdresse()
	{
		return adresse;
	}
	public String getCp()
	{
		return cp;
	}
	public String getVille()
	{
		return ville;
	}
	public Region getRegion()
	{
		return region;
	}
	
}
