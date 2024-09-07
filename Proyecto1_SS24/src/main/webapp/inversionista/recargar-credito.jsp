<%-- 
    Document   : recargar-credito
    Created on : 6/09/2024, 04:02:36
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cartera Digital</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Recarga de Credito</h1>
            <form method="POST" action="">
                <div class="input-group">
                    <label for="cantidad">Cantidad a Recargar:</label>
                    <input type="text" id="cantidad" name="cantidad"/>
                </div>
                <div class="input-group">
                    <label for="fecha">Fecha de Recarga</label>
                    <input type="date" id="fecha" name="fecha"/>
                </div>                
                <button type="submit">Recargar</button>
            </form>
        </div>
    </body>
</html>
