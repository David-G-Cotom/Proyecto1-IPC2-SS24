<%-- 
    Document   : editar-revista
    Created on : 6/09/2024, 03:38:13
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edicion de Revista</title>
        <link rel="stylesheet" href="style-nueva-editar-revista.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Edicion de Revista</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/EdicionRevistaServlet">                
                <input type="hidden" name="idRevista" value="${param.id}">
                <div class="radio-group">
                    <div>                    
                        <label for="comentario-si"><input type="radio" id="comentario-si" name="comentarios" value="SI" checked> Recibir Comentarios</label>                    
                        <label for="comentario-no"><input type="radio" id="comentario-no" name="comentarios" value="NO"> NO Recibir Comentarios</label>
                    </div>
                    <div>                    
                        <label for="likes-si"><input type="radio" id="likes-si" name="likes" value="SI" checked> Recibir Likes</label>                    
                        <label for="likes-no"><input type="radio" id="likes-no" name="likes" value="NO"> NO Recibir Likes</label>
                    </div>
                    <div>                    
                        <label for="suscripciones-si"><input type="radio" id="suscripciones-si" name="suscripciones" value="SI" checked> Recibir Suscripciones</label>                    
                        <label for="suscripciones-no"><input type="radio" id="suscripciones-no" name="suscripciones" value="NO"> NO Recibir Suscripciones</label>
                    </div>
                </div>
                <button type="submit">Guardar Cambios</button>
            </form>
        </div>
    </body>
</html>
