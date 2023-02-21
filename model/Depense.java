/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

import connection.PostgresConnection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Mialisoa
 */
public class Depense extends Model {
    int iddepense;
    int idtypedepense;
    String designation;
    float prix;
    Date date;
    
    public Depense(int iddepense, float prix, String date) throws Exception {
        this.setIddepense(iddepense);
        this.setPrix(prix);
        this.setDate(date);
        this.setNbrField(5);
    }

    public Depense(int iddepense, float prix, Date date) throws Exception {
        this.setIddepense(iddepense);
        this.setPrix(prix);
        this.setDate(date);
        this.setNbrField(5);
    }

    public Depense() {
        this.setNbrField(5);
    }

    public static float somme(Connection connection, Date date) throws SQLException, ClassNotFoundException {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d = dateFormat.format(date) ;
        
        String req = "select sum(prix) from depense where date = '" + d + "'";
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
    }

   

    public int getIddepense() {
        return iddepense;
    }
    

    public void setIddepense(int iddepense) {
        this.iddepense = iddepense;
    }

    public void setIddepense(String iddepense) {
        int id = Integer.parseInt(iddepense);
        setIddepense(id);
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) throws Exception {
        if(prix <= 0) {
            throw new Exception("Prix doit être positif");
        }
        this.prix = prix;
    }

    public void setPrix(String prix) throws Exception {
        float p = Float.parseFloat(prix);
        this.setPrix(p);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) throws ParseException{
        if(date == null)
               this.date = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.date = dateFormat.parse(date);
        }
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getIdtypedepense() {
        return idtypedepense;
    }

    public void setIdtypedepense(int idtypedepense) {
        this.idtypedepense = idtypedepense;
    }

    public void setIdtypedepense(String idtypedepense) {
        int id = Integer.parseInt(idtypedepense);
        setIdtypedepense(id);
    }

    
}
