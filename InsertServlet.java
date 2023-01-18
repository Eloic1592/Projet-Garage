/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exceptions.AgeException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employe;

/**
 *
 * @author Mialisoa
 */
public class InsertServlet extends HttpServlet {

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
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date_naissance = request.getParameter("date_naissance");
        int genre = Integer.parseInt(request.getParameter("genre"));
        int niveau = Integer.parseInt(request.getParameter("niveau"));
        
        //PrintWriter out = response.getWriter();
        Connection connection = null; 
        RequestDispatcher dispatch;
        Integer error = 0;
        try {
        // insertion employe
            Employe emp = new Employe(0, nom, prenom, date_naissance, genre, niveau);

            Integer id = emp.insert(connection);
            
            
            request.getSession().setAttribute("id", id);              
            dispatch = request.getRequestDispatcher("specialite.jsp");
            dispatch.forward(request, response);
        }
        catch (AgeException ageException) {
            error = 3;                      // trop jeune
        }
        catch (Exception e) {
            if(connection != null) {
                error = 1;                  // erreur lié au serveur
                try {
                    connection.rollback();
                }
                catch (SQLException e1) {
                    error = 1;              // erreur lié au serveur
                }
            }
            else {
                error = 2;                  // erreur de connexion
            }
        }
        finally {
            request.setAttribute("error", error);
            dispatch = request.getRequestDispatcher("index.jsp");
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
