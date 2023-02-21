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
public class Service extends Model {
    int idtypeservice;
    String type_service;
    double montant_produit;
    double montant_service;
    double marge_beneficiaire;
    

    public Service(int idtypeservice, String type_service, double montant_produit, double montant_service,
            double marge_beneficiaire) {
        setIdtypeservice(idtypeservice);
        setType_service(type_service);
        setMontant_produit(montant_produit);
        setMontant_service(montant_service);
        setMarge_beneficiaire(marge_beneficiaire);
        setNbrField(5);
    }

    public Service() {
        setNbrField(5);
    }
    
    public double getPrixDeVente() {
        return (getMontant_produit()+getMontant_service())+(getMontant_produit()+getMontant_service())*getMarge_beneficiaire();
    }

    public double getBenefice() {
        return (this.getMontant_produit() + this.getMontant_service())*this.getMarge_beneficiaire();
    }

    public double getPrixDeReviens() {
        return this.getMontant_produit() + this.getMontant_service();
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

    public double getMontant_produit() {
        return montant_produit;
    }

    public void setMontant_produit(double montant_produit) {
        this.montant_produit = montant_produit;
    }

    public double getMontant_service() {
        return montant_service;
    }

    public void setMontant_service(double montant_service) {
        this.montant_service = montant_service;
    }

    public double getMarge_beneficiaire() {
        return marge_beneficiaire;
    }

    public void setMarge_beneficiaire(double marge_beneficiaire) {
        this.marge_beneficiaire = marge_beneficiaire;
    }

}
