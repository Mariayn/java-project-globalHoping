<%-- 
    Document   : createFundraiser
    Created on : Feb 13, 2023, 12:11:58 AM
    Author     : maria
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Images"%>
<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear recaudación de fondos</title>
        <!--CSS-->
        <link href="./CSS/createFund.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
        <!--JS-->
        <script src="./JAVASCRIPT/functions.js" type="text/javascript"></script>
    </head>
    <body>
        <% 
            User objUser = (User)session.getAttribute("objUserSession");
            String name= objUser.getName();

            String rol = objUser.getRol();
            String ADMIN = "admin";
            String USER = "user";
            %>
            
            <header>
                <div>
                    <a href="#"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
                </div>
            
                <% if(rol.equals(ADMIN)){ %>
                <a href="#">Menú administrador</a>
                <%}%>
       
                <a href="../logoutController">Cerrar sesión <i class="fa-solid fa-plus"></i></a>
          </header>
                
                <nav>
                    <a href="userProfile.jsp">Volver a mi perfil</a>
                </nav>
                
                <section> 
                    
                    <form action="../registerFundraiserController" method = 'post' name="Form login" id="myForm">
                        <div id = "fundraiserDatas">
                            <h1>Crear una recaudación de fondos</h1>
                            <label for="email">TÍTULO DE LA RECAUDACIÓN DE FONDOS</label>
                            <input type="text" name="title" required />
                            <label for="email">TU NOMBRE</label>
                            <input type="text" name="name" required />
                            <label for="desc">DESCRIPCIÓN</label>
                            <textarea type="text"name="description" required></textarea>
                            <label for="email">OBJETIVO DE LA RECAUDACIÓN</label>
                            <input type="number" name="goal" required />
                         
                            
                        </div>
                        
                        <div>
                            <h5>SELECCIONA ALGUNA FOTO(opcional)</h5>
                            <div id="fundraiserImages">

                                <% 
                                for(Images objImages : (ArrayList<Images>)session.getAttribute("objArrayImages")){
                                %>
                                <div>
                                    <input required name="radioName" type="radio"  value="<%=objImages.getId()%>" />
                                    <img src="<%=objImages.getRuta()%>" />
                                </div>
                                    <%
                                        }
                                     %>
                            </div>
                             <input class="emailInput" id="submit" name="submit" type="submit" value="CREAR RECAUDACIÓN"/> 
                       </div>
                        
                       
                        
                    </form>
                        <!--< <button type="button" onclick="displayRadioValue()">Submit</button>    style="display: none;"
                        -->
                    
                </section>

    </body>
</html>
