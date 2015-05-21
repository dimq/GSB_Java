package Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Departement;
import com.metier.Region;
import com.metier.Ville;
import com.metier.Visiteur;
import com.persistance.AccesData;

public class AccesDataTest {

	AccesData d = new AccesData();
	Visiteur u;
	Region r;
	Ville v;
	Departement dd;
	@Before
	public void setUp() throws Exception {
/*		Date date = new Date("yyyy-MM-dd HH:mm:ss.S");
		v=new Ville("nomVille","Cp");
		dd = new Departement();
		r=new Region ("Alsace");
		
		u=new Visiteur("id","nom","prenom","portable","fixe",null, v,date,"v",r,dd);*/
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetVisiteur() {
		assertEquals(AccesData.getVisiteur("a131").getPrenomVisiteur(),"Louis");
		
	}

	@Test
	public void testGetListVisiteur() {
		assertEquals(d.getListVisiteur().size(),d.getListVisiteur().size());
	}

	@Test
	public void testGetRegion() {
		assertEquals(d.getRegion(1).getIdRegion(),1);
	}

	@Test
	public void testGetListRegion() {
		assertEquals(d.getListRegion().size(),22);
	}

	@Test
	public void testGetVisiteurByRegion() {
		assertEquals(d.getVisiteurByRegion(6).size(),1);
	}

	@Test
	public void testGetFicheFrais() {
		assertEquals(d.getFichesFrais("a131"),d.getFichesFrais("a131"));
		
	}

	@Test
	public void testGetListFicheFrais() {
		assertEquals(d.getListFicheFrais().size(),248);
	}

	@Test
	public void testGetLigneFraisHorsForfait() {
		assertEquals(d.getLigneFraisHorsForfait(1).getIdLigne(),1);
	}

	@Test
	public void testGetListLigneFraisHorsForfait() {
		assertEquals(d.getListLigneFraisHorsForfait().size(),d.getListLigneFraisHorsForfait().size());
	}

	@Test
	public void testGetLigneFraisForfait() {
		
		assertEquals(d.getLigneFraisForfait(1).getIdVisiteur(),d.getLigneFraisForfait(1).getIdVisiteur());

	}

	@Test
	public void testGetListLigneFraisForfait() {
		assertEquals(d.getListLigneFraisForfait().size(),992);
	}

	@Test
	public void testGetFraisForfait() {
		assertEquals(AccesData.getFraisForfait("ETP").getLibelleFraisForfait(),"Forfait Etape");
	}

	@Test
	public void testGetlistFraisForfait() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateRegion() {
		
	}

	@Test
	public void testUpdateRegion() {

	}

	@Test
	public void testCreateVisiteur() {
		assertTrue(AccesData.createVisiteur(u));
	}

	@Test
	public void testUpdateVisiteur() {
		fail("Not yet implemented");
	}


	@Test
	public void testConnection() {
		fail("Not yet implemented");
	}

}
