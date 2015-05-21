package vue;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import modele.ModeleVisiteur;

import com.metier.Visiteur;
import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Secretaire extends JFrame
{

	private static final JFrame JFrame = null;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenuItem mntmQuitter;
	private static Secretaire frame;
	private JMenuItem mntmDeconnection;
	private JMenu mnGestionVisiteurs;
	
	private JMenuItem mntmConsultation;
	private JMenuItem mntmModification;
	private JMenu mnCreationSuppression;
	private JMenuItem mntmCreationDunVisiteur;
	private JMenuItem mntmSupprimerUnVisiteur;
	private List<Visiteur> utils;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					frame = new Secretaire();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Secretaire()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 800, 300);
		setTitle("Partie Secretaire GSB Ressources Humaines");
		setJMenuBar(getMenuBar_1());
		frame= this;
		utils = AccesData.getListVisiteur();
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFichier());
			menuBar.add(getMnGestionVisiteurs());
			menuBar.add(getMnCreationSuppression());
		}
		return menuBar;
	}
	private JMenu getMnFichier() {
		if (mnFichier == null) {
			mnFichier = new JMenu("Fichier");
			mnFichier.add(getMntmDeconnection());
			mnFichier.add(getMntmQuitter());
		}
		return mnFichier;
	}
	private JMenuItem getMntmQuitter() {
		if (mntmQuitter == null) {
			mntmQuitter = new JMenuItem("Quitter");
			mntmQuitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
				}
			});
		}
		return mntmQuitter;
	}
	private JMenuItem getMntmDeconnection() {
		if (mntmDeconnection == null) {
			mntmDeconnection = new JMenuItem("Deconnexion");
			mntmDeconnection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					JFrame Login = new GSB_RH_Login();
					Login.setVisible(true);
				}
			});
		}
		return mntmDeconnection;
	}
	private JMenu getMnGestionVisiteurs() {
		if (mnGestionVisiteurs == null) {
			mnGestionVisiteurs = new JMenu("Gestion Visiteurs");
			mnGestionVisiteurs.add(getMntmConsultation());
			mnGestionVisiteurs.add(getMntmModification());
		}
		return mnGestionVisiteurs;
	}
	private JMenuItem getMntmConsultation() {
		if (mntmConsultation == null) {
			mntmConsultation = new JMenuItem("Consultation");
			mntmConsultation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(frame);
					frame.setContentPane(new ConsulterFiche(frame,false));
					frame.revalidate();
				}
			});
		}
		return mntmConsultation;
	}
	private JMenuItem getMntmModification() {
		if (mntmModification == null) {
			mntmModification = new JMenuItem("Modification");
			mntmModification.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setContentPane(new ConsulterFiche(frame,true));
					frame.revalidate();
				}
			});
		}
		return mntmModification;
	}
	private JMenu getMnCreationSuppression() {
		if (mnCreationSuppression == null) {
			mnCreationSuppression = new JMenu("Creation/Suppression");
			mnCreationSuppression.add(getMntmCreationDunVisiteur());
			mnCreationSuppression.add(getMntmSupprimerUnVisiteur());
		}
		return mnCreationSuppression;
	}
	private JMenuItem getMntmCreationDunVisiteur() {
		if (mntmCreationDunVisiteur == null) {
			mntmCreationDunVisiteur = new JMenuItem("Creation d'un Visiteur");
			mntmCreationDunVisiteur.addActionListener(new ActionListener() {
				private JOptionPane optionPane;
				private JDialog dialog;

				public void actionPerformed(ActionEvent e) {
					//Create and populate the panel.
					final CreationVisiteur p1 = new CreationVisiteur();


					Object[] options = { "Créer", "Annuler" };
	                int create = JOptionPane.showOptionDialog(null, p1, "Créer un visiteur",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	                null, options, options[0]);
	                boolean effectuer = false;
	               
	                while(effectuer == false){

	                	
	                
	                if ((create == 0)&&(!p1.getNom().equals("")&&(!p1.getPrenom().equals("")&&(!p1.getAdresse().equals("")))))
	                {
	                    int confirm = JOptionPane.showConfirmDialog(null,
	                            "Etes vous sur de vouloir créer ce visiteur", "Créer visiteur", JOptionPane.YES_NO_OPTION);
	                    if ((confirm == 0))
	                    {
	                        Visiteur util = new Visiteur(creerId(),p1.getNom(),p1.getPrenom(),p1.getPortable(),p1.getFixe(),p1.getAdresse(),p1.getVille(),p1.getCp(),p1.getDateEmbauche(),"v",p1.getRegion(),p1.getDepartement());
                            AccesData.createVisiteur(util);
                            effectuer = true;
                            JOptionPane.showConfirmDialog(null,
                                    "Le visiteur a bien ete crée", "Créer visiteur", JOptionPane.CLOSED_OPTION);
	                    }
	                    
	                }
	                else if(create!=0){
	                	
	                	 effectuer=true;
	                }
	                else{
	                	JOptionPane.showConfirmDialog(null,
                                "Champ manquant", "Créer visiteur", JOptionPane.CLOSED_OPTION);
	                	 create = JOptionPane.showOptionDialog(null, p1, "Créer un visiteur",
	         	                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
	         	                null, options, options[0]);
	                }
	                
	                }
				}
			});
		}
		return mntmCreationDunVisiteur;
	}
	private JMenuItem getMntmSupprimerUnVisiteur() {
		if (mntmSupprimerUnVisiteur == null) {
			mntmSupprimerUnVisiteur = new JMenuItem("Supprimer un Visiteur");
			mntmSupprimerUnVisiteur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setContentPane(new Suppression(frame));
					frame.revalidate();
				}
			});
		}
		return mntmSupprimerUnVisiteur;
	}
	/**
	 * Méthode de génération aléatoire de l'identifiant Visiteur
	 * @return id Visiteur de type String
	 */
	public String creerId()
	{
		boolean test = true;
		String id = "";
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		int i =0;
		while (i < utils.size() || test == true)
		{

			if (id.equals(utils.get(i).getIdVisiteur()) || id.equals(""))
			{
				id="";
				int character1=(int)(Math.random()*26);
				id +=alphabet.substring(character1, character1+1);
				id +=1 + (int)(Math.random() * ((200 - 1) + 1));
			}
			else
			{
				test=false;
			}
			i++;
		}
		return id;
	}
}
