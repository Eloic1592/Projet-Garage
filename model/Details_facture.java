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
public class Details_facture extends Model {
    int iddetailsfacture;
    int idfacturemere;
    int idtypeservice;
    double prixunitaire;
    double quantite;
    double montant;
    double remise;

    public Details_facture(int iddetailsfacture, int idfacturemere, int idtypeservice, double prixunitaire,
            double quantite, double remise) {
        setIddetailsfacture(iddetailsfacture);
        setIdfacturemere(idfacturemere);
        setIdtypeservice(idtypeservice);
        setPrixunitaire(prixunitaire);
        setQuantite(quantite);
        setRemise(remise);
        setNbrField(7);
    }

    public Details_facture() {
        setNbrField(7);
    }

    public int getIddetailsfacture() {
        return iddetailsfacture;
    }

    public void setIddetailsfacture(int iddetailsfacture) {
        this.iddetailsfacture = iddetailsfacture;
    }

    public int getIdfacturemere() {
        return idfacturemere;
    }

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public void setIdtypeservice(String idtypeservice) {
        this.idtypeservice = Integer.parseInt(idtypeservice);
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public void setPrixunitaire(String prixunitaire) {
        this.prixunitaire = Double.parseDouble(prixunitaire);
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = Double.parseDouble(quantite);
    }

    public double getMontant() {
        return  (getPrixunitaire() - getPrixunitaire()*getRemise())*getQuantite();
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getPrixremise() {
        return this.getPrixunitaire();
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public void setRemise(String remise) {
        double r = Double.parseDouble(remise);
        this.setRemise(r);
    }
}
