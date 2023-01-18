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
public class Service_specialite extends Model {
    int idtypeservice;
    int idspecialite;
    double dureetravail;

    public Service_specialite(int idtypeservice, int idspecialite, double dureetravail) {
        setIdtypeservice(idtypeservice);
        setIdspecialite(idspecialite);
        setDureetravail(dureetravail);
        this.setNbrField(3);
    }

    public Service_specialite() {
        this.setNbrField(3);
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public int getIdspecialite() {
        return idspecialite;
    }

    public void setIdspecialite(int idspecialite) {
        this.idspecialite = idspecialite;
    }

    public double getDureetravail() {
        return dureetravail;
    }

    public void setDureetravail(double dureetravail) {
        this.dureetravail = dureetravail;
    }

}
