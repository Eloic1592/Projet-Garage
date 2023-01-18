/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mialisoa
 */
public class Service_client extends Model{
    int idserviceclient;
    int idvehiculeclient;
    int idclient;
    int idtypeservice;
    String libelle;
    Date dateservice;

    public Service_client(int idserviceclient, int idvehiculeclient, int idclient, int idtypeservice, String libelle) {
        this.setIdserviceclient(idserviceclient);
        this.setIdvehiculeclient(idvehiculeclient);
        this.setIdclient(idclient);
        this.setIdtypeservice(idtypeservice);
        this.setLibelle(libelle);
        this.setNbrField(6);
    }

    public Service_client(int idserviceclient, int idvehiculeclient, int idclient, int idtypeservice, String libelle,Date dateservice) {
        this.setIdserviceclient(idserviceclient);
        this.setIdvehiculeclient(idvehiculeclient);
        this.setIdclient(idclient);
        this.setIdtypeservice(idtypeservice);
        this.setLibelle(libelle);
        setDateservice(dateservice);
        this.setNbrField(6);
    }

    public Service_client() {
        this.setNbrField(6);
    }

    public int getIdserviceclient() {
        return idserviceclient;
    }

    public void setIdserviceclient(int idserviceclient) {
        this.idserviceclient = idserviceclient;
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

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public Date getDateservice() {
        return dateservice;
    }

    public void setDateservice(Date dateservice) {
        this.dateservice = dateservice;
    }

    public void setDateservice(String dateservice) throws Exception {
        if (dateservice == null)
            this.dateservice = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(dateservice);
            Date today = new Date();

            if (today.getYear() - d.getYear() < 18) {
                throw new Exception("Trop jeune pour ce travail");
            }
            this.dateservice = d;
        }

    }
}
