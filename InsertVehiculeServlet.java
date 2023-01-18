/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicule_client;

/**
 *
 * @author Mialisoa
 */
@WebServlet(urlPatterns = {"/InsertVehicule"})
public class InsertVehiculeServlet extends HttpServlet {

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
        
        int idclient = Integer.parseInt(request.getParameter("client"));
        int idmodele = Integer.parseInt(request.getParameter("modele"));
        String immatriculation = request.getParameter("immatriculation");
        int idvehicule = Integer.parseInt(request.getParameter("vehicule"));
        
        Vehicule_client vehicule_client = new Vehicule_client(0, idclient, idmodele, immatriculation, idvehicule);
        
        Integer error = 0; 
        Integer sqlError = 0;
        Integer validate = 0;
        RequestDispatcher dispatch = null;
        try {
            // verifier ilay immatriculation
            if(immatriculation.equals("") ) {
                validate = 1;
            }
            else {
                vehicule_client.insertToTable(null, true);
            }
            dispatch = request.getRequestDispatcher("ListeClient");

        }
        catch (SQLException e) {
            sqlError = 1;
            request.setAttribute("sqlError", sqlError);
        }
        catch (Exception e1) {
            error = 1;
            request.setAttribute("error", error);
        }
        finally {
            if(error.intValue() != 0) {
                dispatch = request.getRequestDispatcher("vehicule.jsp");
            }
            request.setAttribute("validate", validate);
            request.setAttribute("vehicule_client", vehicule_client);
            
            
            dispatch.forward(request, response);
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
