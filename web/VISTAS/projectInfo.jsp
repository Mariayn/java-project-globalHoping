<%-- 
    Document   : projectInfo
    Created on : Mar 5, 2023, 8:25:52 PM
    Author     : maria
--%>

<%@page import="MODELO.Images"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Project"%>
<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INFORMACIÓN DEL PROYECTO</title>
        <!--CSS-->
        <link href="./CSS/projectInfo.css" rel="stylesheet" type="text/css">
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
            
                        String idProject =request.getParameter("VAR");
                        System.out.println("my id pro :" + idProject);
                        if(idProject == null ||idProject.equalsIgnoreCase("")){
                            System.out.println("es vacio");
                         }
                        int id = Integer.parseInt(idProject);   //id del proyecto seleccionado
         
                        //int i=Integer.parseInt("200");  
            %>
        <header>
            
            <div>
                <a href="menuAdmin.jsp"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
               
            </div>
             <h4>Proyecto pendiente a revisión</h4>
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
                        <p class="link">INFORMES</p>
                        <a><i class="fa-solid fa-bars"></i> Dashboard</a>
                    </div>
                    
                    <div id="gestionar">
                        <p class="link">GESTIONAR</p>
                        <a href="../getUsersController"><i class="fa-sharp fa-regular fa-square-check"></i> Proyectos pendientes</a>
                        <a href="projects.jsp"><i class="fa-sharp fa-solid fa-square-check"></i> Proyectos</a>
                        <a><i class="fa-solid fa-users"></i> Usuarios</a>
                    </div>
                    
                </div>
                
                <section>
                    
                    <div id="project">
                        <% 
                            for (Project objProject : (ArrayList<Project>)session.getAttribute("objArrayProjects")){
                                if(objProject.getId()==(id)){
                                    System.out.println(objProject.getId() + "2");
                                    
                        %>
                        <div id="projectInfo">
                            <label for="fname">Nombre del proyecto:</label><br>
                            <input type="text" name="nombre" value="<%=objProject.getTitle()%>" disabled/>
                            <label for="fname">Proyecto por:</label><br>
                            <input type="text" name="apellido" value="<%=objProject.getName()%>"  disabled/>
                            <label for="fname">Recaudación:</label><br>
                            <input type="text" name="tel" value="<%=objProject.getGoal()%>" disabled/>
                            <label for="fname">Descripción:</label><br>
                            <div>
                                <p  id ="projectDescription"><%=objProject.getDescription()%></p>
                            </div>
                            
                        </div>
                        
                        <div id="photo">
                            <p>Foto representativa del proyecto:</p>
                            <% 
                              
                            for(Images objImages : (ArrayList<Images>)session.getAttribute("objArrayImages")){
                                  if(Integer.parseInt(objProject.getImg()) == objImages.getId()){
                            %>
                            <image src="<%=objImages.getRuta()%>"/>
                            
                             <div id="btnDiv"><a id="btnAprobar" href="../projectApprovalController?VAR=<%=id%>">Aprobar proyecto</a> </div>
                        </div>
                        <%
                            }    }
                         }   }
                         %>
                    </div>
                        
                        
                       
 
              
                    <div id="deniedProject">
                        
                        <h4>DENEGAR PROYECTO</h4>
                        <form action="../rejectController" method = 'post' name="Form login">
                            <p>Motivo:</p>
                            <input type="text"/>
                            <input type="hidden" value="<%=id%>" name="VAR"/>
                            <input  id="btnDenied"   name="submit" type="submit" value="Denegar proyecto"/>
                        </form>
                        
                    </div>
                    
                </section>
                        
            </main>
    </body>
</html>
