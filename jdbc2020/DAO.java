/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author titih
 */
public abstract class DAO<T> {

    protected Connection connect = null;
    private Statement stmt;

    // Constructor
    public DAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3306/shopping";

        //création d'une connexion JDBC à la base 
        connect = DriverManager.getConnection(urlDatabase, "root", "");
    }

    // Methods
    /**
     * Méthode abstraite pour insérer un enregistrement dans la base de données
     *
     * @param obj Objet contenant les données à insérer en base
     * @return L'objet créé
     */
    public abstract void create(T obj);

    /**
     * Méthode abstraite pour supprimer un enregistrement dans la base de
     * données
     *
     * @param obj Objet contenant l'identifiant des données à supprimer en base
     */
    public abstract void delete(T obj);

    /**
     * Méthode abstraite pour trouver un enregistrement dans la base de données
     * à partir de son identifiant
     *
     * @param id Identifiant de l'objet cherché
     * @return L'objet trouvé
     */
    public abstract T find(String username);

    public void executeUpdate(String requeteMaj) throws SQLException { // fonction pour les requetes de modification
        stmt = connect.createStatement();
        stmt.executeUpdate(requeteMaj);
    }

    public ResultSet executeQuery(String requeteMaj) throws SQLException { // fonction pour les requete de lecture 
        stmt = connect.createStatement();
        return stmt.executeQuery(requeteMaj);
    }

}
