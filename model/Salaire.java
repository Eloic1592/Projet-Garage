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
public class Salaire extends Model {
    int idSalaire;
    int idEmploye;
    double salaire;

    public Salaire(int idSalaire, int idEmploye, double salaire) {
        this.setIdSalaire(idSalaire);
        this.setIdEmploye(idEmploye);
        this.setSalaire(salaire);
        this.setNbrField(3);
    }

    public Salaire() {
        this.setNbrField(3);
    }

    public int getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(int idSalaire) {
        this.idSalaire = idSalaire;
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

}
