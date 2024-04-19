package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.metier.*;

/**
 * Classe DAO : liaison classe métier Salarie / table SALARIE
 * @author btssio
 */
public class DaoSalarie {

    /**
     * Rechercher un enregistrement dans la table SALARIE d'après son code
     * (String) et en faire un objet de type Salarie
     *
     * @param id code du salarie recherché
     * @return objet de type Salarie si trouvé dans la BDD, null sinon
     * @throws SQLException
     */
    public static Salarie getOneById(String id) throws SQLException, IOException {
        Salarie salarieTrouve = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie WHERE Code = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            salarieTrouve = creerSalarie(rs);
        }
        return salarieTrouve;
    }

    /**
     * Extraire l'ensemble des enregistrements de la table SALARIE
     *
     * @return liste d'objets de type Salarie
     * @throws SQLException
     */
    public static ArrayList<Salarie> getAll() throws SQLException, IOException {
        ArrayList<Salarie> lesSalariesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie S inner join Categorie C on S.NumCat=C.Code ");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Salarie unSalarie = creerSalarie(rs);
            lesSalariesTrouves.add(unSalarie);
        }
        return lesSalariesTrouves;
    }

    
    /**
     * Transforme un enregistrement de la table SALARIE en instance de Salarie
     * @param rs jeu d'enregistrements ; l'enregistrement courant est concerné
     * @return instance de Salarie
     * @throws SQLException 
     */
    private static Salarie creerSalarie(ResultSet rs) throws SQLException, IOException {
        Salarie unSalarie = null;
        // Récupération du service du salarié
        Categorie categorie = new Categorie (rs.getString("Code"),rs.getString("Libelle"),rs.getDouble("salaireMini"),rs.getString("CaisseDeRetraite"),rs.getInt("PrimeResultat"));
        Service unService = DaoService.getOneById(rs.getInt("CodeServ"));
        unSalarie = new Salarie(
                rs.getString("Code"),
                rs.getString("Nom"),
                rs.getString("Prenom"),
                (java.util.Date) rs.getDate("DateNaiss"),
                (java.util.Date) rs.getDate("DateEmbauche"),
                rs.getString("Fonction"),
                rs.getDouble("TauxHoraire"),
                rs.getString("situationFamiliale"),
                rs.getInt("NbrEnfants"),
                unService,
                categorie
        );
        return unSalarie;
    }

}
