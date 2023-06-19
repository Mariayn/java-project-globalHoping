<%-- 
    Document   : userProfile
    Created on : Feb 8, 2023, 6:50:53 PM
    Author     : maria
--%>

<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MI PERFIL</title>
        <!--CSS-->
        <link href="./CSS/userProfile.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <% 
            User objUser = (User)session.getAttribute("objUserSession");
            String rol = objUser.getRol();
            String ADMIN = "admin";
            
            int id = objUser.getId();
            String name= objUser.getName();
            String lastName= objUser.getLastname();
            String email= objUser.getEmail();
            String cif;
            String add;
            String phone;
            if(objUser.getCif()==null || objUser.getCif() ==""){
                cif ="";
            }else{
                cif= objUser.getCif();
            }
            if(objUser.getAddress()==null || objUser.getAddress() ==""){
                add ="";
            }else{
                add= objUser.getAddress();
            }
            if(objUser.getPhone()==null || objUser.getPhone() ==""){
                phone ="";
            }else{
                phone= objUser.getPhone();
            }

        
            String USER = "user";
            %>
        
            <header>
                <div>
                    <a href="../getImagesController3"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
                </div>
            
                <% if(rol.equals(ADMIN)){ %>
                <a class="underline" href="../getProjectsController">Menú administrador</a>
                <%}%>
       
                <a class="underline"  href="../logoutController">Cerrar sesión <i class="fa-solid fa-plus"></i></a>
        </header>
                
                <nav>
                    <a href="../myDonationsController?VAR=<%=id%>">MIS DONACIONES</a>
 
                    <div class="tooltip">
                        <% if(cif.length()<1||add.length()<1||phone.length()<1){ %>
                        <a id="linker" href="#"  onmouseover="showMge();">CREAR RECAUDACIÓN</a>
                        <span class="tooltiptext"><small>Por favor, completa tus datos para empezar a crear un proyecto</small>.</span>
                        
                        <% }else{ %>
                        <a id="linker" href="../getImagesController">CREAR RECAUDACIÓN</a>
                        <% }%>
                    </div>
                </nav>
                
                <section>
                    <h2>Mis datos</h2>
                    
                    <form action="../updateProfileController" method = 'post' name="Form login">
                        <label for="email">Nombre:</label>
                        <input type="text" name="name" required value="<%=name%>"/>
                        <label for="email">Apellido:</label>
                        <input type="text" name="lastName" required value="<%=lastName%>"/>                  
                        <label for="email">Email:</label>
                        <input class="emailInput" type="email" name="email" required value="<%=email%>"/>
                        <label for="email" >CIF:</label>
                        <input id="cif" type="text" name="cif" maxlength="9" value="<%=cif%>"/>
                        <label for="email">Dirección:</label>
                        <input id="address" type="text" name="address"  value="<%=add%>"/>
                        <label for="email">Teléfono:</label>
                        <input id="phone" type="text" name="phone" maxlength="9" value="<%=phone%>"/>
                        
                        <input class="emailInput" id="submit" name="submit" type="submit" value="GUARDAR"/> 
                    </form>
                    
                    <a href="resetPassword.jsp">Cambiar contraseña</a>
                    
                </section>
        <script src="./JAVASCRIPT/functions.js"></script>
    </body>
</html>
