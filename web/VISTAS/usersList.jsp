<%-- 
    Document   : usersList
    Created on : Mar 20, 2023, 10:38:12 PM
    Author     : maria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Usuarios</title>
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
                <caption>Usuarios</caption>
                    <table>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>CIF</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                        </tr>
                        
                        <% 
                            for(User userObj : (ArrayList<User>)session.getAttribute("objArrayUsersList")){

                                String cif;
                                String add;
                                String phone;
                                if(userObj.getCif()==null || userObj.getCif() ==""){
                                    cif ="";
                                }else{
                                    cif= userObj.getCif();
                                }
                                if(userObj.getAddress()==null || userObj.getAddress() ==""){
                                    add ="";
                                }else{
                                    add= userObj.getAddress();
                                }
                                if(userObj.getPhone()==null || userObj.getPhone() ==""){
                                    phone ="";
                                }else{
                                    phone= userObj.getPhone();
                                }
                        %>
                        <tr>
                            <td><%=userObj.getName()%></td>
                            <td><%=userObj.getLastname()%></td>
                            <td><%=userObj.getEmail()%></td>
                            <td><%=cif%></td>
                            <td><%=add%></td>
                            <td><%=phone%></td>
                        </tr>
                        <%
                         
                         }
                         %>
                        
                    </table>
                    
                </section>
        </main>
                         
    </body>
</html>
