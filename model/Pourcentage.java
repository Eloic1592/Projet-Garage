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
public class Pourcentage extends Model {
    int idpourcentage;
    double prixmin;
    double prixmax;
    double pourcentage;

    public Pourcentage(int idpourcentage, double prixmin, double prixmax, double pourcentage) {
        setIdpourcentage(idpourcentage);
        setPrixmin(prixmin);
        setPrixmax(prixmax);
        setPourcentage(pourcentage);
        this.setNbrField(4);
    }

    public Pourcentage() {
        this.setNbrField(4);
    }

    public int getIdpourcentage() {
        return idpourcentage;
    }

    public void setIdpourcentage(int idpourcentage) {
        this.idpourcentage = idpourcentage;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }

    public double getPrixmax() {
        return prixmax;
    }

    public void setPrixmax(double prixmax) {
        this.prixmax = prixmax;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
