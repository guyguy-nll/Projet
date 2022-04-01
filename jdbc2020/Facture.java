/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author titih
 */
public class Facture {
   private String m_date;// = // your ldt
   private String m_refP;
   private String m_username;
//java.sql.Date sqlDate = java.sql.Date.valueOf(dateTime.toLocalDate());

    public Facture() {
        m_date="";
        m_refP="";
        m_username="";
    }

  
    public Facture(String username, String m_refP, String sqlDate) {
        this.m_date = sqlDate;
        this.m_refP = m_refP;
        this.m_username = username;
    }

   
    public String getSqlDate() {
        return m_date;
    }

    public void setSqlDate(String sqlDate) {
        this.m_date = sqlDate;
    }

    public String getM_refP() {
        return m_refP;
    }

    public void setM_refP(String m_refP) {
        this.m_refP = m_refP;
    }

    public String getM_Username() {
        return m_username;
    }

    public void setM_passwordC(String username) {
        this.m_username = username;
    }
   
   
   
}
