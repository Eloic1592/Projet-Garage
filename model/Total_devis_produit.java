/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Mialisoa
 */
public class Total_devis_produit extends Model {

    int idtypeservice;
    double sum;

    public Total_devis_produit(int idtypeservice, double sum) {
        setIdtypeservice(idtypeservice);
        setSum(sum);
        setNbrField(2);
    }

    public Total_devis_produit() {
        setNbrField(2);
    }

    public double total(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        Total_devis_produit totalProduits = new Total_devis_produit();
        totalProduits.setIdtypeservice(this.getIdtypeservice());
        String[] colonnes = new String[1];
        colonnes[0] = "idtypeservice";

        Vector<Total_devis_produit> sommeProduit = totalProduits.getBy(connection, colonnes);
        double total = 0;
        for (Total_devis_produit p : sommeProduit) {
            total += p.getSum();
        }

        return total;
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}
