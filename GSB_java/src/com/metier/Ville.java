/**
 * 
 */
package com.metier;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe métier Ville
 * 
 * Permet l'instanciation d'un objet de type Ville
 * 
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="villes")
public class Ville
{
    public Ville()
    {
        super();
    }
    @Id
    @GeneratedValue
    @Column(name="id_ville")
    private int idVille;
    @Column(name="nom")
    private String nomVille;
    @Column(name="cp")
    private String cp;
    @ManyToOne
    @JoinColumn(name="code_departement")
    private Departement departement;
    @OneToMany(mappedBy="ville")
    private List<Visiteur> listeVisiteur;
    /**
     * Constructeur public, cree l'instance de Ville sans l'id qui est
     * auto dans la base de donne et qui sera sollicitee pour
     * toutes les methodes de la classe
     * 
     * @param nomVille
     *            de type String
     * @param cp
     *            de type String
     */
    public Ville(String nomVille,String cp)
    {
        super();
        this.nomVille = nomVille;
        this.cp = cp;
    }
	/**
	 * @return the idVille
	 */
	public int getIdVille() {
		return idVille;
	}
	/**
	 * @param idVille the idVille to set
	 */
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}
	/**
	 * @return the nomVille
	 */
	public String getNomVille() {
		return nomVille;
	}
	/**
	 * @param nomVille the nomVille to set
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}
	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	/**
	 * @return the listeVisiteur
	 */
	public List<Visiteur> getListeVisiteur() {
		return listeVisiteur;
	}
	/**
	 * @param listeVisiteur the listeVisiteur to set
	 */
	public void setListeVisiteur(List<Visiteur> listeVisiteur) {
		this.listeVisiteur = listeVisiteur;
	}
    
}