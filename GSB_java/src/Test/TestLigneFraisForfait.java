package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.FraisForfait;
import com.metier.LigneFraisForfait;

public class TestLigneFraisForfait {
	
	LigneFraisForfait ff = new LigneFraisForfait();

	@Before
	public void setUp() throws Exception {
		ff= new LigneFraisForfait("idVisiteur","mois","idFraisForfait",14);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLigneFraisForfait() {
		assertNotNull(ff);
	}



	@Test
	public void testGetIdVisiteur() {
		assertEquals("idVisiteur",ff.getIdVisiteur());
	}

	@Test
	public void testSetIdVisiteur() {
		ff.setIdVisiteur("idVisiteur");
		assertEquals(ff.getIdVisiteur(),"idVisiteur");
	}

	@Test
	public void testGetMois() {
		assertEquals(ff.getMois(),"mois");
	}

	@Test
	public void testSetMois() {
		ff.setMois("mois2");
		assertEquals(ff.getMois(),"mois2");
	}

	@Test
	public void testGetIdFraisForfait() {
		assertEquals(ff.getIdFraisForfait(),"idFraisForfait");
	}

	@Test
	public void testSetIdFraisForfait() {
		
		ff.setIdFraisForfait("idFraisForfait2");
		assertEquals(ff.getIdFraisForfait(),"idFraisForfait2");
		
	}

	@Test
	public void testGetQuantite() {
		assertEquals(ff.getQuantite(),14);
	}

	@Test
	public void testSetQuantite() {
		ff.setQuantite(15);
		assertEquals(ff.getQuantite(),15);
	}

}
