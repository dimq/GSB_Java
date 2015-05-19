package vue;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
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
	private JLabel lblStatNombreLignes;
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
		lblMois.setBounds(20, 41, 92, 14);
		add(lblMois);
		
		lblRegion = new JLabel("Region");
		lblRegion.setBounds(163, 41, 92, 14);
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
		add(getLblStatNombreLignes());

		frame  = myFrame;
		remplirJCombo();







	}
	private void remplirJCombo()
	{
		regions = AccesData.getListRegion();
		for (Region r:regions)
		{
			comboBoxRegion.addItem(r.getLibelleRegion());
		}
		String[] mois = new DateFormatSymbols().getMonths();
		 int[] codeMois =  new int[mois.length];
		 int nummois = 201401;
		 for (int i=0; i<12;i++){
			 codeMois[i]=nummois;
			 nummois=nummois+1;
		 }
		 
		 
		 Calendar c = Calendar.getInstance();
   	 int moisasup = c.get(Calendar.MONTH);
   	 int verif = 0;
   	 String idmois;
   	 for (String moisAajouter : mois){
   		 if (verif != moisasup){
   			 idmois= Integer.toString(codeMois[verif]);
   			 moislist.put(mois[verif],idmois ); 
   		 }
   		 verif=verif+1;
   	 }
   	 
		 
		 
		 
		 for(Entry<String,String> entry :  moislist.entrySet()){
			 
			 comboBoxMois.addItem(entry.getKey());
			 
			 
			    
			}
		 
		 
	
		
	}
	private JLabel getLblStatNombreLignes() {
		if (lblStatNombreLignes == null) {
			lblStatNombreLignes = new JLabel("Stat nombre lignes frais hors forfait Mois/Regions");
			lblStatNombreLignes.setBounds(10, 11, 292, 14);
		}
		return lblStatNombreLignes;
	}
}
