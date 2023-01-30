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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produit;

/**
 *
 * @author Mialisoa
 */
public class PrixProduitServlet extends HttpServlet {

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

        RequestDispatcher dispatcher = request.getRequestDispatcher("prix-produit.jsp");
        try {
                
            int idProduit = Integer.parseInt(request.getParameter("produit"));
            Produit produit = new Produit();
            produit.setIdProduit(idProduit);
            String[] params = new String[1];
            params[0] = "idProduit";

            Produit p = ((Produit)produit.getBy(null, params).get(0));
            produit.setIdProduit(idProduit);


            Double prixConseille = produit.getPrixConseille(null);
            Double marge = produit.getMargeBeneficiaire(null);
            Double benefice = prixConseille.doubleValue() - Double.parseDouble(String.valueOf(p.getPrix())) ;
            // PrintWriter out = response.getWriter();
            // out.print(p.getPrix() + " " + prixConseille);

            request.setAttribute("produit", p);
            request.setAttribute("prix", prixConseille);
            request.setAttribute("benefice", benefice);
            request.setAttribute("marge", marge);

        } catch (SQLException e) {
            Integer sqlError = 1;
            request.setAttribute("sqlError", sqlError);
        } catch (Exception e1) {
            Integer error = 1;
            request.setAttribute("error", error);
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
