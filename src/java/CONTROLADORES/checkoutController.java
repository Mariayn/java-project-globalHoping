/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import DAO.Operaciones;
import MODELO.DBconnection;
import MODELO.Donation;
import MODELO.User;
import MODELO.myException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.faces.component.UIInput.isEmpty;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;

/**
 *
 * @author maria
 */
public class checkoutController extends HttpServlet {

    /****************************************************************************/
    private Connection Con;

    @Override
    public void init() throws ServletException {
        try {
            DBconnection ConexBD = DBconnection.GetConexion();
            Con = ConexBD.GetCon();
        } catch (ClassNotFoundException cnfe) {
        } catch (SQLException sqle) {
        }
    }
    /****************************************************************************/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println("1 CHECK CONTR");
            
            Donation obj;
            int VprojId = Integer.parseInt(request.getParameter("projId"));         
            String VfullName = request.getParameter("nom");
            String Vemail = request.getParameter("email");
            int VuserId = Integer.parseInt(request.getParameter("userId"));
            String Vcard = request.getParameter("numero_tarjeta");
            //String Vcaducidad = request.getParameter("caducidad");
            int Vamount = parseInt(request.getParameter("amount"));
            int Vgoal = (int) parseDouble(request.getParameter("goal"));
            int Vraised = (int) parseDouble(request.getParameter("raised"));

            int n=Vraised+Vamount;
            /*
                String[] parts = Vcaducidad.split("/");
                int month = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);

                YearMonth expirationYearMonth = YearMonth.of(year, month);
                LocalDate expirationDateObj = expirationYearMonth.atEndOfMonth();
                LocalDate currentDate = LocalDate.now();*/
             
            
            if(n>Vgoal){
                myException ex = new myException(999,"No se puede donar porque superas la cantidad deseada.Por favor introduce una cantidad menor o la diferencia para completar el proyecto.","getAllProjects","../getImagesController3");
                HttpSession session = request.getSession(true);
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
            }/*else if(expirationDate.isBefore(currentDate)){
                myException ex = new myException(998,"No se puede donar porque la fecha de caducidad de la tarjeta está caducada.Por favor inserta una tarjeta válida.","getAllProjects","../getImagesController3");
                HttpSession session = request.getSession(true);
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
            }*/
            else{
                obj = new Donation(VprojId,VfullName,Vemail,VuserId,Vcard,Vamount);
                new Operaciones().donate(obj, Con);
               System.out.println(" se ha donado!");

               String mge = "Se ha donado correctamente";
               response.sendRedirect("VISTAS/mge2.jsp?VAR="+ mge);
            }
            
        } catch (myException ex) {
            HttpSession session = request.getSession(true);
            session.setAttribute("exception", ex);
            response.sendRedirect("VISTAS/error.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
