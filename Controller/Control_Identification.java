/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import jdbc2020.ClientDAO;
import jdbc2020.Client;
import InterfaceGraphique.ViewDeConnexion;
import InterfaceGraphique.ViewInscription;
import InterfaceGraphique.ViewSeConnecter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author titih
 */
public class Control_Identification {

    String m_username_Client = "";

    //Fonction qui s'assure que les identifiants passés en paramètres appartiennent à un client de la base de données
    public void connexion() throws ClassNotFoundException, SQLException {
        int nombre = 0;
        ClientDAO Cdao = new ClientDAO();
        ViewDeConnexion view = new ViewDeConnexion();
        view.Affichage();
        do {
            view.setVisible(true);
            //view.Affichage();
            //  System.out.println("Valeur de 1 : " + view.GetBouton1() + " et de 2 : " + view.GetBouton2());
            if (view.etat_bouton1 == 1) {
                view.setVisible(false);
                System.out.println("bouton 1");
                view.setBouton1(0);
                view.setVisible(false);
                int choix = inscription(view);
                if (choix == 1) {
                    nombre = 1;
                } // l utilisateur souhaite sortir de l application
                if (choix == 0) {
                    view.etat_bouton2 = 1;
                }
                view.etat_bouton1 = 0;
            }
            if (view.etat_bouton2 == 1) {
                view.setVisible(false);
                System.out.println("bouton 2");
                view.setBouton2(0);
                ViewSeConnecter viewConn = new ViewSeConnecter();
                viewConn.enleverTexte(false);
                boolean valide = false;
                do {
                    viewConn.setVisible(true);
                    if (viewConn.etat_bouton == 1) {
                        if (viewConn.texte1.equals("employe") && viewConn.texte2.equals("mdp")) { // l'employee se login
                            ControlMenuEmploye MenuEmployee = new ControlMenuEmploye();
                            MenuEmployee.MenuEMploye();

                        } else {
                            Client c = Cdao.find(viewConn.texte1); // on cherche le username de l'utilisateur dans la base de donnée
                            System.out.println("Username :" + c.GetUsername() + "  password : " + c.GetPasswrd());
                            if (c.GetPasswrd().equals(viewConn.texte2) && c.GetUsername().equals(viewConn.texte1) && viewConn.pas_de_saisie == 0) {
                                m_username_Client = viewConn.texte1;
                                valide = true;
                                ControlClient Cclient = new ControlClient(m_username_Client);
                                Cclient.ControlMenu();
                            }
                            if (valide == false) {
                                viewConn.enleverTexte(true);
                            }
                            viewConn.etat_bouton = 0;
                            viewConn.pas_de_saisie = 0;
                        }
                    }
                    if (viewConn.etat_fleche == 1) {
                        valide = true;
                        viewConn.setVisible(false);
                        viewConn.etat_fleche = 1;
                    }
                    //if()
                } while (valide == false);
                view.etat_bouton2 = 0;
            }

        } while (nombre == 0);
    }

    public int inscription(ViewDeConnexion view) throws ClassNotFoundException, SQLException {
        ViewInscription viewSign = new ViewInscription();
        boolean value = false;
        ClientDAO Cdao = new ClientDAO();
        viewSign.enleverTexte(false, 2, 2);
        do {
            viewSign.setVisible(true);
            if (viewSign.etat_bouton == 1) {
                Client c = Cdao.find(viewSign.username);
                // System.out.println("Username de view : "+viewSign.username + " et user : " +c.GetUsername());
                if (!viewSign.telephone.equals("") && c.GetUsername().equals("") && viewSign.infoValide == 1 && !viewSign.username.equals("employe")) { // on regarde si le numero de telephone n est pas trop long et que le username n existe pas deja 
                    m_username_Client = viewSign.username;
                    viewSign.enleverTexte(false, 2, 0);
                    Client newclient = new Client(viewSign.password, viewSign.username, viewSign.nom, viewSign.prenom, viewSign.adresse, viewSign.telephone);
                    Cdao.create(newclient);
                    viewSign.InscriptionReussie();
                } else if (!c.GetUsername().equals("") || viewSign.username.equals("employe")) {
                    viewSign.enleverTexte(true, 0, 0);
                } else {
                    viewSign.enleverTexte(false, 0, 0);
                }
                viewSign.etat_bouton = 0;
            }
            if (viewSign.etat_fleche == 1) {
                value = true;
                viewSign.etat_fleche = 1;
                viewSign.setVisible(false);
            }
            if (viewSign.choix != -1) {
                viewSign.setVisible(false);
                value = true;

            }
        } while (value == false);
        return viewSign.choix;
    }
    /* public void inscription() throws ClassNotFoundException, SQLException {
        ArrayList<String> information = view.Inscription();
        ClientDAO Cdao = new ClientDAO();
        Client c = new Client(information.get(5), information.get(4), information.get(1), information.get(0), information.get(2), information.get(3));
        m_username_Client = information.get(4);
        Cdao.create(c);
    }*/

 /*public boolean UserEmployee() {
        if (m_username_Client == "employe") {
            return true;
        }
        return false;
    }*/
}
