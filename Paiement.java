/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.DataException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Facture_mere;

/**
 *
 * @author Mialisoa
 */
public class Paiement extends HttpServlet {

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
        
        String montant = request.getParameter("montant");
        String idclient = request.getParameter("idclient");
        String idfacture = request.getParameter("idfacture");
        String date = request.getParameter("date");
        Facture_mere facture = new Facture_mere();
        facture.setIdfacturemere(idfacture);
        facture.setIdclient(idclient);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("ServeDetailsFacture?idfacture=" + idfacture + "&&idclient=" + idclient);
        int error = 0;
        try {        
            facture.payer(null, montant, date);
        } catch (SQLException ex) {
            error = 1;
        } catch (DataException ex) {
            error = 5;
        } catch (Exception ex) {
            error = 10;
        }
        finally {
            String location = "ServeDetailsFacture?idfacture=" + idfacture + "&&idclient=" + idclient;
            if(error != 0) {
                location += "&&error="+error;
            }
            response.sendRedirect(location);
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
