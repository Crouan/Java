/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.dao.ConnexionBDD;
import modele.dao.DaoSalarie;
import modele.metier.Salarie;

/**
 *
 * @author btssio
 */
public class TestDaoSalarie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\n Test 1 : DaoSalarie.getOneById");
        try {
            String idRecherche = "2";
            Salarie sae = DaoSalarie.getOneById(idRecherche);
            if(sae != null){
                System.out.println("Service d'id "+idRecherche+" trouvé : \n"+sae.toString());
            }else{
                System.out.println("Service d'id "+idRecherche+" non trouvé : \n");
            }
            
        } catch (SQLException ex) {
            System.out.println("TestDaoSalarie - échec getOneById : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoSalarie - échec getOneById : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoSalarie.getAll");
        try {
            ArrayList<Salarie> lesSalaries = DaoSalarie.getAll();
            for (Salarie sae : lesSalaries) {
                System.out.println(sae.toString());
            }
            System.out.println(lesSalaries.size()+" services trouvés");
        } catch (SQLException ex) {
            System.out.println("TestDaoSalarie - échec getAll : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoSalarie - échec getAll : " + ex.getMessage());
        }
        
    }
    
}
