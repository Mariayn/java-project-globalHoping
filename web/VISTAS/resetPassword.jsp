<%-- 
    Document   : resetPassword
    Created on : Feb 12, 2023, 11:58:33 AM
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset password</title>
        <!--CSS-->
        <link href="./CSS/resetPassword.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
        <!--JS-->
        <script src="./JAVASCRIPT/functions.js" type="text/javascript"></script>
    </head>
    <body>
        
        <header>
            <a href="userProfile.jsp"> > Volver</a>
        </header>
        
        <main>
            
            <h3>Cambiar contraseña</h3>
            <p>Por favor ingresa tu nueva contraseña dos veces. La contraseña debe tener mínimo 6 caracteres, entre letras y números.</p>
            
            <form onSubmit = "return verifyPass(this)" action="../changePassController" method = 'post' name="Form login" >
                <div>
                    <label for="pass" >NUEVA CONTRASEÑA:</label>
                    <input id="pass" type="password" name="pass" maxlength="15" minlength="6" required/>
                </div>
                <div>
                    <label for="pass" >REPETIR NUEVA CONTRASEÑA:</label>
                    <input id="pass2" type="password" name="pass2" maxlength="15" minlength="6" required/>
                </div>
                <input class="emailInput" id="submit" name="submit" type="submit" value="GUARDAR"/>
            </form>
            
        </main>
        
    </body>
</html>
