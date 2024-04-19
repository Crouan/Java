package modele.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie S inner join Categorie C on S.NumCat=C.Code WHERE S.Code = ?");
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
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie S inner join Categorie C on S.NumCat=C.Code");
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
    
    /**
     * Ajoute un salarié à la table SALARIE
     * 
     * @param salarie
     */
    public static void AjouterSalarie(Salarie salarie) throws SQLException {
        try {
            // Établir la connexion à la base de données
            Connection cnx = ConnexionBDD.getConnexion();

            // Préparer la requête
            PreparedStatement pstmt = cnx.prepareStatement("INSERT INTO salarie (Code, Nom, Prenom, DateNaiss, DateEmbauche, Fonction, TauxHoraire, situationFamiliale, NbrEnfants, NumCat, CodeServ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Remplacer les paramètres dans la requête par les valeurs du salarié
            pstmt.setString(1, salarie.getCode());
            pstmt.setString(2, salarie.getNom());
            pstmt.setString(3, salarie.getPrenom());
            pstmt.setDate(4, new java.sql.Date(salarie.getDateNaiss().getTime()));
            pstmt.setDate(5, new java.sql.Date(salarie.getDateEmbauche().getTime()));
            pstmt.setString(6, salarie.getFonction());
            pstmt.setDouble(7, salarie.getTauxHoraire());
            pstmt.setString(8, salarie.getSituationFamiliale());
            pstmt.setInt(9, salarie.getNbrEnfants());
            pstmt.setString(10, salarie.getCategorie().getCode());
            pstmt.setInt(11, salarie.getService().getCode());
            
            // Exécuter la requête
            int rowsUpdated = pstmt.executeUpdate();

            // Vérifier si la mise à jour a été effectuée avec succès
            if (rowsUpdated > 0) {
                System.out.println("Ajout du salarié avec succès !");
            } else {
                System.out.println("Erreur lors de l'ajout du salarié");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erreur : "+ ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("Erreur : "+ ex.getMessage());
        }
    }
    
     /**
     * Suprimme un salarié dans la base de donnée selon sont code
     * @param codeS Code du salarié à supprimé
     * @throws SQLException 
     */
    public static void deleteSalarie(String codeS) throws SQLException, IOException{
        Connection cnx = ConnexionBDD.getConnexion();
        //Suppresion de la dépendance de Salarié par rapport à la table Suivre
        PreparedStatement pstmt1 = cnx.prepareStatement("Delete From Suivre Where CodeSal = ?");
        pstmt1.setString(1, codeS);
        PreparedStatement pstmt2 = cnx.prepareStatement("Delete From Salarie Where Code = ?");
        pstmt2.setString(1, codeS);
        pstmt1.executeUpdate();
        pstmt2.executeUpdate();
    } 
 
    public static List<Salarie> getSalariesbyService (Service unService) throws SQLException, IOException{
     ArrayList<Salarie> lesSalariesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("select * from Salarie sa inner join Service se on sa.CodeServ= se.code inner join Categorie C on sa.NumCat=C.Code where se.Designation= ?");
        pstmt.setString(1, unService.toString());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Salarie unSalarie = creerSalarie(rs);
            lesSalariesTrouves.add(unSalarie);
        }
        return lesSalariesTrouves;
    }
}
