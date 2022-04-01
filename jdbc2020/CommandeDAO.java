/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author titih
 */
public class CommandeDAO extends DAO<Commande>{

    public CommandeDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void create(Commande obj) { // on crée un nouveau commande dans la base de donnée
        try {
            String request = "INSERT INTO commande values ('" + obj.GetUsername()+ "','" + obj.GetRefP() + "');";
            executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Exception commande create : " + e.getMessage());
        }
    }

    @Override
    public void delete(Commande obj) { // on supprime un produit de la commande de la base de donnée
        try {
            executeUpdate("DELETE FROM Commande WHERE referenceP=" + obj.GetRefP());
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Commande find(String passwordC) { // on cherche un client en particulier dans la base de donnée à partir de son username
        Commande obj = new Commande();
        try {
            ResultSet res = connect.createStatement().executeQuery("SELECT * FROM commande WHERE usernameclient='" + passwordC + "';");
            while (res.next()) {
                if (passwordC.equals(res.getString("usernameclient"))) // si un username est égale à celui passé en paramètre
                {
                    obj = new Commande(res.getString("usernameclient"), res.getString("referenceP"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception Commande find : " + e.getMessage());
        }
        return obj;
    }

    public ArrayList<Commande> GetCommandes() {
        ArrayList<Commande> list_Commandes= new ArrayList<>();
        Commande obj = new Commande();
        try {
            ResultSet res = executeQuery("SELECT * FROM commande");
            while (res.next()) {
                obj = new Commande(res.getString("referenceP"), res.getString("usernameclient"));
                list_Commandes.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception Commande getCommande : " + e.getMessage());
        }
        return list_Commandes;
    }
    
    //retourne tous les produits qui sont actuellement dans le panier du client avec le mot de passe passé en paramètre
    public ArrayList<Commande> GetCommandes(String username) {
        ArrayList<Commande> list_Commandes= new ArrayList<>();
        Commande obj = new Commande();
        try {
            ResultSet res = executeQuery("SELECT * FROM commande WHERE usernameclient='" + username + "';");
            while (res.next()) {
                obj = new Commande(res.getString("usernameclient"), res.getString("referenceP"));
                list_Commandes.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception Commande getCommande : " + e.getMessage());
        }
        return list_Commandes;
    }

}
