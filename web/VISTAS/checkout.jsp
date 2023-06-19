<%-- 
    Document   : checkout
    Created on : Mar 7, 2023, 6:07:22 PM
    Author     : maria
--%>

<%@page import="MODELO.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Project"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CHECKOUT</title>
         <!--CSS-->
        <link href="./CSS/checkout.css" rel="stylesheet" type="text/css">
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
        %>
        <header>
            <a href="mainView.jsp"><img id="logo" src="./IMG/logo.png" alt="logo"></a>
            
            <% if(objUser==null){ %>
            <a href="login.jsp">Iniciar sesión </a>
            <%} else { %>
            <div>
            <a href="../logoutController">Cerrar sesión</a>
            <a href="userProfile.jsp" id = "profile" ><i class="fa-regular fa-user"></i></a>
            </div>
        <%}%>
        </header>
        
        <main>
            <%
                
                String idProj = request.getParameter("myVar");
                System.out.println("LINEA 55" + idProj);
                
                for (Project objProject : (ArrayList<Project>)session.getAttribute("objArrayAllProjects")){
                    if(objProject.getId() == Integer.parseInt(idProj)){
                        System.out.println(objProject.getTitle());
            %>
            
            <h1><%=objProject.getTitle()%></h1>
            <span> por  <strong> <%=objProject.getName()%></strong></span>
            
            <div id ="container">  
                <section id="summaryDiv">

                    <div id="summary">
                        <h4>Resumen</h4>
                        <p><%=objProject.getDescription()%></p>
                    </div>

                    <div id="datos">
                        <p><strong><%=(int)objProject.getAmount_raised()%> </strong>€ recaudados de <strong> <%=(int)objProject.getGoal()%></strong> €  la meta</p>
                        <p>Faltan  <strong><%=(int)(objProject.getGoal() - objProject.getAmount_raised())%>€ </strong> para llegar a la meta</p>
                    </div>

                </section>
            
            <section id="checkout">
                <h3>Donar a <strong><%=objProject.getTitle()%></strong></h3>
                
              
             <div>
             
                   
                 <form action="../checkoutController" method = 'post' name="donate to">
                    <input type="hidden" id="custId" name="projId" value="<%=idProj%>">

                    <%if(objUser!=null){ 
                     int id = objUser.getId();
                    String myId =String.valueOf(id);

                    String name;
                    String lastName;
                    String email;
                    name= objUser.getName();
                    lastName= objUser.getLastname();
                    email= objUser.getEmail();
                     %>     
                         <input type="hidden" id="custId" name="userId" value="<%=myId%>">
                         <input type="hidden" id="custId" name="goal" value="<%=objProject.getGoal()%>">
                         <input type="hidden" id="custId" name="raised" value="<%=objProject.getAmount_raised()%>">
                         <div>
                             <input value="<%=name + " " + lastName%>" type="text" name="nom" placeholder="Nombre completo" readonly />
                            <input value="<%=email%>" type="email" name="email" placeholder="Email" readonly />
                         </div>
                     <%}else{%> 
                        <div>
                             <input value="" type="text" name="nom" placeholder="Nombre completo" required/>
                            <input value="" type="email" name="email" placeholder="Email" required/>
                         </div>
            <%}%>
                        <div>
                             <input class="input" required pattern="[0-9]{16}" placeholder="Número de la tarjeta"  type="text" name="numero_tarjeta" />
                             <div>
                                 <input id="expirationDate" class="input" required pattern="(?:0[1-9]|1[0-2])/[0-9]{2}" placeholder="Caducidad"  type="text" name="caducidad"/>
                                 <input class="input" required pattern="[0-9]{3}"  placeholder="CVV"  type="text" name="cvv"/>
                             </div>
                        </div>

                        <div class="checkbox">
                            <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>
                            Sí, envíeme un correo electrónico con actualizaciones sobre cómo se ha utilizado mi donación.
                        </div>
                        <div class="checkbox">
                            <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike" required>
                            * He leído y acepto los términos de servicio, costos de transacción y política de privacidad.
                        </div>

                        <div id="divAmount">
                            <div id="amount">
                                <input required type="number" name="amount">
                                <span>€</span>
                            </div>
                            
                            <div>
                                <%if(objUser==null){ %>
                                <input  value="DONAR" id="submit" name="submit" type="submit" disabled>           
                                
                                 <%}else{%>
                                 <input value="DONAR" id="submit" name="submit" type="submit">
                                 <%}%>
                                 
                                 
                             </div>
                             
                        </div>
                     
                 </form>
                                
             </div>
               <%if(objUser==null){ %>
               <span id="mje">*Por favor inicia sesión para realizar una donación</span> 
               <%}%>
            </section>
            <%
             }    }
             %>
        </div>
        </main>
    </body>
</html>
