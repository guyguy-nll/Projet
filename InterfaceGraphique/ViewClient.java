/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author titih
 */
public class ViewClient extends javax.swing.JFrame {

    /**
     * Creates new form ViewClient
     */
    public ViewClient() {
        etatbouton1 = 0;
        etatbouton2 = 0;
        etatbouton3 = 0;
        etatbouton4 = 0;
        etatbouton5 = 0;
        etatbouton6 = 0;

    }

    public void init() {
        initComponents();
        //  jTable1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(360, 20));
        setMinimumSize(new java.awt.Dimension(1200, 960));
        setPreferredSize(new java.awt.Dimension(1280, 950));
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fruit2.jpg"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setMaximumSize(new java.awt.Dimension(77, 77));
        jButton1.setMinimumSize(new java.awt.Dimension(77, 77));
        jButton1.setPreferredSize(new java.awt.Dimension(77, 77));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 310, 230, 210);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/viandes.jpg"))); // NOI18N
        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(688, 640, 220, 210);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/legumes.jpg"))); // NOI18N
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(686, 310, 220, 210);
        jButton3.getAccessibleContext().setAccessibleDescription("");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menager.jpg"))); // NOI18N
        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(381, 310, 220, 210);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/patisserie.jpg"))); // NOI18N
        jButton5.setText("jButton2");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(73, 640, 220, 210);

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1170, 800, 90, 20);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/poisson.jpg"))); // NOI18N
        jButton6.setText("jButton2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(380, 640, 220, 210);

        jButton7.setBackground(new java.awt.Color(205, 254, 205));
        jButton7.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jButton7.setText("Payer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(1010, 825, 230, 60);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Vos factures");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(760, 103, 180, 25);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setText("Votre Profil");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(250, 103, 180, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        etatbouton1 = 1;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        etatbouton2 = 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        etatbouton3 = 1;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        etatbouton4 = 1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        etatbouton5 = 1;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        etatbouton6 = 1;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        BoutonPayer = 1;
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        BoutonProfil = 1;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        BoutonFacture = 1;
    }//GEN-LAST:event_jButton8ActionPerformed

    public void PrixTotale(double prix) {
        DecimalFormat df = new DecimalFormat("0.00");
        jLabel2.setText("" + df.format(prix));
    }

    /*public void PLusTableau()
    {
        jTable2.setVisible(false);
    }*/
    public void ajoutImageFond() {

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MenuClient.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1260, 900);
    }


    public void CreerNewJlabel(int coordY, String texte, String prix) { //  on va creer un nouveau label lorsqu'il y a une nouvelle colonne

        javax.swing.JLabel jLabel5 = new JLabel(texte);

        // jLabel5.setText(texte);
        // getContentPane().add(jLabel5);
        jLabel5.setBounds(1000, coordY, 210, 40);
        jLabel5.setVisible(true);
        getContentPane().add(jLabel5);

        javax.swing.JLabel jLabel6 = new JLabel(prix);

        // jLabel5.setText(texte);
        // getContentPane().add(jLabel5);
        jLabel6.setBounds(1210, coordY, 210, 40);
        jLabel6.setVisible(true);
        getContentPane().add(jLabel6);
    }

    /**
     * @param args the command line arguments
     */
    /*public void creer_table_facture() {

        //   JScrollPane scroll;       //jscrollpane pour faire d??filer le tableau
       // this.setTitle("Mon tableau");
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        //scroll = new JScrollPane(jTable1);
        String[] title = {"colonne1", "colonne2", "colonne3"};  //entete du tableau
        Object[][] data = { //donn??es du tableau
            {"ligne1", "encore ligne1", "tjrs ligne1"},
            {"ligne2", "encore ligne2", "tjrs ligne2"}
        };
        jTable1 = new JTable(data, title);   //initialiser le tableau
        // getContentPane().add(jTable1.getTableHeader(), BorderLayout.NORTH);
        //getContentPane().add(jTable1, BorderLayout.CENTER);
        this.getContentPane().add(scroll);
        this.setVisible(true);*/

 /* String[] columns = new String[]{"Nom", "Prenom", "Date"};
    jTable1  = new JTable(data, columns);

    jTable1.setVisible (true);
        // jTable1.setVisible(true);
    }*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewClient.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }
    public JPanel panel;
    public int etatbouton1;
    public int etatbouton2;
    public int etatbouton3;
    public int etatbouton4;
    public int etatbouton5;
    public int etatbouton6;
    public int BoutonFacture = 0;
    public int BoutonPayer = 0;
    public int BoutonProfil = 0;
    public javax.swing.JLabel jLabel1 = new JLabel();
    public javax.swing.JTable jTable1;
    //public javax.swing.JTable jTable1 = new javax.swing.JTable();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
