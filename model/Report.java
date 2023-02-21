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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import connection.PostgresConnection;

/**
 *
 * @author Mialisoa
 */
public class Report extends Model {
    int idreport;
    double montant;
    Date datereport;

    public Report(int idreport, double montant, Date datereport) {
        setDatereport(datereport);
        setNbrField(3);
    }

    public Report() {
        setNbrField(3);
    }

    public double getLastSomme(Connection connection) throws ClassNotFoundException, SQLException {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        String req = "select sum(montant) from report  group by datereport  order by datereport limit 1 ";
        Statement statement = connection.createStatement();
        ResultSet response = statement.executeQuery(req);
        double report = 0;
        if(response.next()) {
            report = response.getDouble(1);
        }

        if(isOpen == true) {
            connection.close();
        }

        return report;

    }

    public void setDatereport(String datereport) throws ParseException, Exception{
        if(datereport == null)
               this.datereport = null;
        else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = dateFormat.parse(datereport);
            this.setDatereport(d);
        }
    }

    public int getIdreport() {
        return idreport;
    }

    public void setIdreport(int idreport) {
        this.idreport = idreport;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatereport() {
        return datereport;
    }

    public void setDatereport(Date datereport) {
        this.datereport = datereport;
    }

}
