/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.PostgresConnection;

/**
 *
 * @author Mialisoa
 */
public class Service_client extends Model{
    int idserviceclient;
    int idclient;
    int idtypeservice;
    int quantite;
    Timestamp dateservice;
    

    public Service_client(int idserviceclient, int idclient, int idtypeservice, int quantite, Timestamp date) {
        this.setIdserviceclient(idserviceclient);
        this.setIdclient(idclient);
        this.setIdtypeservice(idtypeservice);
        setQuantite(idtypeservice);
        setDateservice(date);
        this.setNbrField(5);
    }

    public Service_client(int idserviceclient, int idclient, int idtypeservice, int quantite, String date) throws ParseException, Exception {
        this.setIdserviceclient(idserviceclient);
        this.setIdclient(idclient);
        this.setIdtypeservice(idtypeservice);
        setQuantite(idtypeservice);
        setDateservice(date);
        this.setNbrField(5);
    }

    public Service_client() {
        this.setNbrField(5);
    }

    // public int insertReturningId(Connection connection) throws ClassNotFoundException, SQLException {
    //     boolean isOpen = false;
    //     if (connection == null) {
    //         connection = PostgresConnection.getConnection();
    //         isOpen = true;
    //     }

    //     // Statement statement = connection.createStatement();
    //     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    //     String req = "insert into service_client values(default, " + this.getIdvehiculeclient() + ", "+  this.getIdclient() + ", " + this.getIdtypeservice() + ", '" + this.getLibelle() + "', '" + format.format(this.getDateservice()) + "') returning idtypeservice";
    //     Statement statement = connection.createStatement();
    //     ResultSet res = statement.executeQuery(req);
    //     connection.commit();

    //     int id = 0;
    //     if(res.next()) {
    //         id = res.getInt(1);
    //     }
        
    //     return id;
    // }

   

    public int getIdserviceclient() {
        return idserviceclient;
    }

    public void setIdserviceclient(int idserviceclient) {
        this.idserviceclient = idserviceclient;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }
    
    public Date getDateservice() {
        return dateservice;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateservice(Timestamp dateservice) {
        this.dateservice = dateservice;
    }

    public void setDateservice(String jour) throws ParseException, Exception {
        if (jour == null)
            throw new Exception("Le jour est obligatoire");
        else {
            this.setDateservice(Timestamp.valueOf(jour));
        }
    }
}
