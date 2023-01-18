/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import connection.PostgresConnection;

/**
 *
 * @author Mialisoa
 */
public class Model {
    int nbrField;

    public void setNbrField(int nbrField) {
        this.nbrField = nbrField;
    }

    public int getNbrField() {
        return nbrField;
    }

    public void insertToTable(Connection connection, boolean primaryKey) throws SQLException, Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Statement statement = connection.createStatement();
        String req = "insert into " + this.getClass().getSimpleName().toUpperCase() + " values (";
        Field[] fields = this.getClass().getDeclaredFields();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int depart = 0;
        if(primaryKey == true) {
            depart = 1;
            req += "default, ";
        }
        
        for (int i = depart; i < this.getNbrField(); i++) {
            // get the getter of each field
            String getterName = "get" + fields[i].getName().replaceFirst(String.valueOf(fields[i].getName().charAt(0)),
                    String.valueOf(fields[i].getName().toUpperCase().charAt(0)));
           
            Method getter = this.getClass().getDeclaredMethod(getterName);
            if (fields[i].getType().isPrimitive() && !fields[i].getType().equals(boolean.class)) {
                req += getter.invoke(this);
            } else {
                if (getter.invoke(this) == null) {
                    req += "NULL";
                } else {
                    String value = fields[i].get(this).toString();
                    value = getter.invoke(this).toString();

                    if (fields[i].getType().equals(Date.class)) {
                        value = dateFormat.format(fields[i].get(this));
                    }

                    req += "'" + value + "'";
                }
            }
            if (i + 1 < this.getNbrField()) {
                req += ",";
            }
        }
        req += ")";
       
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            connection.rollback();
            throw new Exception("Erreur lors de l'insertion " + req);
        }

        statement.close();
        if (isOpen) {
            connection.commit();
            connection.close();
        }
    }

    public Vector getAll(Connection connection) throws ClassNotFoundException, SQLException, Exception {
        // Cas précis pour ORACLE
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Statement statement = connection.createStatement();
        String req = "SELECT * FROM " + this.getClass().getSimpleName().toUpperCase();
        Field[] fields = this.getClass().getDeclaredFields();
        int nbrFilter = 0;

        try {
            ResultSet responses = statement.executeQuery(req);
            Vector data = new Vector<>();
            String fieldType = "";
            String fieldName = "";
            String dataType = "";
            while (responses.next()) {
                Object object = this.getClass().getConstructor().newInstance();
                for (int i = 0; i < this.getNbrField(); i++) {
                    fields[i].setAccessible(true);
                    Method setter;
                    String setterName;
                    fieldName = fields[i].getName();

                    if (fields[i].getType().isPrimitive() == true) { // int; double, float, boolean
                        fieldType = fields[i].getType().getName();
                        dataType = fieldType.replaceFirst(String.valueOf(fieldType.charAt(0)),
                                String.valueOf(fieldType.toUpperCase().charAt(0)));

                        // Miantso setter
                        setterName = "set"
                                + fieldName.replaceFirst(String.valueOf(fieldName.charAt(0)),
                                        String.valueOf(fieldName.toUpperCase().charAt(0)));

                        setter = this.getClass().getDeclaredMethod(setterName, fields[i].getType());
                        setter.invoke(object, ResultSet.class.getDeclaredMethod("get" + dataType, int.class)
                                .invoke(responses, i + 1));

                    } else {
                        setterName = "set"
                                + fieldName.replaceFirst(String.valueOf(fieldName.charAt(0)),
                                        String.valueOf(fieldName.toUpperCase().charAt(0)));

                        setter = this.getClass().getDeclaredMethod(setterName, String.class);
                        setter.invoke(object, responses.getString(i + 1));
                    }

                }
                data.add(object);
            }
            return data;
        } catch (SQLException e1) {
            throw e1;
        } catch (Exception e2) {
            throw new Exception(
                    "Erreur lors de la recuperation des donnees dans la db et leur transformation en objets\n " + req
                            + "\n" + e2.getMessage());
        } finally {
            statement.close();
            if (isOpen) {
                connection.close();
            }
        }

    }

    public Vector getBy(Connection connection, String[] params) throws ClassNotFoundException, SQLException, Exception {
        boolean isOpen = false;
        if (connection == null) {
            connection = PostgresConnection.getConnection();
            isOpen = true;
        }

        Vector result = new Vector<>();
        Statement statement = connection.createStatement();
        String req = "SELECT * FROM " + this.getClass().getSimpleName();
        String column = "";
        String value = "";
        if (params != null && params.length != 0) {
            req += " WHERE ";
            String getterName = "";
            Method getter;
            Object attribut;
            for (int i = 0; i < params.length; i++) {
                getterName = "get" + params[i].replaceFirst(String.valueOf(params[i].charAt(0)), String.valueOf(params[i].toUpperCase().charAt(0)));
                getter = this.getClass().getDeclaredMethod(getterName);

                column = params[i];
                attribut = getter.invoke(this);
                if(attribut == null) {
                    req += column + " IS NULL";
                }
                else {
                    value = String.valueOf(attribut);
                    if(getter.getReturnType().isPrimitive()) {
                        req += column + " = " + value;
                    }
                    else {
                        req += column + " = '" + value + "'";
                    }
                }
                

                if (i + 1 < params.length) {
                    req += " AND ";
                }
            }
        }

        ResultSet response = statement.executeQuery(req);
        Field[] fields = this.getClass().getDeclaredFields();

        while (response.next()) {
            Object object = this.getClass().getConstructor().newInstance();
            for (int i = 0; i < this.getNbrField(); i++) {
                fields[i].setAccessible(true);
                Method setter;
                String setterName;

                if (fields[i].getType().isPrimitive() == true) { // int; double, float, boolean
                    String fieldType = fields[i].getType().getName();
                    String dataType = fieldType.replaceFirst(String.valueOf(fieldType.charAt(0)),
                            String.valueOf(fieldType.toUpperCase().charAt(0)));

                    // Miantso setter
                    setterName = "set" + fields[i].getName().replaceFirst(String.valueOf(fields[i].getName().charAt(0)),
                            String.valueOf(fields[i].getName().toUpperCase().charAt(0)));

                    setter = this.getClass().getDeclaredMethod(setterName, fields[i].getType());
                    setter.invoke(object,
                            ResultSet.class.getDeclaredMethod("get" + dataType, int.class).invoke(response, i + 1));
                } else {
                    setterName = "set" + fields[i].getName().replaceFirst(String.valueOf(fields[i].getName().charAt(0)),
                            String.valueOf(fields[i].getName().toUpperCase().charAt(0)));
                    // System.out.println(setterName);

                    setter = this.getClass().getDeclaredMethod(setterName, String.class);
                    setter.invoke(object, response.getString(i + 1));
                }
            }
            result.add(object);
        }

        if (isOpen) {
            connection.commit();
            connection.close();
        }
        return result;
    }

}
