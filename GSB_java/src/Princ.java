import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metier.Departement;
import com.metier.FicheFrais;
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
    	System.out.println(AccesData.getListVisiteur().get(0).getNomVisiteur());
		System.out.println(AccesData.getVisiteur("a131").getPrenomVisiteur());
    }

}