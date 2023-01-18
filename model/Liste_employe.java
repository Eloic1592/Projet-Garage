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
public class Liste_employe extends Model{
    int idemploye;
    String nom;
    String prenom;
    String genre;
    String nomspecialite;
    
    public Liste_employe() {
        this.setNbrField(5);
    }
    
    public Liste_employe(int idemploye, String nom, String prenom, String genre, String nomspecialite) {
        this.setIdemploye(idemploye);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setGenre(genre);
        this.setNomspecialite(nomspecialite);

        this.setNbrField(5);
    }

    public int getIdemploye() {
        return idemploye;
    }
    public void setIdemploye(int idemploye) {
        this.idemploye = idemploye;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getNomspecialite() {
        return nomspecialite;
    }
    public void setNomspecialite(String nomspecialite) {
        this.nomspecialite = nomspecialite;
    }

    
}
