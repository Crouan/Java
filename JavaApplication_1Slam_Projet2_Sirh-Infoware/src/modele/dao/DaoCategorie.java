/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.Categorie;

/**
 *
 * @author btssio
 */
public class DaoCategorie {

   public static ArrayList<Categorie> getAll() throws SQLException, IOException {
        ArrayList<Categorie> lesCategorieTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Categorie");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
             Categorie Cat= new Categorie (
                    rs.getString("Code"),
                    rs.getString("Libelle"),
                    rs.getDouble("salaireMini"),
                    rs.getString("CaisseDeRetraite"),
                    rs.getInt("PrimeResultat")
            );
            lesCategorieTrouves.add(Cat);
        }
        return lesCategorieTrouves;
    }
    public static Categorie getOneById(String id) throws SQLException, IOException {
        Categorie categorieTrouve = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Categorie WHERE Code = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            categorieTrouve = new Categorie(
                    id,
                    rs.getString("Libelle"),
                    rs.getDouble("salaireMini"),
                    rs.getString("CaisseDeRetraite"),
                    rs.getInt("PrimeResultat")
            );
        }
        return categorieTrouve;
    }

   
}
