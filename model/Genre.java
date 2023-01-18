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
public class Genre extends Model {
    int idgenre;
    String nom;

    public Genre() {
        this.setNbrField(2);
    }

    public Genre(int idgenre, String nom) {
        this.setIdgenre(idgenre);
        this.setNom(nom);
        this.setNbrField(2);
    }

    public int getIdgenre() {
        return idgenre;
    }

    public void setIdgenre(int idgenre) {
        this.idgenre = idgenre;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
