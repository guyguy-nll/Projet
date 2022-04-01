/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterfaceGraphique.ViewModifyProfil;
import java.sql.SQLException;
import jdbc2020.Client;
import jdbc2020.ClientDAO;

/**
 *
 * @author titih
 */
public class ControlModifyProfil {

    private String m_username;

    public ControlModifyProfil(String username) {
        m_username = username;
    }

    public String ControlProfil() throws ClassNotFoundException, SQLException {
        int boucle = 0;
        ViewModifyProfil VProfil = new ViewModifyProfil();
        ClientDAO CDao = new ClientDAO();
        Client c = CDao.find(m_username);
        System.out.println("");
        String[] info = new String[]{c.GetNom(), c.GetPrenom(), c.GetAdresse(), c.GetTelephone(), c.GetUsername(), c.GetPasswrd()};
        VProfil.modifierTextFields(info);

        do {
            VProfil.setVisible(true);
            
            if (c.GetNom() != VProfil.Nom){
                CDao.executeUpdate("UPDATE Client set nom = '" + VProfil.Nom + "' where username ='" + m_username + "';");
                c = CDao.find(m_username);
            }
            if (c.GetPrenom()!= VProfil.Prenom) {
                CDao.executeUpdate("UPDATE Client set prenom = '" + VProfil.Prenom + "' where username ='" + m_username + "';");
                c = CDao.find(m_username);
            }
            if (c.GetAdresse()!= VProfil.adresse) {
                CDao.executeUpdate("UPDATE Client set adresse = '" + VProfil.adresse + "' where username ='" + m_username + "';");
                c = CDao.find(m_username);
            }
            if (c.GetTelephone()!= VProfil.telephone) {
                CDao.executeUpdate("UPDATE Client set telephone = '" + VProfil.telephone + "' where username ='" + m_username + "';");
                c = CDao.find(m_username);
            }
            if (c.GetUsername()!= VProfil.username) {
                CDao.executeUpdate("UPDATE Client set username = '" + VProfil.username + "' where password ='" + c.GetPasswrd() + "';");
                m_username = VProfil.username;
                c = CDao.find(m_username);
            }
            if (c.GetPasswrd()!= VProfil.password) {
                CDao.executeUpdate("UPDATE Client set password = '" + VProfil.password + "' where username ='" + m_username + "';");
                c = CDao.find(m_username);
            }
            if(VProfil.BoutonRetour ==1)
            {
                boucle = 1;
                VProfil.setVisible(false);
            }

        } while (boucle == 0);
        return m_username;
    }
}
