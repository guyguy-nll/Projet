/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 * @author segado
 */
public class Controleur {

    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
    public static void main(String[] s) throws SQLException, ClassNotFoundException {
        /*Test_Affichage test = new Test_Affichage();
        Connexion c;
        try {
            c = new Connexion("shopping", "root", "");
            test.demander_utilisateur(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        Test_Affichage test = new Test_Affichage();
        Client c = test.creerUtilisateur();
        ClientDAO cdao = new ClientDAO();
        cdao.create(c);
    }
}
