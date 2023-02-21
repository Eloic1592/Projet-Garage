/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Depense;
import model.Facture;
import model.Facture_mere;
import model.Paiementfacture;
import model.Report;

/**
 *
 * @author Mialisoa
 */
public class ServeCaisse extends HttpServlet {

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
        
        Float entree;
        try {
            entree = Paiementfacture.somme(null, new Date());
            Float sortie = Depense.somme(null, new Date());
            Float reste = entree-sortie;
            Double report =  new Report().getLastSomme(null);
            RequestDispatcher dispatcher = request.getRequestDispatcher("caisse.jsp");

            request.setAttribute("entree", entree);
            request.setAttribute("sortie", sortie);
            request.setAttribute("reste", reste);
            request.setAttribute("report", report);


            PrintWriter out = response.getWriter();
            // out.print(entree + " " + sortie + " " + reste);

            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServeCaisse.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(response.getWriter());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServeCaisse.class.getName()).log(Level.SEVERE, null, ex);
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
