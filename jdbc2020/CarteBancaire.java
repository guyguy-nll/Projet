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
public class CarteBancaire {

    private String Num_Carte;
    private String DateValidite;
    private String Crypto;
    private String NomUtilisateur;
    
    public CarteBancaire() {
        this.Num_Carte = "";
        this.DateValidite = "";
        this.Crypto = "";
        this.NomUtilisateur = "";
    }

    public CarteBancaire(String Num_Carte, String DateValidite, String Crypto, String NomUtilisateur) {
        this.Num_Carte = Num_Carte;
        this.DateValidite = DateValidite;
        this.Crypto = Crypto;
        this.NomUtilisateur = NomUtilisateur;
    }

    public String getNomUtilisateur() {
        return NomUtilisateur;
    }

    public void setNomUtilisateur(String NomUtilisateur) {
        this.NomUtilisateur = NomUtilisateur;
    }

    public String getDateValidite() {
        return DateValidite;
    }

    public void setDateValidite(String DateValidite) {
        this.DateValidite = DateValidite;
    }

    public String getNum_Carte() {
        return Num_Carte;
    }

    public String getCrypto() {
        return Crypto;
    }
    
    public void setNum_Carte(String Num_Carte) {
        this.Num_Carte = Num_Carte;
    }

    public void setCrypto(String Crypto) {
        this.Crypto = Crypto;
    }

}
