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
public class Modele_piece extends Model {
    int modelepiece;
    int idpiece;
    String fonctionnalite;
    float dimension;
    float prixpiece;
    int idvehicule;

    
    
    public Modele_piece(int modelepiece, int idpiece, String fonctionnalite, float dimension, float prixpiece,
            int idvehicule) {
            
        this.setModelepiece(modelepiece);
        this.setIdpiece(idpiece);
        this.setFonctionnalite(fonctionnalite);
        this.setDimension(dimension);
        this.setPrixpiece(prixpiece);
        this.setIdvehicule(idvehicule);        
        this.setNbrField(6);
    }

    public Modele_piece() {
        this.setNbrField(6);
    }
    public int getModelepiece() {
        return modelepiece;
    }
    public void setModelepiece(int modelepiece) {
        this.modelepiece = modelepiece;
    }
    public int getIdpiece() {
        return idpiece;
    }
    public void setIdpiece(int idpiece) {
        this.idpiece = idpiece;
    }
    public String getFonctionnalite() {
        return fonctionnalite;
    }
    public void setFonctionnalite(String fonctionnalite) {
        this.fonctionnalite = fonctionnalite;
    }
    public float getDimension() {
        return dimension;
    }
    public void setDimension(float dimension) {
        this.dimension = dimension;
    }
    public float getPrixpiece() {
        return prixpiece;
    }
    public void setPrixpiece(float prixpiece) {
        this.prixpiece = prixpiece;
    }
    public int getIdvehicule() {
        return idvehicule;
    }
    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

}
