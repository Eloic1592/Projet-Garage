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
public class Vente_piece extends Model{
    int modelepiece;
    int quantite;
    int idclient;
    float prix;
    Date date_vente;

    public Vente_piece(int modelepiece, int quantite, int idclient, float prix, Date date_vente) {
        this.modelepiece = modelepiece;
        this.quantite = quantite;
        this.idclient = idclient;
        this.prix = prix;
        this.date_vente = date_vente;
        this.setNbrField(5);
    }

    public Vente_piece() {
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

    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }

    public void setDate_vente(String date_vente) throws Exception {
        if (date_vente == null)
            this.date_vente = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(date_vente);
            Date today = new Date();

            if (today.getYear() - d.getYear() < 18) {
                throw new Exception("Trop jeune pour ce travail");
            }
            this.date_vente = d;
        }
    }
}
