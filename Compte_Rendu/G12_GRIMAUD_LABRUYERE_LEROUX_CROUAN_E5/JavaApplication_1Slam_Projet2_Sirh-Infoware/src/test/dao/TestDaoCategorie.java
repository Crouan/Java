/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.dao.ConnexionBDD;
import modele.dao.DaoCategorie;
import modele.metier.Categorie;

/**
 *
 * @author btssio
 */
public class TestDaoCategorie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // Test 1 getOneById
        System.out.println("\n Test 1 : DaoCategorie.getOneById");
        try {
            String idRecherche = "2";
            Categorie cat = DaoCategorie.getOneById(idRecherche);
            if(cat != null){
                System.out.println("Service d'id "+idRecherche+" trouvé : \n"+cat.toString());
            }else{
                System.out.println("Service d'id "+idRecherche+" non trouvé : \n");
            }
            
        } catch (SQLException ex) {
            System.out.println("TestDaoCategorie - échec getOneById : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoCategorie - échec getOneById : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoCategorie.getAll");
        try {
            ArrayList<Categorie> lesCategories = DaoCategorie.getAll();
            for (Categorie cat : lesCategories) {
                System.out.println(cat.toString());
            }
            System.out.println(lesCategories.size()+" services trouvés");
        } catch (SQLException ex) {
            System.out.println("TestDaoCategorie - échec getAll : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoCategorie - échec getAll : " + ex.getMessage());
        }
        
        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException ex) {
            System.out.println("TestDaoCategorie - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoCategorie - échec de la fermeture de la connexion : " + ex.getMessage());
        }
    }
    
}
