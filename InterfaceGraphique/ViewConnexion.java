/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGraphique;

import java.util.Scanner;
//import Controller.Control_Identification;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author titih
 */
public class ViewConnexion {

    Scanner in = new Scanner(System.in);
    String username = new String();
    String password = new String();
   // Control_Identification identification = new Control_Identification();

    public int MenuConnexion() {
        System.out.println("Bienvenue sur le site !");
        //FAIRE APPARAITRE UN BOUTON "SE connecter"
        System.out.println("Se connecter : 1");
        System.out.println("S'inscrire : 2");
        System.out.println("Votre choix : ");
        int reponse = 0;
        do {
            reponse = in.nextInt();
        } while (reponse != 1 && reponse != 2);
        return reponse;
    }

    public ArrayList<String> ConnexionUtilisateur() {
        //NOUVELLE PAGE AVEC LE USERNAME ET PASSWORD A INSERER
        ArrayList<String> information = new ArrayList<>();
        String eh = in.nextLine();
        System.out.print("\n");
        System.out.print("username : ");
        username = in.nextLine();
        System.out.print("\nmot de passe : ");
        password = in.nextLine();
        information.add(username);
        information.add(password);
        return information; // on retourne les informations de type 
    }

    public ArrayList<String> Inscription() {
        ArrayList<String> information = new ArrayList<>();
        System.out.print("Bienvenue, nous allons créer ensemble votre compte !\nPrenom: ");
        String eh = in.nextLine();
        String prenom = in.nextLine();
        information.add(prenom); //0
        System.out.print("\nNom: ");
        String nom = in.nextLine();
        information.add(nom); //1
        System.out.print("\nAdresse (numéro, rue et ville): ");
        String adresse = in.nextLine();
        information.add(adresse); //2
        System.out.print("\nTelephone: ");
        String telephone = in.nextLine();
        information.add(telephone); //3
        System.out.print("\nUsername: ");
        username = in.nextLine();
        information.add(username); //4
        System.out.print("\nPassword: ");
        String passwrd = in.nextLine();
        information.add(passwrd); //5
        System.out.println("   " + username);
        return information;
    }

}
