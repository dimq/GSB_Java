/**
 * 
 */
package com.metier;
import java.util.ArrayList;
import java.util.HashMap;
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
 * Classe métier Departement
 * 
 * Permet l'instanciation d'un objet de type Departement
 * 
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="departements")
public class Departement
{
    @Id
    @GeneratedValue
    @Column(name="code_departement")
    private String codeDepartement;
    @Column(name="nom_departement")
    private String libelleDepartement;
    @ManyToOne
    @JoinColumn(name="idRegion")
    private Region region;
    @OneToMany(mappedBy="departement")
    private List<Ville> listeVille;
    @OneToMany(mappedBy="departement")
    private List<Visiteur> listeVisiteur;
    
    public Departement()
    {
        super();
    }
    /**
     * Constructeur public, cree l'instance de Departement sans l'id qui est
     * auto dans la base de donne et qui sera sollicitee pour
     * toutes les methodes de la classe
     * 
     * @param code
     *            de type String
     * @param libelleDepartement
     *            de type String
     */
    public Departement(String libelleDepartement)
    {
        super();
        this.libelleDepartement = libelleDepartement;
    }
	/**
	 * @return the libelleDepartement
	 */
	public String getLibelleDepartement() {
		return libelleDepartement;
	}
	/**
	 * @param libelleDepartement the libelleDepartement to set
	 */
	public void setLibelleDepartement(String libelleDepartement) {
		this.libelleDepartement = libelleDepartement;
	}
	/**
	 * @return the listeVille
	 */
	public List<Ville> getListeVille() {
		return listeVille;
	}
	/**
	 * @param listeVille the listeVille to set
	 */
	public void setListeVille(List<Ville> listeVille) {
		this.listeVille = listeVille;
	}
	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}
	/**
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
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