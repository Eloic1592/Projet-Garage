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
    float marge_beneficiaire;

    

    public Type_service(int idtypeservice, String type_service, float marge_beneficiaire) {
        this.idtypeservice = idtypeservice;
        this.type_service = type_service;
        setMarge_beneficiaire(marge_beneficiaire);
        this.setNbrField(3);
    }

    public Type_service() {
        this.setNbrField(3);
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

    public float getMarge_beneficiaire() {
        return marge_beneficiaire;
    }

    public void setMarge_beneficiaire(float marge_beneficiaire) {
        this.marge_beneficiaire = marge_beneficiaire;
    }
}
