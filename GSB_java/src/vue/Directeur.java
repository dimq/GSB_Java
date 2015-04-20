package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.metier.Visiteur;
import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class Directeur extends JFrame
{

    private static final JFrame JFrame = null;
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnFichier;
    private JMenuItem mntmQuitter;
    private static Directeur frame;
    private JMenuItem mntmDeconnection;
    private JMenu mnGestionVisiteurs;
    private JMenuItem mntmConsultation;
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
                    frame = new Directeur();
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
    public Directeur()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 150, 800, 300);
        setTitle("Partie Directeur GSB Ressources Humaines");
        setJMenuBar(getMenuBar_1());
        frame= this;
        utils = AccesData.getListVisiteur();
    }
    private JMenuBar getMenuBar_1() {
        if (menuBar == null) {
        	menuBar = new JMenuBar();
        	menuBar.add(getMnFichier());
        	menuBar.add(getMnGestionVisiteurs());
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
        }
        return mnGestionVisiteurs;
    }
    private JMenuItem getMntmConsultation() {
        if (mntmConsultation == null) {
        	mntmConsultation = new JMenuItem("Consultation");
        	mntmConsultation.addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	        frame.setContentPane(new ConsulterFiche(frame,false));
        	        frame.revalidate();
        	    }
        	});
        }
        return mntmConsultation;
    }
}
