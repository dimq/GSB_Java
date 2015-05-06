package vue;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
import modele.ModeleStatMontantFraisHorsForfaitMoisRegions;
import modele.ModeleStatNbFraisHorsForfaitMoisRegion;

import org.apache.commons.collections.map.HashedMap;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class StatNbFraisHorsForfaitMoisRegion extends JPanel
{
	private JComboBox comboBoxRegion;
	private JLabel lblRegion;
	private JComboBox comboBoxMois;
	private JLabel lblMois;
	private List<Visiteur> utils;
	private List<Region> regions;
	private JButton buttonOkRegion;
	private JFrame frame;
	private ModeleStatNbFraisHorsForfaitMoisRegion modeleUtil;
	private List<Visiteur> VisiteurByRegion;
	private JTable table;
	private JOptionPane optionPane;
	private JDialog dialog;
	private HashMap<String,String> moislist = new HashMap<String,String>();
	/**
	 * Create the panel.
	 */
	public StatNbFraisHorsForfaitMoisRegion(JFrame myFrame,final boolean edit)
	{
		setLayout(null);
		Border paneEdge = BorderFactory.createEmptyBorder(0, 10, 10, 10);

		comboBoxRegion = new JComboBox();
		comboBoxRegion.setEditable(true);
		comboBoxRegion.setBounds(163, 66, 119, 20);
		AutoCompleteDecorator.decorate(comboBoxRegion);
		add(comboBoxRegion);
		
		comboBoxMois = new JComboBox();
		comboBoxMois.setEditable(true);
		comboBoxMois.setBounds(10, 66, 119, 20);
		AutoCompleteDecorator.decorate(comboBoxMois);
		add(comboBoxMois);



		lblMois = new JLabel("Mois");
		lblMois.setBounds(163, 41, 92, 14);
		add(lblMois);
		
		lblRegion = new JLabel("Region");
		lblRegion.setBounds(32, 41, 92, 14);
		add(lblRegion);

	

		buttonOkRegion = new JButton("OK");
		buttonOkRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisiteurByRegion = AccesData.getVisiteurByRegion(regions.get(comboBoxRegion.getSelectedIndex()).getIdRegion());
				Region r = new Region();
				
				r= AccesData.findRegion(comboBoxRegion.getSelectedItem().toString()); 
				System.out.println(r.getLibelleRegion()+"ffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
				
				modeleUtil = new ModeleStatNbFraisHorsForfaitMoisRegion(AccesData.getVisiteurByRegion(r.getIdRegion()), moislist.get(comboBoxMois.getSelectedItem().toString()));
				
				System.out.println(moislist.get(comboBoxMois.getSelectedItem().toString())+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				table.setModel(modeleUtil);
				table.revalidate();

			}
		});
		buttonOkRegion.setBounds(322, 65, 59, 23);
		add(buttonOkRegion);

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


					if (edit == true)
					{
						optionPane = new JOptionPane(
								p1,
								JOptionPane.QUESTION_MESSAGE,
								JOptionPane.OK_CANCEL_OPTION);
						dialog = new JDialog(frame, 
								"Modification fiche visiteur",
								true);
					}
					else
					{
						optionPane = new JOptionPane(
								p1,
								JOptionPane.QUESTION_MESSAGE,
								JOptionPane.CLOSED_OPTION);
						dialog = new JDialog(frame, 
								"Consultation fiche visiteur",
								true);
					}

					
					dialog.setContentPane(optionPane);

					dialog.pack();
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				}
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
		 String[] mois = new DateFormatSymbols().getMonths();
		
		 moislist.put("janvier", "201401");
		 moislist.put("février", "201402");
		 moislist.put("mars", "201403");
		 moislist.put("avril", "201404");
		 moislist.put("mai", "201405");
		 moislist.put("juin", "201406");
		 moislist.put("juillet", "201407");
		 moislist.put("août", "201408");
		 moislist.put("septembre", "201409");
		 moislist.put("octobre", "201410");
		 moislist.put("novembre", "201411");
		 moislist.put("décembre", "201412");
		 
		 
		 
		 for(Entry<String,String> entry :  moislist.entrySet()){
			 
			 comboBoxMois.addItem(entry.getKey());
			 
			 
			    
			}
		 
		 
	
		
	}
}
