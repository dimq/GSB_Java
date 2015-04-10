/**
 * 
 */
package com.metier;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe metier LigneFraisHorsForfait
 * 
 * Permet l'instanciation d'un objet de type LigneFraisHorsForfait
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="lignefraishorsforfait")
public class LigneFraisHorsForfait
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private int idLigne;
    @Column(name="idVisiteur")
    private String idVisiteur;
    @Column(name="mois")
    private String mois;
    @Column(name="libelle")
    private String libelle;
    @Column(name="date")
    private Date date;
    @Column(name="montant")
    private BigDecimal montant;
    /**
     * 
     */
    public LigneFraisHorsForfait()
    {
        super();
    }
    /**
     * Constructeur public, cree l'instance de LigneFraisHorsForfait qui sera solicitee pour
     * toutes les méthodes de la classe
     * 
     * @param idLigne type int
     * @param idVisiteur type String
     * @param mois type String
     * @param libelle type String
     * @param date type String
     * @param montant type double
     */
    public LigneFraisHorsForfait(int idLigne, String idVisiteur, String mois, String libelle,
            Date date, BigDecimal montant)
    {
        super();
        this.idLigne = idLigne;
        this.idVisiteur = idVisiteur;
        this.mois = mois;
        this.libelle = libelle;
        this.date = date;
        this.montant = montant;
    }
    /**
     * @return the idLigne
     */
    public int getIdLigne()
    {
        return idLigne;
    }
    /**
     * @param idLigne the idLigne to set
     */
    public void setIdLigne(int idLigne)
    {
        this.idLigne = idLigne;
    }
    /**
     * @return the idVisiteur
     */
    public String getIdVisiteur()
    {
        return idVisiteur;
    }
    /**
     * @param idVisiteur the idVisiteur to set
     */
    public void setIdVisiteur(String idVisiteur)
    {
        this.idVisiteur = idVisiteur;
    }
    /**
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
     * @return the libelle
     */
    public String getLibelle()
    {
        return libelle;
    }
    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }
    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
    /**
     * @return the montant
     */
    public BigDecimal getMontant()
    {
        return montant;
    }
    /**
     * @param montant the montant to set
     */
    public void setMontant(BigDecimal montant)
    {
        this.montant = montant;
    }
    
}