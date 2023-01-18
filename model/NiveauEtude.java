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
public class NiveauEtude extends Model {
    int idniveauetude;
    String niveauetude;
    int niveau;

    public NiveauEtude() {
        this.setNbrField(3);
    }

    public NiveauEtude(int idniveauetude, String niveauetude, int niveau) {
        this.idniveauetude = idniveauetude;
        this.niveauetude = niveauetude;
        this.setNiveau(niveau);
        this.setNbrField(3);
    }

    

    public int getIdniveauetude() {
        return idniveauetude;
    }

    public void setIdniveauetude(int idniveauetude) {
        this.idniveauetude = idniveauetude;
    }

    public String getNiveauEtude() {
        return niveauetude;
    }

    public void setNiveauEtude(String niveauetude) {
        this.niveauetude = niveauetude;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }

    public String getNiveauetude() {
        return niveauetude;
    }

    public void setNiveauetude(String niveauetude) {
        this.niveauetude = niveauetude;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
}
