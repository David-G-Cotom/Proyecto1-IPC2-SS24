<%-- 
    Document   : nuevo-comentario
    Created on : 12/09/2024, 23:24:55
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nuevo Comentario</title>
        <link rel="stylesheet" href="style-new-suscripcion-comentario.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Nuevo Comentario</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/NuevoComentarioServlet">
                <input type="hidden" name="idRevista" value="${param.revista}">             
                <input type="hidden" name="idUsuario" value="${param.id}">
                <div class="input-group">
                    <label for="comentario">Comentario para la Revista:</label>
                    <textarea id="comentario" name="comentario"></textarea>
                </div>
                <button type="submit">Crear Comentario</button>
            </form>
        </div>
    </body>
</html>
