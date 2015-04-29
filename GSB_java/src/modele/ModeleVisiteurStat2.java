package modele;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.metier.*;

import javax.swing.table.AbstractTableModel;

public class ModeleVisiteurStat2 extends AbstractTableModel {

	private String[] entete = { "Nom", "Prenom", " Nombre fiche hors forfait" };
	List<Visiteur> uneListeUtilisateur;
	String moisSelect;
	
	public ModeleVisiteurStat2(List<Visiteur>lstv, String moisSelect){
		this.uneListeUtilisateur=lstv;
		this.moisSelect=moisSelect;
	}
	
	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return uneListeUtilisateur.size();
	}

	 public Object getValueAt(int rowIndex, int columnIndex) {
	        switch (columnIndex) {
	        case 0:            
	            return uneListeUtilisateur.get(rowIndex).getNomVisiteur();
	        case 1:            
	            return uneListeUtilisateur.get(rowIndex).getPrenomVisiteur();
	        case 2:
	            return uneListeUtilisateur.get(rowIndex).getNbFraisHorsForfait(moisSelect);
	            
	        default:
	            throw new IllegalArgumentException();
	        }
	    }
}
