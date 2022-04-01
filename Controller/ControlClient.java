/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.ViewClient;
import InterfaceGraphique.ViewFacture;
import InterfaceGraphique.ViewPageFruit;
import java.awt.Point;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import jdbc2020.Client;
import jdbc2020.ClientDAO;
import jdbc2020.Commande;
import jdbc2020.CommandeDAO;
import jdbc2020.Facture;
import jdbc2020.FactureDAO;
import jdbc2020.Produit;
import jdbc2020.ProduitDAO;

/**
 *
 * @author titih
 */
public class ControlClient {

    private String m_username;
    public ControlClient(String username) {
        m_username = username;
    }

    public void ControlMenu() throws ClassNotFoundException, SQLException {
        ViewClient Vclient = new ViewClient();
        ViewClient Vclient2 = new ViewClient();;
        Vclient.init();
       
        ControlAffichageCommande(Vclient);
        int nombre = 0;
        int etatBouton = 0;
        do {
            Vclient.setVisible(true);
            etatBouton = BoutonPresse(Vclient);

            if (etatBouton > 0) {
                Vclient.setVisible(false);
                ControlPageFruit Cfruit = new ControlPageFruit(m_username);
                Cfruit.CPageFruit(etatBouton);
                Vclient = new ViewClient();
                Vclient.init();
                ControlAffichageCommande(Vclient);
            }
            if (Vclient.BoutonPayer == 1) {
                Vclient.setVisible(false);
                ControlReglement Creglement = new ControlReglement(m_username);
                Creglement.ControlPageReglement();
                Vclient = new ViewClient();
                Vclient.init();
                ControlAffichageCommande(Vclient);
                Vclient.BoutonPayer = 0;
            }
            if (Vclient.BoutonFacture == 1) {
                Vclient.setVisible(false);
                ViewFacture viewF = new ViewFacture();
                AfficherDonneeFacture(viewF);
                viewF.ajoutImageFond();
                int test = 0;
                int valeurprec = -1;
                
                do {
                    viewF.setVisible(true);
                    if (valeurprec != viewF.CasePointee) { // on entre va afficher la nouvelle facture seulement si on appuie sur une autre que celle selectionnee
                        viewF.setVisible(false);
                        String Date = viewF.DateLigne;
                        viewF = new ViewFacture();
                        ProduitFacture(viewF, Date);
                        AfficherDonneeFacture(viewF);

                        viewF.ajoutImageFond();
                        valeurprec = viewF.CasePointee;
                    }
                    if (viewF.BoutonFleche == 1) {
                        test = 1;
                        viewF.setVisible(false);
                    }

                } while (test == 0);
                Vclient.BoutonFacture = 0;
            }
            if(Vclient.BoutonProfil==1)
            {
                ControlModifyProfil CProfil = new ControlModifyProfil(m_username);
               m_username= CProfil.ControlProfil();
               Vclient.BoutonProfil =0;
            }
        } while (nombre == 0);
        
    }

    public int BoutonPresse(ViewClient viewC) {
        if (viewC.etatbouton1 == 1) {
            viewC.etatbouton1 = 0;
            return 1;
        } else if (viewC.etatbouton2 == 1) {
            viewC.etatbouton2 = 0;
            return 6;
        } else if (viewC.etatbouton3 == 1) {
            viewC.etatbouton3 = 0;
            return 3;
        } else if (viewC.etatbouton4 == 1) {
            viewC.etatbouton4 = 0;
            return 2;
        } else if (viewC.etatbouton5 == 1) {
            viewC.etatbouton5 = 0;
            return 4;
        } else if (viewC.etatbouton6 == 1) {
            viewC.etatbouton6 = 0;
            return 5;
        }
        return 0;
    }

