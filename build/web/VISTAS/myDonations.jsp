<%-- 
    Document   : myDonations
    Created on : Mar 15, 2023, 10:29:00 AM
    Author     : maria
--%>

<%@page import="MODELO.project_donation"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MIS DONACIONES</title>
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
                    <a href="userProfile.jsp"><i class="fa-solid fa-bars"></i>  Ir a mi perfil</a>
            </div>
            
            <section>
                <caption>Proyectos a los que he donado</caption>
                    <table>
                        <tr>
                            <th>Nombre del proyecto</th>
                            <th>Creado por</th>
                            <th>Cantidad donada</th>
                            <th>Estado del proyecto</th>
                        </tr>
                        
                        <% 
                            for(project_donation objProject : (ArrayList<project_donation>)session.getAttribute("objArrayDonations")){
                        %>
                        <tr>
                            <td><%=objProject.getProjectTitle()%></td>
                            <td><%=objProject.getName()%></td>
                            <td><%=(int)objProject.getAmount()%></td>
                            <td><%=objProject.getStatus()%></td>
                        </tr>
                        <%
                         }  
                         
                         %>
                        
                    </table>
                    
                </section>
        </main>
        
        
    </body>
</html>
