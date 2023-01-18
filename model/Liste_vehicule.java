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
public class Liste_vehicule extends Model {
    int idclient;
    String nom;
    String prenom;
    String immatriculation;
    String marque;
    String modele;

    public Liste_vehicule() {
        this.setNbrField(6);
    }

    public Liste_vehicule(int idclient, String nom, String prenom, String immatriculation,String marque,
            String modele) {
        this.setIdclient(idclient);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setImmatriculation(immatriculation);
        this.setMarque(marque);
        this.setModele(modele);
        this.setNbrField(6);
    }

    public Vector<Liste_vehicule> vehicule_client(Connection connection, int id) throws ClassNotFoundException, SQLException {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Statement statement = connection.createStatement();
        String req = "select * from liste_vehicule where idclient=" + id;

        ResultSet res = statement.executeQuery(req);
        Vector<Liste_vehicule> vehicules = new Vector<Liste_vehicule>();
        Liste_vehicule tmp;
        while(res.next()) {
            tmp = new Liste_vehicule(res.getInt("idclient"), res.getString("nom"), res.getString("prenom"), res.getString("immatriculation"), res.getString("marque"), res.getString("modele"));
            vehicules.add(tmp);
        }

        if(isOpen) {
            connection.close();
        }

        return vehicules;

    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

}
