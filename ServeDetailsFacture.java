/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.PostgresConnection;
import model.Client;
import model.Details_facture_client;
import model.Facture_mere;
import model.Remise;

/**
 *
 * @author Mialisoa
 */
public class ServeDetailsFacture extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("details_facture.jsp");
        try {
            Connection connection = PostgresConnection.getConnection();
            Details_facture_client details = new Details_facture_client();
            details.setIdfacturemere(request.getParameter("idfacture"));
            String[] params = new String[1];
            params[0] = "idfacturemere";

            Facture_mere factureMere = new Facture_mere();
            factureMere.setIdfacturemere(request.getParameter("idfacture"));
            Vector<Details_facture_client> factures = factureMere.getDetailsFactureClient(connection);

            Facture_mere f = (Facture_mere)factureMere.getBy(connection, params).get(0);
            
            // Timestamp temps = f.getDates();
            // int jour = temps.getDay();
            // int mois = temps.getMonth();

            // Client c = new Client();
            // c.setIdclient(f.getIdclient());
            // params[0] = "idclient";

            // Client client = ((Client)c.getBy(connection, params).get(0));
            // Double total = Details_facture_client.getTotal(factures);    

            // if(jour == client.getDatenaissance().getDay() && mois == client.getDatenaissance().getMonth()) {
            //     total = total/2;
            // }

            Double reste = factureMere.getResteAPayer(connection);
            String remise = f.parseRemise();
            request.setAttribute("factures", factures);
            request.setAttribute("reste", reste);
            request.setAttribute("remise", remise); 

            connection.close();
        } catch (SQLException e) {
            Integer sqlError = 1;
            request.setAttribute("sqlError", sqlError);
            response.getWriter().print("sql");
            e.printStackTrace(response.getWriter());
        } catch (Exception e1) {
            Integer error = 1;
            request.setAttribute("error", error);
            response.getWriter().print("error\n");
            e1.printStackTrace(response.getWriter());

        }
        finally {
            dispatcher.forward(request, response);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
