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
public class Marque extends Model {
    int id;
    String marque;

    public Marque(int id, String marque) {
        this.id = id;
        this.marque = marque;
        this.setNbrField(2);
    }
    
    

    public Marque() {
        this.setNbrField(2);
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }
    
    
}
