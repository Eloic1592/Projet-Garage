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
public class Piece extends Model{
    int idpiece;
    String nompiece;

    public Piece(int idpiece, String nompiece) {
        this.idpiece = idpiece;
        this.nompiece = nompiece;
        this.setNbrField(2);
    }

    public Piece() {
        this.setNbrField(2);
    }

    public int getIdpiece() {
        return idpiece;
    }

    public void setIdpiece(int idpiece) {
        this.idpiece = idpiece;
    }

    public String getNompiece() {
        return nompiece;
    }

    public void setNompiece(String nompiece) {
        this.nompiece = nompiece;
    }
}
