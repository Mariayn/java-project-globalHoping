/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import DAO.Operaciones;
import MODELO.DBconnection;
import MODELO.User;
import MODELO.myException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
public class changePassController extends HttpServlet {
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);//Iniciamos sesión
            User objUser = (User)session.getAttribute("objUserSession");//Traemos la sesión objUser
            int id= objUser.getId();
            
            User userForm;
            String Vpass = request.getParameter("pass");
            String Vpass2 = request.getParameter("pass2");
            
            if (new Operaciones().validatePass(Vpass)) {
                        System.out.println("Vpass");
                        if (new Operaciones().validatePass(Vpass2)) {
                            System.out.println("Vpass2");
                            
                            userForm = new User(Vpass);
                            System.out.println("Vpass3");
                            new Operaciones().changePass(userForm, id, Con);
                            System.out.println("Vpass4");
                            
                            //destruimos sesion x cambio de contraseña
                            session.invalidate();
                            
                            String mge = "Se ha cambiado la contaseña correctamente..";
                            response.sendRedirect("VISTAS/mge2.jsp?VAR="+ mge);
                            
                        }else{
                            myException ex = new myException(100,"Error al validar la segunda contraseña. ","changePassController","./resetPassword.jsp");
                           // HttpSession session = request.getSession(true);
                            session.setAttribute("exception", ex);
                            response.sendRedirect("VISTAS/error.jsp");
                        }
                    }else{
                            myException ex = new myException(100,"Error al validar la primera contraseña. ","changePassController","./resetPassword.jsp");
                           // HttpSession session = request.getSession(true);
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
