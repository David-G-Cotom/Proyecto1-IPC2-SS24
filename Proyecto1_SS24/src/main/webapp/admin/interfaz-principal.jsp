<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page import="com.mycompany.proyecto1_ss24.backend.data.AnuncioDB" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pagina Principal (Administrador de Sistema)</title>
        <link rel="stylesheet" href="admin/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menú</h2>
            <ul>
                <li><a href="#editar-precio-tipo-anuncio">Editar Precios de Tipo de Anuncio</a></li>
                <li><a href="#editar-precio-tiempo-anuncios">Editar Precios de Periodos de Tiempo para Anuncios</a></li>
                <li><a href="#editar-precio-revista">Editar Precios de Revistas</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/PerfilServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}">Perfil</a></li>
                <li><a href="#">Reporte de Ganancias</a></li>
                <li><a href="#">Reporte de Anuncios Comprados</a></li>
                <li><a href="#">Reporte de las Revistas mas Populares</a></li>
                <li><a href="#">Reporte de las Revistas mas Comentadas</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Administrador de Sistema: ${sessionScope.usuarioLogeado} ${usuarioLogeado.getNombre()}</h1>   
            <div id="editar-precio-tipo-anuncio">
                <h2>Edicion de Precios para los Tipos de Anuncios</h2>
                <div class="form-container">
                    <form method="POST" action="${pageContext.servletContext.contextPath}/EdicionPrecioTipoAnuncioServlet">
                        <%
                            AnuncioDB dataAnuncio = new AnuncioDB();
                            double[] preciosTipoAnuncio = dataAnuncio.getPreciosTipoAnuncios();
                        %>
                        <div class="input-group">
                            <label for="precio-texto">Precio para el Anuncio de Texto:</label>
                            <input type="text" id="precio-texto" name="precio-texto" value="<%=preciosTipoAnuncio[0]%>"/>
                        </div>
                        <div class="input-group">
                            <label for="precio-texto-imagen">Precio para el Anuncio de Texto e Imagen:</label>
                            <input type="text" id="precio-texto-imagen" name="precio-texto-imagen" value="<%=preciosTipoAnuncio[1]%>"/>
                        </div>
                        <div class="input-group">
                            <label for="precio-video">Precio para el Anuncio de Video</label>
                            <input type="text" id="precio-video" name="precio-video" value="<%=preciosTipoAnuncio[2]%>"/>
                        </div>
                        <button type="submit">Guardar</button>
                    </form>
                </div>
            </div>
            <div id="editar-precio-tiempo-anuncios">
                <h2>Edicion de Precios para los Periodos de Tiempos en los Anuncios</h2>
                <div class="form-container">
                    <form method="POST" action="${pageContext.servletContext.contextPath}/EdicionPrecioPeriodoTiempoServlet">
                        <%
                            double[] preciosPeriodosTiempo = dataAnuncio.getPreciosPeriodoTiempo();
                        %>
                        <div class="input-group">
                            <label for="precio-1">Precio para 1 dia:</label>
                            <input type="text" id="precio-1" name="precio-1" value="<%=preciosPeriodosTiempo[0]%>"/>
                        </div>
                        <div class="input-group">
                            <label for="precio-3">Precio para 3 dias:</label>
                            <input type="text" id="precio-3" name="precio-3" value="<%=preciosPeriodosTiempo[1]%>"/>
                        </div>
                        <div class="input-group">
                            <label for="precio-7">Precio para 7 dias</label>
                            <input type="text" id="precio-7" name="precio-7" value="<%=preciosPeriodosTiempo[2]%>"/>
                        </div>
                        <div class="input-group">
                            <label for="precio-14">Precio para 14 dias</label>
                            <input type="text" id="precio-14" name="precio-14" value="<%=preciosPeriodosTiempo[3]%>"/>
                        </div>
                        <button type="submit">Guardar</button>
                    </form>
                </div>
            </div>
            <div id="editar-precio-revista">
                <h2>Edicion de Precios para las Revistas</h2>
                <div class="content-revistas">
                    <p>Estas son las Revistas Registradas en el Sistema</p>
                    <div>
                        <h3>Revista</h3>
                        <p>Descripcion de Revista</p>
                        <div class="input-group">
                            <label for="precio-rev1">Precio Actual</label>
                            <input type="text" id="precio-rev1" name="precio-rev1" value=""/>
                        </div>
                        <button type="submit">Cambiar</button>
                    </div>            
                    <div>
                        <h3>Revista</h3>
                        <p>Descripcion de Revista</p>
                        <div class="input-group">
                            <label for="precio-rev2">Precio Actual</label>
                            <input type="text" id="precio-rev2" name="precio-rev2" value=""/>
                        </div>
                        <button type="submit">Cambiar</button>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
