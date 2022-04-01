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
public class ProduitDAO extends DAO<Produit> {

    public ProduitDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    // on crée un nouveau client dans la base de donnée
    @Override
    public void create(Produit obj) {
        try {
            String request = "INSERT INTO Produit VALUES ('" + obj.GetRef() + "','" + obj.GetNom() + "', '" + obj.GetType() + "', '" + obj.GetPrix() + "', '" + obj.GetPromotion() + "', '" + obj.GetPeremption() + "', '" + obj.getM_prix_promo() + "', '" + obj.GetStock() + "');";
            executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Exception Produit create : " + e.getMessage());
        }
    }

    @Override
    public void delete(Produit obj) { // on supprime un client dans la base de donnée
        try {
            executeUpdate("DELETE FROM Produit WHERE reference =" + obj.GetRef());
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Produit find(String reference) { // on cherche un client en particulier dans la base de donnée à partir de son username
        Produit obj = new Produit();
        try {
            ResultSet res = connect.createStatement().executeQuery("SELECT * FROM Produit WHERE reference=" + reference);
            while (res.next()) {
                if (reference.equals(res.getString("reference"))) // si un username est égale à celui passé en paramètre
                {
                    obj = new Produit(res.getString("reference"), res.getString("nom"), res.getString("type"), Double.parseDouble(res.getString("prix")), Double.parseDouble(res.getString("promotion")), res.getString("peremption"), Double.parseDouble(res.getString("prixpromotion")), Integer.parseInt(res.getString("stock")));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception Produit find : " + e.getMessage());
        }
        return obj;
    }

    //récupère dans une liste l'ensemble des produits de la BDD
    public ArrayList<Produit> GetProduits(String requete) {
        ArrayList<Produit> list_Produits = new ArrayList<>();
        Produit obj = new Produit();
        try {
            ResultSet res = executeQuery(requete);
            while (res.next()) {
                obj = new Produit(res.getString("reference"), res.getString("nom"), res.getString("type"), Double.parseDouble(res.getString("prix")), Double.parseDouble(res.getString("promotion")), res.getString("peremption"),Double.parseDouble(res.getString("prixpromotion")), Integer.parseInt(res.getString("stock")));
                list_Produits.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception produit GetProduits: " + e.getMessage());
        }
        return list_Produits;
    }

}
