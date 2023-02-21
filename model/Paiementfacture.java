/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.PostgresConnection;

/**
 *
 * @author Mialisoa
 */
public class Paiementfacture extends Model {
    int idfacturemere;
    int idclient;
    double montant;
    Date datepaiement;
    
    
    public Paiementfacture(int idfacturemere, int idclient, double montant, String date) throws ParseException, Exception {
        setIdfacturemere(idfacturemere);
        setIdclient(idclient);
        setMontant(montant);
        setDatepaiement(date);
        setNbrField(4);
    }


    public Paiementfacture(String idfacturemere, String idclient, String montant, String date) throws ParseException, Exception {
        setIdfacturemere(idfacturemere);
        setIdclient(idclient);
        setMontant(montant);
        setDatepaiement(date);
        setNbrField(4);
    }

    public Paiementfacture() {
        setNbrField(4);
    }

    public static float somme(Connection connection, Date date) throws SQLException, ClassNotFoundException {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d = dateFormat.format(date) ;

        String req = "select sum(montant) from paiementfacture where datepaiement = '" + d + "'";
        System.out.println(req);
        java.sql.Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(req);

        float somme = 0;
        if(res.next()) {
            somme = res.getFloat(1);
        }

        if(isOpen == true) {
            connection.close();
        }

        return somme;
        // return 0;
    }

    public void setDatepaiement(String datepaiement) throws ParseException, Exception{
        if(datepaiement == null)
               this.datepaiement = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(datepaiement);
            this.setDatepaiement(d);
        }
    }

    public int getIdfacturemere() {
        return idfacturemere;
    }

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
    }

    public void setIdfacturemere(String idfacturemere) {
        this.idfacturemere = Integer.parseInt(idfacturemere);
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = Integer.parseInt(idclient);
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setMontant(String montant) {
        this.montant = Double.parseDouble(montant);
    }

    public Date getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(Date datepaiement) {
        this.datepaiement = datepaiement;
    }

}
