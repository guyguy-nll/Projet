/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.HistogramPanel;
import InterfaceGraphique.ViewEmployeMenu;
import InterfaceGraphique.ViewFacture;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import jdbc2020.CamembertStat;
import jdbc2020.Client;
import jdbc2020.ClientDAO;
import jdbc2020.Facture;
import jdbc2020.FactureDAO;
import jdbc2020.Produit;
import jdbc2020.ProduitDAO;

/**
 *
 * @author titih
 */
public class ControlMenuEmploye {

    public void MenuEMploye() throws ClassNotFoundException, SQLException {
        ViewEmployeMenu ViewE = new ViewEmployeMenu();

        ViewE.Menu();
        int boucle = 0;
        do {
            ViewE.setVisible(true);
            if (ViewE.BoutonDossierClient == 1) {
                DossierClient(ViewE);
                ViewE.Menu();
                ViewE.BoutonDossierClient = 0;
            }
            if (ViewE.BoutonExamVente == 1) {
                ViewE.InterfaceExamVente(0);
                Affichage(ViewE);
                ViewE.Menu();
                ViewE.BoutonExamVente = 0;
                // HistogramPanel histo = new HistogramPanel();
                // histo.createAndShowGUI();

                int test = 0;

            }
            if (ViewE.BoutonInventaire == 1) {
                SetPromotion(ViewE);
                ViewE.Menu();
                ViewE.BoutonInventaire = 0;
            }
            if (ViewE.BoutonOffreRabais == 1) {
                ViewE.BoutonOffreRabais = 0;
            }
        } while (boucle == 0);
    }

