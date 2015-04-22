package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Responsable extends JFrame {

	private JPanel contentPane;
	private JMenu mnFichier;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmDeconneexion;
	private JMenu mnStatMoisRegion;
	private JMenuItem mntmStat;
	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Responsable frame = new Responsable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Responsable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(getMnFichier());
		menuBar.add(getMnStatMoisRegion());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


	}

	private JMenu getMnFichier() {
		if (mnFichier == null) {
			mnFichier = new JMenu("Fichier");
			mnFichier.add(getMntmDeconneexion());
			mnFichier.add(getMntmQuitter());
		}
		return mnFichier;
	}
	private JMenuItem getMntmQuitter() {
		if (mntmQuitter == null) {
			mntmQuitter = new JMenuItem("Quitter");
			mntmQuitter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmQuitter;
	}
	private JMenuItem getMntmDeconneexion() {
		if (mntmDeconneexion == null) {
			mntmDeconneexion = new JMenuItem("Deconnexion");
		}
		return mntmDeconneexion;
	}
	private JMenu getMnStatMoisRegion() {
		if (mnStatMoisRegion == null) {
			mnStatMoisRegion = new JMenu("Stat mois region");
			mnStatMoisRegion.add(getMntmStat());
		}
		return mnStatMoisRegion;
	}
	private JMenuItem getMntmStat() {
		if (mntmStat == null) {
			mntmStat = new JMenuItem("stat1");
			mntmStat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new stat1(frame,false));
					revalidate();
				}
			});
		}
		return mntmStat;
	}
}
