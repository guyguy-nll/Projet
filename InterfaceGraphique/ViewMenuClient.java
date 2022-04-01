/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGraphique;

import java.util.ArrayList;
import jdbc2020.Produit;

/**
 *
 * @author titih
 */
// on doit pouvoir visualiser les types d'aliments(légumes, viande, patisserie, poisson, Fruit), un logo d'un cadi pour que le client accède à sa commande et un logo pour consulter son profil
public class ViewMenuClient {

    public void InterfaceMenuClient() {
        System.out.println("                                       OnlineMarket                                                        ");
        System.out.println("\nProfile :(1)                                                                                Vos Commandes(2)");
        System.out.println("\nFruit(3)         Legumes(4)          Patisserie(5)             Viandes(6)        Poisson(7) \n        Deconnexion (8)");
        System.out.println("\nVotre choix : ");
    }

}

/*public void InterfaceMenuClient(ArrayList<Produit> listProduit) {
        for (int i = 0; i < listProduit.size(); i++) {
            if (listProduit.get(i).GetStock()>0)
            {
                //System.out.println(listProduit.get(i).GetType()+" : " + );
            }
        }
    }
*/
