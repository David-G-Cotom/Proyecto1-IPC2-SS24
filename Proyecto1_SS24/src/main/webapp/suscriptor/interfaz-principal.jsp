<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
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
        <title>Pagina Principal (Suscriptor)</title>
        <link rel="stylesheet" href="suscriptor/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menu</h2>
            <ul>
                <li><a href="suscriptor/suscripcion.jsp?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Suscribir Revista</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/PerfilServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Perfil</a></li>
                <li><a href="index.jsp">Cerrar Sesion</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Suscriptor: ${sessionScope.usuarioLogeado} ${usuarioLogeado.getNombre()}</h1>
            <div class="form-container">
                <h2>Busqueda de Revistas Suscritas</h2>
                <form method="GET" action="${pageContext.servletContext.contextPath}/FiltroRevistasServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">
                    <h3>Filtrar por Categorias</h3>
                    <input type="hidden" name="id" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">
                    <div class="checkbox-group">
                        <label><input type="checkbox" name="categorias" value="SOFTWARE"> SOFTWARE</label>
                        <label><input type="checkbox" name="categorias" value="IA"> IA</label>
                        <label><input type="checkbox" name="categorias" value="TENDENCIAS DE MODA"> TENDENCIAS DE MODA</label>
                        <label><input type="checkbox" name="categorias" value="BELLEZA"> BELLEZA</label>
                        <label><input type="checkbox" name="categorias" value="ACCESORIOS"> ACCESORIOS</label>
                        <label><input type="checkbox" name="categorias" value="NUTRICION"> NUTRICION</label>
                        <label><input type="checkbox" name="categorias" value="EJERCICIO"> EJERCICIO</label>
                        <label><input type="checkbox" name="categorias" value="SALUD MENTAL"> SALUD MENTAL</label>
                        <label><input type="checkbox" name="categorias" value="MEDICINA ALTERNATIVA"> MEDICINA ALTERNATIVA</label>
                        <label><input type="checkbox" name="categorias" value="PINTURA"> PINTURA</label>
                        <label><input type="checkbox" name="categorias" value="ESCULTURA"> ESCULTURA</label>
                        <label><input type="checkbox" name="categorias" value="LITERATURA"> LITERATURA</label>
                        <label><input type="checkbox" name="categorias" value="CINE"> CINE</label>
                        <label><input type="checkbox" name="categorias" value="DESTINOS TURISTICOS"> DESTINOS TURISTICOS</label>
                        <label><input type="checkbox" name="categorias" value="GUIAS DE VIAJE"> GUIAS DE VIAJE</label>
                        <label><input type="checkbox" name="categorias" value="CONSEJOS DE VIAJES"> CONSEJOS DE VIAJES</label>
                        <label><input type="checkbox" name="categorias" value="EMPRENDIMIENTO"> EMPRENDIMIENTO</label>
                        <label><input type="checkbox" name="categorias" value="INVERSIONES"> INVERSIONES</label>
                        <label><input type="checkbox" name="categorias" value="ECONOMIA"> ECONOMIA</label>
                        <label><input type="checkbox" name="categorias" value="MARKETING"> MARKETING</label>
                        <label><input type="checkbox" name="categorias" value="DESCUBRIMIENTOS"> DESCUBRIMIENTOS</label>
                        <label><input type="checkbox" name="categorias" value="INVESTIGACIONES"> INVESTIGACIONES</label>
                        <label><input type="checkbox" name="categorias" value="EDUCACION"> EDUCACION</label>
                        <label><input type="checkbox" name="categorias" value="INNOVACION CIENTIFICA"> INNOVACION CIENTIFICA</label>
                        <label><input type="checkbox" name="categorias" value="FUTBOL"> FUTBOL</label>
                        <label><input type="checkbox" name="categorias" value="BALONCESTO"> BALONCESTO</label>
                        <label><input type="checkbox" name="categorias" value="DEPORTES EXTREMOS"> DEPORTES EXTREMOS</label>
                        <label><input type="checkbox" name="categorias" value="ATLETISMO"> ATLETISMO</label>                    
                        <label><input type="checkbox" name="categorias" value="DECORACION"> DECORACION</label>                    
                        <label><input type="checkbox" name="categorias" value="JARDINERIA"> JARDINERIA</label>                    
                        <label><input type="checkbox" name="categorias" value="MUSICA"> MUSICA</label>                    
                        <label><input type="checkbox" name="categorias" value="SERIES Y PELICULAS"> SERIES Y PELICULAS</label>                    
                        <label><input type="checkbox" name="categorias" value="VIDEOJUEGOS"> VIDEOJUEGOS</label>                    
                        <label><input type="checkbox" name="categorias" value="CELEBRIDADES"> CELEBRIDADES</label>                    
                    </div>
                    <h3>Filtrar por Etiquetas</h3>
                    <div class="checkbox-group">
                        <label><input type="checkbox" name="tags" value="TECNOLOGIA"> Tecnologi­a</label>
                        <label><input type="checkbox" name="tags" value="INNOVACION"> Innovacion</label>
                        <label><input type="checkbox" name="tags" value="MODA"> Moda</label>
                        <label><input type="checkbox" name="tags" value="ESTILO_DE_VIDA"> Estilo de Vida</label>
                        <label><input type="checkbox" name="tags" value="SALUD"> Salud</label>
                        <label><input type="checkbox" name="tags" value="BIENESTAR"> Bienestar</label>
                        <label><input type="checkbox" name="tags" value="CULTURA"> Cultura</label>
                        <label><input type="checkbox" name="tags" value="ARTE"> Arte</label>
                        <label><input type="checkbox" name="tags" value="VIAJES"> Viajes</label>
                        <label><input type="checkbox" name="tags" value="TURISMO"> Turismo</label>
                        <label><input type="checkbox" name="tags" value="NEGOCIOS"> Negocios</label>
                        <label><input type="checkbox" name="tags" value="FINANZAS"> Finanzas</label>
                        <label><input type="checkbox" name="tags" value="EDUCACION"> Educacion</label>
                        <label><input type="checkbox" name="tags" value="CIENCIA"> Ciencia</label>
                        <label><input type="checkbox" name="tags" value="DEPORTES"> Deportes</label>
                        <label><input type="checkbox" name="tags" value="ENTRETENIMIENTO"> Entretenimiento</label>
                        <label><input type="checkbox" name="tags" value="MUSICA"> Musica</label>
                        <label><input type="checkbox" name="tags" value="CINE"> Cine</label>
                        <label><input type="checkbox" name="tags" value="SERIES"> Series</label>
                        <label><input type="checkbox" name="tags" value="VIDEOJUEGOS"> Videojuegos</label>
                        <label><input type="checkbox" name="tags" value="HOGAR"> Hogar</label>
                        <label><input type="checkbox" name="tags" value="JARDINERIA"> Jardineria</label>
                        <label><input type="checkbox" name="tags" value="NUTRICION"> Nutricion</label>
                        <label><input type="checkbox" name="tags" value="EJERCICIO"> Ejercicio</label>
                        <label><input type="checkbox" name="tags" value="SALUD_MENTAL"> Salud Mental</label>
                        <label><input type="checkbox" name="tags" value="BELLEZA"> Belleza</label>
                        <label><input type="checkbox" name="tags" value="ACCESORIOS"> Accesorios</label>
                        <label><input type="checkbox" name="tags" value="DECORACION"> Decoracion</label>                    
                    </div>
                    <button type="submit">Buscar Revistas</button>
                </form>
            </div>
            <div class="revistas-container">
                <h2 style="text-align: center;">Todas las Revistas Suscritas</h2>
                <%
                    ArrayList<Revista> revistas = new ArrayList<>();
                    SuscripcionDB dataRevistas = new SuscripcionDB();
                    SuscriptorDB dataSuscripcion = new SuscriptorDB();
                    UsuarioAplicacion usuario = (UsuarioAplicacion) request.getAttribute("usuarioLogeado");
                    int idSuscriptor = dataRevistas.getIdSuscriptor(usuario.getIdUsuario());
                    revistas = dataRevistas.getRevistasSuscritas(idSuscriptor);
                    for(Revista revista : revistas) {
                %>
                    <div>
                        <h3>Nombre de Revista: <%=revista.getNombreRevista()%></h3>
                        <p>Descripcion de Revista: <%=revista.getDescripcion()%></p>
                        <p>Categoria: <%=revista.getCategoria()%></p>
                        <p>Etiquetas: <%=revista.getEtiquetas()%></p>
                        <a href="${pageContext.servletContext.contextPath}/PdfControlerServlet?id=<%=revista.getIdRevista()%>" target="_blank">Leer</a>                   
                        <a href="${pageContext.servletContext.contextPath}/PdfControlerServlet?id=<%=revista.getIdRevista()%>" target="_blank">Descargar</a>
                        <a href="${pageContext.servletContext.contextPath}/PerfilEditorServlet?id=<%=revista.getAutor().getIdEditor()%>">Perfil de Autor</a>
                        <%
                            if (revista.isPuedeComentarse()) {
                        %>
                        <a href="suscriptor/nuevo-comentario.jsp?revista=<%=revista.getIdRevista()%>&id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Comentar</a>
                        <%
                            }
                            if (revista.isPuedeTenerLikes()) {
                                if (!dataSuscripcion.revistaConLike(revista.getIdRevista(), idSuscriptor)) {
                        %>
                        <a href="${pageContext.servletContext.contextPath}/LikeServlet?revista=<%=revista.getIdRevista()%>&id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Dar Like</a>
                        <%
                                } else {
                        %>
                        <p>Ya le diste Like!!!</p>
                        <%
                                }
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
