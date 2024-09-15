<%-- 
    Document   : perfil-editor
    Created on : 15/09/2024, 15:27:10
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil Editor</title>
        <link rel="stylesheet" href="perfil/style-perfil-usuarios.css">
    </head>
    <body>
        <div class="profile-container">
            <h1>Perfil del Autor</h1>
            <div class="form-container">
                <div class="input-group">
                    <p>Foto de Perfil</p>
                    <img src="${pageContext.servletContext.contextPath}/ImageControlerServlet?id=${sessionScope.autorRevista}${autorRevista.getIdUsuario()}" alt="Foto de perfil" class="profile-img">
                </div>
                <div class="input-group">
                    <p>Nombre del Autor</p>
                    <input type="text" id="nombre" name="nombre" value="${sessionScope.autorRevista}${autorRevista.getNombre()}" disabled/>
                </div>
                <div class="input-group">
                    <p>Hobbies del Autor</p>
                    <input type="text" id="hobbies" name="hobbies" value="${sessionScope.autorRevista}${autorRevista.getHobbies()}" disabled/>
                </div>
                <div class="input-group">
                    <p>Temas de Interes del Autor</p>
                    <input type="text" id="temasInteres" name="temasInteres" value="${sessionScope.autorRevista}${autorRevista.getTemasInteres()}" disabled/>
                </div>
                <div class="input-group">
                    <p>Descripcion del Autor</p>
                    <input type="text" id="descripcion" name="descripcion" value="${sessionScope.autorRevista}${autorRevista.getDescripcion()}" disabled/>
                </div>
                <div class="input-group">
                    <p>Gustos del Autor</p>
                    <input type="text" id="gustos" name="gustos" value="${sessionScope.autorRevista}${autorRevista.getGustos()}" disabled/>
                </div>
            </div>
        </div>
    </body>
</html>
