<%-- 
    Document   : formularioContacto
    Created on : Mar 14, 2023, 3:06:18 PM
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--CSS-->
        <link href="./CSS/formularioContacto.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
       <header>
            <a href="../getImagesController3"> > Volver</a>
        </header>
        
        <main>
            <h2>Formulario de contacto</h2>
            <h3>Escríbenos y en breve nos pondremos en contacto contigo</h3>
            <form id="myForm" action="../contactFormController" method = 'post' name="Formulario contacto" >
                    
                    <label for="fname">Nombre:</label>
                    <input type="text" name="name" required/>
                    <label for="fname">Apellido:</label>
                    <input type="text" name="lastname"  required/>
                    <label for="fname">Teléfono:</label>
                    <input type="text" name="tel" required pattern="[0-9]{9}"/>
                    <label for="email">Email:</label>
                    <input type="email" name="email"  required/>
                    <label for="email">Asunto:</label>
                    <input type="text" name="asunto"  required/>
                    <label for="fname">Mensaje:</label>
                    <textarea  type="text" name="mensaje"  required></textarea>
                    <input  id="submit" name="submit" type="submit" value="Enviar"/>
                </form>
            
        </main>
    </body>
</html>
