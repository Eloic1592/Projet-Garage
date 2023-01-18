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
public class Client extends Model {
    int idClient;
    String nom;
    String prenom;
    String email;
    String contact;
    String adresse;

    public Client(int idClient, String nom, String prenom, String email, String contact, String adresse) {
        this.setIdClient(idClient);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setContact(contact);
        this.setAdresse(adresse);
        this.setNbrField(6);
    }

    public Client() {
        this.setNbrField(6);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
