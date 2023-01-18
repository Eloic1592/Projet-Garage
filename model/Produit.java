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
public class Produit extends Model {
    int idProduit;
    String nomproduit;
    float prix;

    public Produit(int idProduit, String nomproduit, float prix) {
        setIdProduit(idProduit);
        setNomproduit(nomproduit);
        setPrix(prix);
        this.setNbrField(3);
    }

    public Produit() {
        this.setNbrField(3);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

}
