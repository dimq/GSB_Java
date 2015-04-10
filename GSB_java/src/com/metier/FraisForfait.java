/**
 * 
 */
package com.metier;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author quenault-d
 *
 */
@Entity
@Table(name="fraisforfait")
public class FraisForfait
{
    @Id
    @Column(name="id")
    private String idFraisForfait;
    @Column(name="libelle")
    private String libelleFraisForfait;
    @Column(name="montant")
    private BigDecimal montant;
    /**
     * 
     */
    public FraisForfait()
    {
        super();
    }
    
    public FraisForfait(String idFraisForfait, String libelleFraisForfait, BigDecimal montant)
    {
        super();
        this.idFraisForfait = idFraisForfait;
        this.libelleFraisForfait = libelleFraisForfait;
        this.montant = montant;
    }

    /**
     * Accesseur sur la propriété idFraisForfait et qui renvoie une chaine
     * @return the idFraisForfait type String
     */
    public String getIdFraisForfait()
    {
        return idFraisForfait;
    }
    /**
     * Modificateur sur idFraisForfait nomme setIdFraisForfait et qui permet de modifier
     * l'id d'un frais forfait
     * @param idFraisForfait the idFraisForfait to set type String
     */
    public void setIdFraisForfait(String idFraisForfait)
    {
        this.idFraisForfait = idFraisForfait;
    }
    /**
     * Accesseur sur la propriete libelleFraisForfait nomme getLibelleFraisForfait et qui
     * renvoie une chaine
     * @return the libelleFraisForfait type String
     */
    public String getLibelleFraisForfait()
    {
        return libelleFraisForfait;
    }
    /**
     * Modificateur sur la propriete libelleFraisForfait nomme setLibelleFraisForfait et qui permet
     * de modifier le libelle d'un frais forfait
     * @param libelleFraisForfait the libelleFraisForfait to set type String
     */
    public void setLibelleFraisForfait(String libelleFraisForfait)
    {
        this.libelleFraisForfait = libelleFraisForfait;
    }
    /**
     * Accesseur sur la propriete montant nomme getMontant et qui renvoie un
     * double
     * @return the montant type double
     */
    public BigDecimal getMontant()
    {
        return montant;
    }
    /**
     * Modificateur sur la propriete montant nomme setMontant et qui permet de modifier
     * le montant d'un frais forfait
     * @param montant the montant to set type double
     */
    public void setMontant(BigDecimal montant)
    {
        this.montant = montant;
    }
    

}
