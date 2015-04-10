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
public class ModeleUtilisateur extends AbstractTableModel {

	private String[] entete = { "Identifiant", "Nom", "Prenom" };
	private List<Utilisateur> listeUtilisateur;

	/**
	 * Constructeur public, cree une instance de Modele de stations en
	 * recuperant notre collection de stations
	 * 
	 * @param listesStation
	 *            de type collection de stations
	 */
	public ModeleUtilisateur(List<Utilisateur> listesUtilisateur) {
		listeUtilisateur = listesUtilisateur;
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
		return listeUtilisateur.size();
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
			return listeUtilisateur.get(rowIndex).getIdUtilisateur();
		case 1:
			return listeUtilisateur.get(rowIndex).getNomUtilisateur();
		case 2:
			return listeUtilisateur.get(rowIndex).getPrenomUtilisateur();
		default:
			throw new IllegalArgumentException();
		}
	}

}
