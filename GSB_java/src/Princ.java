import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metier.Departement;
import com.metier.Region;
import com.metier.Ville;
import com.metier.Visiteur;
import com.persistance.AccesData;
public class Princ
{

    public Princ()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args)
    {
    	Visiteur v = AccesData.getVisiteur("e52");
        System.out.println(v.getRegion().getListeDepartement().get(0).getListeVille());
		
		
    }

}