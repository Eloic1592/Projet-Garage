/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import connection.PostgresConnection;

/**
 *
 * @author Mialisoa
 */
public class Vehicule_client extends Model {
    int idvehiculeclient;
    int idclient;
    int idmodele;
    String immatriculation;
    int idvehicule;

    public Vehicule_client(int idvehiculeclient, int idclient, int idmodele, String immatriculation, int idvehicule) {
        this.setIdvehiculeclient(idvehiculeclient);
        this.setIdclient(idclient);
        this.setIdmodele(idmodele);
        this.setImmatriculation(immatriculation);
        this.setIdvehicule(idvehicule);
        this.setNbrField(5);
        
    }

    public Vehicule_client() {
        this.setNbrField(5);
    }

    public int getIdvehiculeclient() {
        return idvehiculeclient;
    }

    public void setIdvehiculeclient(int idvehiculeclient) {
        this.idvehiculeclient = idvehiculeclient;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }
}
