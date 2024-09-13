<%-- 
    Document   : editar-anuncio
    Created on : 6/09/2024, 04:02:47
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edicion de Anuncio</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Estado de Anuncio</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/EdicionAnuncioServlet">
                <input type="hidden" name="idAnuncio" value="${param.id}">
                <div class="radio-group">
                    <div>                    
                        <label for="estado-si"><input type="radio" id="estado-si" name="estado" value="SI" checked> Activar</label>                    
                        <label for="estado-no"><input type="radio" id="estado-no" name="estado" value="NO"> Desactivar</label>
                    </div>
                </div>
                <button type="submit">Guardar</button>
            </form>
        </div>
    </body>
</html>
