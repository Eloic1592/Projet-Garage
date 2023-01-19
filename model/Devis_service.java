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
public class Devis_service extends Model {
    int idtypeservice;
    String type_service;
    String nomspecialite;
    double dureetravail;
    double salaire_par_heure;
    double prix_salariale;
    double marge_beneficiaire;
    

    public Devis_service(int idtypeservice, String type_service, String nomspecialite,
            double dureetravail, double salaire_par_heure, double prix_salariale) {

        setIdtypeservice(idtypeservice);
        setType_service(type_service);
        setNomspecialite(nomspecialite);
        setDureetravail(dureetravail);
        setSalaire_par_heure(salaire_par_heure);
        setPrix_salariale(prix_salariale);
        setMarge_beneficiaire(prix_salariale);
        setNbrField(7);
    }

    public Devis_service() {
        setNbrField(7);
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

    public String getNomspecialite() {
        return nomspecialite;
    }

    public void setNomspecialite(String nomspecialite) {
        this.nomspecialite = nomspecialite;
    }

    public double getDureetravail() {
        return dureetravail;
    }

    public void setDureetravail(double dureetravail) {
        this.dureetravail = dureetravail;
    }

    public double getSalaire_par_heure() {
        return salaire_par_heure;
    }

    public void setSalaire_par_heure(double salaire_par_heure) {
        this.salaire_par_heure = salaire_par_heure;
    }

    public double getPrix_salariale() {
        return prix_salariale;
    }

    public void setPrix_salariale(double prix_salariale) {
        this.prix_salariale = prix_salariale;
    }

    public double getMarge_beneficiaire() {
        return marge_beneficiaire;
    }

    public void setMarge_beneficiaire(double marge_beneficiaire) {
        this.marge_beneficiaire = marge_beneficiaire;
    }

}
