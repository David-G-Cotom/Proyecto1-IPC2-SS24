<%-- 
    Document   : nueva-suscripcion
    Created on : 12/09/2024, 17:41:25
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nueva Suscripcion</title>
        <link rel="stylesheet" href="style-nueva-suscripcion.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Nueva Suscripcion</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/SuscripcionServlet">
                <input type="hidden" name="idRevista" value="${param.revista}">             
                <input type="hidden" name="idUsuario" value="${param.id}">             
                <div class="input-group">
                    <label for="fecha">Fecha de Suscripcion:</label>
                    <input type="date" id="fecha" name="fecha"/>
                </div>
                <button type="submit">Suscribirse</button>
            </form>
        </div>
    </body>
</html>
