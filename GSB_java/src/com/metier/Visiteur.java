/**
 * 
 */
package com.metier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe metier Visiteur
 * 
 * Permet l'instanciation d'un objet de type Visiteur
 * 
 * @author b0dian
 * @version 1.0
 */
@Entity
@Table(name="Visiteur")
public class Visiteur 
{
    @Id
    @Column(name="id")
    private String idVisiteur; 
    

    @Column(name="nom")
    private String nomVisiteur ;
    @Column(name="prenom")
    private String prenomVisiteur;
    @Column(name="numPortable")
    private String numPort;
    @Column(name="numFixe")
    private String numFixe;
    @Column(name="login")
    private String login;
    @Column(name="mdp")
    private String mdp;
    @Column(name="mailPro")
    private String mailPro;
    @Column(name="adresse")
    private String adressseRue;
    @Column(name="cp")
    private String cp;
    @Column(name="ville")
    private String ville;
    @Column(name="dateEmbauche")
    private Date dateEmbauche;
    @Column(name="idType")
    private String idType;
    @ManyToOne
    @JoinColumn(name="idRegion")
    private Region region;
    @OneToMany
    @JoinColumn(name="idVisiteur")
    private List<FicheFrais> listeFicheFrais;
    @Column(name="suppr")
    private String suppr;
    
    
    /**
     * Constructeur public, cree l'instance de Visiteur a
     * avec les information minimumns
     * 
     * @param idVisiteur
     *            de type string
     * @param nomVisiteur
     *            de type String
     * @param prenomVisiteur
     *          de type String
     */
    
    public Visiteur() {
    
        super();
        
        // TODO Auto-generated constructor stub
    }
    
    public Visiteur(String idVisiteur,String nomVisiteur,String prenomVisiteur,String adresse,String cp,String ville,String idType,Region region) {
        
        this.idVisiteur=idVisiteur;
        this.nomVisiteur=nomVisiteur;
        this.prenomVisiteur=prenomVisiteur;
        this.listeFicheFrais=new ArrayList<FicheFrais>();
        this.adressseRue = adresse;
        this.cp = cp;
        this.idType = idType;
        this.login = creerLogin();
        this.mailPro = creerMail();
        this.mdp = "gsb1234";
        this.region = region;
        this.ville = ville;
    }
    /**
     * Constructeur Visiteur surcharge avec les numeros de telephones et la date d'embauche
     */
    public Visiteur(String idVisiteur,String nomVisiteur,String prenomVisiteur,String portable,String fixe,String adresse,String cp,String ville,Date dateEmbauche,String idType,Region region) {
        
        this.idVisiteur=idVisiteur;
        this.nomVisiteur=nomVisiteur;
        this.prenomVisiteur=prenomVisiteur;
        this.listeFicheFrais=new ArrayList<FicheFrais>();
        this.adressseRue = adresse;
        this.cp = cp;
        this.idType = idType;
        this.login = creerLogin();
        this.mailPro = creerMail();
        this.mdp = "gsb1234";
        this.region = region;
        this.ville = ville;
        this.numFixe = fixe;
        this.numPort = portable;
        this.dateEmbauche = dateEmbauche;
    }
    
    /**
     * Accesseur sur la propriÃ©tÃ© nomVisiteur
     * @return nomVisiteur de type String
     */
    
    public String getNomVisiteur() {
        return nomVisiteur;
    }
    
    
    /**
     * Modificateur sur la propriete nomVisiteur 
     * @param nomVisiteur the nomVisiteur to set
     */

    public void setNomVisiteur(String nomVisiteur) {
        this.nomVisiteur = nomVisiteur;
    }

    /**
     * Accesseur sur la propriÃ©tÃ© prenomVisiteur
     * @return prenomVisiteur de type String
     */

    public String getPrenomVisiteur() {
        return prenomVisiteur;
    }
    
    /**
     * Modificateur sur la propriete prenomVisiteur 
     * @param prenomVisiteur the prenomVisiteur to set
     */

    public void setPrenomVisiteur(String prenomVisiteur) {
        this.prenomVisiteur = prenomVisiteur;
    }

    /**
     * Accesseur sur la propriÃ©tÃ© numPort
     * @return numPort de type String
     */
    public String getNumPort() {
        return numPort;
    }
     
    /**
     * Modificateur sur la propriete numPort 
     * @param numPort the numPort to set
     */

    public void setNumPort(String numPort) {
        this.numPort = numPort;
    }

    /**
     * Accesseur sur la propriÃ©tÃ© numFixe
     * @return numFixe de type String
     */
    public String getNumFixe() {
        return numFixe;
    }
    
