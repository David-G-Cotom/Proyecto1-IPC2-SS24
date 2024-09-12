<%-- 
    Document   : nueva-suscripcion
    Created on : 7/09/2024, 00:04:44
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.Revista" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.SuscripcionDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Revistas no Suscritas</title>
        <link rel="stylesheet" href="style-suscripcion.css">
    </head>
    <body>
        <div class="content">
            <h1>Revistas NO Suscritas</h1>
            <%
                ArrayList<Revista> revistas = new ArrayList<>();
                SuscripcionDB dataRevistas = new SuscripcionDB();
                String id = (String) request.getParameter("id");
                System.out.println(id);
                int idUsuario = Integer.parseInt(id);
                revistas = dataRevistas.getRevistasNoSuscritas(idUsuario);
                System.out.println(revistas);
                for(Revista revista : revistas) {
            %>
                <div>
                    <h2>Nombre de Revista: <%=revista.getNombreRevista()%></h2>
                    <p>Descripcion de Revista: <%=revista.getDescripcion()%></p>
                    <p>Categoria: <%=revista.getCategoria()%></p>
                    <p>Etiquetas: <%=revista.getEtiquetas()%></p>
                    <p>Nombre del Autor: <%=revista.getAutor().getNombre()%></p>
                    <p>Likes: <%=revista.getLikes()%></p>
                    <a href="editor/editar-revista.jsp?id=<%=revista.getIdRevista()%>" target="_blank">Suscribir</a>
                </div>
            <%
                }
            %>
        </div>
    </body>
</html>
