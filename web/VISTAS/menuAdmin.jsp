<%-- 
    Document   : menuAdmin
    Created on : Mar 3, 2023, 1:27:01 PM
    Author     : maria
--%>

<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU ADMINISTRADOR</title>
        <!--CSS-->
        <link href="./CSS/menuAdmin.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <% 
            User objUser = (User)session.getAttribute("objUserSession");
            String rol = objUser.getRol();
            String name= objUser.getName();
            String lastName= objUser.getLastname();
            String ADMIN = "admin";
            String USER = "user";
            %>
        <header>
            
            <div>
                <a href="../getImagesController3"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
                
            </div>
            <h4>Usuario : <%=name + " " + lastName%></h4>
            <div>
                <nav>
                <a href="../logoutController">Cerrar sesión</a>
                <a href="userProfile.jsp" id = "profile" ><i class="fa-regular fa-user"></i></a>
                </nav>
            </div>

        </header>
            
            
            <main>
                <div id="menu">
                    <div>
                        <p>INFORMES</p>
                        <a><i class="fa-solid fa-bars"></i> Dashboard</a>
                    </div>
                    
                    <div id="gestionar">
                        <p>GESTIONAR</p>
                        <a href="../getUsersController"><i class="fa-sharp fa-regular fa-square-check"></i> Proyectos pendientes</a>
                        <a href="projectsList.jsp"><i class="fa-sharp fa-solid fa-square-check"></i> Proyectos</a>
                        <a href="../getUsersController2"><i class="fa-solid fa-users"></i> Usuarios</a>
                    </div>
                    
                </div>
                
                <section>
                    
                    
                </section>
                
            </main>
        
        
    </body>
</html>
