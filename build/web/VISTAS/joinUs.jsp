<%-- 
    Document   : joinUs
    Created on : Mar 21, 2023, 4:15:39 PM
    Author     : maria
--%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Trabaja con nosotros</title>
        <!--CSS-->
        <link href="./CSS/privacidad-politica.css" rel="stylesheet" type="text/css">
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
        <%
        String filename = "texto.txt";
        String path = application.getRealPath("/");
        String filepath = path + "/VISTAS/" + filename;
        File file = new File(filepath);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            out.println(line);
        }
        br.close();
        fr.close();
        
        %>
        </main>
    </body>
</html>
