/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import connection.PostgresConnection;
import exceptions.AuthException;

/**
 *
 * @author Mialisoa
 */
public class Garagiste extends Model {
    int idgaragiste;
    String email;
    String mdp;

    
    public Garagiste(int idgaragiste, String email, String mdp) {
        this.setIdgaragiste(idgaragiste);
        this.setEmail(email);
        this.setMdp(mdp);
        this.setNbrField(3);
    }

    public Garagiste() {
        this.setNbrField(3);
    }

    public int authentification(Connection connection) throws ClassNotFoundException, SQLException, AuthException, Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }
        
        String[] params = new String[2];
        params[0] = "email";
        params[1] = "mdp";

        Vector<Garagiste> auth = this.getBy(connection, params);
        if(isOpen == true) {
            connection.close();
        }
        if(auth.size() == 1) {
            return auth.get(0).getIdgaragiste();
        }
        else {
            throw new AuthException("Identifiants incorrects"); 
        }

    }

    public int getIdgaragiste() {
        return idgaragiste;
    }

    public void setIdgaragiste(int idgaragiste) {
        this.idgaragiste = idgaragiste;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}
