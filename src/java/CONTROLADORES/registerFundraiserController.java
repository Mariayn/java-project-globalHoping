/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import DAO.Operaciones;
import MODELO.DBconnection;
import MODELO.Project;
import MODELO.User;
import MODELO.myException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
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
public class registerFundraiserController extends HttpServlet {

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
            
            HttpSession session = request.getSession(true);//Iniciamos sesión
            User objUser = (User)session.getAttribute("objUserSession");//Traemos la sesión objUser
            int id= objUser.getId();
            System.out.println(objUser);
            Project projectObj;
            
            String Vtitle = request.getParameter("title");
            String Vname = request.getParameter("name");
            String Vdescription = request.getParameter("description");
            String VidImg = request.getParameter("radioName");//recojo el value(string)
            int Vgoal = parseInt(request.getParameter("goal"));
            LocalDate dateNow = LocalDate.now();
           System.out.println( dateNow);
                System.out.println("cont 3");
                projectObj = new Project(Vtitle,Vname,id,VidImg,Vdescription,Vgoal,dateNow);
                new Operaciones().createProject(projectObj, Con);
                
                String mge = "Se ha creado tu proyecto. En breves momentos nuestro personal revisara el contenido de tu proyecto y se cantactará contigo.";
               response.sendRedirect("VISTAS/mge2.jsp?VAR="+ mge);
        
                
                
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
            Logger.getLogger(registerFundraiserController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(registerFundraiserController.class.getName()).log(Level.SEVERE, null, ex);
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
