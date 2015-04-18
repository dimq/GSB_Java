package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.metier.Visiteur;

public class VisiteurTest {
	
	Visiteur u; 
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
		
		u=new Visiteur("id","nom","prenom","adresse","cp","ville","idType",r);

		f=new FicheFrais("idVisiteur","mois",0,big,new Date(1999,25,16),listFraisForfait,listFraisHorsForfait);

		u.setDateEmbauche(new Date(1993,10,10));

	
	}

	@After
	public void tearDown() throws Exception {
		u=null;
		lstfrais=null;
		lstfrais2=null;
		f=null;
	}

	@Test
	public void testVisiteur() {
		assertTrue(true);
	}

	@Test
	public void testVisiteurStringStringString() {
		assertNotNull(u);
	}

	@Test
	public void testGetNomVisiteur() {
		assertEquals(u.getNomVisiteur(),"nom");
	}

	@Test
	public void testSetNomVisiteur() {
		u.setNomVisiteur("nomChanger");
		assertEquals(u.getNomVisiteur(),"nomChanger");
		
	}

	@Test
	public void testGetPrenomVisiteur() {
		assertEquals(u.getPrenomVisiteur(),"prenom");
	}

	@Test
	public void testSetPrenomVisiteur() {
		u.setPrenomVisiteur("prenomChanger");
		assertEquals(u.getPrenomVisiteur(),"prenomChanger");
	}

	@Test
	public void testGetNumPort() {
		assertEquals(u.getNumPort(),"numPort");
	}

	@Test
	public void testSetNumPort() {
		u.setNumPort("00");
		assertEquals(u.getNumPort(),"00");	}

	@Test
	public void testGetNumFixe() {
		assertEquals(u.getNumFixe(),"numFixe");
	}

	@Test
	public void testSetNumFixe() {
		u.setNumFixe("01");
		assertEquals(u.getNumFixe(),"01");
	}

	@Test
	public void testGetLogin() {
		assertEquals(u.getLogin(),"login");
	}

	@Test
	public void testSetLogin() {
		u.setLogin("login2");
		assertEquals(u.getLogin(),"login2");
	}

	@Test
	public void testGetMdp() {
		assertEquals(u.getMdp(),"mdp");
	}

	@Test
	public void testSetMdp() {
		u.setMdp("mdp2");
		assertEquals(u.getMdp(),"mdp2");
	}

	@Test
	public void testGetAdressseRue() {
		assertEquals(u.getAdressseRue(),"adresse");
	}

	@Test
	public void testSetAdressseRue() {
		u.setAdressseRue("adresse2");
		assertEquals(u.getAdressseRue(),"adresse2");
	}

	@Test
	public void testGetCp() {
		assertEquals(u.getCp(),"cp");
	}

	@Test
	public void testSetCp() {
		u.setCp("cp2");
		assertEquals(u.getCp(),"cp2");
	}

	@Test
	public void testGetVille() {
		assertEquals(u.getVille(),"ville");
	}

	@Test
	public void testSetVille() {
		u.setVille("ville2");
		assertEquals(u.getVille(),"ville2");
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
		assertEquals(u.getIdType(),"type");
	}

	@Test
	public void testSetIdType() {
		u.setIdType("type2");
		assertEquals(u.getIdType(),"type2");
	}

	@Test
	public void testGetRegion() {
		assertEquals(u.getRegion().getLibelleRegion(),"region1");
		
	}

	@Test
	public void testSetRegion() {
		u.setRegion(r2);
		assertEquals(u.getRegion().getLibelleRegion(),"region2");
	}

	@Test
	public void testGetListeFicheFrais() {
		assertEquals(u.getListeFicheFrais(),lstfrais);
	}

	@Test
	public void testSetListeFicheFrais() {
		u.setListeFicheFrais(lstfrais2);
		assertEquals(u.getListeFicheFrais(),lstfrais2);
	}

	@Test
	public void testGetIdVisiteur() {
		assertEquals(u.getIdVisiteur(),"id");
	}

}
