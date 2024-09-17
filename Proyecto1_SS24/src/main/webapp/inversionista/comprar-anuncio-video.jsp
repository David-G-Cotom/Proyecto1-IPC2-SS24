<%-- 
    Document   : compra-anuncio-video
    Created on : 16/09/2024, 15:51:11
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Compra de Anuncio de Video</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Compra de Anuncio de Video</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/BuyAdVideoServlet" enctype="multipart/form-data">
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
                <div class="input-group">
                    <label for="titulo">Titulo del Anuncio:</label>
                    <input type="text" id="titulo" name="titulo"/>
                </div>
                <div class="input-group">
                    <label for="mediaFile">Video del Anuncio</label>                    
                    <input type="file" data-buttonText="Foto" name="mediaFile" id="mediaFile">                        
                </div>
                <button type="submit">Comprar</button>
            </form>
        </div>
    </body>
</html>
