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
public class Type_service extends Model {
    int idtypeservice;
    String type_service;

    public Type_service(int idtypeservice, String type_service) {
        this.idtypeservice = idtypeservice;
        this.type_service = type_service;
        this.setNbrField(2);
    }

    public Type_service() {
        this.setNbrField(2);
    }

    public int getIdtypeservice() {
        return idtypeservice;
    }

    public void setIdtypeservice(int idtypeservice) {
        this.idtypeservice = idtypeservice;
    }

    public String getType_service() {
        return type_service;
    }

    public void setType_service(String type_service) {
        this.type_service = type_service;
    }
}
