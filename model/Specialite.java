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
public class Specialite extends Model {
    int idspecialite;
    String nomSpecialite;
    double salaire_par_heure;
    

    public Specialite() {   
        this.setNbrField(3);
    }

    public Specialite(int idspecialite, String nomSpecialite, double salaire_par_heure) {
        setIdspecialite(idspecialite);
        setNomSpecialite(nomSpecialite);
        this.setSalaire_par_heure(salaire_par_heure);
        this.setNbrField(3);
    }
    
    public int getIdspecialite() {
        return idspecialite;
    }

    public void setIdspecialite(int idspecialite) {
        this.idspecialite = idspecialite;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }

    public double getSalaire_par_heure() {
        return salaire_par_heure;
    }

    public void setSalaire_par_heure(double salaire_par_heure) {
        this.salaire_par_heure = salaire_par_heure;
    }
    
    
}
