/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.ViewPageFruit;
import InterfaceGraphique.ViewReglement;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc2020.CarteBancaire;
import jdbc2020.CarteDAO;
import jdbc2020.Client;
import jdbc2020.ClientDAO;
import jdbc2020.Commande;
import jdbc2020.CommandeDAO;
import jdbc2020.Produit;
import jdbc2020.ProduitDAO;

/**
 *
 * @author titih
 */
public class ControlPageFruit {

    private ArrayList<Produit> m_listeTypeProduit = new ArrayList<>();
    private String m_username;

    public ControlPageFruit(String username) {
        m_username = username;
    }

    public void CPageFruit(int boutonPresse) throws ClassNotFoundException, SQLException {
        System.out.println("BOUTON : " + boutonPresse);
        ProduitDAO Pdao = new ProduitDAO();
        ViewPageFruit viewF = TypeProduit(boutonPresse, Pdao);
        viewF.init();
        ControlAffichageCommande(viewF);
        int nombre = 0;
        UploadInfoFenetre(viewF);
        do {
            viewF.setVisible(true);
            int bouton = AjouterProduitCommande(viewF);
            if (bouton == 1) {
                viewF.setVisible(false);
                viewF = new ViewPageFruit();
                viewF.init();
                UploadInfoFenetre(viewF);
                ControlAffichageCommande(viewF);

            }
            if (viewF.BoutonRetour == 1) {
                nombre = 1;
                viewF.setVisible(false);
            }
            if (viewF.etatBoutonPayer == 1) {
                viewF.setVisible(false);
                ControlReglement Creglement = new ControlReglement(m_username);
                if (Creglement.ControlPageReglement() == 1) {
                    nombre = 1;
                } else {
                    viewF.etatBoutonPayer = 0;
                    viewF = new ViewPageFruit();
                    viewF.init();
                    UploadInfoFenetre(viewF);
                    ControlAffichageCommande(viewF);
                }
            }
        } while (nombre == 0);
    }

    public ViewPageFruit TypeProduit(int boutonPresse, ProduitDAO Pdao) {
        if (boutonPresse == 1) {
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Fruit';");
            return new ViewPageFruit();
        } else if (boutonPresse == 2) {
            System.out.print(" PRODUIT MENAGER ");
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Menager';");
            return new ViewPageFruit();
        } else if (boutonPresse == 3) {
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Legumes';");
            return new ViewPageFruit();
        } else if (boutonPresse == 4) {
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Patisserie';");
            return new ViewPageFruit();
        } else if (boutonPresse == 5) {
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Poisson';");
            return new ViewPageFruit();
        } else if (boutonPresse == 6) {
            m_listeTypeProduit = Pdao.GetProduits("Select * from produit where type = 'Viande';");
            return new ViewPageFruit();
        }
        return null;
    }

    public void UploadInfoFenetre(ViewPageFruit ViewF) // on va modifier les informations des boutons en fonction des produits à afficher
    {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
        for (int i = 1; i <= m_listeTypeProduit.size(); i++) {
            // System.out.print("  " + m_listeTypeProduit.get(i - 1).GetNom());        
            ViewF.SetBouton_Texte(m_listeTypeProduit.get(i - 1).GetNom(), i, "Unite : " + m_listeTypeProduit.get(i - 1).GetPrix() + "E; " + df2.format(m_listeTypeProduit.get(i - 1).GetPromotion()) + "x = " + df.format(m_listeTypeProduit.get(i - 1).getM_prix_promo()) + "E", m_listeTypeProduit.get(i - 1).GetStock());

        }

    }

    // FONCTION PERMETTANT DE VERIFIER SI UNE VALEUR A ETE RENTREE DANS LES TEXTFIELS DE LA QUANTITE DE PRODUITS A AJOUTER OU SUPPRIMER DE SA COMMANDE
    public int AjouterProduitCommande(ViewPageFruit ViewF) throws SQLException, ClassNotFoundException { // Fonction permettant d'ajouter un produit à la base de donnée de commande de l'utilisateur

        for (int i = 0; i < 9; i++) {
            if (ViewF.ListTextFields.get(i).equals("Quantite") == false && !ViewF.ListTextFields.get(i).equals("vide")) { // si on a inserer du texte &
                // System.out.println("entrer : " + ViewF.ListTextFields.get(0));
                CommandeDAO CommDao = new CommandeDAO();
                ClientDAO Cdao = new ClientDAO();
                Client client = Cdao.find(m_username);
                if (Integer.parseInt(ViewF.ListTextFields.get(i)) >= 0) {
                    for (int j = 0; j < Integer.parseInt(ViewF.ListTextFields.get(i)); j++) { // on crée le nombre d eproduit souhaités
                        Commande Comm = new Commande(m_listeTypeProduit.get(i).GetRef(), client.GetUsername());
                        CommDao.create(Comm);
                    }
                } else if (NbApparationArticle(ViewF, CommDao, client, Math.abs(Integer.parseInt(ViewF.ListTextFields.get(i))), m_listeTypeProduit.get(i).GetRef())) { // on vérifie que le nombre d article a enlever se trouve bien dans la commande
                    RetirerArticleCommande(client.GetUsername(), m_listeTypeProduit.get(i).GetRef(), Math.abs(Integer.parseInt(ViewF.ListTextFields.get(i))), CommDao);
                } else {
                    ViewF.afficherErreur("Erreur : vous tentez de retirer un nombre d'articles que vous ne possédez pas !");
                }
                ViewF.ListTextFields.set(i, "Quantite");
                return 1;
            }
        }
        return 0;
    }

