<%-- 
    Document   : login
    Created on : Feb 1, 2023, 11:35:39 PM
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
        <!--CSS-->
        <link href="./CSS/login.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <header>
            <div>
                    <a href="../getImagesController3"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
            </div>
        </header>
        
        <main>
                <div id="signup">
                    <p>¿No tienes una cuenta?</p>
                    <a href="register.jsp"> Regístrate</a>
                </div>
            
                <form action="../loginController" method = 'post' name="Form login" >
                    <label for="email">Email:</label><br>
                    <input class="emailInput" type="email" name="email" required/>
                    
                    <label for="pass">Contraseña:</label><br>
                    <input class="emailInput" type="password" name="pass" maxlength="15" minlength="6" required/>

                    <input class="emailInput" id="submit" name="submit" type="submit" value="Iniciar sesión"/>       
                </form>
 
        </main>
        
    </body>
</html>
