/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Departement;
import modele.Medecin;
import modele.DAO;
import modele.Pays;
import java.util.Collection;
import java.util.TreeSet;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Controleur", urlPatterns = {"/Controleur"})
public class Controleur extends HttpServlet {

    private Pays pays;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pays = new Pays();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        request.setAttribute("pays", pays);

        if (action == null) {

            String page = "menu.jsp";
            request.getRequestDispatcher(page).forward(request, response);

        } else {
            switch (action) {

                case "listedepartements":
                    String choixDep = request.getParameter("choixDepartement");
                    if (choixDep == null) {
                        String page = "listedepartements.jsp";
                        request.getRequestDispatcher(page).forward(request, response);
                    } else {
                        Collection Medecins = pays.getLeDep(choixDep).getLesMeds();
                        request.setAttribute("medecins", Medecins);
                        String page = "listemedecinspardep.jsp";
                        request.getRequestDispatcher(page).forward(request, response);

                    }
                    break;
                    
                case "listespecialite":
                    String choixSpe = request.getParameter("choixSpecialite");
                    if (choixSpe == null) {
                        String page = "listespe.jsp";
                        request.getRequestDispatcher(page).forward(request, response);
                    } else {
                        Collection Medecins = pays.getLesMedsParSpe(choixSpe);
                        request.setAttribute("medecins",Medecins);
                        String page = "listemedecinsparspe.jsp";
                        request.getRequestDispatcher(page).forward(request, response);
                    }

                    break;
                    
                case "listenom":
                    String choixNom = request.getParameter("choixNom");
                    if(choixNom == null) {
                        String page = "listenom.jsp";
                        request.getRequestDispatcher(page).forward(request, response);
                    }else {
                        Collection Medecins = pays.getLesMedsParNom(choixNom);
                        request.setAttribute("medecins",Medecins);
                        String page = "listemedecinsparnom.jsp";
                        request.getRequestDispatcher(page).forward(request, response);
                    }
                    break;

            }
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
