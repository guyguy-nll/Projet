/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.Scanner;
import jdbc2020.Client;
import jdbc2020.ClientDAO;

/**
 *
 * @author titih
 */
public class ControlProfil {

    private String m_username_Client;

    public ControlProfil(String username) {
        m_username_Client = username;
    }

    public void ModifierProfil() throws ClassNotFoundException, SQLException {
        ClientDAO Cdao = new ClientDAO();
        Client c;
        int nombre = 0;
        do {
            c = Cdao.find(m_username_Client);
            System.out.println("\n                 Votre Profil");
            System.out.println("Nom : " + c.GetNom() + "(1)");
            System.out.println("Prenom : " + c.GetPrenom() + "(2)");
            System.out.println("Adresse : " + c.GetAdresse() + "(3)");
            System.out.println("Telephone : " + c.GetTelephone() + "(4)");
            System.out.print("Username : " + c.GetUsername() + "(5)\nPassword : ");
            for (int i = 0; i < c.GetPasswrd().length(); i++) {
                System.out.print("*");
            }
            System.out.print(" : (6)\n\n Inserer le numero de ce que vous voulez modifier (0 si retour) : ");
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print(" Votre valeur : ");
                nombre = sc.nextInt();
            } while (nombre > 6 || nombre < 0);
            UpdateInfo(nombre, c, Cdao, sc);
        } while (nombre != 0);

    }

    // On met à jour toutes les modifications faites par l'utilisateur
    public void UpdateInfo(int nombre, Client c, ClientDAO Cdao, Scanner sc) throws SQLException {
        if (nombre == 1) {
            String nom = NouvelleInformation(sc, "Nom");
            c.SetNom(nom);
            Cdao.executeUpdate("UPDATE Client SET nom ='" + c.GetNom() + "' WHERE username='" + c.GetUsername() + "';");
        } else if (nombre == 2) {
            String prenom = NouvelleInformation(sc, "Prenom");
            c.Setprenom(prenom);
            Cdao.executeUpdate("UPDATE Client SET prenom ='" + c.GetPrenom() + "' WHERE username='" + c.GetUsername() + "';");
        } else if (nombre == 3) {
            String adresse = NouvelleInformation(sc, "Adresse");
            c.SetAdresse(adresse);
            Cdao.executeUpdate("UPDATE Client SET adresse ='" + c.GetAdresse() + "' WHERE username='" + c.GetUsername() + "';");
        } else if (nombre == 4) {
            String telephone = NouvelleInformation(sc, "Telephone");
            c.SetTelephone(telephone);
            Cdao.executeUpdate("UPDATE Client SET telephone ='" + c.GetTelephone() + "' WHERE username='" + c.GetUsername() + "';");
        } else if (nombre == 5) {
            String username = NouvelleInformation(sc, "Username");
            c.SetUsername(username);
            m_username_Client = c.GetUsername();
            Cdao.executeUpdate("UPDATE Client SET username ='" + c.GetUsername() + "' WHERE password='" + c.GetPasswrd() + "';");
        } else if (nombre == 6) {
            String password = NouvelleInformation(sc, "Password");
            c.SetPasswrd(password);
            Cdao.executeUpdate("UPDATE Client SET password ='" + c.GetPasswrd() + "' WHERE username='" + c.GetUsername() + "';");
        }
    }

    // on demande à l'utilisateur la nouvelle donnee à modifier dans sa base de donnee
    public String NouvelleInformation(Scanner sc, String texte) {
        System.out.print("Veuillez inserer la modification de " + texte + " : ");
        String info = sc.nextLine();
        info = sc.nextLine();
        return info;
    }
}
