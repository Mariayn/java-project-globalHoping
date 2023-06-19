/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import DAO.Operaciones;
import MODELO.DBconnection;
import MODELO.myException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author maria
 */
public class contactFormController extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String asunto = request.getParameter("asunto");
            String mje = request.getParameter("mensaje");
            LocalDate currentDate = LocalDate.now();
            
            
            if (new Operaciones().validateName(name)) {
                System.out.println("11");
                if (new Operaciones().validateName(lastname)) {
                    System.out.println("22");
                    if (new Operaciones().validatePhone(tel)) {
                        System.out.println("33");
                        if (new Operaciones().validateEmail(email)) {
                            System.out.println("44");
                            if(new Operaciones().validateName(asunto)){
                                System.out.println("55");
                                if(new Operaciones().validateName(mje)){
                                    System.out.println("66");
                           
                                    
      
                            new Operaciones().contactForm(name,lastname,tel,email,asunto,mje,currentDate,Con);
              
                            
                            
                            String mge = "Mensaje enviado.";
                            response.sendRedirect("VISTAS/message.jsp?VAR="+ mge);
                                }else{
                           myException ex = new myException(105,"Error en el campo: Mensaje","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                                }
                            }else{
                           myException ex = new myException(106,"Error en el campo: Asunto","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                                }
                        }else{
                           myException ex = new myException(107,"Error en el campo: Email","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                                }
                    }else{
                           myException ex = new myException(108,"Error en el campo: Telefono","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                                }
                }else{
                           myException ex = new myException(109,"Error en el campo: Apellido","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                                }
            }else{
                           myException ex = new myException(110,"Error en el campo: Nombre","contactFormController","./formularioContacto.jsp");
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
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
            Logger.getLogger(contactFormController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(contactFormController.class.getName()).log(Level.SEVERE, null, ex);
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
