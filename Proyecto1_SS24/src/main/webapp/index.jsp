<%-- 
    Document   : index
    Created on : 5/09/2024, 12:42:19
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.Revista" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioTexto" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioTextoImagen" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioVideo" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.MostrarAnunciosControler" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.PreciosRevistaDB" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Blog de Revistas</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <nav id="navbar">
            <ul>
                <li><a href="log/inicio-sesion.jsp">Iniciar Sesion</a></li>
                <li><a href="log/registro-usuario.jsp">Registrarse</a></li>
            </ul>
        </nav>
        <%
            MostrarAnunciosControler dataAnuncios = new MostrarAnunciosControler(); 
            ArrayList<Anuncio> anunciosIzquierda = dataAnuncios.getAnunciosIzquierda();
            ArrayList<Anuncio> anunciosDerecha = dataAnuncios.getAnunciosDerecha();
        %>
        <div id="left-sidebar" class="sidebar">
            <%
                for(Anuncio anuncio : anunciosIzquierda) {
                    if (anuncio instanceof AnuncioTexto) {
                        AnuncioTexto anuncioTexto = (AnuncioTexto) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Texto</h2>
                <h3>Titulo: <%=anuncioTexto.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTexto.getContenido()%></p>
            </div>
            <%
                    } else if (anuncio instanceof AnuncioTextoImagen) {
                        AnuncioTextoImagen anuncioTextoImagen = (AnuncioTextoImagen) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Texto e Imagen</h2>
                <h3>Titulo: <%=anuncioTextoImagen.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTextoImagen.getContenido()%></p>
                <img src="${pageContext.servletContext.contextPath}/ImageControlerAdServlet?id=<%=anuncioTextoImagen.getIdAdTextoImagen()%>" alt="Foto de perfil" class="profile-img" width="200px" height="200px">
            </div>
            <%
                    } else if (anuncio instanceof AnuncioVideo) {
                        AnuncioVideo anuncioVideo = (AnuncioVideo) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Video</h2>
                <h3>Titulo: <%=anuncioVideo.getTitulo()%></h3>
                <video src="${pageContext.servletContext.contextPath}/VideoControlerServlet?id=<%=anuncioVideo.getIdAnuncioVideo()%>" width="200" height="200" controls></video>                
            </div>
            <%
                    }
                }
            %>   
        </div>
        <div id="content-block">
            <%
                ArrayList<Revista> revistas = new ArrayList<>();
                PreciosRevistaDB dataRevistas = new PreciosRevistaDB();
                revistas = dataRevistas.getAllRevistas();
                for(Revista revista : revistas) {
            %>
            <div>
                <h2>Nombre de Revista: <%=revista.getNombreRevista()%></h2>
                <p>Descripcion: <%=revista.getDescripcion()%></p>
                <p>Categoria: <%=revista.getCategoria()%></p>
                <p>Etiquetas: <%=revista.getEtiquetas()%></p>
                <p>Nombre del Autor: <%=revista.getAutor().getNombre()%></p>
                <p>Likes: <%=revista.getLikes()%></p>
                <button type="button" onclick="alert('Antes, Debes Registrarte o Iniciar Sesion como Suscriptor')">Suscribirse</button>
            </div>                    
            <%    
                }
            %>
        </div>
        <div id="right-sidebar" class="sidebar">
            <%
                for(Anuncio anuncio : anunciosDerecha) {
                    if (anuncio instanceof AnuncioTexto) {
                        AnuncioTexto anuncioTexto = (AnuncioTexto) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Texto</h2>
                <h3>Titulo: <%=anuncioTexto.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTexto.getContenido()%></p>
            </div>
            <%
                    } else if (anuncio instanceof AnuncioTextoImagen) {
                        AnuncioTextoImagen anuncioTextoImagen = (AnuncioTextoImagen) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Texto e Imagen</h2>
                <h3>Titulo: <%=anuncioTextoImagen.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTextoImagen.getContenido()%></p>
                <img src="${pageContext.servletContext.contextPath}/ImageControlerAdServlet?id=<%=anuncioTextoImagen.getIdAdTextoImagen()%>" alt="Foto de perfil" class="profile-img" width="200px" height="200px">
            </div>
            <%
                    } else if (anuncio instanceof AnuncioVideo) {
                        AnuncioVideo anuncioVideo = (AnuncioVideo) anuncio;
            %>
            <div class="sidecontent">
                <h2>Anuncio de Video</h2>
                <h3>Titulo: <%=anuncioVideo.getTitulo()%></h3>
                <video src="${pageContext.servletContext.contextPath}/VideoControlerServlet?id=<%=anuncioVideo.getIdAnuncioVideo()%>" width="200" height="200" controls></video>                
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
