<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pagina Principal (Inversionista)</title>
        <link rel="stylesheet" href="inversionista/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menú</h2>
            <ul>
                <li><a href="#">Comprar Anuncio</a></li>
                <li><a href="#">Perfil</a></li>
                <li><a href="#">Recargar Credito</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Inversionista: ${sessionScope.usuarioLogeado} ${usuarioLogeado.getNombre()}</h1>
            <p>Estas son tus Anuncios Registradas en el Sistema</p>
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>             
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>             
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>             
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>             
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>             
            <div>
                <h2>Anuncio</h2>
                <a href="#">Editar</a>
            </div>            
        </div> 
    </body>
</html>
