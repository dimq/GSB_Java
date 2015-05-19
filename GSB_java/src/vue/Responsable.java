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
	private JMenuItem mntmStat_1;
	private JMenuItem mntmStat_2;
	private JMenu mnStatRegion;
	private JMenuItem mntmMoyenneFraisForfait;
	private JMenuItem mntmMoyenneFraisHors;

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
		setBounds(100, 100, 666, 307);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(getMnFichier());
		menuBar.add(getMnStatMoisRegion());
		menuBar.add(getMnStatRegion());
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
			mnStatMoisRegion.add(getMntmStat_1());
			mnStatMoisRegion.add(getMntmStat_2());
		}
		return mnStatMoisRegion;
	}
	private JMenuItem getMntmStat() {
		if (mntmStat == null) {
			mntmStat = new JMenuItem("Montant frais hors forfait mois /region");
			mntmStat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new MoyenneMontantFraisHorsForfaitMoisRegion(frame,false));
					revalidate();
				}
			});
		}
		return mntmStat;
	}
	private JMenuItem getMntmStat_1() {
		if (mntmStat_1 == null) {
			mntmStat_1 = new JMenuItem("Nombre frais hors forfait mois/regions");
			mntmStat_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new StatNbFraisHorsForfaitMoisRegion(frame,false));
					revalidate();
				}
			});
		}
		return mntmStat_1;
	}
	private JMenuItem getMntmStat_2() {
		if (mntmStat_2 == null) {
			mntmStat_2 = new JMenuItem("Montant frais forfait mois/region");
			mntmStat_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new StatMontantFraisForfaitMoisRegions(frame,false));
					revalidate();
				}
			});
		}
		return mntmStat_2;
	}
	private JMenu getMnStatRegion() {
		if (mnStatRegion == null) {
			mnStatRegion = new JMenu("Stat Region");
			mnStatRegion.add(getMntmMoyenneFraisForfait());
			mnStatRegion.add(getMntmMoyenneFraisHors());
		}
		return mnStatRegion;
	}
	private JMenuItem getMntmMoyenneFraisForfait() {
		if (mntmMoyenneFraisForfait == null) {
			mntmMoyenneFraisForfait = new JMenuItem("Moyenne frais forfait mois");
			mntmMoyenneFraisForfait.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new JFrameMoyenneFraisForfaitMois(frame,false));
					revalidate();
				}
			});
			
		}
		return mntmMoyenneFraisForfait;
	}
	private JMenuItem getMntmMoyenneFraisHors() {
		if (mntmMoyenneFraisHors == null) {
			mntmMoyenneFraisHors = new JMenuItem("Moyenne frais hors forfait mois");
			mntmMoyenneFraisHors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					setContentPane(new JFrameMoyenneFraisHorsForfaitMois(frame,false));
					revalidate();
				}
			});
		}
		return mntmMoyenneFraisHors;
	}
}
