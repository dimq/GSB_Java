package com.persistance;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Departement;
import com.metier.FicheFrais;
import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.metier.Visiteur;
import com.util.HibernateSession;

/**
 * Classe persistance AccesData
 * 
 * Permet l'instanciation d'un objet de type AccesData qui delivre des methodes
 * appelant le framework Hibernate
 * 
 * @author b0dian
 * @version 1.0
 */
public class AccesData {
    // proprietees
    private static Session session = HibernateSession.getSession();

    // accesseurs sur les proprietes du dessus
    /**
     * Accesseur getVisiteur qui prend en parramï¿½tre un id Visiteur et nous
     * renvoie l'Visiteur correspondant en utilisant la methode find
     * 
     * @param id
     *            de type String
     * @return s de type Visiteur
     */
    public static Visiteur getVisiteur(String id) {
        Visiteur Visiteur = (Visiteur) session.get(Visiteur.class, id);
        return Visiteur;
    }

    /**
     * Accesseur getListVisiteur qui renvoie tout les Visiteurs en utilisant la
     * methode retrieve
     * 
     * @return listeStation de type collections de stations
     */
    public static List<Visiteur> getListVisiteur() {
        List<Visiteur> listVisiteurs = session.createQuery("from Visiteur order by nom").list();
        return listVisiteurs;
    }

    /**
     * Accesseur getRegion qui prend en parramï¿½tre un id de region et nous renvoie
     * la region correspondante en utilisant la methode find
     * 
     * @param id
     *            de type int
     * @return b de type region
     */
    public static Region getRegion(int id) {
        Region region = (Region) session.get(Region.class, id);
        return region;
    }

    /**
     * Accesseur getListRegion qui renvoie toutes les Regions en utilisant la methode
     * retrieve
     * 
     * @return listeRegion de type collections de Region
     */
    public static List<Region> getListRegion() {
        List<Region> listRegion = session.createQuery("from Region order by libelleRegion").list();
        return listRegion;
    }
    
    /**
     * Accesseur getListDepartement qui renvoie tout les Departements en utilisant la methode
     * retrieve
     * 
     * @return listeDepartement de type collections de Departement
     */
    public static List<Departement> getListDepartement() {
        List<Departement> listDepartement = session.createQuery("from Departement order by nom_departement").list();
        return listDepartement;
    }

    /**
     * Accesseur getVisiteurByRegion qui renvoie tout les Visiteurs existant
     * dans la region correspondante grace a l'id de region passe en parramï¿½tre en utilisant
     * la methode retrieve par id
     * 
     * @return listeVisiteurs de type collections d'Visiteurs
     */
    public static List<Visiteur> getVisiteurByRegion(int id) {
        List<Visiteur> listVisiteur = session.createQuery("from Visiteur where idRegion="+id+" order by nom").list();
        return listVisiteur;
    }

    /**
     * Accesseur getFicheFrais qui renvoie la fiche de frais correspondante a l'id
     * passe en parrametre
     * 
     * @return listFicheFrais de type collection de fiche frais
     */
    public static List<FicheFrais> getFichesFrais(String idVisiteur) {
        List<FicheFrais> listFicheFrais = session.createQuery("from FicheFrais where idVisiteur = '"+idVisiteur+"'").list();
        return listFicheFrais;
    }
    /**
     * Accesseur getFicheFraisRembourse qui renvoie un booleen specifiant si toutes les
     * fiches frais ont ete rembourse true si toutes rembourse sinon false
     * 
     * @return boolean
     */
    public static boolean getFicheFraisRembourse(String idVisiteur) {
        List<FicheFrais> listFicheFrais = getFichesFrais(idVisiteur);
        boolean test =true;
        int i =0;
        while (test == true && i < listFicheFrais.size())
        {
        	if (!listFicheFrais.get(i).getEtat().equals("RB"))
        	{
        		test=false;
        	}
        	i++;
        }
        return test;
    }