    // Fonction qui supprime le nombre d article de la commande selon le choix du client
    public void RetirerArticleCommande(String username, String ref, int repetition, CommandeDAO Cdao) throws SQLException {//Math.abs(Integer.parseInt(ViewF.ListTextFields.get(0)))
        for (int i = 0; i < repetition; i++) { // on supprime le nombre de fois demande le produit avec cette reference de la commande
            Cdao.executeUpdate("Delete from commande where referenceP ='" + ref + "' and usernameclient='" + username + "' LIMIT 1;");
        }
    }

    // Fonciton qui retourne true si le nombre d'articles à retirer de la commande existent vraiment
    public boolean NbApparationArticle(ViewPageFruit View, CommandeDAO CommDao, Client client, int NbArticleRemove, String refProduit) throws SQLException {
        int NbProduitPanier = 0;
        ResultSet resultat = CommDao.executeQuery("Select * from commande where usernameclient='" + client.GetUsername() + "' and referenceP='" + refProduit + "';"); // On va extraire le nombre de produit de cette ref qui sont present dans la commande
        while (resultat.next()) {
            NbProduitPanier++; // on compte le nombre d article de cette ref dans le panier
        }
        if (NbProduitPanier >= NbArticleRemove) {
            return true;
        }
        return false;
    }

    public void ControlAffichageCommande(ViewPageFruit V) throws ClassNotFoundException, SQLException {
        ArrayList<String> typeVue = new ArrayList<>();
        CommandeDAO CommDao = new CommandeDAO();
        ClientDAO Cdao = new ClientDAO();
        Client client = Cdao.find(m_username);
        ArrayList<Commande> list_Comm = CommDao.GetCommandes();
        ProduitDAO PDao = new ProduitDAO();
        int coordY = 150;
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
        double Prix_Total = 0;
        for (int i = 0; i < list_Comm.size(); i++) {
            // System.out.println(list_Comm.get(i).GetMdpC() + " et client : " + client.GetPasswrd());
            if (list_Comm.get(i).GetUsername().equals(client.GetUsername())) {
                Produit produit = PDao.find(list_Comm.get(i).GetRefP());
                double[] valeur = compteurType(list_Comm, V, list_Comm.get(i).GetUsername(), typeVue, produit.GetNom(), PDao);
                //System.out.println("Valeur position 0 : " + valeur[0] + " et 1: "+valeur[1] + " pour fruit : "+produit.GetNom());
                for (int j = 0; j < (int) valeur[0]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom() + " x" + df2.format(produit.GetPromotion()), df.format(produit.getM_prix_promo()).toString());
                    Prix_Total += produit.getM_prix_promo();

                    coordY += 20;
                }
                for (int j = 0; j < (int) valeur[1]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom(), df.format(produit.GetPrix()).toString());
                    coordY += 20;
                    Prix_Total += produit.GetPrix();
                }

            }
        }
        V.PrixTotale(Prix_Total);
        V.AfficherFond();
        System.out.println("FINIIIIII\n");
    }

    public double[] compteurType(ArrayList<Commande> list_Comm, ViewPageFruit V, String PasswrdClient, ArrayList<String> typeVue, String nomproduit, ProduitDAO Pdao) {
        double[] tab = {0, 0};
        if (ProduitPasPasse(typeVue, nomproduit) == true) {
            System.out.println("Produit ajoute : " + nomproduit);
            typeVue.add(nomproduit);
            for (int i = 0; i < list_Comm.size(); i++) {
                Produit p = Pdao.find(list_Comm.get(i).GetRefP());
                if (p.GetNom().equals(nomproduit)) {
                    tab[1]++;
                    if (tab[1] == p.GetPromotion()) {
                        tab[1] = 0;
                        tab[0] += 1;
                    }
                }
            }
        }
        return tab;
    }

    public boolean ProduitPasPasse(ArrayList<String> typeVue, String nom_produit) {
        for (int i = 0; i < typeVue.size(); i++) {
            if (typeVue.get(i).equals(nom_produit)) {
                return false;
            }
        }
        return true;
    }

}
