package com.metier;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

/**
 * Classe metier FicheFrais
 * 
 * Permet l'instanciation d'un objet de type FicheFrais
 * 
 * @author b0dian
 * @version 1.0
 *
 */
@Entity
@Table(name="fichefrais")
// lien vers la classe FicheFraisPK qui gére la clé primaire
@IdClass(FicheFraisPK.class)
@Embeddable
public class FicheFrais implements Serializable
{
    @Id
    @Columns(columns = {@Column(name = "idVisiteur",insertable=false, updatable=false),
    @Column(name = "mois",insertable=false, updatable=false)
    })
    private String idVisiteur;
    private String mois;
    
    @Column(name="nbJustificatifs")
    private int nbJustificatifs;
    @Column(name="montantValide")
    private BigDecimal montantValide;
    @Column(name="dateModif")
    private Date dateModif;
    @OneToMany
    @JoinColumns({
    @JoinColumn(name="idVisiteur", insertable=false, updatable=false),
    @JoinColumn(name="mois", insertable=false, updatable=false)})
    private List<LigneFraisForfait> listeLigneFraisForfait;
    @OneToMany
    @JoinColumns({
    @JoinColumn(name="idVisiteur", insertable=false, updatable=false),
    @JoinColumn(name="mois", insertable=false, updatable=false)})
    private List<LigneFraisHorsForfait> listeLigneFraisHorsForfait;
    
    public FicheFrais()
    {
        super();
    }
    /**
     * Constructeur public, cree l'instance de FicheFrais qui sera solicitee pour
     * toutes les méthodes de la classe
     * 
     * @param idUtilisateur type String
     * @param mois type String
     * @param nbJustificatifs type int
     * @param montant type double
     * @param dateModif type String
     * @param listeLigneFraisForfait type List<LigneFraisForfait>
     * @param listeLigneFraisHorsForfait type List<LigneFraisHorsForfait>
     */
    public FicheFrais(String idUtilisateur,String mois,int nbJustificatifs, BigDecimal montant,Date dateModif,List<LigneFraisForfait> listeLigneFraisForfait,List<LigneFraisHorsForfait> listeLigneFraisHorsForfait)
    {
        super();
        this.dateModif = dateModif;
        this.idVisiteur = idUtilisateur;
        this.listeLigneFraisForfait = listeLigneFraisForfait;
        this.listeLigneFraisHorsForfait = listeLigneFraisHorsForfait;
        this.mois = mois;
        this.montantValide = montant;
        this.nbJustificatifs = nbJustificatifs;
    }
    /**
     * Accesseur sur la propriete idUtilisateur nomme getIdUtilisateur qui renvoie l'id de l'utilisateur concerné
     * 
     * @return the idUtilisateur
     */
    public String getIdUtilisateur()
    {
        return idVisiteur;
    }
    /**
     * Modificateur sur la propriete idUtilisateur nomme setIdUtilisateur qui modifie l'id de l'utilisateur concerné
     * 
     * @param idUtilisateur the idUtilisateur to set
     */
    public void setIdUtilisateur(String idUtilisateur)
    {
        this.idVisiteur = idUtilisateur;
    }
    /**
     * Accesseur sur la propriete mois nomme getMois qui renvoie le mois correspondant
     * 
     * @return the mois
     */
    public String getMois()
    {
        return mois;
    }
    /**
     * @param mois the mois to set
     */
    public void setMois(String mois)
    {
        this.mois = mois;
    }
    /**
     * @return the nbJustificatifs
     */
    public int getNbJustificatifs()
    {
        return nbJustificatifs;
    }
    /**
     * @param nbJustificatifs the nbJustificatifs to set
     */
    public void setNbJustificatifs(int nbJustificatifs)
    {
        this.nbJustificatifs = nbJustificatifs;
    }
    /**
     * @return the montantValide
     */
    public BigDecimal getMontantValide()
    {
        return montantValide;
    }
    /**
     * @param montantValide the montantValide to set
     */
    public void setMontantValide(BigDecimal montantValide)
    {
        this.montantValide = montantValide;
    }
    /**
     * @return the dateModif
     */
    public Date getDateModif()
    {
        return dateModif;
    }
    /**
     * @param dateModif the dateModif to set
     */
    public void setDateModif(Date dateModif)
    {
        this.dateModif = dateModif;
    }
    /**
     * @return the listeLigneFraisForfait
     */
    public List<LigneFraisForfait> getListeLigneFraisForfait()
    {
        return listeLigneFraisForfait;
    }
    /**
     * @param listeLigneFraisForfait the listeLigneFraisForfait to set
     */
    public void setListeLigneFraisForfait(List<LigneFraisForfait> listeLigneFraisForfait)
    {
        this.listeLigneFraisForfait = listeLigneFraisForfait;
    }
    /**
     * @return the listeLigneFraisHorsForfait
     */
    public List<LigneFraisHorsForfait> getListeLigneFraisHorsForfait()
    {
        return listeLigneFraisHorsForfait;
    }
    /**
     * @param listeLigneFraisHorsForfait the listeLigneFraisHorsForfait to set
     */
    public void setListeLigneFraisHorsForfait(List<LigneFraisHorsForfait> listeLigneFraisHorsForfait)
    {
        this.listeLigneFraisHorsForfait = listeLigneFraisHorsForfait;
    }
    
    
    /**
     * Retourne pour une fiche frais et un mois donner le nombre de lignes frais hors forfait 
     * 
     * @param mois
     * @return le nombre de ligne
     */
    
    public int nbMontantHorsForfait(String mois){
    	int nb = 0;
    	ArrayList<LigneFraisHorsForfait> lsts= new ArrayList<LigneFraisHorsForfait>();
    	for(LigneFraisHorsForfait fr:this.getListeLigneFraisHorsForfait())
    	{
    		lsts.add(fr);
    	}   
    	
    	for(LigneFraisHorsForfait lfhf : lsts){
    		if (lfhf.getMois().equals(mois)){
    			nb=nb+1;
    		}
    		
    	}
    	
    	return nb;
    }
    
}