    /**
     * Accesseur getListFicheFrais qui renvoie toutes les fiches de frais existantes
     * dans la base de donne grace a la methode retrieve
     * 
     * @return listFicheFrais de type collection de fiche frais
     */
    public static List<FicheFrais> getListFicheFrais() {
        List<FicheFrais> listFicheFrais= session.createQuery("from FicheFrais").list();
        return listFicheFrais;
    }
    /**
     * Accesseur getLigneFraisHorsForfait qui renvoie la ligne de frais hors forfait correspondante a l'id
     * passe en parrametre grace a la methode find
     * 
     * @return ligneFraisHorsForfait de type LigneFraisHorsForfait
     */
    public static LigneFraisHorsForfait getLigneFraisHorsForfait(int id) {
        LigneFraisHorsForfait ligneFraisHorsForfait = (LigneFraisHorsForfait) session.get(LigneFraisHorsForfait.class, id);
        return ligneFraisHorsForfait;
    }

    /**
     * Accesseur getListLigneFraisHorsForfait qui renvoie toutes les lignes de frais hors forfait existantes
     * dans la base de donne grace a la methode retrieve
     * 
     * @return listLigneFraisHorsForfait de type collection de LigneFraisHorsForfait
     */
    public static List<LigneFraisHorsForfait> getListLigneFraisHorsForfait() {
        List<LigneFraisHorsForfait> listLigneFraisHorsForfait= session.createQuery("from LigneFraisHorsForfait").list();
        return listLigneFraisHorsForfait;
    }
    /**
     * Accesseur getLigneFraisForfait qui renvoie la ligne de frais forfait correspondante a l'id
     * passe en parrametre grace a la methode find
     * 
     * @return ligneFraisForfait de type LigneFraisForfait
     */
    public static LigneFraisForfait getLigneFraisForfait(int id) {
        LigneFraisForfait ligneFraisForfait = (LigneFraisForfait) session.get(LigneFraisForfait.class, id);
        return ligneFraisForfait;
    }

    /**
     * Accesseur getListLigneFraisForfait qui renvoie toutes les lignes de frais hors forfait existantes
     * dans la base de donne grace a la methode retrieve
     * 
     * @return listLigneFraisHorsForfait de type collection de LigneFraisHorsForfait
     */
    public static List<LigneFraisForfait> getListLigneFraisForfait() {
        List<LigneFraisForfait> listLigneFraisForfait= session.createQuery("from LigneFraisForfait").list();
        return listLigneFraisForfait;
    }
    /**
     * Accesseur getFraisForfait qui renvoie le frais forfait correspondant a l'id
     * passe en parrametre grace a la methode find
     * 
     * @return fraisForfait de type FraisForfait
     */
    public static FraisForfait getFraisForfait(int id) {
        FraisForfait fraisForfait = (FraisForfait) session.get(FraisForfait.class, id);
        return fraisForfait;
    }

    /**
     * Accesseur getlistFraisForfait qui renvoie toutes les lignes de frais forfait existantes
     * dans la base de donne grace a la methode retrieve
     * 
     * @return listLigneFraisHorsForfait de type collection de LigneFraisHorsForfait
     */
    public static List<FraisForfait> getlistFraisForfait() {
        List<FraisForfait> listFraisForfait= session.createQuery("from FraisForfait").list();
        return listFraisForfait;
    }

    // modificateur sur les prorietes plus haut
    /**
     * Modificateur createRegion qui prend une region en parramï¿½tre et qui creera
     * l'objet dans la base de donnees
     * 
     * @param r
     *            de type Region
     * @return success de type boolean
     */
    public static boolean createRegion(Region r) {
        boolean success = false;   
        try {
            Transaction trans = session.beginTransaction();
            session.save(r);
            trans.commit();
            success = true;

        } catch (HibernateException e) {
          
        } 
        return success ;
    }

    /**
     * Modificateur updateRegion qui prend un objet Region en parramï¿½tre et qui
     * ira modifier l'objet correspondant dans la base de donnees
     * 
     * @param r
     *            de type Region
     * @return success de type boolean
     */
    public static boolean updateRegion(Region r) {
        boolean success = false;   
        try {
            Transaction trans = session.beginTransaction();
            session.saveOrUpdate(r);
            trans.commit();
            success = true;

        } catch (HibernateException e) {
          
        } 
        return success ;
    }

    

