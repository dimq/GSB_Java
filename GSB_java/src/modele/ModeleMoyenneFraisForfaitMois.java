package modele;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.metier.*;

import javax.swing.table.AbstractTableModel;

public class ModeleMoyenneFraisForfaitMois extends AbstractTableModel {

	private String[] entete = { "Nom region", "nombre utilsateur", " moyenne" };
	List<Region> uneListeRegion;
	String moisSelect;
	
	public ModeleMoyenneFraisForfaitMois(List<Region>lst, String moisSelect){
		this.uneListeRegion=lst;
		this.moisSelect=moisSelect;
	}
	
	@Override
	public int getColumnCount() {
		return entete.length;
	}

	@Override
	public int getRowCount() {
		return uneListeRegion.size();
	}

	 public Object getValueAt(int rowIndex, int columnIndex) {
	        switch (columnIndex) {
	        case 0:            
	            return uneListeRegion.get(rowIndex).getLibelleRegion();
	        case 1:            
	            return uneListeRegion.get(rowIndex).getListeVisiteur().size();
	        case 2:
	            return uneListeRegion.get(rowIndex).MoyenneMontantFraisForfait(moisSelect);
	            
	        default:
	            throw new IllegalArgumentException();
	        }
	    }
}
