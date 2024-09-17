<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioTexto" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioTextoImagen" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioVideo" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.AnuncioDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.CompraAnuncioDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pagina Principal (Inversionista)</title>
        <link rel="stylesheet" href="inversionista/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menú</h2>
            <ul>
                <li><a href="inversionista/comprar-anuncio-texto.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Comprar Anuncio de Texto</a></li>
                <li><a href="inversionista/comprar-anuncio-texto-imagen.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Comprar Anuncio de Texto e Imagen</a></li>
                <li><a href="inversionista/comprar-anuncio-video.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Comprar Anuncio de Video</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/PerfilServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Perfil</a></li>
                <li><a href="inversionista/recargar-credito.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Recargar Credito</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Inversionista: ${sessionScope.usuarioLogeado} ${usuarioLogeado.getNombre()}</h1>
            <%
                AnuncioDB dataAnuncios = new AnuncioDB();
                CompraAnuncioDB dataCredito = new CompraAnuncioDB();
                UsuarioAplicacion usuario = (UsuarioAplicacion) request.getAttribute("usuarioLogeado");
                int idInversionista = dataAnuncios.getIdInversionista(usuario.getIdUsuario());
            %>
            <h3>Este es tu Credito Actual: <%=dataCredito.getCredito(idInversionista)%></h3>
            <p>Estas son tus Anuncios Registradas en el Sistema</p>
            <%
                ArrayList<Anuncio> anuncios = new ArrayList<>();
                anuncios = dataAnuncios.getAnuncios(idInversionista);
                for(Anuncio anuncio : anuncios) {
                    if (anuncio instanceof AnuncioTexto) {
                        AnuncioTexto anuncioTexto = (AnuncioTexto) anuncio;
            %>
            <div>
                <h2>Anuncio de Texto</h2>
                <h3>Titulo: <%=anuncioTexto.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTexto.getContenido()%></p>
                <p>Vigencia en Dias: <%=anuncioTexto.getVigenciaDias()%></p>
                <p>Esta Activo: <%=anuncioTexto.isIsActivo()%></p>
                <p>Costo: <%=anuncioTexto.getPrecio()%></p>
                <a href="inversionista/editar-anuncio.jsp?id=<%=anuncioTexto.getIdAnuncio()%>">Editar</a>
            </div>
            <%
                    } else if (anuncio instanceof AnuncioTextoImagen) {
                        AnuncioTextoImagen anuncioTextoImagen = (AnuncioTextoImagen) anuncio;
            %>
            <div>
                <h2>Anuncio de Texto e Imagen</h2>
                <h3>Titulo: <%=anuncioTextoImagen.getTitulo()%></h3>
                <p>Contenido: <%=anuncioTextoImagen.getContenido()%></p>
                <img src="${pageContext.servletContext.contextPath}/ImageControlerAdServlet?id=<%=anuncioTextoImagen.getIdAdTextoImagen()%>" alt="Foto de perfil" class="profile-img" width="300px" height="300px">
                <p>Vigencia en Dias: <%=anuncioTextoImagen.getVigenciaDias()%></p>
                <p>Esta Activo: <%=anuncioTextoImagen.isIsActivo()%></p>
                <p>Costo: <%=anuncioTextoImagen.getPrecio()%></p>
                <a href="inversionista/editar-anuncio.jsp?id=<%=anuncioTextoImagen.getIdAnuncio()%>">Editar</a>
            </div>
            <%
                    } else if (anuncio instanceof AnuncioVideo) {
                        AnuncioVideo anuncioVideo = (AnuncioVideo) anuncio;
            %>
            <div>
                <h2>Anuncio de Video</h2>
                <h3>Titulo: <%=anuncioVideo.getTitulo()%></h3>
                <video src="${pageContext.servletContext.contextPath}/VideoControlerServlet?id=<%=anuncioVideo.getIdAnuncioVideo()%>" width="300" height="300" controls></video>
                <p>Vigencia en Dias: <%=anuncioVideo.getVigenciaDias()%></p>
                <p>Esta Activo: <%=anuncioVideo.isIsActivo()%></p>
                <p>Costo: <%=anuncioVideo.getPrecio()%></p>
                <a href="inversionista/editar-anuncio.jsp?id=<%=anuncioVideo.getIdAnuncio()%>">Editar</a>
            </div>
            <%
                    }
                }
            %>            
        </div> 
    </body>
</html>
