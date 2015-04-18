package modele;

import com.metier.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 * Classe metier Modele de Station
 * 
 * Permet de mettre en forme des donnees provenant d'une collection de Station
 * pour une JTable
 * 
 * @author b0dian
 * @version 1.0
 */
public class ModeleVisiteur extends AbstractTableModel {

	private String[] entete = { "Identifiant", "Nom", "Prenom" };
	private List<Visiteur> listeVisiteur;

	/**
	 * Constructeur public, cree une instance de Modele de stations en
	 * recuperant notre collection de stations
	 * 
	 * @param listesStation
	 *            de type collection de stations
	 */
	public ModeleVisiteur(List<Visiteur> listesVisiteur) {
		listeVisiteur = listesVisiteur;
	}

	/**
	 * Accesseur permettant de recuperer le nombre de colonnes dans notre entète
	 * predefini
	 * 
	 * @return nbColumn de type int
	 */
	@Override
	public int getColumnCount() {
		return entete.length;
	}

	/**
	 * Accesseur permettant de recuperer le nombre de lignes en recuperant le
	 * nombre d'occurences dans notre collection
	 * 
	 * @return nbLignes de type int
	 */
	@Override
	public int getRowCount() {
		return listeVisiteur.size();
	}

	/**
	 * Accesseur permettant de recuperer le noms des colonnes dans notre entète
	 * predefini
	 * 
	 * @return nameColumn de type String
	 */
	@Override
	public String getColumnName(int column) {
		return entete[column];
	}

	/**
	 * Accesseur permettant de recuperer les occurrences correspondants dans
	 * notre collection
	 * 
	 * @return valeurs de type String ou int
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listeVisiteur.get(rowIndex).getIdVisiteur();
		case 1:
			return listeVisiteur.get(rowIndex).getNomVisiteur();
		case 2:
			return listeVisiteur.get(rowIndex).getPrenomVisiteur();
		default:
			throw new IllegalArgumentException();
		}
	}

}
