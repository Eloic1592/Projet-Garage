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
public class Demandedevis extends Model {
    int iddevis;
    int idclient;
    int idtypeservice;
    Date datedevis;

    public Demandedevis(int iddevis, int idclient, int idtypeservice, Date datedevis) {
        this.setIddevis(iddevis);
        setIdclient(idclient);
        setIdtypeservice(idtypeservice);
        setDatedevis(datedevis);
        this.setNbrField(4);
    }

    public Demandedevis() {
        this.setNbrField(4);
    }

    public void setDatedevis(String datedevis) throws Exception {
        if (datedevis == null)
            this.datedevis = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(datedevis);
            Date today = new Date();

            if (today.getYear() - d.getYear() < 18) {
                throw new Exception("Trop jeune pour ce travail");
            }
            this.datedevis = d;
        }
    }

    public int getIddevis() {
        return iddevis;
    }

    public void setIddevis(int iddevis) {
        this.iddevis = iddevis;
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

    public Date getDatedevis() {
        return datedevis;
    }

    public void setDatedevis(Date datedevis) {
        this.datedevis = datedevis;
    }
}
