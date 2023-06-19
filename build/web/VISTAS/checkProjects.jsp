<%-- 
    Document   : checkProjects
    Created on : Mar 4, 2023, 12:11:24 PM
    Author     : maria
--%>

<%@page import="MODELO.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROYECTOS PENDIENTES</title>
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
            
            String status= "no active";          
System.out.println(status);
        %>
        <header>
            
            <div>
                <a href="menuAdmin.jsp"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
                
            </div>
            <h4>Proyectos pendientes</h4>
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
                    <a href="menuAdmin.jsp"><i class="fa-solid fa-bars"></i> Menu administrador</a>
                    </div>
                    
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
                    <%
                    //ArrayList<Project> objProject2 = (ArrayList<Project>)session.getAttribute("objArrayProjects");
                    //for(Project objProject2 : (ArrayList<Project>)session.getAttribute("objArrayProjects")){
                    //if((objProject2.getStatus().equals("no active"))==false){
                    %>

                    <table>
                        <tr>
                            <th>Nombre del proyecto</th>
                            <th>Fecha</th>
                            <th>Creado por</th>
                            <th>Acción</th>
                            <th>Acción</th>
                        </tr>
                        
                        <% 
                            for(Project objProject : (ArrayList<Project>)session.getAttribute("objArrayProjects")){
                         
                                if(objProject.getStatus().equals("no active")){
                              
                                for(User objUsers : (ArrayList<User>)session.getAttribute("objArrayUsers")){
                                    if(objProject.getUser_id()==objUsers.getId()){
                                        
                                        System.out.println("2" + status);
                            //objProject = (ArrayList)session.getAttribute("objArrayProjects");
                        %>
                        <tr>
                            <td><%=objProject.getTitle()%></td>
                            <td><%=objProject.getCurrentDate()%></td>
                            <td><%=objUsers.getName() + " " + objUsers.getLastname()%></td>
                            <td><a href="#">Ver usuario</a></td>
                            <td><a href="../getImagesController2?VAR=<%=objProject.getId()%>">Ver proyecto</a></td>
                        
                        </tr>
                        <%
                         }   }
                         }   
                         }
                         %>
                        
                        
                    </table>
                   
                    
                </section>
                
            </main>
        
        
    </body>
</html>