    ///// *************  FONCIONS POUR HISTOGRAMME DES VENTES  ************************///
    public void Affichage(ViewEmployeMenu ViewE) throws ClassNotFoundException, SQLException {
        CamembertStat Camembert = creerCamembert(ViewE);
        int boucle = 0;
        String valeurPrec = "";
        String valeurPrecDate = "";
        FactureDAO Fdao = new FactureDAO();
        String[] test = new String[9];
        HistogramPanel Histogramme = new HistogramPanel();
        int test2 = 0;
        do {

            ViewE.setVisible(true);
            if (!valeurPrec.equals(ViewE.ItemChoisi)) {
                ViewE.AjouterLigneTab("", 1);
                if (ViewE.ItemChoisi.equals("Fruit")) {
                    test = new String[]{"orange", "kiwi", "kaki", "banane", "mangue", "pomme", "melon", "pasteque", "ananas"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;
                }
                if (ViewE.ItemChoisi.equals("Viande")) {
                    test = new String[]{"poulet", "Steak", "Porc", "Boeuf", "Agneau", "Veau", "Volaille", "Dinde", "Chorizo"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;
                }
                if (ViewE.ItemChoisi.equals("Poisson")) {
                    test = new String[]{"Seche", "Homard", "Haddock", "Saumon", "Maquereau", "Roussette", "Bar", "Poulpe", "Araignee"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;
                }
                if (ViewE.ItemChoisi.equals("Patisserie")) {
                    test = new String[]{"MuffinChoco", "PainChoco", "Croissant", "Paris Brest", "EclairChoco", "Cookie", "Brownie", "Fraisier", "Macaron"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;
                }
                if (ViewE.ItemChoisi.equals("Legumes")) {
                    test = new String[]{"Aubergine", "Poivron", "Artichaut", "Concombre", "Carotte", "Poireau", "Courge", "Choux", "Celeri"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;

                }
                if (ViewE.ItemChoisi.equals("Menager")) {
                    test = new String[]{"Lessive", "Gel WC", "Savon", "Dentifrice", "Shampoing", "Gel Douche", "Papier WC", "Eponge", "Poele 28 cm"};
                    RemplirTableauHistogramme(ViewE, Fdao);
                    valeurPrec = ViewE.ItemChoisi;
                }

                valeurPrecDate = "";
                ViewE.DatePointee = "";

            }
            if (!valeurPrecDate.equals(ViewE.DatePointee)) {
                // Histogramme.setVisible(false);
                Histogramme.frame.setVisible(false);
                Histogramme = InformationHistogramme(test, ViewE, ViewE.DatePointee, Fdao, Histogramme);

                valeurPrecDate = ViewE.DatePointee;
                test2 = 1;

            }
            if (ViewE.BoutonRetour == 1) {
                boucle = 1;
                Histogramme.frame.setVisible(false);
                Camembert.setVisible(false);
                ViewE.InterfaceExamVente(1);
                ViewE.BoutonRetour = 0;
            }

        } while (boucle == 0);
    }

    public void RemplirTableauHistogramme(ViewEmployeMenu ViewE, FactureDAO Fdao) throws ClassNotFoundException, SQLException { // on va afficher dans un tableau les dates ou des fruits ou legume ou ... ont ete achetee et afficher leur proportion

        ArrayList<String> date_passee = new ArrayList<>();
        ResultSet DateAchat = Fdao.executeQuery("Select distinct date from facture;");
        String date = "";
        while (DateAchat.next()) {
            if (!date.equals(DateAchat.getString("date").substring(0, 10))) {
                date = DateAchat.getString("date").substring(0, 10);
                ViewE.AjouterLigneTab(date, 0);
            }

        }
    }

    public HistogramPanel InformationHistogramme(String[] produit, ViewEmployeMenu ViewE, String date, FactureDAO Fdao, HistogramPanel Histogramme) throws ClassNotFoundException, SQLException {
        ProduitDAO Pdao = new ProduitDAO();
        ArrayList<Integer> CompteurProduit = new ArrayList<Integer>();
        ArrayList<Facture> FactureDate = Fdao.GetFacture();
        int passe = 0;
        for (int i = 0; i < 9; i++) {
            CompteurProduit.add(0);
            /*ResultSet DateAchat = Fdao.executeQuery("Select refproduit from facture where date ='" + date + "';");
            while (DateAchat.next()) {
                Produit p = Pdao.find(DateAchat.getString("refproduit"));
                if (produit[i].equals(p.GetNom())) {
                    CompteurProduit.set(i, CompteurProduit.get(i) + 1);
                }
            }*/

            for (int j = 0; j < FactureDate.size(); j++) {

                if (FactureDate.get(j).getSqlDate().substring(0, 10).equals(date)) {
                    Produit p = Pdao.find(FactureDate.get(j).getM_refP());
                    if (produit[i].equals(p.GetNom())) {
                        CompteurProduit.set(i, CompteurProduit.get(i) + 1);
                        passe = 1;
                    }
                }
            }
        }

        Histogramme.nonVisible();
        //if(passe==1){
        Histogramme = new HistogramPanel(CompteurProduit, produit);
        Histogramme.createAndShowGUI();
        // }
        return Histogramme;

    }

    ///*************************** FONCTION POUR CAMEMBERT DES VENTES ************************************//
    public CamembertStat creerCamembert(ViewEmployeMenu V) throws ClassNotFoundException, SQLException { //on va compter ici combien les types de produits(ex:fruits) ont rapportés à l'entreprise depuis le début 
        ProduitDAO Pdao = new ProduitDAO();
        ArrayList<String> typeVue = new ArrayList<>();
        double[] achat = new double[]{0, 0, 0, 0, 0, 0};
        String Nom_Produit[] = new String[]{"fruit", "Viande", "Poisson", "Legumes", "Patisserie", "Menager"};
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
        FactureDAO Fdao = new FactureDAO();
        ArrayList<Facture> list_facture = Fdao.GetFacture();
        for (int i = 0; i < achat.length; i++) {
            System.out.println("\n\n************** Type du produit : " + Nom_Produit[i] + "///////////////");
            for (int j = 0; j < list_facture.size(); j++) {
                Produit produit = Pdao.find(list_facture.get(j).getM_refP());
                System.out.println("type du Produit : " + produit.GetNom() + " et le type en cours : " + Nom_Produit[i]);
                if (produit.GetType().equals(Nom_Produit[i])) { // on va compter par exemple comn
                    double[] valeur = compteurTypeFacture(list_facture, V, typeVue, produit.GetNom(), Pdao, "", "", 1);
                    //System.out.println("Valeur0 : " + valeur[0] + "valeur 1: " + valeur[1]);
                    // System.out.println("Valeur position 0 : " + valeur[0] + " et 1: " + valeur[1] + " pour fruit : " + produit.GetNom());
                    System.out.println("Il y a " + valeur[0] + " promotion et " + valeur[1] + " prix normale pour " + produit.GetNom());
                    for (int h = 0; h < (int) valeur[0]; h++) {
                        achat[i] += produit.getM_prix_promo();
                        System.out.println("Achat [i] promo : " + achat[i]);
                    }
                    for (int h = 0; h < (int) valeur[1]; h++) {
                        achat[i] += produit.GetPrix();
                        System.out.println("Achat [i]  : " + achat[i]);
                    }
                    System.out.println("Valeur final achat : " + achat[i]);
                }
            }
        }
        double somme = (achat[0] + achat[1] + achat[2] + achat[3] + achat[4] + achat[5]);
        for (int i = 0; i < achat.length; i++) {
            Nom_Produit[i] += " " + df.format((achat[i] / somme) * 100) + "%";
        }
        CamembertStat Camembert = new CamembertStat(Nom_Produit, achat);
        Camembert.AfficherCamembert();
        Camembert.setVisible(true);
        return Camembert; // cela va permettre de l'enlever de l'affichage par la suite 
    }

    ///FONCTION POUR LE DOSSIER DES CLIENS
    public void DossierClient(ViewEmployeMenu ViewE) throws ClassNotFoundException, SQLException {
        int boucle = 0;
        FactureDAO Fdao = new FactureDAO();
        ArrayList<Facture> ListFacture = Fdao.GetFacture();
        ViewE.DossierClient();
        RemplirTableauDossierClient(ViewE, Fdao, ListFacture);
        int valeurPrec = -1;
        do {
            ViewE.setVisible(true);
            if (valeurPrec != ViewE.CasePointee) {
                ViewE.setVisible(false);
                // valeurPrec = ViewE.CasePointee;
                String username = ViewE.Username;
                String date = ViewE.DatePointee;
                ViewE = new ViewEmployeMenu();
                ProduitFacture(ViewE, date, username, Fdao, ListFacture);
                RemplirTableauDossierClient(ViewE, Fdao, ListFacture);
                System.out.println("passeeee par la aussi");

                System.out.println("passeeee valeur Prec :" + valeurPrec + " et " + ViewE.CasePointee);
                ViewE.DossierClient();
            }
            if (ViewE.BoutonRetour == 1) {

                boucle = 1;
                ViewE.BoutonRetour = 0;
            }

        } while (boucle == 0);
    }

    public void RemplirTableauDossierClient(ViewEmployeMenu ViewE, FactureDAO Fdao, ArrayList<Facture> ListFacture) throws ClassNotFoundException, SQLException {
        ArrayList<String> DatePassee = new ArrayList<>();
        String mdpClient = "";
        ProduitDAO Pdao = new ProduitDAO();
        ClientDAO Cdao = new ClientDAO();
        for (int i = ListFacture.size() - 1; i > 0; i--) {
            System.out.println("MDP DE LA FACTURE: " + ListFacture.get(i).getM_Username());
            if (ElementNonPresent(DatePassee, ListFacture.get(i).getSqlDate()) || !mdpClient.equals(ListFacture.get(i).getM_Username())) {
                DatePassee.add(ListFacture.get(i).getSqlDate());
                mdpClient = ListFacture.get(i).getM_Username();
                ResultSet res = Cdao.executeQuery("Select * from client where username = '" + mdpClient + "';");
                while (res.next()) {
                    System.out.println("\n" + res.getString("username"));
                    String[] InfoTableau = new String[]{res.getString("username"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("telephone"), ListFacture.get(i).getSqlDate()};
                    ViewE.AjouterLigneTab2(InfoTableau);
                }

            }
        }
    }

    public boolean ElementNonPresent(ArrayList<String> typeVue, String nom_produit) {
        for (int i = 0; i < typeVue.size(); i++) {
            if (typeVue.get(i).equals(nom_produit)) {
                return false;
            }
        }
        return true;
    }

    public void ProduitFacture(ViewEmployeMenu V, String DateFacture, String username, FactureDAO Fdao, ArrayList<Facture> list_facture) throws ClassNotFoundException, SQLException {
        ArrayList<String> typeVue = new ArrayList<>();
        ClientDAO Cdao = new ClientDAO();
        Client client = Cdao.find(username);
        ProduitDAO PDao = new ProduitDAO();
        int coordY = 150;
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat df2 = new DecimalFormat("0");
        double Prix_Total = 0;
        System.out.println("taille Facture: " + list_facture.size());
        for (int i = 0; i < list_facture.size(); i++) {
            System.out.println("username facture : " + list_facture.get(i).getM_Username() + "celle client: " + client.GetUsername() + "date facture :" + list_facture.get(i).getSqlDate() + "et client: " + DateFacture);
            if (list_facture.get(i).getM_Username().equals(client.GetUsername()) && list_facture.get(i).getSqlDate().equals(DateFacture)) {
                Produit produit = PDao.find(list_facture.get(i).getM_refP());
                double[] valeur = compteurTypeFacture(list_facture, V, typeVue, produit.GetNom(), PDao, DateFacture, client.GetUsername(), 0);
                System.out.println("Valeur0 : " + valeur[0] + "valeur 1: " + valeur[1]);
                // System.out.println("Valeur position 0 : " + valeur[0] + " et 1: " + valeur[1] + " pour fruit : " + produit.GetNom());
                for (int j = 0; j < (int) valeur[0]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom() + " x" + df2.format(produit.GetPromotion()), df.format(produit.getM_prix_promo()).toString());
                    // Prix_Total += produit.GetPrix() * produit.GetPromotion() * 0.7;
                    Prix_Total += produit.getM_prix_promo();
                    coordY += 20;
                }
                for (int j = 0; j < (int) valeur[1]; j++) {
                    V.CreerNewJlabel(coordY, produit.GetNom(), df.format(produit.GetPrix()).toString());
                    // Prix_Total += produit.GetPrix() * produit.GetPromotion() * 0.7;
                    coordY += 20;
                    Prix_Total += produit.GetPrix();
                }

            }
        }
        V.PrixTotale(Prix_Total);
        // V.ajoutImageFond();
    }

    public double[] compteurTypeFacture(ArrayList<Facture> list_Comm, ViewEmployeMenu V, ArrayList<String> typeVue, String nomproduit, ProduitDAO Pdao, String Date, String username, int passe) {
        double[] tab = {0, 0};
        if (ElementNonPresent(typeVue, nomproduit) == true) {
            typeVue.add(nomproduit);
            for (int i = 0; i < list_Comm.size(); i++) {
                Produit p = Pdao.find(list_Comm.get(i).getM_refP());
                if ((p.GetNom().equals(nomproduit) && list_Comm.get(i).getSqlDate().equals(Date) && username.equals(list_Comm.get(i).getM_Username())) || (p.GetNom().equals(nomproduit) && passe == 1)) {
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

///////////////////// FONCTION POUR LES PROMOTIONS //////////////////////////
    public void SetPromotion(ViewEmployeMenu ViewE) throws ClassNotFoundException, SQLException {
        ViewE.Inventaire();
        ProduitDAO Pdao = new ProduitDAO();
        int nombre = 0;
        String valeurprecType = "";
        String valeurprecProduit = "";
        String[] InfoTextFields = new String[]{"", "", "", "", "", "", "", "", ""};
        int changerProduit = 0;
        do {
            ViewE.setVisible(true);
            if (!valeurprecType.equals(ViewE.ItemChoisi)) {
                InfoTextFields = RemplirLabel(ViewE);
                valeurprecType = ViewE.ItemChoisi;
                changerProduit = 1;
            }
            if (!valeurprecProduit.equals(ViewE.ProduitChoisi) || changerProduit == 1) {
                changerProduit = 0;
                for (int i = 0; i < 9; i++) {
                    if (ViewE.ProduitChoisi.equals("Prix Unitaire")) {
                        ResultSet res = Pdao.executeQuery("Select distinct prix from produit where nom='" + InfoTextFields[i] + "';");
                        while (res.next()) {
                            ViewE.modifierTextfields(i, res.getDouble("prix"));
                        }
                    } else if (ViewE.ProduitChoisi.equals("Lot Promotion")) {
                        ResultSet res = Pdao.executeQuery("Select distinct promotion from produit where nom='" + InfoTextFields[i] + "';");
                        while (res.next()) {
                            ViewE.modifierTextfields(i, res.getInt("promotion"));
                        }
                    } else if (ViewE.ProduitChoisi.equals("Prix Promotion")) {
                        ResultSet res = Pdao.executeQuery("Select distinct prixpromotion from produit where nom='" + InfoTextFields[i] + "';");
                        while (res.next()) {
                            ViewE.modifierTextfields(i, res.getDouble("prixpromotion"));
                        }
                    } else if (ViewE.ProduitChoisi.equals("Stock")) {
                        ResultSet res = Pdao.executeQuery("Select distinct stock from produit where nom='" + InfoTextFields[i] + "';");
                        while (res.next()) {
                            ViewE.modifierTextfields(i, res.getDouble("stock"));
                        }
                    }

                }
                valeurprecProduit = ViewE.ProduitChoisi;
            }

            int result = ViewE.ModifyTextFieldsInventaire(); // on regarde si une valeur sur le textfields a ete modifiee
            if (result >= 0) {
                if (ViewE.ProduitChoisi.equals("Prix Unitaire")) {
                    Pdao.executeUpdate("Update produit set prix='" + ViewE.ListTextFields.get(result) + "' where nom='" + InfoTextFields[result] + "';");

                } else if (ViewE.ProduitChoisi.equals("Lot Promotion")) {
                    Pdao.executeUpdate("Update produit set promotion='" + ViewE.ListTextFields.get(result) + "' where nom='" + InfoTextFields[result] + "';");

                } else if (ViewE.ProduitChoisi.equals("Prix Promotion")) {
                    Pdao.executeUpdate("Update produit set prixpromotion='" + ViewE.ListTextFields.get(result) + "' where nom='" + InfoTextFields[result] + "';");

                } else if (ViewE.ProduitChoisi.equals("Stock")) {
                    Pdao.executeUpdate("Update produit set stock='" + ViewE.ListTextFields.get(result) + "' where nom='" + InfoTextFields[result] + "';");

                }
                ViewE.ListTextFields.set(result, "");
            }
            if (ViewE.BoutonRetour == 1) {
                nombre = 1;
                ViewE.BoutonRetour = 0;
            }
        } while (nombre == 0);
    }

    public String[] RemplirLabel(ViewEmployeMenu ViewE) {
        String[] produit = new String[]{"", "", "", "", "", "", "", "", ""};

        if (ViewE.ItemChoisi.equals("Fruit")) {
            produit = new String[]{"orange", "kiwi", "kaki", "banane", "mangue", "pomme", "melon", "pasteque", "ananas"};
            ViewE.RemplirLabel(produit);
        } else if (ViewE.ItemChoisi.equals("Viande")) {
            produit = new String[]{"poulet", "Steak", "Porc", "Boeuf", "Agneau", "Veau", "Volaille", "Dinde", "Chorizo"};
            ViewE.RemplirLabel(produit);

        } else if (ViewE.ItemChoisi.equals("Poisson")) {
            produit = new String[]{"Seche", "Homard", "Haddock", "Saumon", "Maquereau", "Roussette", "Bar", "Poulpe", "Araignee"};
            ViewE.RemplirLabel(produit);

        } else if (ViewE.ItemChoisi.equals("Patisserie")) {
            produit = new String[]{"MuffinChoco", "PainChoco", "Croissant", "Paris Brest", "EclairChoco", "Cookie", "Brownie", "Fraisier", "Macaron"};
            ViewE.RemplirLabel(produit);

        } else if (ViewE.ItemChoisi.equals("Legumes")) {
            produit = new String[]{"Aubergine", "Poivron", "Artichaut", "Concombre", "Carotte", "Poireau", "Courge", "Choux", "Celeri"};
            ViewE.RemplirLabel(produit);

        } else if (ViewE.ItemChoisi.equals("Menager")) {
            produit = new String[]{"Lessive", "Gel WC", "Savon", "Dentifrice", "Shampoing", "Gel Douche", "Papier WC", "Eponge", "Poele 28 cm"};
            ViewE.RemplirLabel(produit);

        }
        return produit;
    }
}

