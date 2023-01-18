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
