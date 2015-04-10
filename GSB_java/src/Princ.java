import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metier.Region;
import com.metier.Utilisateur;
import com.persistance.AccesData;
public class Princ
{

    public Princ()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {
    	List<Utilisateur> listeUtils = AccesData.getListUtilisateur();
    	for (Utilisateur u:listeUtils){
    	    u.creerLogin();
    	    u.creerMail();
    	    AccesData.updateUtilisateur(u);
    	}
        
        
		
		
    }

}