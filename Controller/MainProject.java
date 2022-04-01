/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.ViewDeConnexion;
import java.sql.SQLException;

/**
 *
 * @author titih
 */
public class MainProject {

    public static void main(String[] s) throws ClassNotFoundException, SQLException {
        Control_Identification control = new Control_Identification();
        control.connexion();
    }
}
