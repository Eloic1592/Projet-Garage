/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Devis_produit;
import model.Devis_service;
import model.Service_client;
import model.Total_devis_produit;
import model.Total_devis_service;

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
        
        /*int idVehicule = Integer.parseInt(request.getParameter("vehicule"));
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
                Integer id = service_client.insertReturningId(null);
                // PrintWriter out = response.getWriter();
                // out.print(id);
                request.setAttribute("typeService", id);

                Devis_service devis_service = new Devis_service();
                devis_service.setIdtypeservice(id);
                String[] colonnes = new String[1];
                colonnes[0] = "idtypeservice";
                Vector<Devis_service> montantsService = devis_service.getBy(null, colonnes);

                Devis_produit devis_produit = new Devis_produit();
                devis_produit.setIdtypeservice(idTypeService);

                Vector<Devis_produit> montanProduits = devis_produit.getBy(null, colonnes);

                Total_devis_produit totalProduits = new Total_devis_produit();
                totalProduits.setIdtypeservice(idTypeService);

                Vector<Total_devis_produit> sommeProduit = totalProduits.getBy(null, colonnes);

                Total_devis_service totalService = new Total_devis_service();
                totalService.setIdtypeservice(idTypeService);

                Vector<Total_devis_service> sommeService = totalService.getBy(null, colonnes);

                request.setAttribute("service", montantsService);
                request.setAttribute("produit", montanProduits);
                if(sommeProduit.size() != 0 && sommeService.size() != 0)
                request.setAttribute("montantService", sommeService.get(0).getSum());
                request.setAttribute("montantProduit", sommeProduit.get(0).getSum());
                request.setAttribute("total", sommeProduit.get(0).getSum()+sommeService.get(0).getSum());

                request.setAttribute("benefice", (sommeProduit.get(0).getSum()+sommeService.get(0).getSum())*devis_service.getMarge_beneficiaire());


                PrintWriter out = response.getWriter();
                out.print(id);
                dispatcher = request.getRequestDispatcher("devis.jsp");
            } catch (SQLException e) {
                e.printStackTrace(response.getWriter());
                request.setAttribute("sqlError", sqlError);
                dispatcher = request.getRequestDispatcher("Service.jsp");
            } catch (Exception e1) {
                e1.printStackTrace(response.getWriter());
                request.setAttribute("error", error);
                dispatcher = request.getRequestDispatcher("Service.jsp");
            }
            finally {
                if(error.intValue() != 0 || sqlError.intValue() != 0) {
                    request.setAttribute("service_client", service_client);
                }
                dispatcher.forward(request, response);
            }*/
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
