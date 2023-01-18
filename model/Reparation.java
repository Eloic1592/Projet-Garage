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
public class Reparation extends Model {
    int idemploye;
    int idserviceclient;

    
    public Reparation(int idemploye, int idserviceclient) {
        setIdemploye(idemploye);
        setIdserviceclient(idserviceclient);
        this.setNbrField(2);
    }

    public Reparation() {
        this.setNbrField(2);
    }

    public int getIdemploye() {
        return idemploye;
    }

    public void setIdemploye(int idemploye) {
        this.idemploye = idemploye;
    }

    public int getIdserviceclient() {
        return idserviceclient;
    }

    public void setIdserviceclient(int idserviceclient) {
        this.idserviceclient = idserviceclient;
    }
}
