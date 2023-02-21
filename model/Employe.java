/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import connection.PostgresConnection;
import exceptions.AgeException;
import java.text.ParseException;

/**
 *
 * @author Mialisoa
 */
public class Employe extends Model {
    int idEmploye;
    String nom;
    String prenom;
    Date dateNaissance;
    int idGenre;
    int idNiveauEtude;
   
    public Employe(int id, String nom, String prenom, String dateNaissance, int idGenre, int idNiveauEtude) throws Exception {
        this.setIdEmploye(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setdateNaissance(dateNaissance);
        this.setIdGenre(idGenre);
        this.setIdNiveauEtude(idNiveauEtude);
        this.setNbrField(6);
    }


    public Employe() {
        this.setNbrField(6);
    }

    public int insert(Connection connection) throws ClassNotFoundException, SQLException {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Statement statement = connection.createStatement();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String req = "insert into employe values (default, '" +this.getNom()+ "' , '" + this.getPrenom() + "', '" + format.format(this.getDateNaissance())+ "'," + this.getIdGenre() +", " + this.getIdNiveauEtude() + " ) returning idemploye";
        ResultSet res = statement.executeQuery(req);

        int id = 0;
        if(res.next()) {
            id = res.getInt(1);
        }

        if (isOpen) {
            connection.commit();
            connection.close();
        }

        return id;
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

    public Date getdateNaissance() {
        return dateNaissance;
    }

    public void setdateNaissance(Date dateNaissance) throws Exception {
        Date today = new Date();
        if(today.getYear() - dateNaissance.getYear() < 18) {
            throw new Exception("Trop jeune pour ce travail");
        }
        this.dateNaissance = dateNaissance;
    }
    
    public void setdateNaissance(String dateNaissance) throws ParseException, Exception{
        if(dateNaissance == null)
               this.dateNaissance = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(dateNaissance);
            this.setdateNaissance(d);
        }
    }

    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getIdNiveauEtude() {
        return idNiveauEtude;
    }

    public void setIdNiveauEtude(int idNiveauEtude) {
        this.idNiveauEtude = idNiveauEtude;
    }
    
    
}
