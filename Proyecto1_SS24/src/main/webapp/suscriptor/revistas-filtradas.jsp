<%-- 
    Document   : revistas-filtradas
    Created on : 13/09/2024, 03:54:00
    Author     : Carlos Cotom
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.Revista" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.SuscripcionDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.data.SuscriptorDB" %>
<%@page import="com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Revistas Filtradas</title>
        <link rel="stylesheet" href="suscriptor/style-revistas-filtradas.css">
    </head>
    <body>
        <div class="content">
            <div class="revistas-container">
                <h2 style="text-align: center;">Revistas Suscritas con el Filtro</h2>
                <%
                    ArrayList<Revista> revistas = (ArrayList<Revista>) request.getAttribute("revistasFiltradas");
                    SuscripcionDB dataRevistas = new SuscripcionDB();
                    SuscriptorDB dataSuscripcion = new SuscriptorDB();
                    int idUsuario = (int) request.getAttribute("idUsuario");
                    int idSuscriptor = dataRevistas.getIdSuscriptor(idUsuario);
                    for(Revista revista : revistas) {
                %>
                    <div>
                        <h3>Nombre de Revista: <%=revista.getNombreRevista()%></h3>
                        <p>Descripcion de Revista: <%=revista.getDescripcion()%></p>
                        <p>Categoria: <%=revista.getCategoria()%></p>
                        <p>Etiquetas: <%=revista.getEtiquetas()%></p>
                        <a href="${pageContext.servletContext.contextPath}/PdfControlerServlet?id=<%=revista.getIdRevista()%>">Leer</a>                   
                        <a href="${pageContext.servletContext.contextPath}/PdfControlerServlet?id=<%=revista.getIdRevista()%>">Descargar</a>
                        <a href="suscriptor/nuevo-comentario.jsp?revista=<%=revista.getIdRevista()%>&id=<%=request.getAttribute("idUsuario")%>">Comentar</a>                   
                        <a href="${pageContext.servletContext.contextPath}/PerfilEditorServlet?id=<%=revista.getAutor().getIdEditor()%>">Perfil de Autor</a>
                        <%
                            if(!dataSuscripcion.revistaConLike(revista.getIdRevista(), idSuscriptor)) {
                        %>
                        <a href="${pageContext.servletContext.contextPath}/LikeServlet?revista=<%=revista.getIdRevista()%>&id=<%=request.getAttribute("idUsuario")%>">Dar Like</a>                            
                        <%
                            }
                        %>
                        <hr>
                    </div>
                <%
                    }
                %>
            </div>           
        </div>
    </body>
</html>
