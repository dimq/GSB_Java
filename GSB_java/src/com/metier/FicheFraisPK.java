package com.metier;
import javax.persistence.Embeddable;

/**
 * Classe de gestion de la cle primaire compose sur la classe FicheFrais
 * 
 * @author b0dian
 * @version 1.0
 */
@Embeddable
public class FicheFraisPK implements java.io.Serializable
{
    private String idVisiteur;
    private String mois;
    /**
     * 
     */
    public FicheFraisPK()
    {
        super();
    }
    public FicheFraisPK(String idVisiteur, String mois) 
    {
        this.idVisiteur = idVisiteur;
        this.mois = mois;
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
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idVisiteur == null) ? 0 : idVisiteur.hashCode());
        result = prime * result + ((mois == null) ? 0 : mois.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FicheFraisPK other = (FicheFraisPK) obj;
        if (idVisiteur == null) {
            if (other.idVisiteur != null)
                return false;
        }
        else if (!idVisiteur.equals(other.idVisiteur))
            return false;
        if (mois == null) {
            if (other.mois != null)
                return false;
        }
        else if (!mois.equals(other.mois))
            return false;
        return true;
    }

}
