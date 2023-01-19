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
public class Devis_produit extends Model {
    int idproduit;
    String nomproduit;
    double prix;
    double quantite;
    int idtypeservice;
    String type_service;
    double prix_total_produit;

    public Devis_produit(int idproduit, String nomproduit, double prix, double quantite, int idtypeservice,
            String type_service, double prix_total_produit) {
        setIdproduit(idproduit);
        setNomproduit(nomproduit);
        setPrix(prix_total_produit);
        setQuantite(quantite);
        setIdtypeservice(idtypeservice);
        setType_service(type_service);
        setPrix_total_produit(prix_total_produit);
        setNbrField(7);
    }

    public Devis_produit() {
        setNbrField(7);
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }

    public double getPrix_total_produit() {
        return prix_total_produit;
    }

    public void setPrix_total_produit(double prix_total_produit) {
        this.prix_total_produit = prix_total_produit;
    }

}
