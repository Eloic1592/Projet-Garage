/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import exceptions.AgeException;

/**
 *
 * @author Mialisoa
 */
public class Depense extends Model {
    int iddepense;
    int idtypedepense;
    float prix;
    Date date;
    
    public Depense(int iddepense, int idtypedepense, float prix, String date) throws ParseException {
        this.setIddepense(iddepense);
        this.setIdtypedepense(idtypedepense);
        this.setPrix(prix);
        this.setdate(date);
        this.setNbrField(4);
    }

    public Depense(int iddepense, int idtypedepense, float prix, Date date) {
        this.setIddepense(iddepense);
        this.setIdtypedepense(idtypedepense);
        this.setPrix(prix);
        this.setDate(date);
        this.setNbrField(4);
    }

    public Depense() {
        this.setNbrField(4);
    }

    public int getIddepense() {
        return iddepense;
    }

    public void setIddepense(int iddepense) {
        this.iddepense = iddepense;
    }

    public int getIdtypedepense() {
        return idtypedepense;
    }

    public void setIdtypedepense(int idtypedepense) {
        this.idtypedepense = idtypedepense;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setdate(String date) throws ParseException{
        if(date == null)
               this.date = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.date = dateFormat.parse(date);
        }
    }
}
