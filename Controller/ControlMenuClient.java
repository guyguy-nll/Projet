/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import jdbc2020.ClientDAO;
import jdbc2020.Commande;
import jdbc2020.ProduitDAO;
import jdbc2020.Produit;
import InterfaceGraphique.ViewMenuClient;
import java.util.Scanner;
import jdbc2020.Client;
import jdbc2020.CommandeDAO;

/**
 *
 * @author titih
 */
public class ControlMenuClient {

    private ArrayList<Produit> m_listProduit = new ArrayList<>();
    private ViewMenuClient ViewClient = new ViewMenuClient();
    Scanner sc = new Scanner(System.in);
    String m_username_Client; // on garde en mémoire le username du client qui a été inscrit et à chaque fois on ira chercher dans la base de donnée ses informations

    // constructeur dans lequel on transfere le username du client connecté
    public ControlMenuClient(String username) {
        m_username_Client = username;
    }

    //fonction principale du menu
    public void MenuShopClient() throws ClassNotFoundException, SQLException {
        RecupListCommande();
        ViewClient.InterfaceMenuClient();
        int nombre;
        do {
            do {
                nombre = sc.nextInt();
                ViewClient.InterfaceMenuClient();
            } while (nombre < 1 || nombre > 8);
            if (nombre == 1) {
                ControlProfil profil = new ControlProfil(m_username_Client);
                profil.ModifierProfil();
            } else if (nombre == 3) {
                AfficherAliments("Fruit");
            } else if (nombre == 4) {
                AfficherAliments("Legume");
            } else if (nombre == 5) {
                AfficherAliments("Patisserie");
            } else if (nombre == 6) {
                AfficherAliments("Viandes");
            } else if (nombre == 7) {
                AfficherAliments("Poisson");
            } else if (nombre == 8) {
                AfficherAliments("Poisson");
            }
        } while (nombre != 8);

    }

    public void AfficherAliments(String TypeAliment) throws ClassNotFoundException, SQLException {
        ProduitDAO Pdao = new ProduitDAO();
        ClientDAO CDAO = new ClientDAO();
        ArrayList<Produit> produit = Pdao.GetProduits("SELECT * FROM produit WHERE type='" + TypeAliment + "';");
        System.out.println("                                                   Quels produits voulez-vous acheter ?");
        int choix;
        do {
            for (int i = 0; i < produit.size(); i++) {
                if (produit.get(i).GetStock() > 0) { // on affiche que les produits en stock
                    System.out.println(produit.get(i).GetRef() + " : " + TypeAliment + " : " + produit.get(i).GetNom() + " : " + i);
                }
            }
            choix = sc.nextInt();
            Client c = CDAO.find(m_username_Client); // on récupère le client qui ajoute sa commande pour créer une commande dans la base de donnée
            Commande commande = new Commande(produit.get(choix).GetRef(), c.GetPasswrd());
            CommandeDAO ComDAO = new CommandeDAO();
            System.out.println("mot de passe : " + c.GetPasswrd() + " ref : " + produit.get(choix).GetRef());
            ComDAO.create(commande); // on ajoute le produit dans la base de donnée
            produit.get(choix).SetStock(produit.get(choix).GetStock() - 1); // on diminue son stock de 1
            Pdao.executeUpdate("UPDATE produit SET stock ='" + (produit.get(choix).GetStock()) + "' WHERE reference='" + produit.get(choix).GetRef() + "';");
        } while (choix != 0);
    }

    // on récupère les produits du shop (même ceux qui ne sont plus en stock) 
    public void RecupListCommande() throws ClassNotFoundException, SQLException {
        ProduitDAO Pdao = new ProduitDAO();
        m_listProduit = Pdao.GetProduits("SELECT * FROM produit");
    }

}
