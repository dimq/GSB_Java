package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Region;
import com.metier.Visiteur;

public class TestRegion
{

	private Region r ; 
	Visiteur u1,u2;
	private ArrayList<Visiteur> listUtil2; // liste avec un Visiteur 
	private ArrayList<Visiteur> listUtil; //liste vide
	private ArrayList<Visiteur> listUtilVide;
	
    @Before
    public void setUp()
            throws Exception
    {
    	
    	listUtil=new ArrayList<Visiteur>();
    	listUtil2=new ArrayList<Visiteur>();
    	listUtilVide=new ArrayList<Visiteur>();
    	
    	
    	
    	
    	u1= new Visiteur("num", "nom","prenom","num", null, null, null, r);
    	listUtil2.add(u1);
    	r= new Region("region1");
    	
    }

    @After
    public void tearDown()
            throws Exception
    {
    	r=null;
    	listUtil=null;
    	listUtil2=null;
    	listUtilVide=null;   	
    	
    	
    }

    @Test
    public void testRegion()
    {
        assertNotNull(r);
    }

    @Test
    public void testRegionString()
    {
        assertTrue(true);
    }

    @Test
    public void testGetIdRegion()
    {
        assertEquals(r.getIdRegion(),1);
    }

    @Test
    public void testSetIdRegion()
    {
        r.setIdRegion(2);
        assertEquals(r.getIdRegion(),2);
    }

    @Test
    public void testGetLibelleRegion()
    {
        assertEquals(r.getLibelleRegion(),"region1");
    }

    @Test
    public void testSetLibelleRegion()
    {
       r.setLibelleRegion("RegionChanger");
       assertEquals(r.getLibelleRegion(),"RegionChanger");
    }

    @Test
    public void testGetListeVisiteur()
    {
    	
    
        assertEquals(r.getListeVisiteur(),listUtilVide);
    }

    @Test
    public void testSetListeVisiteur()
    {
    	
    	r.setListeVisiteur(listUtil2);
    	assertEquals(r.getListeVisiteur(),listUtil2);
       
    }

}
