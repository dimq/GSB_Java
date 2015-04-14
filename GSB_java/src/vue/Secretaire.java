package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Secretaire extends JFrame
{

    private static final JFrame JFrame = null;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnFichier;
    private JMenuItem mntmQuitter;
    private static Secretaire frame;
    private JMenuItem mntmDconnection;
    private JMenu mnGestionVisiteurs;
    private JMenuItem mntmConsultation;
    private JMenuItem mntmModification;
    private JMenu mnCrationsuppression;
    private JMenuItem mntmCrationDunVisiteur;
    private JMenuItem mntmSupprimerUnVisiteur;
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
    }
    private JMenuBar getMenuBar_1() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnFichier());
        	menuBar.add(getMnGestionVisiteurs());
        	menuBar.add(getMnCrationsuppression());
        }
        return menuBar;
    }
    private JMenu getMnFichier() {
        if (mnFichier == null) {
        	mnFichier = new JMenu("Fichier");
        	mnFichier.add(getMntmDconnection());
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
    private JMenuItem getMntmDconnection() {
        if (mntmDconnection == null) {
        	mntmDconnection = new JMenuItem("Deconnexion");
        	mntmDconnection.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frame.dispose();
        	        JFrame Login = new GSB_RH_Login();
                    Login.setVisible(true);
        	    }
        	});
        }
        return mntmDconnection;
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
    private JMenu getMnCrationsuppression() {
        if (mnCrationsuppression == null) {
        	mnCrationsuppression = new JMenu("Creation/Suppression");
        	mnCrationsuppression.add(getMntmCrationDunVisiteur());
        	mnCrationsuppression.add(getMntmSupprimerUnVisiteur());
        }
        return mnCrationsuppression;
    }
    private JMenuItem getMntmCrationDunVisiteur() {
        if (mntmCrationDunVisiteur == null) {
        	mntmCrationDunVisiteur = new JMenuItem("Creation d'un Visiteur");
        	mntmCrationDunVisiteur.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	      //Create and populate the panel.
                    CreationVisiteur p1 = new CreationVisiteur(AccesData.getListRegion());

//                    JFrame frame = new JFrame();
//                    frame.setContentPane(new CreationVisiteur(AccesData.getListRegion()));
//                    frame.setBounds(50, 50, 500, 500);
//                    frame.setAlwaysOnTop(true);
//                    frame.setVisible(true);
                    
                    JOptionPane.showOptionDialog(null, p1, "Creation visiteur",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                    
        	    }
        	});
        }
        return mntmCrationDunVisiteur;
    }
    private JMenuItem getMntmSupprimerUnVisiteur() {
        if (mntmSupprimerUnVisiteur == null) {
        	mntmSupprimerUnVisiteur = new JMenuItem("Supprimer un Visiteur");
        	mntmSupprimerUnVisiteur.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    }
        	});
        }
        return mntmSupprimerUnVisiteur;
    }
}
