<%-- 
    Document   : projectsList
    Created on : Mar 6, 2023, 9:04:10 PM
    Author     : maria
--%>

<%@page import="MODELO.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de proyectos en marcha</title>
        <!--CSS-->
        <link href="./CSS/projectsList.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <main>
            <div>
                    <a href="menuAdmin.jsp"><i class="fa-solid fa-bars"></i> Menu administrador</a>
            </div>
            
            <section>
                <caption>Proyectos en marcha</caption>
                    <table>
                        <tr>
                            <th>Nombre del proyecto</th>
                            <th>Creado por</th>
                            <th>Fecha de creación </th>
                            <th>Objetivo de recaudación</th>
                            <th>Recaudado</th>
                        </tr>
                        
                        <% 
                            for(Project objProject : (ArrayList<Project>)session.getAttribute("objArrayProjects")){
                                if(objProject.getStatus().equals("active")){
                                    System.out.println("1->" + objProject.getStatus());
                                
                        %>
                        <tr>
                            <td><%=objProject.getTitle()%></td>
                            <td><%=objProject.getName()%></td>
                            <td><%=objProject.getCurrentDate()%></td>
                            <td><%=(int)objProject.getGoal()%></td>
                            <td><%=(int)objProject.getAmount_raised()%></td>
                        </tr>
                        <%
                         }   
                         }
                         %>
                        
                    </table>
                    
                </section>
        </main>
    </body>
</html>