    /**
     * Modificateur createVisiteur qui prend un parramï¿½tre Visiteur et qui ira
     * creer l'entre correspondante dans la base de donnees
     * 
     * @param u
     *            de type Visiteur
     * @return success de type boolean
     */
    public static boolean createVisiteur(Visiteur u) {
        boolean success = false;   
        try {
            Transaction trans = session.beginTransaction();
            session.save(u);
            trans.commit();
            success = true;

        } catch (HibernateException e) {
          System.out.println(e);
        } 
        return success ;
    }

    /**
     * Modificateur updateVisiteur qui prend un parramï¿½tre Visiteur et qui ira
     * modifier l'entre correspondante dans la base de donnees
     * 
     * @param u
     *            de type Visiteur
     * @return success de type boolean
     */
    public static boolean updateVisiteur(Visiteur u) {
        Boolean ok = false;
        try {            
        	Transaction  trans = session.beginTransaction();
            session.update(u);
            trans.commit();
            ok = true;
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }
        return ok;
    }

    /**
     * Modificateur deleteVisiteur qui prend un parramï¿½tre Visiteur et qui ira
     * supprimer l'entre correspondante dans la base de donnees
     * 
     * @param u
     *            de type Visiteur
     * @return success de type boolean
     */
    public static boolean deleteVisiteur(Visiteur u) {
        boolean success = false;   
        try {
            Transaction trans = session.beginTransaction();
            session.delete(u);
            trans.commit();
            success = true;

        } catch (HibernateException e) {
          
        } 
        return success ;
    }
    /**
     * Modificateur deleteVisiteur qui prend un parramï¿½tre Visiteur et qui ira
     * supprimer de facon logique le visiteur dans la base de donnees
     * 
     * @param u
     *            de type Visiteur
     * @return success de type boolean
     */
    public static boolean deleteLogicalVisiteur(Visiteur u) {
    	u.setSuppr("N");
    	Boolean ok = false;
        try {            
        	Transaction  trans = session.beginTransaction();
            session.update(u);
            trans.commit();
            ok = true;
        }
        catch(HibernateException e) {
            e.printStackTrace();
        }
        return ok;
    }
    
    /**
     * Methode permettant de crée un objet région valide pour la 
     * création d'Visiteur
     * 
     * @param String libelleRegion
     *            
     * @return L'objet région corespondant
     */
    
    public static Region findRegion(String libelleRegion){
    	
    	 List<Region> lr= new ArrayList<Region>();
         lr=AccesData.getListRegion();
         boolean trouver = false ;
         int i=0;
         while(trouver == false){
         	if(lr.get(i).getLibelleRegion().equals(libelleRegion)){
         		
         		trouver = true;
         		
         		
         	}
         	else{
         		i=i+1;
         	}
         }
         
         return lr.get(i);
    	
    	
    	
    }
    
    
    /**
     * MÃ©thode de connection
     * 
     * @param login de type String
     * @param mdp de type char[]
     * 
     * @return success de type boolean
     */
    public static Utilisateur connection(String login,char[] mdp)
    {
    	Utilisateur util = null;
        try
        {
            util =(Utilisateur) session.createQuery("from Utilisateur where login='"+login+"' and mdp='"+String.valueOf(mdp)+"'").list().get(0);
        }
        catch (HibernateException e)
        {
            
        }
        
        return util;
    }
    
    public static List<Visiteur> getUtilistaeyrRegion(Region r){
    	ArrayList<Visiteur> lesutilRegion = new ArrayList<Visiteur>();
    	for(Visiteur u : AccesData.getListVisiteur()){
    		
    		if(u.getRegion()==r){
    			lesutilRegion.add(u);
    		}
    		
    	}
    	
    	
    	return lesutilRegion;
    	
    }
}

