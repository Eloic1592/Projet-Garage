/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mialisoa
 */
public class Service_produit extends Model {
    int idtypeservice;
    int idProduit;
    float quantite;

    public Service_produit(int idtypeservice, int idProduit, float quantite) {
        setIdtypeservice(idtypeservice);
        setIdProduit(idProduit);
        setQuantite(quantite);
        this.setNbrField(3);
    }

    public Service_produit() {
        this.setNbrField(3);
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

}
