<%-- 
    Document   : mainView
    Created on : Jan 30, 2023, 12:22:00 AM
    Author     : maria
--%>

<%@page import="MODELO.Images"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODELO.Project"%>
<%@page import="MODELO.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>Donación a proyectos solidarios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--CSS-->
        <link href="./CSS/style.css" rel="stylesheet" type="text/css">
        <!--GOOGLE FONTS-->
        <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;700&family=Open+Sans:wght@300;400;500&display=swap" rel="stylesheet">
        <!--FONT AWESOME-->
        <script src="https://kit.fontawesome.com/68ca212b88.js" crossorigin="anonymous"></script>
      
    </head>
    <body>
        <%
        String Vcookie = (String)session.getAttribute("cookie");
        if(Vcookie!="1" || Vcookie=="" || Vcookie==null){
        %>
        <div class="cookies-box" >
            <div class="container-cookies">
                <div class="parrafo">
                    Las cookies son importantes para el correcto funcionamiento del sitio. Para mejorar su experiencia de navegación, usamos cookies para recordar sus datos de inicio de sesión y 
                    brindarle un inicio seguro, recopilar estadísticas para optimizar la funcionalidad del sitio y ofrecerle contenido personalizado en función de sus intereses. 
                    Haga clic en “Aceptar" para  continuar navegando o, haga clic en “Más información” para ver la descripción detallada de los tipos de cookies y 
                    decidir si acepta ciertas cookies mientras navega en el sitio.
                    <a href="./VISTAS/privacidad-politica.php">Más información</a>
                </div>
                <div class="botones">
                    <button onclick="closeModal()">Aceptar</button>
              
                </div>
            </div>
        </div>
        <% } %>
        
        
        
        <% 
            User objUser = (User)session.getAttribute("objUserSession");
            //String rol = objUser.getRol();
            String ADMIN = "admin";
            String USER = "user";
            String clave= "explore";
            %>
        <header>
            <img id="logo" src="./IMG/logo.png" alt="logo de la empresa">
            
            <div>
                <a href="../getAllProjectsController?VAR=<%=clave%>">
                    EXPLORAR PROYECTOS
                    <i class="fa-solid fa-magnifying-glass"></i>
                </a>
            </div>

            <% if(objUser==null){ %>
            <a href="login.jsp">Iniciar sesión  <i class="fa-solid fa-right-to-bracket"></i> </a>
            <%} else { %>
            <div>
            <a href="../logoutController">Cerrar sesión</a>
            <a href="userProfile.jsp" id = "profile" ><i class="fa-regular fa-user"></i></a>
            </div>
        <%}%>
        </header>
        
        <main>
            <div id="title">
                <h2>Apoya una causa que te importe</h2>
            </div>
            
            <!-- NEWS CARDS -->
            <div class="news-cards">
                <% 
                            for (Project objProject : (ArrayList<Project>)session.getAttribute("objArrayPopularProjects")){
                                if(objProject.getStatus().equals("active")){
                            for(Images objImages : (ArrayList<Images>)session.getAttribute("objArrayImages")){
                                if(Integer.parseInt(objProject.getImg()) == objImages.getId()){
                            
                                    
                        %>
                <div class="divProject">
                    <img class="imgProject" src="<%=objImages.getRuta()%>" alt="News 1">
                    
                    <h3><%=objProject.getTitle()%></h3>
                    <div class="content">
                        <a class="text_shadows" href="../getAllProjectsController?VAR=<%=objProject.getId()%>" >DONAR <i class="fas fa-angle-double-right"></i></a>
                    </div>
                    
                </div>
                <%
                            }    }
                         }   }
                         %>
            </div>    
            
            <section id ="text">
            <div>
            <h2>DAR ALIENTA A AMIGOS Y FAMILIAS A HACER LO MISMO</h2>
            <p>
                Nuestras propias donaciones caritativas hermosas pueden inspirar a nuestros seres queridos más cercanos a dar a las causas importantes para ellos, e incluso podrían generar un esfuerzo a nivel familiar para respaldar una organización benéfica que tienen un significado especial para la familia o grupo de amigos.
            </p>
            </div>
            <div>
                <img id="image" src="./IMG/pic1.png" alt="Hombre alimentado a un cachorro" >
            </div>
        </section>
            
        </main>
        
        
        
        <footer>
        
            <div class="container">

              <div class="footer__links col1">
                    <a href="#">Sobre Nosotros</a>
                    <a href="#">Responsabilidad</a>
                    <a href="formularioContacto.jsp">Contacto</a>
              </div>

              <div class="footer__links col2">
                  <a href="joinUs.jsp">Trabaja con nosotros</a>
                    <a href="politica-privicidad.jsp">Política de Privacidad</a>
                    <a href="#">Información adicional</a>
              </div>

              <div class="footer__social">
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20">
                            <title>Facebook</title>
                            <path
                              fill="#ffffff"
                              d="M18.896 0H1.104C.494 0 0 .494 0 1.104v17.793C0 19.506.494 20 1.104 20h9.58v-7.745H8.076V9.237h2.606V7.01c0-2.583 1.578-3.99 3.883-3.99 1.104 0 2.052.082 2.329.119v2.7h-1.598c-1.254 0-1.496.597-1.496 1.47v1.928h2.989l-.39 3.018h-2.6V20h5.098c.608 0 1.102-.494 1.102-1.104V1.104C20 .494 19.506 0 18.896 0z"
                            />
                        </svg>
                    </a>

                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="20">
                          <title>YouTube</title>
                          <path
                            fill="#ffffff"
                            d="M10.333 0c-5.522 0-10 4.478-10 10 0 5.523 4.478 10 10 10 5.523 0 10-4.477 10-10 0-5.522-4.477-10-10-10zm3.701 14.077c-1.752.12-5.653.12-7.402 0C4.735 13.947 4.514 13.018 4.5 10c.014-3.024.237-3.947 2.132-4.077 1.749-.12 5.651-.12 7.402 0 1.898.13 2.118 1.059 2.133 4.077-.015 3.024-.238 3.947-2.133 4.077zM8.667 8.048l4.097 1.949-4.097 1.955V8.048z"
                          />
                        </svg>
                      </a>

                      <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="18">
                          <title>Twitter</title>
                          <path
                            fill="#ffffff"
                            d="M20.667 2.797a8.192 8.192 0 01-2.357.646 4.11 4.11 0 001.804-2.27 8.22 8.22 0 01-2.606.996A4.096 4.096 0 0014.513.873c-2.649 0-4.595 2.472-3.997 5.038a11.648 11.648 0 01-8.457-4.287 4.109 4.109 0 001.27 5.478A4.086 4.086 0 011.47 6.59c-.045 1.901 1.317 3.68 3.29 4.075a4.113 4.113 0 01-1.853.07 4.106 4.106 0 003.834 2.85 8.25 8.25 0 01-6.075 1.7 11.616 11.616 0 006.29 1.843c7.618 0 11.922-6.434 11.662-12.205a8.354 8.354 0 002.048-2.124z"
                          />
                        </svg>
                      </a>

                      <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="20">
                          <title>Instagram</title>
                          <path
                            fill="#ffffff"
                            d="M10.333 1.802c2.67 0 2.987.01 4.042.059 2.71.123 3.976 1.409 4.1 4.099.048 1.054.057 1.37.057 4.04 0 2.672-.01 2.988-.058 4.042-.124 2.687-1.386 3.975-4.099 4.099-1.055.048-1.37.058-4.042.058-2.67 0-2.986-.01-4.04-.058-2.717-.124-3.976-1.416-4.1-4.1-.048-1.054-.058-1.37-.058-4.041 0-2.67.01-2.986.058-4.04.124-2.69 1.387-3.977 4.1-4.1 1.054-.048 1.37-.058 4.04-.058zm0-1.802C7.618 0 7.278.012 6.211.06 2.579.227.56 2.242.394 5.877.345 6.944.334 7.284.334 10s.011 3.057.06 4.123c.166 3.632 2.181 5.65 5.816 5.817 1.068.048 1.408.06 4.123.06 2.716 0 3.057-.012 4.124-.06 3.628-.167 5.651-2.182 5.816-5.817.049-1.066.06-1.407.06-4.123s-.011-3.056-.06-4.122C20.11 2.249 18.093.228 14.458.06 13.39.01 13.049 0 10.333 0zm0 4.865a5.135 5.135 0 100 10.27 5.135 5.135 0 000-10.27zm0 8.468a3.333 3.333 0 110-6.666 3.333 3.333 0 010 6.666zm5.339-9.87a1.2 1.2 0 10-.001 2.4 1.2 1.2 0 000-2.4z"
                          />
                        </svg>
                      </a>

              </div>

              <div class="copyright">
                &copy; GlobalHoping. Todos los derechos reservados.
            </div>

            </div>
        </footer>
    
        <script src="./JAVASCRIPT/functions.js"></script>
    </body>
</html>

