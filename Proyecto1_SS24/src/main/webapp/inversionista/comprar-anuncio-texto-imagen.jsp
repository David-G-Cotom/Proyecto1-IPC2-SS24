<%-- 
    Document   : compra-anuncio-texto-imagen
    Created on : 16/09/2024, 15:51:02
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Compra de Anuncio de Texto e Imagen</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Compra de Anuncio de Texto e Imagen</h1>
            <form method="POST" action="${pageContext.servletContext.contextPath}/BuyAdTextImageServlet" enctype="multipart/form-data">
                <input type="hidden" name="idUsuario" value="${param.id}">
                <div class="input-group">
                    <label for="fecha">Fecha de Compra:</label>
                    <input type="date" id="fecha" name="fecha"/>
                </div>
                <input type="hidden" name="tipoanuncio" value="ANUNCIO_TEXTO_IMAGEN">
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
                    <label for="contenido">Contenido del Anuncio:</label>
                    <textarea id="contenido" name="contenido"></textarea>
                </div>
                <div class="input-group">
                    <label for="mediaFile">Imagen del Anuncio</label>                    
                    <input type="file" data-buttonText="Foto" name="imageFile" id="mediaFile">                        
                </div>
                <button type="submit">Comprar</button>
            </form>
        </div>
    </body>
</html>
