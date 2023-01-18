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
public class Vehicule extends Model {
    int idvehicule;
    String typevehicule;

    public Vehicule(int idvehicule, String typevehicule) {
        this.setIdvehicule(idvehicule);
        this.setTypevehicule(typevehicule);
        this.setNbrField(2);
    }

    public Vehicule() {
        this.setNbrField(2);
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getTypevehicule() {
        return typevehicule;
    }

    public void setTypevehicule(String typevehicule) {
        this.typevehicule = typevehicule;
    }

}
