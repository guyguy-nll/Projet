/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author titih
 */
public class ClientDAO extends DAO<Client> {

    public ClientDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void create(Client obj) { // on crée un nouveau client dans la base de donnée
        try {
            String request = "INSERT INTO Client VALUES ('" + obj.GetPasswrd() + "','" + obj.GetUsername() + "', '" + obj.GetNom() + "', '" + obj.GetPrenom() + "', '" + obj.GetAdresse() + "', '" + obj.GetTelephone() + "');";
            executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Exception Client create : " + e.getMessage());
        }
    }

    @Override
    public void delete(Client obj) { // on supprime un client dans la base de donnée
        try {
            executeUpdate("DELETE FROM client WHERE username=" + obj.GetUsername());
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Client find(String username) { // on cherche un client en particulier dans la base de donnée à partir de son username
        Client obj = new Client();
        try {
            ResultSet res = connect.createStatement().executeQuery("SELECT * FROM client WHERE username='" + username + "';");//'" + username + "';");
           // System.out.println("passeeeee");
            //if(res.next()){System.out.println(res.getString("username"));
            while (res.next()) {
             //   System.out.println(res.getString("username"));
                if (username.equals(res.getString("username"))) // si un username est égale à celui passé en paramètre
                {
                    obj = new Client(res.getString("password"), res.getString("username"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("telephone"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Exception Client find : " + e.getMessage());
        }
        return obj;
    }

    public ArrayList<Client> GetClients() {
        ArrayList<Client> list_Clients = new ArrayList<>();
        Client obj = new Client();
        try {
            ResultSet res = executeQuery("SELECT * FROM client");
            while (res.next()) {
                obj = new Client(res.getString("password"), res.getString("username"), res.getString("nom"), res.getString("prenom"), res.getString("adresse"), res.getString("telephone"));
                list_Clients.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Exception Client getClient : " + e.getMessage());
        }
        return list_Clients;
    }
}
