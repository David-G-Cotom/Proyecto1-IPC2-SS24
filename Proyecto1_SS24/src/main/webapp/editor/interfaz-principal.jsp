<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.Revista" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.RevistaDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pagina Principal (Editor)</title>
        <link rel="stylesheet" href="editor/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menú</h2>
            <ul>
                <li><a href="editor/nueva-revista.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Crear Revista</a></li>
                <li><a href="perfil/perfil-usuarios.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Perfil</a></li>
                <li><a href="#">Reporte de Comentarios</a></li>
                <li><a href="#">Reporte de Suscripciones</a></li>
                <li><a href="#">Reporte de Revistas Top</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Autor: ${sessionScope.usuarioLogeado} ${usuarioLogeado.getNombre()}</h1>
            <p>Estas son tus Revistas Registradas en el Sistema</p>
            <%
                ArrayList<Revista> revistas = new ArrayList<>();
                RevistaDB dataRevistas = new RevistaDB();
                UsuarioAplicacion usuario = (UsuarioAplicacion) request.getAttribute("usuarioLogeado");
                int idEditor = dataRevistas.getIdEditor(usuario.getIdUsuario());
                revistas = dataRevistas.getRevistas(idEditor);
                for(Revista revista : revistas) {
            %>
                <div>
                    <h2>Nombre de Revista: <%=revista.getNombreRevista()%></h2>
                    <p>Descripcion de Revista: <%=revista.getDescripcion()%></p>
                    <p>Categoria: <%=revista.getCategoria()%></p>
                    <p>Etiquetas: <%=revista.getEtiquetas()%></p>
                    <p>Likes: <%=revista.getLikes()%></p>
                    <a href="editor/editar-revista.jsp?id=<%=revista.getIdRevista()%>">Editar</a>
                </div>
            <%
                }
            %>          
        </div> 
    </body>
</html>
