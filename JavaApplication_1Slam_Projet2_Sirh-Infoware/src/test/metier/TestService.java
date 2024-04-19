package test.metier;

import java.text.SimpleDateFormat;
import modele.metier.Service;

/**
 * Classe de test unitaire de la classe Service
 * @author btssio
 */
public class TestService {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        
        System.out.println("TestService");
        
        Service unService = new Service(1, "Informatique", "Inf-logihome@logihome.com", "0169983212");        
        System.out.println(unService.toStringEtat());
    }

}
