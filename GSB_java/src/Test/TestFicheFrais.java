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

public class TestFicheFrais {

	FicheFrais ff = new FicheFrais();
	ArrayList<LigneFraisForfait> lff = new ArrayList<LigneFraisForfait>();
	ArrayList<LigneFraisHorsForfait> lfhf = new ArrayList<LigneFraisHorsForfait>();
	
	@Before
	public void setUp() throws Exception {
		ff= new FicheFrais("idVisiteur","mois",3,new BigDecimal(25),new Date(1999,25,16),lff,lfhf);
	}

	@After
	public void tearDown() throws Exception {
		ff=null;
	}

	@Test
	public void testFicheFrais() {
		assertNotNull(ff);
	}

	@Test
	public void testGetIdVisiteur() {
		assertEquals(ff.getIdVisiteur(),"idVisiteur");
	}

	@Test
	public void testSetIdVisiteur() {
		ff.setIdVisiteur("ff");
		assertEquals(ff.getIdVisiteur(),"ff");
	}

	@Test
	public void testGetMois() {
		assertEquals(ff.getMois(),"mois");
	}

	@Test
	public void testSetMois() {
		ff.setMois("456");
		assertEquals(ff.getMois(),"456");
	}

	@Test
	public void testGetNbJustificatifs() {
		assertEquals(ff.getNbJustificatifs(),3);
	}

	@Test
	public void testSetNbJustificatifs() {
		ff.setNbJustificatifs(45);
		assertEquals(ff.getNbJustificatifs(),45);
	}

	@Test
	public void testGetMontantValide() {
		assertEquals(ff.getMontantValide(),new BigDecimal(25));
		
	}

	@Test
	public void testSetMontantValide() {
	ff.setMontantValide(new BigDecimal(1478));
	assertEquals(ff.getMontantValide(),new BigDecimal(1478));
	}

	@Test
	public void testGetDateModif() {
		assertEquals(ff.getDateModif(),new Date(1999,25,16));
	}

	@Test
	public void testSetDateModif() {
		ff.setDateModif(new Date(1999,25,17));
		assertEquals(ff.getDateModif(),new Date(1999,25,17));
	}

	@Test
	public void testGetListeLigneFraisForfait() {
		assertEquals(ff.getListeLigneFraisForfait(),lff);
	}

	@Test
	public void testSetListeLigneFraisForfait() {
		ff.setListeLigneFraisForfait(null);
		assertEquals(ff.getListeLigneFraisForfait(),null);
	}

	@Test
	public void testGetListeLigneFraisHorsForfait() {
		assertEquals(ff.getListeLigneFraisHorsForfait(),lfhf);
	}

	@Test
	public void testSetListeLigneFraisHorsForfait() {
		ff.setListeLigneFraisHorsForfait(null);
		assertEquals(ff.getListeLigneFraisHorsForfait(),null);
	}

}
