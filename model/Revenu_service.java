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
public class Revenu_service extends Model {
    int idtypeservice;
    String type_service;
    double total_salaire;
    double total_produit;
    double marge;

    public Revenu_service(int idtypeservice, String type_service, double total_salaire, double total_produit) {
        setIdtypeservice(idtypeservice);
        setType_service(type_service);
        setTotal_salaire(total_salaire);
        setTotal_produit(total_produit);
        setMarge();
        setNbrField(4);
    }

    public Revenu_service() {
        setNbrField(4);
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

    public double getTotal_salaire() {
        return total_salaire;
    }

    public void setTotal_salaire(double total_salaire) {
        this.total_salaire = total_salaire;
    }

    public double getTotal_produit() {
        return total_produit;
    }

    public void setTotal_produit(double total_produit) {
        this.total_produit = total_produit;
    }

    public double getMarge() {
        return marge;
    }

    public void setMarge() {
        this.marge =  (this.getTotal_produit() + this.getTotal_salaire())*0.2;
    }


}
