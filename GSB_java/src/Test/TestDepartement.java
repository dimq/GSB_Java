package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Departement;
import com.metier.Region;
import com.metier.Ville;
import com.metier.Visiteur;

public class TestDepartement {

	Departement d = new Departement();
	ArrayList<Ville> v = new ArrayList<Ville>();
	ArrayList<Ville> vr = new ArrayList<Ville>();
	ArrayList<Visiteur>lv = new ArrayList<Visiteur>();
	ArrayList<Visiteur>lv2 = new ArrayList<Visiteur>();
	Ville ve = new Ville(); 
	Ville de = new Ville();
	Region r = new Region();
	Region rr = new Region ();
	Visiteur vis = new Visiteur();
	@Before
	public void setUp() throws Exception {
		d = new Departement ("libelle") ;
		d.setCodeDepartement("45");
		de.setIdVille(14);
		v.add(de);
		 r = new Region("Region");
		 rr = new Region ("pasregion");
		d.setRegion(r);
		d.setListeVille(v);
		d.setRegion(r);
		lv.add(vis);
		d.setListeVisiteur(lv);
		
	}

	@After
	public void tearDown() throws Exception {
		d = null;
		de = null;
		v = null;
		lv = null;
	}

	@Test
	public void testDepartement() {
		assertNotNull(d);
	}


	@Test
	public void testGetLibelleDepartement() {
		assertEquals(d.getLibelleDepartement(),"libelle");
	}

	@Test
	public void testSetLibelleDepartement() {
		d.setLibelleDepartement("modif");
		assertEquals(d.getLibelleDepartement(),"modif");
	}

	@Test
	public void testGetListeVille() {
		assertEquals(d.getListeVille(),v);
	}

	@Test
	public void testSetListeVille() {
		d.setListeVille(vr);
		assertEquals(d.getListeVille(),vr);
	}

	@Test
	public void testGetCodeDepartement() {
		assertEquals(d.getCodeDepartement(),"45");
	}

	@Test
	public void testSetCodeDepartement() {
		d.setCodeDepartement("47");
		assertEquals(d.getCodeDepartement(),"47");
	}

	@Test
	public void testGetRegion() {
		assertEquals(d.getRegion(),r);
	}

	@Test
	public void testSetRegion() {
		d.setRegion(rr);
		assertEquals(d.getRegion(),rr);
	}

	@Test
	public void testGetListeVisiteur() {
		assertEquals(d.getListeVisiteur(),lv);
	}

	@Test
	public void testSetListeVisiteur() {
		d.setListeVisiteur(lv2);
		assertEquals(d.getListeVisiteur(),lv2);
		
		
	}

}
