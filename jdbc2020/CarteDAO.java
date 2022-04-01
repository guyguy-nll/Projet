/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author titih
 */
public class CarteDAO extends DAO<CarteBancaire> {

    public CarteDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void create(CarteBancaire obj) { // on crée un nouveau client dans la base de donnée
        try {
            String request = "INSERT INTO cbancaire VALUES ('" + obj.getNum_Carte() + "','" + obj.getDateValidite() + "', '" + obj.getCrypto() + "', '" + obj.getNomUtilisateur() + "');";
            executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Exception CarteBancaire create : " + e.getMessage());
        }
    }

    @Override
    public void delete(CarteBancaire obj) { // on supprime un client dans la base de donnée
        try {
            executeUpdate("DELETE FROM cbancaire WHERE NumCarte=" + obj.getNum_Carte());
        } catch (SQLException ex) {
            //Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CarteBancaire find(String Num_Carte) { // on cherche un client en particulier dans la base de donnée à partir de son username
        CarteBancaire obj = new CarteBancaire();
        try {
            ResultSet res = connect.createStatement().executeQuery("SELECT * FROM cbancaire WHERE NumCarte='" + Num_Carte + "';");//'" + username + "';");
            System.out.println("passeeeee");
            //if(res.next()){System.out.println(res.getString("username"));
            while (res.next()) {
                System.out.println(res.getString("NumCarte"));
                if (Num_Carte.equals(res.getString("NumCarte"))) // si un username est égale à celui passé en paramètre
                {
                    obj = new CarteBancaire(res.getString("NumCarte"), res.getString("datefinvalide"), res.getString("Cryptogramme"), res.getString("NomProprio"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception CarteBancaire find : " + e.getMessage());
        }
        return obj;
    }

    public ArrayList<CarteBancaire> GetCarteB() {
        ArrayList<CarteBancaire> list_CB = new ArrayList<>();
        CarteBancaire obj = new CarteBancaire();
        try {
            ResultSet res = executeQuery("SELECT * FROM cbancaire");
            while (res.next()) {
                obj = new CarteBancaire(res.getString("NumCarte"), res.getString("datefinvalide"), res.getString("Cryptogramme"), res.getString("NomProprio"));
                list_CB.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception CarteBancaire getCarteBancaire : " + e.getMessage());
        }
        return list_CB;
    }
}