    /**
     * Modificateur sur la propriete numFixe 
     * @param numFixe the numFixe to set
     */

    public void setNumFixe(String numFixe) {
        this.numFixe = numFixe;
    }

    /**
     * Accesseur sur la propriÃ©tÃ© login
     * @return login de type String
     */

    public String getLogin() {
        return login;
    }
     
    /**
     * Modificateur sur la propriete login 
     * @param login the login to set
     */

    public void setLogin(String login) {
        this.login = login;
    }

    
    /**
     * Accesseur sur la propriÃ©tÃ© mot de passe
     * @return mdp de type String
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Modificateur sur la propriete mdp 
     * @param mdp the mdp to set
     */

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    /**
     * Accesseur sur la propriÃ©tÃ© adresseRue
     * @return adresseRue de type String
     */
    
    public String getAdressseRue() {
        return adressseRue;
    }

    /**
     * Modificateur sur la propriete adressseRue 
     * @param adressseRue the adressseRue to set
     */


    public void setAdressseRue(String adressseRue) {
        this.adressseRue = adressseRue;
    }
    
    
    
    /**
     * Accesseur sur la propriÃ©tÃ© code postale
     * @return cp de type String
     */

    public String getCp() {
        return cp;
    }

    /**
     * Modificateur sur la propriete cp 
     * @param cp the cp to set
     */

    public void setCp(String cp) {
        this.cp = cp;
    }


    /**
     * Accesseur sur la propriÃ©tÃ© ville
     * @return ville de type String
     */
    
    public String getVille() {
        return ville;
    }
    
    /**
     * Modificateur sur la propriete ville 
     * @param ville the ville to set
     */



    public void setVille(String ville) {
        this.ville = ville;
    }

    
    /**
     * Accesseur sur la propriÃ©tÃ© dateEmbauche
     * @return dateEmbauche de type String
     */
    
    public Date getDateEmbauche() {
        return dateEmbauche;
    }
    
    /**
     * Modificateur sur la propriete dateEmbauche 
     * @param dateEmbauche the dateEmbauche to set
     */



    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    
    /**
     * Accesseur sur la propriÃ©tÃ© le type de l'Visiteur
     * @return idType de type String
     */
    
    public String getIdType() {
        return idType;
    }
    
    
    /**
     * Modificateur sur la propriete idType 
     * @param idType the idType to set
     */



    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * Accesseur sur la propriÃ©tÃ© l'objet rÃ©gion de l'Visiteur
     * @return region de type Region
     */

    public Region getRegion() {
        return region;
    }
    
    /**
     * Modificateur sur la propriete region 
     * @param region the region to set
     */



    public void setRegion(Region region) {
        this.region = region;
    }

     
    /**
     * Accesseur sur la propriÃ©tÃ© listeFicheFrais
     * @return listeFicheFrais de type List
     */
    
    public List<FicheFrais> getListeFicheFrais() {
        return listeFicheFrais;
    }

    /**
     * Modificateur sur la propriete listeFicheFrais 
     * @param listeFicheFrais the listeFicheFrais to set
     */

    public void setListeFicheFrais(List<FicheFrais> listeFicheFrais) {
        this.listeFicheFrais = listeFicheFrais;
    }

    
    /**
     * Accesseur sur la propriÃ©tÃ© idVisiteur
     * @return idVisiteur de type String
     */
    public String getIdVisiteur() {
        return idVisiteur;
    }
    
    /**
     * creerLogin fonction de génération automatique du login de l'Visiteur
     */
    public String creerLogin()
    {
        String login;
        login = nomVisiteur+"-"+prenomVisiteur.substring(0, 1);
        login = login.toLowerCase();
        return login;
    }
    /**
     * creerLogin fonction de génération automatique du login de l'Visiteur
     */
    public String creerMail()
    {
        String mail;
        mail = nomVisiteur+"."+prenomVisiteur+"@gsb.fr";
        mail = mail.toLowerCase();
        mailPro = mail;
        return mail;
    }
    

	/**
	 * @return the mailPro
	 */
	public String getMailPro() {
		return mailPro;
	}

	/**
	 * @param mailPro the mailPro to set
	 */
	public void setMailPro(String mailPro) {
		this.mailPro = mailPro;
	}

	/**
	 * @param idVisiteur the idVisiteur to set
	 */
	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}

	/**
	 * @return the suppr
	 */
	public String getSuppr() {
		return suppr;
	}

	/**
	 * @param suppr the suppr to set
	 */
	public void setSuppr(String suppr) {
		this.suppr = suppr;
	}
    
}