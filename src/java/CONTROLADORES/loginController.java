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
public class loginController extends HttpServlet {
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
            throws ServletException, IOException,SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            User loginUser;
            String nif = request.getParameter("email");
            String password = request.getParameter("pass");
            
            loginUser = new User(nif,password);
            
            User objUser = null;
            objUser = new Operaciones().login(loginUser, Con);
                
            System.out.println("antes if");
            if(objUser == null){
                myException ex = new myException(100,"Error al iniciar sesion,datos incorrectos","loginController","./login.jsp");
                HttpSession session = request.getSession(true);
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
            }
            else{
                System.out.println("creando sesion");
                HttpSession session = request.getSession(true);
                session.setAttribute("objUserSession", objUser);
                response.sendRedirect("VISTAS/userProfile.jsp");
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
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
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
