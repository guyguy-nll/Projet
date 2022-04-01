/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.util.ArrayList;

/**
 *
 * @author titih
 */
public class Commande {

    private String m_referenceP; // reference du produit à ajouter dans la commande
    private String m_username; // password du client car seul lui a accès à ce mot de passe

    public Commande() {
        m_referenceP = "";
        m_username = "";
    }

    public Commande(String referenceP, String username) {
        m_referenceP = referenceP;
        m_username = username;
    }

    //GETTER
    public String GetRefP() {
        return m_referenceP;
    }

    public String GetUsername() {
        return m_username;
    }

    // on ajoute un produit dans notre panier
    /* void AjouterProduit(Produit produit) {
        m_produit.add(produit);
    }

    boolean EnleverProduit(String name) {
        for (int i = 0; i < m_produit.size(); i++) {
            if (m_produit.get(i).GetNom().equals(name)) {
                m_produit.remove(i);
                return true;
            }
        }
        return false; // le produit n'a pas été trouvé dans la commande
    }*/
}
