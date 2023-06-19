<%-- 
    Document   : mgeMainView
    Created on : Feb 9, 2023, 5:31:00 PM
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <section>
                
                    <%
                        String mge = request.getParameter("VAR");
                        System.out.println(mge);
                        %>
              
                        <h3> <%=mge%></h3>
                        <a href="mainView.jsp"> Ir a inicio</a>
                
           </section>
        
    </body>
</html>
