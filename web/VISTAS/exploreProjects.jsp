<%-- 
    Document   : exploreProjects
    Created on : Mar 7, 2023, 3:34:41 PM
    Author     : maria
--%>

<%@page import="MODELO.User"%>
<%@page import="MODELO.Images"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROYECTOS</title>
        <!--CSS-->
        <link href="./CSS/explore.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <% 
            User objUser = (User)session.getAttribute("objUserSession");
            //String rol = objUser.getRol();
            String ADMIN = "admin";
            String USER = "user";
            %>
        <header>
            <a href="mainView.jsp"><img id="logo" src="./IMG/logo.png" alt="logo"></a>

            <% if(objUser==null){ %>
            <a href="login.jsp">Iniciar sesión <i class="fa-solid fa-right-to-bracket"></i></a>
            <%} else { %>
            <div>
            <a href="../logoutController">Cerrar sesión</a>
            <a href="userProfile.jsp" id = "profile" ><i class="fa-regular fa-user"></i></a>
            </div>
        <%}%>
        </header>
        
        <main>
            
            <div class="news-cards">
            <% 
                            for (Project objProject : (ArrayList<Project>)session.getAttribute("objArrayAllProjects")){
                                if(objProject.getStatus().equals("active")){
                            for(Images objImages : (ArrayList<Images>)session.getAttribute("objArrayImages")){
                                if(Integer.parseInt(objProject.getImg()) == objImages.getId()){
                        %>
            <div class="divProject">
                    <img src="<%=objImages.getRuta()%>" alt="News 1">
                    <div>
                        <h4><%=objProject.getTitle()%></h4>
                        <a  class="btnDonar" href="../getAllProjectsController?VAR=<%=objProject.getId()%>">DONAR <i class="fas fa-angle-double-right"></i></a>
                    </div>
            </div>
                    <%
                            }    }
                         }   }
                         %>
            </div>
            
        </main>
            
            <footer>
                 <div class="copyright">
                &copy; StarBugs. Todos los derechos reservados.
                </div>
            </footer>
    </body>
    
</html>
