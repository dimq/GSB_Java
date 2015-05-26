package vue;

import java.beans.PropertyChangeEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import net.sourceforge.jcalendarbutton.JCalendarButton;

import com.metier.Departement;
import com.metier.Region;
import com.metier.Ville;
import com.metier.Visiteur;
import com.persistance.AccesData;

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
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    private boolean testPortable;
    private boolean testFixe;
    private String id;
    private String nom;
    private String prenom;
    private String portable;
    private String fixe;
    private String adresse;
    private String cp;
    private Ville ville;
    private Date dateEmbauche;
    private Region region;
    private Departement departement;
    List<Departement> listeDepartement = new ArrayList();
    private List<Ville> listeVille = new ArrayList();
    private List<Ville> listeCp;

    private JLabel idVisiteur;
    private JTextField textFieldId;
    private JLabel label;
    private JLabel nomVisiteur;
    private JTextField textFieldNom;
    private JLabel label1;
    private JLabel prenomVisiteur;
    private JTextField textFieldPrenom;
    private JLabel label2;
    private JLabel portableVisiteur;
    private JTextField textFieldPortable;
    private JLabel label3;
    private JLabel telephoneVisiteur;
    private JTextField textFieldFixe;
    private JLabel mailVisiteur;
    private JTextField textFieldMail;
    private JLabel label5;
    private JLabel adresseVisiteur;
    private JTextField textFieldAdresse;
    private JLabel label4;
    private JLabel label6;
    private JLabel cpVisiteur;
    private JTextField textFieldCp;
    private JLabel label7;
    private JLabel villeVisiteur;
    private JTextField textFieldVille;
    private JLabel label8;
    private JLabel dateVisiteur;
    private JTextField textFieldDate;
    private JCalendarButton calendar;
    private JLabel regionVisiteur;
    private JComboBox comboFieldRegion;
    private JLabel label10;
    private JComboBox comboFieldCp;
    private JLabel departementVisiteur;
    private JComboBox comboFieldDepartement;
    private JLabel label11;
    private JComboBox comboFieldVille;
    private JLabel label12;
    private JLabel label13;
    private List<Region> regions;
    private List<Departement> departements;

    /**
     * Create the panel.
     * @return 
     */
    public ConsultModifVisiteur(final Visiteur util,final boolean edit) {
        regions = AccesData.getListRegion();
        /*departements = AccesData.getListDepartement();*/

        this.setLayout(new SpringLayout());

        idVisiteur = new JLabel();
        idVisiteur.setText("Identifiant ");
        this.add(idVisiteur);
        textFieldId = new JTextField(10);
        textFieldId.setText(util.getIdVisiteur());
        idVisiteur.setLabelFor(textFieldId);
        this.add(textFieldId);
        label = new JLabel();
        this.add(label);
        textFieldId.setEditable(false);
        id = textFieldId.getText();


        nomVisiteur = new JLabel();
        nomVisiteur.setText("Nom ");
        this.add(nomVisiteur);
        textFieldNom = new JTextField(10);
        textFieldNom.setText(util.getNomVisiteur());
        nomVisiteur.setLabelFor(textFieldNom);
        this.add(textFieldNom);
        label1 = new JLabel();
        this.add(label1);
        textFieldNom.setEditable(edit);
        nom = textFieldNom.getText();
        textFieldNom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                nom = textFieldNom.getText();
            }
        });


        prenomVisiteur = new JLabel();
        prenomVisiteur.setText("Prenom ");
        this.add(prenomVisiteur);
        textFieldPrenom = new JTextField(10);
        textFieldPrenom.setText(util.getPrenomVisiteur());
        prenomVisiteur.setLabelFor(textFieldPrenom);
        this.add(textFieldPrenom);
        label2 = new JLabel();
        this.add(label2);
        textFieldPrenom.setEditable(edit);
        prenom = textFieldPrenom.getText();
        textFieldPrenom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                prenom = textFieldPrenom.getText();
            }
        });

        portableVisiteur = new JLabel();
        portableVisiteur.setText("Portable ");
        this.add(portableVisiteur);
        textFieldPortable = new JTextField(10);
        label3 = new JLabel();
        textFieldPortable.setText(util.getNumPort());
        if (edit == true)
        {
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
                public void keyTyped(KeyEvent e) {
                    if(textFieldPortable.getText().length() >= 10)
                    {
                        e.consume();
                    }
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();  // ignore event
                    }
                }
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
        }
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

        telephoneVisiteur = new JLabel();
        telephoneVisiteur.setText("Telephone ");
        this.add(telephoneVisiteur);
        textFieldFixe = new JTextField(10);
        label4 = new JLabel();
        textFieldFixe.setText(util.getNumFixe());
        if (edit == true)
        {
            if (textFieldFixe.getText().length() == 10)
            {
                label4.setText("Bon numero");
                testFixe= true;
            }
            else
            {
                label4.setText("Mauvais numero");
                testFixe = false;
            }
            textFieldFixe.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if(textFieldFixe.getText().length() >= 10)
                    {
                        e.consume();
                    }
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();  // ignore event
                    }
                }
                @Override
                public void keyReleased(KeyEvent arg0) {
                    if (textFieldFixe.getText().length() == 10)
                    {
                        label4.setText("Bon numero");
                        testFixe = true;
                    }
                    else
                        label4.setText("Mauvais numero");
                    testFixe = false;
                }
            });
        }
        telephoneVisiteur.setLabelFor(textFieldFixe);
        this.add(textFieldFixe);
        this.add(label4);
        textFieldFixe.setEditable(edit);
        fixe = textFieldFixe.getText();
        textFieldFixe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                fixe = textFieldFixe.getText();
            }
        });

        mailVisiteur = new JLabel();
        mailVisiteur.setText("Mail ");
        this.add(mailVisiteur);
        textFieldMail = new JTextField(10);
        textFieldMail.setText(util.getMailPro());
        mailVisiteur.setLabelFor(textFieldMail);
        this.add(textFieldMail);
        label5 = new JLabel();
        this.add(label5);
        textFieldMail.setEditable(false);

        adresseVisiteur = new JLabel();
        adresseVisiteur.setText("Adresse ");
        this.add(adresseVisiteur);
        textFieldAdresse = new JTextField(10);
        textFieldAdresse.setText(util.getAdressseRue());
        adresseVisiteur.setLabelFor(textFieldAdresse);
        this.add(textFieldAdresse);
        label6 = new JLabel();
        this.add(label6);
        textFieldAdresse.setEditable(edit);
        adresse = textFieldAdresse.getText();
        textFieldAdresse.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                adresse = textFieldAdresse.getText();
            }
        });



        dateVisiteur = new JLabel();
        dateVisiteur.setText("Date d'embauche ");
        this.add(dateVisiteur);
        textFieldDate = new JTextField(10);
        textFieldDate.setText(dateFormat.format(util.getDateEmbauche()));
        textFieldDate.setEditable(false);
        dateVisiteur.setLabelFor(textFieldDate);
        this.add(textFieldDate);
        try {
            dateEmbauche = dateFormat.parse(textFieldDate.getText());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        calendar = new JCalendarButton();
        calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if (evt.getNewValue() instanceof Date){
                    dateEmbauche = (Date) evt.getNewValue();
                    String dateString = dateFormat.format(dateEmbauche);
                    textFieldDate.setText(dateString);
                }
            }
        });
        calendar.setEnabled(edit);
        this.add(calendar);




        regionVisiteur = new JLabel();
        regionVisiteur.setText("Region ");
        this.add(regionVisiteur);
        comboFieldRegion = new JComboBox();
        for (Region r:regions)
        {
            comboFieldRegion.addItem(r.getLibelleRegion());
        }
        comboFieldRegion.setSelectedIndex(regions.indexOf(util.getRegion()));
        comboFieldRegion.setEnabled(edit);
        AutoCompleteDecorator.decorate(comboFieldRegion);
        regionVisiteur.setLabelFor(comboFieldRegion);
        this.add(comboFieldRegion);
        label10 = new JLabel();
        this.add(label10);
        region = regions.get(comboFieldRegion.getSelectedIndex());


        departements = region.getListeDepartement();
        departementVisiteur = new JLabel();
        departementVisiteur.setText("Departement ");
        this.add(departementVisiteur);
        comboFieldDepartement = new JComboBox();
        comboFieldDepartement.removeAllItems();
        for (Departement d:departements)
        {
            comboFieldDepartement.addItem(d.getLibelleDepartement());
        }
        comboFieldDepartement.setSelectedIndex(departements.indexOf(util.getDepartement()));
        comboFieldDepartement.setEnabled(edit);
        AutoCompleteDecorator.decorate(comboFieldDepartement);
        departementVisiteur.setLabelFor(comboFieldDepartement);
        this.add(comboFieldDepartement);
        label11 = new JLabel();
        this.add(label11);
        departement = departements.get(comboFieldDepartement.getSelectedIndex());

        listeVille= departement.getListeVille();
        villeVisiteur = new JLabel();
        villeVisiteur.setText("Ville ");
        this.add(villeVisiteur);
        comboFieldVille = new JComboBox();
        comboFieldVille.removeAllItems();
        for (Ville v:listeVille)
        {
            comboFieldVille.addItem(v.getNomVille());
        }
        comboFieldVille.setSelectedIndex(listeVille.indexOf(util.getVille()));
        comboFieldVille.setEnabled(edit);
        AutoCompleteDecorator.decorate(comboFieldVille);
        villeVisiteur.setLabelFor(comboFieldVille);
        this.add(comboFieldVille);
        label12 = new JLabel();
        this.add(label12);
        ville = listeVille.get(comboFieldVille.getSelectedIndex());




        cpVisiteur = new JLabel();
        cpVisiteur.setText("Code postal ");
        this.add(cpVisiteur);
        comboFieldCp= new JComboBox();
        if (ville.getCp().split("-").length == 1)
        {
            comboFieldCp.addItem(ville.getCp());
        }
        else
        {
            for (String code : ville.getCp().split("-"))
            {
                comboFieldCp.addItem(code);
            }
        }
        if(!util.getCp().equals(""))
        {
            comboFieldCp.setSelectedItem(util.getCp());
        }
        else
        {
            comboFieldCp.setSelectedIndex(0);
        }
        cpVisiteur.setLabelFor(comboFieldCp);
        this.add(comboFieldCp);
        label13 = new JLabel();
        this.add(label13);
        comboFieldCp.setEnabled(edit);


        comboFieldRegion.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {

                region = regions.get(comboFieldRegion.getSelectedIndex());
                listeDepartement= region.getListeDepartement();
                comboFieldDepartement.removeAllItems();
                for (Departement d:listeDepartement)
                {
                    comboFieldDepartement.addItem(d.getLibelleDepartement());
                }
                departement = listeDepartement.get(comboFieldDepartement.getSelectedIndex());


            }
        });

        comboFieldDepartement.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                listeDepartement= region.getListeDepartement();
                try
                {
                    departement = listeDepartement.get(comboFieldDepartement.getSelectedIndex());
                }
                catch (Exception e)
                {

                }
                listeVille= departement.getListeVille();
                comboFieldVille.removeAllItems();
                for (Ville v:listeVille)
                {
                    comboFieldVille.addItem(v.getNomVille());
                }
                ville = listeVille.get(comboFieldVille.getSelectedIndex());
            }
        });

        comboFieldVille.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                listeVille= departement.getListeVille();
                try
                {
                    ville = listeVille.get(comboFieldVille.getSelectedIndex());
                }
                catch (Exception e)
                {

                }
                if (edit == true)
                {
                    comboFieldCp.removeAllItems();
                    if (ville.getCp().split("-").length == 1)
                    {
                        comboFieldCp.addItem(ville.getCp());
                    }
                    else
                    {
                        for (String code : ville.getCp().split("-"))
                        {
                            comboFieldCp.addItem(code);
                        }
                    }
                }



            }
        });

        comboFieldCp.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try{
                    cp=comboFieldCp.getSelectedItem().toString();
                }
                catch (Exception e2)
                {

                }

            }

        });


        //Lay out the panel.
        SpringUtilities.makeCompactGrid(this,
                12, 3, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad


    }
    public String getId()
    {
        return id;
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
    public Ville getVille()
    {
        return ville;
    }
    public Date getDateEmbauche()
    {
        return dateEmbauche;
    }
    public Region getRegion()
    {
        return region;
    }
    public Departement getDepartement()
    {
        return departement;
    }
}
