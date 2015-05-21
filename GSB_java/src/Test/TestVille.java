package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Departement;
import com.metier.Ville;
import com.metier.Visiteur;

public class TestVille {
	Ville v = new Ville();
	Departement d = new Departement() ;
	Departement dd = new Departement() ;
	ArrayList<Visiteur> lstv = new ArrayList<Visiteur>();
	ArrayList<Visiteur> lstv2 = new ArrayList<Visiteur>();
	Visiteur vist = new Visiteur () ;
	Visiteur vist2 = new Visiteur () ; 

	@Before
	public void setUp() throws Exception {
		v = new Ville("nomVille","cp");
		v.setIdVille(1);
		d.setCodeDepartement("45");
		v.setDepartement(d);
		dd.setCodeDepartement("46");
		lstv.add(vist);
		lstv2.add(vist);
		lstv2.add(vist2);
		v.setListeVisiteur(lstv);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVilleStringString() {
		assertNotNull(v);
	}

	@Test
	public void testGetIdVille() {
		assertEquals(v.getIdVille(),1);
	}

	@Test
	public void testSetIdVille() {
		v.setIdVille(2);
		assertEquals(v.getIdVille(),2);
	}

	@Test
	public void testGetNomVille() {
		assertEquals(v.getNomVille(), "nomVille");
	}

	@Test
	public void testSetNomVille() {
		v.setNomVille("nomModif");
		assertEquals(v.getNomVille(),"nomModif");
	}

	@Test
	public void testGetCp() {
		assertEquals(v.getCp(),"cp");
	}

	@Test
	public void testSetCp() {
		v.setCp("cpmodif");
		assertEquals(v.getCp(),"cpmodif");
	}

	@Test
	public void testGetDepartement() {
		assertEquals(v.getDepartement(),d);
	}

	@Test
	public void testSetDepartement() {
		v.setDepartement(dd);
		assertEquals(v.getDepartement(),dd);
	}

	@Test
	public void testGetListeVisiteur() {
		assertEquals(v.getListeVisiteur(),lstv);
	}

	@Test
	public void testSetListeVisiteur() {
		v.setListeVisiteur(lstv2);
		assertEquals(v.getListeVisiteur(),lstv2);
	}

}
