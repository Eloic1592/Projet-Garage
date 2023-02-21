/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mialisoa
 */
public class Client extends Model {
    int idclient;
    String nom;
    String prenom;
    String email;
    String contact;
    String adresse;
    Date datenaissance;
    
    public Client(int idClient, String nom, String prenom, String email, String contact, String adresse, String dateNaissance) throws ParseException, Exception {
        this.setIdclient(idClient);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setContact(contact);
        this.setAdresse(adresse);
        this.setDatenaissance(dateNaissance);
        this.setNbrField(7);
    }

    public Client() {
        this.setNbrField(7);
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idClient) {
        this.idclient = idClient;
    }

    public void setIdclient(String idClient) {
        this.setIdclient(Integer.parseInt(idClient));;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date dateNaissance) throws Exception {
        Date today = new Date();
        this.datenaissance = dateNaissance;
    }
    
    public void setDatenaissance(String dateNaissance) throws ParseException, Exception{
        if(dateNaissance == null)
               this.datenaissance = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(dateNaissance);
            this.setDatenaissance(d);
        }
    }

}
