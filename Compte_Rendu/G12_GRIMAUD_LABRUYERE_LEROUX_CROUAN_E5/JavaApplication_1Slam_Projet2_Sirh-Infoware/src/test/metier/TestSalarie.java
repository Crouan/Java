package test.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import modele.metier.Salarie;
import modele.metier.Service;
import modele.metier.Categorie;


/**
 * Classe de test unitaire de la classe Salarie
 * @author btssio
 */
public class TestSalarie {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Salarie unSalarie = null;
        
        System.out.println("TestSalarie");
        
        System.out.println("1 - Salarié sans service");
        try {
            unSalarie = new Salarie("R06", "LANDREAU", "Bertrand", sdf.parse("12/12/1980"), sdf.parse("15/11/2006"), "Développeur", 10.0, "marié", 2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println(unSalarie.toString());
        
        System.out.println("2 - Salarié avec service");
        try {
            int prime;
            double smic;
            
            prime = 1010;
            smic=1300;
            
            Service serv = new Service(1, "Informatique", "Inf-logihome@logihome.com", "0169983212");
            Categorie cat = new Categorie("0A429","Chomeur",smic,"URSAF",prime);
            unSalarie = new Salarie("R06", "LANDREAU", "Bertrand", sdf.parse("12/12/1980"), sdf.parse("15/11/2006"), "Développeur", 10.0, "marié", 2, serv,cat);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println(unSalarie.toString());
    }

}
