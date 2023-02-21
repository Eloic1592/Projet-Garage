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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Vector;

import connection.PostgresConnection;
import exceptions.DataException;

/**
 *
 * @author Mialisoa
 */
public class Facture_mere extends Model {
    int idfacturemere;
    int idclient;
    Timestamp dates;
    double remise;

    public Facture_mere(int idfacturemere, int idclient, Timestamp dates, double remise) {
        setIdfacturemere(idfacturemere);
        setIdclient(idclient);
        setDates(dates);
        setRemise(remise);
        setNbrField(4);
    }

    public Facture_mere() {
        setNbrField(4);
    }

    public void setRemise(Connection connection) throws Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        // Client c = new Client();
        // c.setIdclient(idclient);
        // String[] params = new String[1];
        // params[0] = "idclient";
        
        // Client client = ((Client)c.getBy(connection, params).get(0));
        // int jour = client.getDatenaissance().getDate();
        // int mois = client.getDatenaissance().getMonth();

        // if(jour == this.getDates().getDate() && mois == this.getDates().getMonth()) {
        //     this.setRemise(0.5);  
        // }

        String req = "select * from facture_mere where extract(year from dates) = extract(year from current_timestamp ) and idclient = " + this.getIdclient();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(req);
        int result = 0;
        while(res.next()) {
            result++;
        }

        if(result == 0) {
            this.setRemise(0.8);
        }

        if(isOpen == true) {
            connection.close();
        }
    }

    public Vector<Details_facture_client> getDetailsFactureClient(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Details_facture_client details = new Details_facture_client();
        details.setIdfacturemere(this.getIdfacturemere());
        String[] params = new String[1];
        params[0] = "idfacturemere";

        Vector<Details_facture_client> factures = details.getBy(connection, params);
        
        if(isOpen) {
            connection.close();
        }

        return factures;
    }

    public double getMontantPaye(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        double montant = 0;
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Paiementfacture p = new Paiementfacture();
        p.setIdfacturemere(this.getIdfacturemere());
        String[] params = new String[1];
        params[0] = "idfacturemere";

        Vector<Paiementfacture> paiements = p.getBy(connection, params);
        for (Paiementfacture paiement : paiements) {
            montant += paiement.getMontant();
        }

        if(isOpen == true) {
            connection.close();
        }
        return montant;
    }

    public double getResteAPayer(Connection connection) throws ClassNotFoundException, SQLException, Exception { 
        double reste  = 0;
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Vector<Details_facture_client> details = this.getDetailsFactureClient(connection);
        double montantTotal = Details_facture_client.getTotal(details);
        double montantPaye = this.getMontantPaye(connection);
        reste = montantTotal - montantPaye;

        if(isOpen) {
            connection.close();
        }

        return reste;
    }

    public void payer(Connection connection, String montant, String date) throws ClassNotFoundException, SQLException, DataException, Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        if(Double.parseDouble(montant) <= 0) {
            if(isOpen) {
                connection.commit();
                connection.close();
            }
            throw new DataException("Le montant doit être positive et supérieure à 0.");
        }

        if(this.getResteAPayer(connection) == 0) {
            if(isOpen) {
                connection.commit();
                connection.close();
            }
            throw new DataException("La totalité de la facture a déjà été payée.");
        }

        Paiementfacture paiement = new Paiementfacture(this.getIdfacturemere(), this.getIdclient(), Double.parseDouble(montant), date);
        paiement.insertToTable(connection, false);

        if(isOpen) {
            connection.commit();
            connection.close();
        }
    }

    public int getIdfacturemere() {
        return idfacturemere;
    }

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
    }

    public void setIdfacturemere(String idfacturemere) {
        this.idfacturemere = Integer.parseInt(idfacturemere);
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = Integer.parseInt(idclient);
    }

    public Timestamp getDates() {
        return dates;
    }

    public void setDates(Timestamp dates) {
        this.dates = dates;
    }

    public void setDates(String jour) throws ParseException, Exception {
        if (jour == null)
            throw new Exception("Le jour est obligatoire");
        else {
            this.setDates(Timestamp.valueOf(jour));
        }
    }

    public double getRemise() {
        return remise;
    }

    public String parseRemise() {
        return this.getRemise()*100 + "%";
    }

    public void setRemise(double remise) {
        System.out.println("setter " +  remise);
        this.remise = remise;
    }

}
