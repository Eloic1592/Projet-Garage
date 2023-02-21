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
public class Remise extends Model {
    int idremise;
    int idservice;
    double remise;

    public Remise(int idremise, int idservice, double remise) {
        this.idremise = idremise;
        this.idservice = idservice;
        this.remise = remise;
        setNbrField(3);
    }

    public Remise() {
        setNbrField(3);
    }

    public int getIdremise() {
        return idremise;
    }

    public void setIdremise(int idremise) {
        this.idremise = idremise;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

}
