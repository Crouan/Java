package lanceur;

import vue.JFrameListeSalaries;
import java.util.ArrayList;
import modele.dao.DaoSalarie;
import modele.dao.DaoService;
import modele.metier.Salarie;
import modele.metier.Service;

/**
 * Classe de lancement de l'application
 * @author btssio
 */
public class Main {

    public static void main(String args[]) {
        JFrameListeSalaries jfListeSalaries;
        ArrayList<Service> lesServices = null;
        ArrayList<Salarie> lesSalaries = null;

        // Instancier la GUI principale (liste des salsriés)
        jfListeSalaries = new JFrameListeSalaries();

        // Remplissage combobox des services 
        try {
            lesServices = DaoService.getAll();
        } catch (Exception ex) {
            System.out.println("Main - pb remplissage combo services : " + ex.getMessage());
            System.exit(1);
        }
        jfListeSalaries.remplirJComBoxServices(lesServices);

        // Initialement, tous les salariés sont sélectionnés
        try {
            lesSalaries = DaoSalarie.getAll();
        } catch (Exception ex) {
            System.out.println("Main - pb remplissage JTable salaries : " + ex.getMessage());
            System.exit(1);
        }
        jfListeSalaries.remplirJTableSalaries(lesSalaries);
        jfListeSalaries.setVisible(true);

    }
}
