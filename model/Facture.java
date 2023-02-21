/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.text.ParseException;

/**
 *
 * @author Mialisoa
 */
public class Facture extends Model {
    int idfacturemere;
    int idclient;
    String nom;
    String prenom;
    Timestamp dates;

    public Facture(int idfacturemere, int idclient, String nom, String prenom, Timestamp dates) {
        setIdfacturemere(idfacturemere);
        setIdclient(idclient);
        setNom(prenom);
        setPrenom(prenom);
        setDates(dates);
        setNbrField(5);
    }

    public Facture() {
        setNbrField(5);
    }

    public int getIdfacturemere() {
        return idfacturemere;
    }

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
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

    public Timestamp getDates() {
        return dates;
    }

    public void setDates(Timestamp dates) {
        this.dates = dates;
    }

    public void setDates(String jour) throws ParseException, Exception {
        if (jour == null)
            throw new Exception("Le jour est obligatoire");
        else {
            this.setDates(Timestamp.valueOf(jour));
        }
    }

}