    public void ControlAffichageCommande(ViewClient V) throws ClassNotFoundException, SQLException {
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
                // System.out.println("Valeur position 0 : " + valeur[0] + " et 1: " + valeur[1] + " pour fruit : " + produit.GetNom());
                for (int j = 0; j < (int) valeur[0]; j++) {
                    V.CreerNewJlabel(coordY, (produit.GetNom() + " x" + df2.format(produit.GetPromotion())), df.format(produit.getM_prix_promo()).toString());
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
        V.ajoutImageFond();
    }

    public double[] compteurType(ArrayList<Commande> list_Comm, ViewClient V, String PasswrdClient, ArrayList<String> typeVue, String nomproduit, ProduitDAO Pdao) {
        double[] tab = {0, 0};
        if (ElementNonPresent(typeVue, nomproduit) == true) {
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

    public boolean ElementNonPresent(ArrayList<String> typeVue, String nom_produit) {
        for (int i = 0; i < typeVue.size(); i++) {
            if (typeVue.get(i).equals(nom_produit)) {
                return false;
            }
        }
        return true;
    }

    /// FONCTION POUR LES DONNEES DU TABLEAU A AFFICHER POUR LES FACTURES
    public void AfficherDonneeFacture(ViewFacture ViewF) throws ClassNotFoundException, SQLException {
        FactureDAO fDao = new FactureDAO();
        ArrayList<String> dateFacture = new ArrayList<>();
        ArrayList<Facture> ListFacture = fDao.GetFacture();
        ClientDAO Cdao = new ClientDAO();
        Client c = Cdao.find(m_username);
        for (int i = 0; i < ListFacture.size(); i++) {
            if (ElementNonPresent(dateFacture, ListFacture.get(i).getSqlDate()) && ListFacture.get(i).getM_Username().equals(c.GetUsername())) {
                dateFacture.add(ListFacture.get(i).getSqlDate());             
                String[] Info = new String[]{c.GetNom(), c.GetPrenom(), ListFacture.get(i).getSqlDate()};
                ViewF.AjouterLigneTab(Info);
            }
        }
    }

    public void ProduitFacture(ViewFacture V, String DateFacture) throws ClassNotFoundException, SQLException {
        ArrayList<String> typeVue = new ArrayList<>();
        FactureDAO Fdao = new FactureDAO();
        ClientDAO Cdao = new ClientDAO();
        Client client = Cdao.find(m_username);
        ArrayList<Facture> list_facture = Fdao.GetFacture();
        ProduitDAO PDao = new ProduitDAO();
        int coordY = 150;
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
        double Prix_Total = 0;
        for (int i = 0; i < list_facture.size(); i++) {
            if (list_facture.get(i).getM_Username().equals(client.GetUsername()) && list_facture.get(i).getSqlDate().equals(DateFacture)) {
                Produit produit = PDao.find(list_facture.get(i).getM_refP());
                double[] valeur = compteurTypeFacture(list_facture, V, list_facture.get(i).getM_Username(), typeVue, produit.GetNom(), PDao, DateFacture);
                // System.out.println("Valeur position 0 : " + valeur[0] + " et 1: " + valeur[1] + " pour fruit : " + produit.GetNom());
                for (int j = 0; j < (int) valeur[0]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom() + " x" + df2.format(produit.GetPromotion()), df.format(produit.getM_prix_promo()).toString());
                   // Prix_Total += produit.GetPrix() * produit.GetPromotion() * 0.7;
                    Prix_Total += produit.getM_prix_promo();
                    coordY += 20;
                }
                for (int j = 0; j < (int) valeur[1]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom(), df.format(produit.GetPrix()).toString());
                    ///Prix_Total += produit.GetPrix() * produit.GetPromotion() * 0.7;
                    coordY += 20;
                    Prix_Total += produit.GetPrix();
                }

            }
        }
        V.PrixTotale(Prix_Total);
        V.ajoutImageFond();
    }

    // Fonction qui permet de calculer le nombre de produit beneficiant de la facture
    public double[] compteurTypeFacture(ArrayList<Facture> list_Comm, ViewFacture V, String username, ArrayList<String> typeVue, String nomproduit, ProduitDAO Pdao, String date) {
        double[] tab = {0, 0}; // en [1] les produits achetés en unite et en [0] les promotions
        if (ElementNonPresent(typeVue, nomproduit) == true) { // on n'applique cette fonction une seule fois par nom de produit (pas de doublons car ils sont tous pris en compte dans le for)
            typeVue.add(nomproduit);
            for (int i = 0; i < list_Comm.size(); i++) {
                Produit p = Pdao.find(list_Comm.get(i).getM_refP());
                
                if (p.GetNom().equals(nomproduit) && list_Comm.get(i).getSqlDate().equals(date) && username.equals(list_Comm.get(i).getM_Username())) {
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

}
