/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc2020;

/**
 *
 * @author titih
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset;

public class CamembertStat extends JFrame {

    private JPanel pnl;
    private String[] m_nom;
    private double[] m_nombre;

    public CamembertStat(String[] nom, double[] nombre) {
        m_nom = nom;
        m_nombre = nombre;               
    }

    public void AfficherCamembert() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        pnl = new JPanel(new BorderLayout());
        setContentPane(pnl);
        setSize(600, 500);
        setLocation(1260, 500);

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 0; i < m_nom.length; i++) {
            pieDataset.setValue(m_nom[i], m_nombre[i]);
        }

        JFreeChart pieChart = ChartFactory.createPieChart("Proportion de prix entre les produits vendus",
                pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);
        pnl.add(cPanel);
    }

    /*public static void main(String args[]) {
        CamembertStat tpc = new CamembertStat();
        tpc.setVisible(true);
    }*/
}
