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
public class updateProfileController extends HttpServlet {
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
            String Vname = request.getParameter("name");
            String VlastName = request.getParameter("lastName");
            String Vemail = request.getParameter("email");
            String Vcif = request.getParameter("cif");
            String Vaddress = request.getParameter("address");
            String Vphone = request.getParameter("phone");
            System.out.println(Vname);
            System.out.println(VlastName);
            System.out.println(Vemail);
            System.out.println(Vcif);
            System.out.println(Vaddress);
            System.out.println(Vphone);
 
            System.out.println("before ");
            userForm = new User(Vname,VlastName,Vemail,Vcif,Vaddress,Vphone);
            new Operaciones().update(userForm,id,Con);
            System.out.println("after ");
            String mge = "Perfil actualizado correctamente";
            response.sendRedirect("VISTAS/mge2.jsp?VAR="+ mge);
            //response.sendRedirect("logoutController");
            
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
