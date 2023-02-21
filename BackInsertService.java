/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.PostgresConnection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import model.Client;
import model.Details_facture;
import model.Facture;
import model.Facture_mere;
import model.Service_client;

/**
 *
 * @author Mialisoa
 */
public class BackInsertService extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            Connection connection = PostgresConnection.getConnection();
            String idclient = request.getParameter("idclient");
            String[] services = request.getParameterValues("service");
            String[] quantites = request.getParameterValues("quantite");
            String[] prix = request.getParameterValues("prix");
            // String[] remises = request.getParameterValues("remise");
            PrintWriter out = response.getWriter();

            Facture_mere factureMere = new Facture_mere();
            factureMere.setIdclient(idclient);
            factureMere.setDates(Timestamp.valueOf(LocalDateTime.now()));
            
            Client c = new Client();
            c.setIdclient(idclient);
            String[] params = new String[1];
            params[0] = "idclient";
        
            Client client = ((Client)c.getBy(connection, params).get(0));
            int jour = client.getDatenaissance().getDate();
            int mois = client.getDatenaissance().getMonth();

            // out.print("client " + jour + "/" + mois);
            // out.print("facture " + factureMere.getDates().getDate() + "/" + factureMere.getDates().getMonth());

            // out.print(client.getDatenaissance());

            if(jour == factureMere.getDates().getDate() && mois == factureMere.getDates().getMonth()) {
               factureMere.setRemise(0.5);  
            }

            factureMere.setRemise(connection);
            Integer idFactureMere = factureMere.insertReturning(connection, true, "idfacturemere") ;
            factureMere.setIdfacturemere(idFactureMere.intValue());

            
            // Double total = Details_facture_client.getTotal(factures);

            // out.println(quantites.length);
            Service_client s = new Service_client();
            Details_facture detailsFacture = new Details_facture();
            detailsFacture.setIdfacturemere(factureMere.getIdfacturemere());
            for(int i=0; i<quantites.length; i++) {
                if(Integer.parseInt(quantites[i]) != 0) {
                // anaty service client 
                    s.setIdclient(Integer.parseInt(idclient));
                    s.setIdtypeservice(Integer.parseInt(services[i]));
                    s.setQuantite(Integer.parseInt(quantites[i]));
                    s.setDateservice(factureMere.getDates());
                    s.insertToTable(connection, true);

                // anaty details_facture
                    detailsFacture.setIdtypeservice(services[i]);
                    detailsFacture.setPrixunitaire(prix[i]);
                    detailsFacture.setQuantite(quantites[i]);
                    // detailsFacture.setRemise(Double.parseDouble(remises[i]));
                    detailsFacture.insertToTable(connection, true);
                }
            }


            connection.commit();
            connection.close();
            response.sendRedirect("ServeListeFacture?idclient=" + idclient);
        } catch (SQLException ex) {
            ex.printStackTrace(response.getWriter());
            // Logger.getLogger(BackInsertService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            // Logger.getLogger(BackInsertService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(response.getWriter());
            
        } catch (Exception ex) {
            // Logger.getLogger(BackInsertService.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(response.getWriter());
            
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
