<%-- 
    Document   : message
    Created on : Feb 8, 2023, 12:07:06 AM
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje de registro</title>
        <!--CSS-->
        <link href="./CSS/mge2.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <main>
            
            
            <section>
                <div>
                    
                    <%
                        String mge = request.getParameter("VAR");
                        System.out.println(mge);
                        if(mge.equals("Mensaje enviado.")){
                        %>
                        <h3> <%=mge%></h3>
                        <a href="../getImagesController3"> Ir al menu principal</a>
                        <%}else{%>
                        <h3> <%=mge%></h3>
                        <a href="userProfile.jsp"> > Ir a mi  perfil</a>
                        <%}%>
                 </div>
                 
      
           </section>
            
         </main>
        
    </body>
</html>
