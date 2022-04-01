/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.SQLException;

/**
 *
 * @author titih
 */
public class Client {

    private String m_passrwd;
    private String m_username;
    private String m_prenom;
    private String m_nom;
    private String m_adresse;
    private String m_telephone;
   // private Commande m_commande = new Commande();

    Client() {
        m_passrwd = "";
        m_username = "";
        m_prenom = "";
        m_nom = "";
        m_adresse = "";
        m_telephone = "";
    }

    public Client(String passwrd, String username, String nom, String prenom, String adresse, String telephone) {
        m_passrwd = passwrd;
        m_username = username;
        m_prenom = prenom;
        m_nom = nom;
        m_adresse = adresse;
        m_telephone = telephone;
    }

    // GETTER
    public String GetPasswrd() {
        return this.m_passrwd;
    }

    public String GetUsername() {
        return this.m_username;
    }

    public String GetPrenom() {
        return this.m_prenom;
    }

    public String GetNom() {
        return this.m_nom;
    }

    public String GetAdresse() {
        return this.m_adresse;
    }

    public String GetTelephone() {
        return this.m_telephone;
    }
    
    //SETTER
    
    public void SetPasswrd(String passwrd)
    {
        m_passrwd = passwrd;
    }
    
    public void SetUsername(String username)
    {
        m_username = username;
    }
    
    public void SetNom(String nom)
    {
        m_nom = nom;
    }
    
    public void Setprenom(String prenom)
    {
        m_prenom = prenom;
    }
    
    public void SetAdresse(String adresse)
    {
        m_adresse = adresse;
    }
    
    public void SetTelephone(String telephone)
    {
        m_telephone = telephone;
    }

}
