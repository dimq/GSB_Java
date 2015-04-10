package Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.LigneFraisHorsForfait;

public class LigneFraisHorsForfaitTest {

	LigneFraisHorsForfait lfhf = new LigneFraisHorsForfait();
	@Before
	public void setUp() throws Exception {
		
		BigDecimal b = new BigDecimal(1444);
		
		lfhf.setIdLigne(1);
		lfhf.setIdVisiteur("idvisiteur");
		lfhf.setLibelle("Libelle");
		lfhf.setMois("mois");
		lfhf.setMontant(b);
		lfhf.setMontant(new BigDecimal(12));
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		lfhf=null;
		
	}
	
	@Test
	public void testLigneFraisHorsForfait() {
		assertNotNull(lfhf);
	}

	@Test
	public void testGetIdLigne() {
		assertEquals(lfhf.getIdLigne(),1);
	}

	@Test
	public void testSetIdLigne() {
		lfhf.setIdLigne(3);
		assertEquals(lfhf.getIdLigne(),3);
	}

	@Test
	public void testGetIdVisiteur() {
		assertEquals(lfhf.getIdVisiteur(),"idvisiteur");
	}

	@Test
	public void testSetIdVisiteur() {
		lfhf.setIdVisiteur("3");
		assertEquals(lfhf.getIdVisiteur(),"3");
		
		
	}

	@Test
	public void testGetMois() {
		assertEquals(lfhf.getMois(),"mois");
	}

	@Test
	public void testSetMois() {
		lfhf.setMois("mois2");
		assertEquals(lfhf.getMois(),"mois2");
	}

	@Test
	public void testGetLibelle() {
		assertEquals(lfhf.getLibelle(),"Libelle");
		
	}

	@Test
	public void testSetLibelle() {
		lfhf.setLibelle("libelle2");
		assertEquals(lfhf.getLibelle(),"libelle2");
	}

	//TODO verifier
	
/*	@Test
	public void testGetDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDate() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetMontant() {
		assertEquals(lfhf.getMontant(),new BigDecimal( 12));
	}

	@Test
	public void testSetMontant() {
		lfhf.setMontant(new BigDecimal(1555));
		assertEquals(lfhf.getMontant(),new BigDecimal(1555));
	}

}
