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
public class registerController extends HttpServlet {

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
            User registerUser;
            User loginUser;
            //HttpSession session = request.getSession(true);
            //String email = request.getParameter("email");

            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
System.out.println("0");
            if (new Operaciones().validateName(name)) {
                System.out.println("1");
                if (new Operaciones().validateName(lastname)) {
                    System.out.println("2");
                    if (new Operaciones().validateEmail(email)) {
                        System.out.println("3");
                        if (new Operaciones().validatePass(pass)) {
                            System.out.println("4");
                            
                            registerUser = new User(name, lastname, email, pass);
                            new Operaciones().register(registerUser, Con);
                            
                            loginUser = new User(email, pass);
                            User objUser = null;
                            objUser = new Operaciones().login(loginUser, Con);//este método devuelve un obj
                            
                            System.out.println("creando sesion");
                            session.setAttribute("objUserSession", objUser);
                            
                            String mge = "Usuario registrado.";
                            response.sendRedirect("VISTAS/message.jsp?VAR="+ mge);
                        }else{
                myException ex = new myException(501,"No se pudo registrar, la contraseña debe contener al menos un número.","registerController","./register.jsp");
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
                        }
                    }else{
                myException ex = new myException(502,"No se pudo registrar, problema con email","registreController","./register.jsp");
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
                        }
                }else{
                myException ex = new myException(503,"No se pudo registrar, problema con apellido","registreController","./register.jsp");
                session.setAttribute("exception", ex);
                response.sendRedirect("VISTAS/error.jsp");
                        }
            }else{
                myException ex = new myException(504,"No se pudo registrar, problema con nombre","registreController","./register.jsp");
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
            Logger.getLogger(registerController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(registerController.class.getName()).log(Level.SEVERE, null, ex);
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
