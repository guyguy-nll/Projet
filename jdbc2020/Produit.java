/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

/**
 *
 * @author titih
 */
public class Produit {

    private String m_reference;
    private double m_prix; // prix du produit
    private double m_promotion; // prix pour le paquet en promotion
    private String m_nom; // nom du produit
    private String m_type; // type (FRUIT/LEGUME/VIANDE)
    private String m_peremption; // date de peremption
    private double m_prix_promo;
    private int m_stock; // contient la quantité restante de ce produit 
    //Image mettre image

    Produit() {
        m_reference = "";
        m_prix = 0;
        m_promotion = 0.00;
        m_nom = "";
        m_type = "";
        m_peremption = "";
        m_prix_promo = 0;
        m_stock = 0;
    }

    Produit(String reference, String nom, String type, double prix, double promotion, String peremption, double prix_promo, int stock) {
        m_reference = reference;
        m_prix = prix;
        m_promotion = promotion;
        m_nom = nom;
        m_type = type;
        m_peremption = peremption;
        m_prix_promo = prix_promo;
        m_stock = stock;
    }

    public double getM_prix_promo() {
        return m_prix_promo;
    }

    public void setM_prix_promo(double m_prix_promo) {
        this.m_prix_promo = m_prix_promo;
    }

    //GETTER    
    public String GetRef() {
        return m_reference;
    }

    public String GetNom() {
        return m_nom;
    }

    public String GetType() {
        return m_type;
    }

    public String GetPeremption() {
        return m_peremption;
    }

    public int GetStock() {
        return m_stock;
    }

    public double GetPrix() {
        return m_prix;
    }

    public double GetPromotion() {
        return m_promotion;
    }

    public void SetStock(int valeur) {
        m_stock = valeur;
    }

    //mettre une image
}
