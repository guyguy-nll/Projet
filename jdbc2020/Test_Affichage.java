/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.*;

/**
 *
 * @author titih
 */
public class Test_Affichage {

    Scanner sc = new Scanner(System.in);

    Client demander_utilisateur(Connexion c) throws SQLException {
        System.out.println("Bienvenue sur le site !");
        int compte_existant = 0;
        int creation_compte = 0;
        Client c_cree; // on va chercher si le mdp et username correspond à un utilisateur, si c'est le cas on, va assigner à c_cree les caractéritiques de ce client à partir de la BDD
        do {
            System.out.println("Voulez-vous vous connecter (1) ou vous inscrire(2) ? : ");
            String resp = sc.next();
            if (resp.equals("1")) {
                System.out.print("Username: ");
                String username = sc.next();
                System.out.print("\nPassword: ");
                String mdp = sc.next();
                ResultSet res = c.executeQuery("SELECT * FROM client");

                while (res.next()) { // On cherche un utilisateur avec le même mot de passe et username dans la base de données
                    //System.out.println(res.getString("password") + " " + res.getString("username"));
                    if (username.equals(res.getString("username")) && mdp.equals(res.getString("password"))) {
                        System.out.println("Vous avez un compte ");
                        c_cree = new Client(res.getString("password"), res.getString("username"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("telephone"));
                        compte_existant = 1;
                        return c_cree;
                    }
                }
                if (compte_existant == 0) {
                    System.out.println("\nIl semble y avoir un problème avec vos informations");
                }
            } else {
                creation_compte = 1;
                compte_existant = 1;
            }
        } while (compte_existant == 0);

        // On entre ici lorsque l'on veut créer un nouvel utilisateur
        Client c1 = new Client();//creerUtilisateur(creation_compte, c);
        compte_existant = 0;
        return c1;
    }

    /*Client creerUtilisateur(int creation_compte, Connexion con) throws SQLException {
        System.out.print("Bienvenue, nous allons créer ensemble votre compte !\nPrenom: ");
        String eh = sc.nextLine();
        String prenom = sc.nextLine();
        System.out.print("\nNom: ");
        String nom = sc.nextLine();
        System.out.print("\nAdresse (numéro, rue et ville): ");
        String adresse = sc.nextLine();
        System.out.print("\nTelephone: ");
        String telephone = sc.nextLine();
        System.out.print("\nUsername: ");
        String username = sc.nextLine();
        System.out.print("\nPassword: ");
        String passwrd = sc.nextLine();
        Client c = new Client(passwrd, username, prenom, nom, adresse, telephone);
        //c.ajouterUtilisateur(con);
        return c;
    }*/
    
     Client creerUtilisateur() throws SQLException {
        System.out.print("Bienvenue, nous allons créer ensemble votre compte !\nPrenom: ");
        //String eh = sc.nextLine();
        String prenom = sc.nextLine();
        System.out.print("\nNom: ");
        String nom = sc.nextLine();
        System.out.print("\nAdresse (numéro, rue et ville): ");
        String adresse = sc.nextLine();
        System.out.print("\nTelephone: ");
        String telephone = sc.nextLine();
        System.out.print("\nUsername: ");
        String username = sc.nextLine();
        System.out.print("\nPassword: ");
        String passwrd = sc.nextLine();
        Client c = new Client(passwrd, username, prenom, nom, adresse, telephone);
        //c.ajouterUtilisateur(con);
        return c;
    }
}
