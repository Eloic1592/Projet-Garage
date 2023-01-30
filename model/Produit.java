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
public class Produit extends Model {
    int idProduit;
    String nomproduit;
    float prix;

    public Produit(int idProduit, String nomproduit, float prix) {
        setIdProduit(idProduit);
        setNomproduit(nomproduit);
        setPrix(prix);
        this.setNbrField(3);
    }

    public double getPrixConseille(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        String[] params = new String[1];
        params[0] = "idProduit";
        Produit produit = ((Produit)this.getBy(connection, params).get(0));

        double prixAchat = produit.getPrix();
        double marge = 0;
        // if(prixAchat > 0 && prixAchat <=1000) {
        //     marge = (double)50/100;
        // }
        // else if(prixAchat <= 5000) 
        //     marge = (double)30/100;
        // else if (prixAchat <= 10000) 
        //     marge = (double)10/100;
        // else 
        //     marge = (double)2/100;
        
        
        Vector<Pourcentage> pourcentages = new Pourcentage().getAll(connection);
        for (Pourcentage pourcentage : pourcentages) {
            if(prixAchat >= pourcentage.getPrixmin() && prixAchat < pourcentage.getPrixmax())
            marge = pourcentage.getPourcentage();
        }
        
        double benefice = prixAchat*marge;
        return benefice+prixAchat;
    }

    public double getMargeBeneficiaire(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        String[] params = new String[1];
        params[0] = "idProduit";
        Produit produit = ((Produit)this.getBy(connection, params).get(0));

        double prixAchat = produit.getPrix();
        double marge = 0;

        Vector<Pourcentage> pourcentages = new Pourcentage().getAll(connection);
        for (Pourcentage pourcentage : pourcentages) {
            if(prixAchat >= pourcentage.getPrixmin() && prixAchat < pourcentage.getPrixmax())
            marge = pourcentage.getPourcentage();
        }
        
        return marge*100;
    }

    public Produit() {
        this.setNbrField(3);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

}
