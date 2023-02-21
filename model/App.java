/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Mialisoa
 */
public class App {
public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
    
    Vector<Details_facture_client> f = new Details_facture_client().getAll(null);
    for (Details_facture_client d : f) {
        System.out.println(d.getRemise());
    }

}    
}
