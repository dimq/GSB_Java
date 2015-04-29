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
    private List<Visiteur> listeVisiteur;
    @OneToMany(mappedBy="region")
    private List<Departement> listeDepartement;
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
        this.listeVisiteur = new ArrayList<Visiteur>();
        this.listeDepartement = new ArrayList<Departement>();
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
     * Accesseur sur la liste d'Visiteur nomme getListeVisiteur et qui renvoie 
     * une List
     * @return the listeVisiteur
     */
    public List<Visiteur> getListeVisiteur()
    {
        return listeVisiteur;
    }
    /**
     * Modificateur sur la liste d'Visiteur nomme setListeVisiteur qui permet de
     * modifier cette liste
     * @param listeVisiteur the listeVisiteur to set
     */
    public void setListeVisiteur(List<Visiteur> listeVisiteur)
    {
        this.listeVisiteur = listeVisiteur;
    }
    
    
    /**
     * Retourne une hashmap<Visiteur,nombre de ligne frais hors forfait> 
     * pour le mois donn�e
     * @param le mois en question
     */
    
    public  HashMap<Visiteur,Integer> nbFicheHorsForfait(String mois)
    {
    	HashMap<Visiteur, Integer> stat = new HashMap<Visiteur, Integer>();
    	ArrayList<Visiteur> lstu =new ArrayList<Visiteur>();
    	for(Visiteur u : this.getListeVisiteur()){
    		lstu.add(u);
    	}
    
    	int nb = 0;
    	for(Visiteur p : lstu){
    		
    			for(FicheFrais f : p.getListeFicheFrais()){
    				nb=f.nbMontantHorsForfait(mois)+nb;
    			}
    			
    			stat.put(p, nb);
    			nb=0;
    		
    		
    	}
    	return stat; 
    	
    	
    }
	/**
	 * @return the listeDepartement
	 */
	public List<Departement> getListeDepartement() {
		return listeDepartement;
	}
	/**
	 * @param listeDepartement the listeDepartement to set
	 */
	public void setListeDepartement(List<Departement> listeDepartement) {
		this.listeDepartement = listeDepartement;
	}
	
	public Double MoyenneMontantFraisForfait(String mois) {
	
	 
	    Double  montant=00.0;
	    	List<Visiteur> lv=this.getListeVisiteur();
	    	
	    	for(Visiteur v : lv){
	    		montant = montant + v.getMontantFraisForfait(mois);
	    	}
	    	
	        
	        montant=montant/lv.size();
	        
	    
	    
	    return montant;
	}
	
	public Double MoyenneMontantFraisHorsForfait(String mois) {
		
		 
	    Double  montant=00.0;
	    	List<Visiteur> lv=this.getListeVisiteur();
	    	
	    	for(Visiteur v : lv){
	    		montant=montant+v.getMontantFraisHorsForfait(mois);
	    	}
	    	
	        
	        montant=montant/lv.size();
	        
	    
	    
	    return montant;
	}
	
	
	}
	
	
    
