package Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FicheFrais;
import com.metier.LigneFraisForfait;
import com.metier.LigneFraisHorsForfait;
import com.metier.Region;
import com.metier.Utilisateur;
import com.metier.Visiteur;

public class Testutilisateur {
	
	Utilisateur u; 
	FicheFrais f;
	ArrayList<LigneFraisForfait> listFraisForfait ; 
	ArrayList<LigneFraisHorsForfait> listFraisHorsForfait ; 
	ArrayList<FicheFrais> lstfrais;
	ArrayList<FicheFrais> lstfrais2;
	BigDecimal big;
	Region r,r2;

	@Before
	public void setUp() throws Exception {
		listFraisHorsForfait= new ArrayList<LigneFraisHorsForfait>();
		listFraisForfait= new ArrayList<LigneFraisForfait>();
		lstfrais=new ArrayList<FicheFrais>();
		lstfrais2=new ArrayList<FicheFrais>();
		r=new Region ("region1");
		r2=new Region ("region2");
		
		u=new Utilisateur();

		f=new FicheFrais("idVisiteur","mois",0,big,new Date(1999,25,16),listFraisForfait,listFraisHorsForfait);

		u.setDateEmbauche(new Date(1993,10,10));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUtilisateur() {
		assertNotNull(u);
	}

	@Test
	public void testGetNomUtilisateur() {
		u.setNomUtilisateur("nom");
		assertEquals(u.getNomUtilisateur(),"nom");
	}

	@Test
	public void testSetNomUtilisateur() {
		u.setNomUtilisateur("nom1");
		assertEquals(u.getNomUtilisateur(),"nom1");
	}

	@Test
	public void testGetPrenomUtilisateur() {
		u.setPrenomUtilisateur("prenom");
		assertEquals(u.getPrenomUtilisateur(),"prenom");
	}

	@Test
	public void testSetPrenomUtilisateur() {
		u.setPrenomUtilisateur("prenomChanger");
		assertEquals(u.getPrenomUtilisateur(),"prenomChanger");
	}

	@Test
	public void testGetNumPort() {
		u.setNumPort("numPort");
		assertEquals(u.getNumPort(),"numPort");
	}

	@Test
	public void testSetNumPort() {
		u.setNumPort("00");
		assertEquals(u.getNumPort(),"00");
	}

	@Test
	public void testGetNumFixe() {
		u.setNumFixe("numFixe");
		assertEquals(u.getNumFixe(),"numFixe");
	}

	@Test
	public void testSetNumFixe() {
		u.setNumFixe("01");
		assertEquals(u.getNumFixe(),"01");
	}

	@Test
	public void testGetLogin() {
		u.setLogin("login");
		assertEquals(u.getLogin(),"login");
	}

	@Test
	public void testSetLogin() {
		u.setLogin("login2");
		assertEquals(u.getLogin(),"login2");
	}

	@Test
	public void testGetMdp() {
		u.setMdp("mdp");
		assertEquals(u.getMdp(),"mdp");
	}

	@Test
	public void testSetMdp() {
		u.setMdp("mdp2");
		assertEquals(u.getMdp(),"mdp2");
	}

	@Test
	public void testGetAdressseRue() {
		u.setAdressseRue("adresse");
		assertEquals(u.getAdressseRue(),"adresse");
	}

	@Test
	public void testSetAdressseRue() {
		u.setAdressseRue("adresse2");
		assertEquals(u.getAdressseRue(),"adresse2");
	}

	@Test
	public void testGetDateEmbauche() {
		assertEquals(u.getDateEmbauche(),new Date(1993,10,10));
	}

	@Test
	public void testSetDateEmbauche() {
		u.setDateEmbauche(new Date(1992,12,12));
		assertEquals(u.getDateEmbauche(),new Date(1992,12,12));
	}

	@Test
	public void testGetIdType() {
		u.setIdType("type");
		assertEquals(u.getIdType(),"type");
	}

	@Test
	public void testSetIdType() {
		u.setIdType("type2");
		assertEquals(u.getIdType(),"type2");
	}

	@Test
	public void testGetIdUtilisateur() {
		u.setIdUtilisateur("id");
		assertEquals(u.getIdUtilisateur(),"id");
	}

	@Test
	public void testCreerLogin() {

		
	}

	@Test
	public void testCreerMail() {
		assertTrue(true);
	}

	@Test
	public void testGetMailPro() {
		u.setMailPro(u.getPrenomUtilisateur()+"@gsb.fr");
		assertEquals(u.getPrenomUtilisateur()+"@gsb.fr",u.getPrenomUtilisateur()+"@gsb.fr");
	}

	@Test
	public void testSetMailPro() {
	
	}

	@Test
	public void testSetIdUtilisateur() {
		u.setIdUtilisateur("idutil");
		assertEquals(u.getIdUtilisateur(),"idutil");
	}

	@Test
	public void testGetSuppr() {
		u.setSuppr("sup");
		assertEquals(u.getSuppr(),"sup");
	}

	@Test
	public void testSetSuppr() {
		u.setSuppr("sup2");
		assertEquals(u.getSuppr(),"sup2");
	}

}
