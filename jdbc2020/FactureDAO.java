/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author titih
 */
public class FactureDAO extends DAO<Facture> {

    public FactureDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void create(Facture obj) { // on crée un nouveau client dans la base de donnée
        try {
            String request = "INSERT INTO facture VALUES ('" + obj.getM_Username()+ "','" + obj.getM_refP() + "', '" + obj.getSqlDate() + "');";
            executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Exception Facture create : " + e.getMessage());
        }
    }

    @Override
    public void delete(Facture obj) { // on supprime un client dans la base de donnée
        try {
            executeUpdate("DELETE FROM facture WHERE usernameclient=" + obj.getM_Username());
        } catch (SQLException ex) {
            Logger.getLogger(FactureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Facture find(String username) { // on cherche un client en particulier dans la base de donnée à partir de son username
        Facture obj = new Facture();
        try {
            ResultSet res = connect.createStatement().executeQuery("SELECT * FROM facture WHERE usernameclient='" + username + "';");//'" + username + "';");
            while (res.next()) {
                System.out.println(res.getString("usernameclient"));
                if (username.equals(res.getString("usernameclient"))) // si un username est égale à celui passé en paramètre
                {
                    obj = new Facture(res.getString("usernameclient"), res.getString("refproduit"), res.getString("date"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception facture find : " + e.getMessage());
        }
        return obj;
    }

    public ArrayList<Facture> GetFacture() {
        ArrayList<Facture> list_facture = new ArrayList<>();
        Facture obj = new Facture();
        try {
            ResultSet res = executeQuery("SELECT * FROM facture");
            while (res.next()) {
                obj = new Facture(res.getString("usernameclient"), res.getString("refproduit"), res.getString("date"));
                list_facture.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception Facture fromgetFacture : " + e.getMessage());
        }
        return list_facture;
    }
}
