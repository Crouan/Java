package test.vue;

import java.sql.Date;
import java.util.ArrayList;
import modele.metier.Salarie;
import modele.metier.Service;

/**
 * Fournir des données fictives pour les tests unitaires et d'intégration
 * @author N. Bourgeois 
 * @version 3 mai 2020
 */
public class Bouchon {
    public static Salarie daoSalarieGetOneById(String leCodeDuSalarie) {
        return new Salarie(leCodeDuSalarie, "LANDREAU", "Bertrand", Date.valueOf("1980-12-12"), Date.valueOf("2006-11-15"), "Développeur", 10.0, "marié", 2);
    }

    public static ArrayList<Salarie> daoSalarieGetAllByService(int codeDuService) {
        ArrayList<Salarie> desSalaries = new ArrayList<>();
        desSalaries.add(new Salarie("S03", "RETAIS", "Jérôme", Date.valueOf("1968-09-14"), Date.valueOf("2000-09-01"), "Ingénieur informatique", 14.0, "Divorcé", 4));
        desSalaries.add(new Salarie("S04", "DOMARD", "Pierre", Date.valueOf("1960-06-14"), Date.valueOf("2000-09-01"), "Directeur général", 22.5, "Marié", 3));
        return desSalaries;
    }

    public static ArrayList<Salarie> daoSalarieGetAll() {
        ArrayList<Salarie> desSalaries = new ArrayList<>();
        desSalaries.add(new Salarie("S01", "RETAIS", "Claude", Date.valueOf("1962-03-31"), Date.valueOf("2000-09-01"), "Chef de projet", 19.5, "Marié", 3));
        desSalaries.add(new Salarie("S02", "BERNARD", "Céline", Date.valueOf("1972-08-14"), Date.valueOf("2000-09-01"), "Directrice commerciale", 19.5, "Marié", 2));
        desSalaries.add(new Salarie("S03", "RETAIS", "Jérôme", Date.valueOf("1968-09-14"), Date.valueOf("2000-09-01"), "Ingénieur informatique", 14.0, "Divorcé", 4));
        desSalaries.add(new Salarie("S04", "DOMARD", "Pierre", Date.valueOf("1960-06-14"), Date.valueOf("2000-09-01"), "Directeur général", 22.5, "Marié", 3));
        desSalaries.add(new Salarie("S05", "LALOIS", "Régis", Date.valueOf("1967-07-25"), Date.valueOf("2000-09-01"), "Chef comptable", 17.3, "Célibataire", 0));
        desSalaries.add(new Salarie("S06", "DUPONT", "Henri", Date.valueOf("1968-11-15"), Date.valueOf("2000-09-01"), "Développeur", 11.6, "Marié", 2));
        return desSalaries;
    }
    
    public static ArrayList<Service> daoServiceGetAll() {
        ArrayList<Service> desServices = new ArrayList<>();
        desServices.add(new Service(1, "Informatique"));
        desServices.add(new Service(2, "Administration"));
        desServices.add(new Service(3, "Commercial"));
//        desServices.add(new Service(4, "Comptable"));
        return desServices;
    }
    

}
