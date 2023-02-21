/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Mialisoa
 */
public class Details_facture_client extends Model {
    int idfacturemere;
    int idclient;
    String nom;
    String prenom;
    int idtypeservice;
    String type_service;
    double montant;
    double prixunitaire;
    double quantite;
    double remise;
    double prixremise;
    
    
    public Details_facture_client(int idfacturemere, int idclient, String nom, String prenom, int idtypeservice,
            String type_service, double prixunitaire, double quantite, double remise) {
        setIdfacturemere(idfacturemere);
        setIdclient(idclient);
        setNom(nom);
        setPrenom(prenom);
        setIdtypeservice(idtypeservice);
        setType_service(type_service);
        setPrixunitaire(prixunitaire);
        setQuantite(quantite);
        setRemise(remise);
        setNbrField(10);
    }

    public Details_facture_client() {
        setNbrField(10);
    }

    public static double getTotal(Vector<Details_facture_client> factures) throws ClassNotFoundException, SQLException, Exception {
        double total = 0;
        int idFactureMere = 0;
        for (Details_facture_client facture : factures) {
            total += facture.getMontant();
            idFactureMere = facture.getIdfacturemere();
        } 

        Facture_mere f = new Facture_mere();
        f.setIdfacturemere(idFactureMere);
        String[] params = new String[1];
        params[0] = "idfacturemere";

        Facture_mere factureMere = ((Facture_mere)f.getBy(null, params).get(0));

        return total - (total*factureMere.getRemise());
    }

    public String parseRemise() {
        return this.getRemise()*100 + "%";
    }

    public int getIdfacturemere() {
        return idfacturemere;
    }

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
    }

    public void setIdfacturemere(String idfacturemere) {
        this.idfacturemere = Integer.parseInt(idfacturemere);
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public double getMontant() {
        return getPrixremise() * getQuantite();
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public double getPrixremise() {
        return this.getPrixunitaire() - this.getPrixunitaire()*this.getRemise();
    }

    public void setPrixremise(double prixremise) {
        this.prixremise = prixremise;
    }

}
