<%-- 
    Document   : error
    Created on : Mar 14, 2023, 11:40:05 PM
    Author     : maria
--%>

<%@page import="MODELO.myException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENSAJE DE ERROR</title>
        <!--CSS-->
        <link href="./CSS/error.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <main>
       
            <section>
                
                <div>
                    <%
                        myException ex = (myException)session.getAttribute("exception");
                    %>
                    
                    <h3>¡Error!</h3>
                    <p><%=ex.getMensaje()%></p>
                    <p>Código:<%=ex.getCodigo()%> -  Ocurrido en: <%=ex.getUbicacion()%></p>
                    <a id="back" href="<%=ex.getUrl() %>"> <p> > Volver </p></a>
                </div>
                
                <div id="divSvg">
                    <svg aria-hidden="true" class="valign-middle icon___7kqQL" focusable="false" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24" style="width: 34px; height: 34px; overflow: visible; fill: currentcolor;"><path d="M13 7h-2v6h2V7zm-1 15c5.52 0 10-4.48 10-10S17.52 2 12 2 2 6.48 2 12s4.48 10 10 10zm0-18c4.41 0 8 3.59 8 8s-3.59 8-8 8-8-3.59-8-8 3.59-8 8-8zm1 11h-2v2h2v-2z"></path></svg>               
                 </div>   
                 
            </section>
            
            
        </main>
    </body>
</html>
