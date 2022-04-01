/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.ViewReglement;
//import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import jdbc2020.CarteBancaire;
import jdbc2020.CarteDAO;
import jdbc2020.Client;
import jdbc2020.ClientDAO;
import jdbc2020.Commande;
import jdbc2020.CommandeDAO;
import jdbc2020.Facture;
import jdbc2020.FactureDAO;
import jdbc2020.Produit;
import jdbc2020.ProduitDAO;
import java.text.ParseException;
import java.util.Date;
//import org.apache.commons.lang3.time.DateFormatUtils;

/**
 *
 * @author titih
 */
public class ControlReglement {
    /// ON CONTROLE ICI LA PAGE DE REGLEMENT 

    private String m_username;

    public ControlReglement(String username) {
        m_username = username;
    }

    public int ControlPageReglement() throws ClassNotFoundException, SQLException {
        CarteDAO Carte = new CarteDAO();
        ViewReglement Vbuy = new ViewReglement();
        Vbuy.init();
        ControlAffichageCommandeReglement(Vbuy);
        int nombre = 0;
        do {
            Vbuy.setVisible(true);
            if (Vbuy.BoutonValide == 1) {
                CarteBancaire CB = Carte.find(Vbuy.textNumCarte);
                if (!CB.getNomUtilisateur().equals(Vbuy.textNomProprio) || !CB.getNum_Carte().equals(Vbuy.textNumCarte) || !CB.getCrypto().equals(Vbuy.textCrypto) || !CB.getDateValidite().equals(Vbuy.texteDateValidite)) {
                    Vbuy.messageErreur();
                } else {
                    Vbuy.PaiementAccepte();
                    AjouterFactureBDD();
                    Vbuy.setVisible(false);
                    nombre=1;
                    return 1; // on retourne au menu
                }
                Vbuy.BoutonValide = 0;
            }
            if (Vbuy.BoutonAnnule == 1) {
                nombre = 1;
                Vbuy.setVisible(false);
                return 0; // on revient à la page precedente
            }
        } while (nombre == 0);
        return 0;
    }

    public void ControlAffichageCommandeReglement(ViewReglement V) throws ClassNotFoundException, SQLException {
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
                double[] valeur = compteurTypeReglement(list_Comm, V, list_Comm.get(i).GetUsername(), typeVue, produit.GetNom(), PDao);
                //System.out.println("Valeur position 0 : " + valeur[0] + " et 1: "+valeur[1] + " pour fruit : "+produit.GetNom());
                for (int j = 0; j < (int) valeur[0]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom() + " x" + df2.format(produit.GetPromotion()) + " : " + df.format(produit.getM_prix_promo()).toString());
                   // Prix_Total += produit.GetPrix() * produit.GetPromotion() * 0.7;
                   Prix_Total += produit.getM_prix_promo();
                    coordY += 20;
                }
                for (int j = 0; j < (int) valeur[1]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom() + " : " + df.format(produit.GetPrix()));
                    coordY += 20;
                    Prix_Total += produit.GetPrix();
                }

            }
        }
        V.PrixTotale(Prix_Total);
        V.AfficherFond();
        System.out.println("FINIIIIII\n");
    }

    public double[] compteurTypeReglement(ArrayList<Commande> list_Comm, ViewReglement V, String PasswrdClient, ArrayList<String> typeVue, String nomproduit, ProduitDAO Pdao) {
        double[] tab = {0, 0};
        if (ProduitPasPasse(typeVue, nomproduit) == true) {
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

    public boolean ProduitPasPasseReglement(ArrayList<String> typeVue, String nom_produit) {
        for (int i = 0; i < typeVue.size(); i++) {
            if (typeVue.get(i).equals(nom_produit)) {
                return false;
            }
        }
        return true;
    }

    public boolean ProduitPasPasse(ArrayList<String> typeVue, String nom_produit) {
        for (int i = 0; i < typeVue.size(); i++) {
            if (typeVue.get(i).equals(nom_produit)) {
                return false;
            }
        }
        return true;
    }

    public void AjouterFactureBDD() throws ClassNotFoundException, SQLException {
        FactureDAO FDAO = new FactureDAO();
        CommandeDAO CommDao = new CommandeDAO();
        ArrayList<Commande> list_Comm = CommDao.GetCommandes();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        ClientDAO Cdao = new ClientDAO();
        Client c = Cdao.find(m_username);
        String dateToStr = dateFormat.format(date);
        for (int i = 0; i < list_Comm.size(); i++) {
            if (c.GetUsername().equals(list_Comm.get(i).GetUsername())) {
                Facture f = new Facture(list_Comm.get(i).GetUsername(), list_Comm.get(i).GetRefP(), dateToStr);
                FDAO.create(f);
            }
        }
        ClientDAO CDAO = new ClientDAO();
        CommDao.executeUpdate("Delete from commande where usernameClient = '" + c.GetUsername() + "';");
    }
}
