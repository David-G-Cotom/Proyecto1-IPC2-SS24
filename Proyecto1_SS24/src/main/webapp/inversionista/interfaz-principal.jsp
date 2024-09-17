<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.AnuncioDB" %>
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
            <p>Estas son tus Anuncios Registradas en el Sistema</p>
            <%
                ArrayList<Anuncio> anuncios = new ArrayList<>();
                AnuncioDB dataAnuncios = new AnuncioDB();
                UsuarioAplicacion usuario = (UsuarioAplicacion) request.getAttribute("usuarioLogeado");
                int idInversionista = dataAnuncios.getIdInversionista(usuario.getIdUsuario());
                anuncios = dataAnuncios.getAnuncios(idInversionista);
                for(Anuncio anuncio : anuncios) {
                    String tipoAnuncio = "";
                    switch (anuncio.getIdTipoAnuncio()) {
                        case 1: tipoAnuncio = "Anuncio de Texto";
                            break;
                        case 2: tipoAnuncio = "Anuncio de Texto e Imagen";
                            break;
                        case 3: tipoAnuncio = "Anuncio de Video";
                            break;
                    }
            %>
            <div>
                <h2>Tipo de Anuncio: <%=tipoAnuncio%></h2>
                <p>Vigencia en Dias: <%=anuncio.getVigenciaDias()%></p>
                <p>Esta Activo: <%=anuncio.isIsActivo()%></p>
                <p>Costo: <%=anuncio.getPrecio()%></p>
                <a href="inversionista/editar-anuncio.jsp?id=<%=anuncio.getIdAnuncio()%>">Editar</a>
            </div>
            <%
                }
            %>            
        </div> 
    </body>
</html>
