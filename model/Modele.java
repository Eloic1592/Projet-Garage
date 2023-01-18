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
public class Modele extends Model{
    int id;
    String marque;
    int idmarque;

    public Modele(int id, String marque, int idmarque) {
        this.setId(id);
        this.setMarque(marque);
        this.setIdmarque(idmarque);
        this.setNbrField(3);
    }

    public Modele() {
        this.setNbrField(3);
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

    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }
    
    
}
