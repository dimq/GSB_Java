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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe métier Region
 * 
 * Permet l'instanciation d'un objet de type Region
 * 
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="regions")
public class Region
{
    public Region()
    {
        super();
    }
    @Id
    @GeneratedValue
    @Column(name="idRegion")
    private int idRegion;
    @Column(name="libelleRegion")
    private String libelleRegion;
    @OneToMany(mappedBy="region")
    private List<Utilisateur> listeUtilisateur;
    /**
     * Constructeur public, cree l'instance de Region sans l'id qui est
     * auto dans la base de donne et qui sera sollicitee pour
     * toutes les methodes de la classe
     * 
     * @param idRegion
     *            de type int
     * @param libelleRegion
     *            de type String
     */
    public Region(String libelleRegion)
    {
        super();
        this.libelleRegion = libelleRegion;
        this.listeUtilisateur = new ArrayList<Utilisateur>();
    }
    /**
     * Accesseur sur la propriété idRegion nomme getidRegion et qui renvoie l'id de 
     * la region
     * @return idRegion de type int
     */
    public int getIdRegion()
    {
        return idRegion;
    }
    /**
     * Modificateur sur la propriete idRegion nomme setIdRegion et qui modifie l'id
     * @param idRegion the idRegion to set
     */
    public void setIdRegion(int idRegion)
    {
        this.idRegion = idRegion;
    }
    /**
     * Accesseur sur la propriété libelleRegion nomme getLibelleRegion et qui renvoie le libelle de 
     * la region
     * @return the libelleRegion
     */
    public String getLibelleRegion()
    {
        return libelleRegion;
    }
    /**
     * Modificateur sur la propriété libelleRegion nomme setLibelleRegion et qui modifie
     * le libelle de la region
     * @param libelleRegion the libelleRegion to set
     */
    public void setLibelleRegion(String libelleRegion)
    {
        this.libelleRegion = libelleRegion;
    }
    /**
     * Accesseur sur la liste d'utilisateur nomme getListeUtilisateur et qui renvoie 
     * une List
     * @return the listeUtilisateur
     */
    public List<Utilisateur> getListeUtilisateur()
    {
        return listeUtilisateur;
    }
    /**
     * Modificateur sur la liste d'utilisateur nomme setListeUtilisateur qui permet de
     * modifier cette liste
     * @param listeUtilisateur the listeUtilisateur to set
     */
    public void setListeUtilisateur(List<Utilisateur> listeUtilisateur)
    {
        this.listeUtilisateur = listeUtilisateur;
    }
    
    
    /**
     * Retourne une hashmap<utilisateur,nombre de ligne frais hors forfait> 
     * pour le mois donn�e
     * @param le mois en question
     */
    
    public  HashMap<Utilisateur,Integer> nbFicheHorsForfait(String mois)
    {
    	HashMap<Utilisateur, Integer> stat = new HashMap<Utilisateur, Integer>();
    	ArrayList<Utilisateur> lstu =new ArrayList<Utilisateur>();
    	for(Utilisateur u : this.getListeUtilisateur()){
    		lstu.add(u);
    	}
    
    	int nb = 0;
    	for(Utilisateur p : lstu){
    		
    			for(FicheFrais f : p.getListeFicheFrais()){
    				nb=f.nbMontantHorsForfait(mois)+nb;
    			}
    			
    			stat.put(p, nb);
    			nb=0;
    		
    		
    	}
    	return stat; 
    	
    	
    }
    
}