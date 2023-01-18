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
public class Achat_piece extends Model{
    int modelepiece;
    int quantite;
    int idclient;
    float prix;
    Date date_achat;

    public Achat_piece(int modelepiece, int quantite, int idclient, float prix, Date date_achat) {
        this.modelepiece = modelepiece;
        this.quantite = quantite;
        this.idclient = idclient;
        this.prix = prix;
        this.date_achat = date_achat;
        this.setNbrField(5);
    }

    public Achat_piece() {
        this.setNbrField(5);
    }

    public int getModelepiece() {
        return modelepiece;
    }

    public void setModelepiece(int modelepiece) {
        this.modelepiece = modelepiece;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    public void setDate_achat(String date_achat) throws Exception {
        if (date_achat == null)
            this.date_achat = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(date_achat);
            Date today = new Date();

            if (today.getYear() - d.getYear() < 18) {
                throw new Exception("Trop jeune pour ce travail");
            }
            this.date_achat = d;
        }
    }
}
