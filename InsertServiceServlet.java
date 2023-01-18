/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service_client;

/**
 *
 * @author Mialisoa
 */
@WebServlet(urlPatterns = {"/InsertService"})
public class InsertServiceServlet extends HttpServlet {

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
        
        int idVehicule = Integer.parseInt(request.getParameter("vehicule"));
        int idClient = Integer.parseInt(request.getParameter("client"));
        int idTypeService = Integer.parseInt(request.getParameter("service"));
        String libelle = request.getParameter("libelle");
        Date today = new Date();
        
        Service_client service_client = new Service_client(0, idVehicule, idClient, idTypeService, libelle, today);

        RequestDispatcher dispatcher = null;
        Integer sqlError = 0, error = 0, validate = 0;
    // validation libelle
        // if(libelle.equals("") || libelle == null) {
        //     validate = 1;
        //     request.setAttribute("validate", validate);
        //     request.setAttribute("service_client", service_client);
        //     dispatcher = request.getRequestDispatcher("Service.jsp");
        //     dispatcher.forward(request, response);
        // }        
        // else {
            try {
                service_client.insertToTable(null, true);
                dispatcher = request.getRequestDispatcher("ServeDevis");
            } catch (SQLException e) {
                // e.printStackTrace(response.getWriter());
                request.setAttribute("sqlError", sqlError);
                dispatcher = request.getRequestDispatcher("Service.jsp");
            } catch (Exception e1) {
                // e1.printStackTrace(response.getWriter());
                request.setAttribute("error", error);
                dispatcher = request.getRequestDispatcher("Service.jsp");
            }
            finally {
                if(error.intValue() != 0 || sqlError.intValue() != 0) {
                    request.setAttribute("service_client", service_client);
                }
                dispatcher.forward(request, response);
            }
        // }

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
