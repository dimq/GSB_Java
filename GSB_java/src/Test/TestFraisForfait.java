package Test;
import java.math.BigDecimal;

import com.metier.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFraisForfait {

	private FraisForfait f; 
	
	
	@Before
	public void setUp() throws Exception {
		f= new FraisForfait("idFraisForfait","libelleFraisForfait",new BigDecimal(1000));
		
	}

	@After
	public void tearDown() throws Exception {
		f = null;
	}

	@Test
	public void testFraisForfaitStringStringBigDecimal() {
		assertNotNull(f);	
		}

	@Test
	public void testGetIdFraisForfait() {
		assertEquals(f.getIdFraisForfait(),"idFraisForfait");
	}

	@Test
	public void testSetIdFraisForfait() {
		f.setIdFraisForfait("eeee");
		assertEquals(f.getIdFraisForfait(),"eeee");
	}

	@Test
	public void testGetLibelleFraisForfait() {
		assertEquals(f.getLibelleFraisForfait(),"libelleFraisForfait");
	}

	@Test
	public void testSetLibelleFraisForfait() {
		f.setLibelleFraisForfait("azerty");
		assertEquals(f.getLibelleFraisForfait(),"azerty");
	}

	@Test
	public void testGetMontant() {
		assertEquals(f.getMontant(),new BigDecimal(1000));
	}

	@Test
	public void testSetMontant() {
		f.setMontant(new BigDecimal(5000));
		assertEquals(f.getMontant(),new BigDecimal(5000));
	}

}