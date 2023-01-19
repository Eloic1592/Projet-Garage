/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.PostgresConnection;
import model.Devis_produit;
import model.Devis_service;
import model.Service;

/**
 *
 * @author Mialisoa
 */
public class SingleServiceDevis extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("devis-service.jsp");
        try {
            response.setContentType("text/html;charset=UTF-8");
            Connection connection = PostgresConnection.getConnection();

            int idTypeService = Integer.parseInt(request.getParameter("idService"));
            Devis_service devis_service = new Devis_service();
            devis_service.setIdtypeservice(idTypeService);
            String[] colonnes = new String[1];
            colonnes[0] = "idtypeservice";
            Vector<Devis_service> infoService = devis_service.getBy(connection, colonnes);

            Devis_produit devis_produit = new Devis_produit();
            devis_produit.setIdtypeservice(idTypeService);

            Vector<Devis_produit> infoProduit = devis_produit.getBy(connection, colonnes);

            Service s = new Service();
            s.setIdtypeservice(idTypeService);
            if(s.getBy(connection, colonnes).size() != 0) {
                Service service = ((Service)s.getBy(connection, colonnes).get(0));
                request.setAttribute("service", service);
            }

            request.setAttribute("infoService", infoService);
            request.setAttribute("infoProduit", infoProduit);
  
        } catch (SQLException ex) {
            request.setAttribute("sqlError", 1);
        } catch (Exception ex) {
            request.setAttribute("error", 1);
        } finally {
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
