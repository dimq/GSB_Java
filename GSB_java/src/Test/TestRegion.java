package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Region;
import com.metier.Utilisateur;

public class TestRegion
{

	private Region r ; 
	Utilisateur u1,u2;
	private ArrayList<Utilisateur> listUtil2; // liste avec un utilisateur 
	private ArrayList<Utilisateur> listUtil; //liste vide
	private ArrayList<Utilisateur> listUtilVide;
	
    @Before
    public void setUp()
            throws Exception
    {
    	
    	listUtil=new ArrayList<Utilisateur>();
    	listUtil2=new ArrayList<Utilisateur>();
    	listUtilVide=new ArrayList<Utilisateur>();
    	
    	
    	
    	
    	u1= new Utilisateur("num", "nom","prenom","num", null, null, null, r);
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
    public void testGetListeUtilisateur()
    {
    	
    
        assertEquals(r.getListeUtilisateur(),listUtilVide);
    }

    @Test
    public void testSetListeUtilisateur()
    {
    	
    	r.setListeUtilisateur(listUtil2);
    	assertEquals(r.getListeUtilisateur(),listUtil2);
       
    }

}
