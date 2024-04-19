package modele.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe de connexion JDBC de type singleton
 * @author btssio
 * @version 05-2020 : les propriétés de connexion sont lues dans un fichier de paramètres
 */
public class ConnexionBDD {

    private static Connection cnx;

    /**
     * Retourner une connexion ; la créer si elle n'existe pas...
     *
     * @return : objet de type java.sql.Connection
     */
    public static Connection getConnexion() throws SQLException, FileNotFoundException, IOException {
        if (cnx == null) {
            Properties propertiesJdbc; // objet de propriétés (paramètres de l'appplication) pour Jdbc
            InputStream input;         // flux de lecture des properties
            // Chargement des paramètres du fichier de properties
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            input = classLoader.getResourceAsStream("modele/dao/sirhJdbc.properties");
            propertiesJdbc = new Properties();
            propertiesJdbc.load(input);
            cnx = DriverManager.getConnection(propertiesJdbc.getProperty("url"), propertiesJdbc.getProperty("utilBD"), propertiesJdbc.getProperty("mdpBD"));
            System.out.println("getConnexion : " + propertiesJdbc.getProperty("url"));
        }
        return cnx;
    }

}
