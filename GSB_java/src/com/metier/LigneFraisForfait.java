/**
 * 
 */
package com.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

/**
 * Classe metier LigneFraisForfait
 * 
 * Permet l'instanciation d'un objet de type LigneFraisForfait
 * 
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="lignefraisforfait")
//lien vers la classe FicheFraisPK qui gére la clé primaire
@IdClass(LigneFraisForfaitPK.class)
@Embeddable
public class LigneFraisForfait implements Serializable
{
    @Id
    @Columns(columns = {@Column(name = "idVisiteur",insertable=false, updatable=false),
    @Column(name = "mois",insertable=false, updatable=false),@Column(name = "idFraisForfait",insertable=false, updatable=false)
    })
    private String idVisiteur;
    private String mois;
    @ManyToOne
    @JoinColumn(name="idFraisForfait", insertable=false, updatable=false)
    private String idFraisForfait;
    @ManyToOne
    @JoinColumn(name="idFraisForfait", insertable=false, updatable=false)
    private FraisForfait fraisForfait;
    @Column(name="quantite")
    private int quantite;
    
    public LigneFraisForfait()
    {
        super();
    }
    /**
     * Constructeur public, cree l'instance de LigneFraisForfait qui sera solicitee pour
     * toutes les methodes de la classe
     * 
     * @param idVisiteur de type String
     * @param mois de type String
     * @param idFraisForfait de type String
     * @param quantite de type int
     */
    public LigneFraisForfait(String idVisiteur,String mois,String idFraisForfait,int quantite)
    {
        super();
        this.idFraisForfait = idFraisForfait;
        this.idVisiteur = idVisiteur;
        this.mois = mois;
        this.quantite = quantite;
    }
    /**
     * Accesseur sur la propriete idVisiteur nomme getIdVisiteur et qui renvoie
     * l'id du visiteur
     * @return the idVisiteur type String
     */
    public String getIdVisiteur()
    {
        return idVisiteur;
    }
    /**
     * Modificateur sur la propriete idVisiteur nomme setIdVisiteur et qui modifie 
     * l'id du visiteur
     * @param idVisiteur the idVisiteur to set type String
     */
    public void setIdVisiteur(String idVisiteur)
    {
        this.idVisiteur = idVisiteur;
    }
    /**
     * Accesseur sur la propriete mois nomme getMois et qui renvoie le mois
     * de la ligne de frais forfait
     * @return the mois type String
     */
    public String getMois()
    {
        return mois;
    }
    /**
     * Modificateur sur la propriete mois nomme setMois et qui modifie le mois
     * de la ligne de frais forfait
     * @param mois the mois to set type String
     */
    public void setMois(String mois)
    {
        this.mois = mois;
    }
    /**
     * Accesseur sur la propriete idFraisForfait nomme getIdFraisForfait et qui permet
     * de recuper l'id du frais forfait correspondant
     * @return the idFraisForfait type String
     */
    public String getIdFraisForfait()
    {
        return idFraisForfait;
    }
    /**
     * Modificateur sur la propriete idFraisForfait nomme getIdFraisForfait et qui permet
     * de modifier l'id du frais forfait correspondant
     * @param idFraisForfait the idFraisForfait to set type String
     */
    public void setIdFraisForfait(String idFraisForfait)
    {
        this.idFraisForfait = idFraisForfait;
    }
    /**
     * Accesseur sur la propriete quantite nomme getQuantite et qui permet
     * de recuper la quantite
     * @return the quantite type int
     */
    public int getQuantite()
    {
        return quantite;
    }
    /**
     * Modificateur sur la propriete quantite nomme setQuantite et qui permet
     * de modifier la quantite
     * @param quantite the quantite to set
     */
    public void setQuantite(int quantite)
    {
        this.quantite = quantite;
    }
	/**
	 * Accesseur permettant de recuperer le frais forfait correspondant
	 * @return the fraisForfait
	 */
	public FraisForfait getFraisForfait() {
		return fraisForfait;
	}
	/**
	 * 
	 * Modificateur sur le frais forfait correspondant afin de le modifier
	 * @param fraisForfait the fraisForfait to set
	 */
	public void setFraisForfait(FraisForfait fraisForfait) {
		this.fraisForfait = fraisForfait;
	}
    

}
