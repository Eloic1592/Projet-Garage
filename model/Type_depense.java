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
public class Type_depense extends Model{
    int idtypedepense;
    String type_depense;
    
    public Type_depense() {
        setNbrField(2);
    }
    
    public Type_depense(int idtypedepense, String type_depense) {
        setIdtypedepense(idtypedepense);
        setType_depense(type_depense);
        setNbrField(2);
    }

    public int getIdtypedepense() {
        return idtypedepense;
    }
    public void setIdtypedepense(int idtypedepense) {
        this.idtypedepense = idtypedepense;
    }
    public String getType_depense() {
        return type_depense;
    }
    public void setType_depense(String type_depense) {
        this.type_depense = type_depense;
    }

    
}
