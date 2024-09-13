<%-- 
    Document   : comprar-anuncio
    Created on : 6/09/2024, 04:02:00
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Compra de Anuncio</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Compra de Anuncio</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/CompraAnuncioServlet">
                <input type="hidden" name="idUsuario" value="${param.id}">
                <div class="input-group">
                    <label for="fecha">Fecha de Compra:</label>
                    <input type="date" id="fecha" name="fecha"/>
                </div>
                <div class="input-group">
                    <label for="tipoanuncio">Tipo de Anuncio:</label>
                    <select id="tipoanuncio" name="tipoanuncio">
                        <option value="ANUNCIO_TEXTO">ANUNCIO DE TEXTO</option>
                        <option value="ANUNCIO_TEXTO_IMAGEN">ANUNCIO DE TEXTO E IMAGEN</option>
                        <option value="ANUNCIO_VIDEO">ANUNCIO DE VIDEO</option>               
                    </select>
                </div>
                <div class="input-group">
                    <label for="duracion">Duracion de Anuncio:</label>
                    <select id="duracion" name="duracion">
                        <option value="1">1 DIA</option>
                        <option value="3">3 DIAS</option>
                        <option value="7">7 DIAS</option>               
                        <option value="14">14 DIAS</option>               
                    </select>
                </div>
                <button type="submit">Comprar</button>
            </form>
        </div>
    </body>
</html>
