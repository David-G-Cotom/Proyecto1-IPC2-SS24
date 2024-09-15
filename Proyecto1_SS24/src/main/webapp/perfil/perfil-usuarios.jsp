<%-- 
    Document   : perfil-usuarios
    Created on : 6/09/2024, 22:11:59
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil Usuario</title>
        <link rel="stylesheet" href="perfil/style-perfil-usuarios.css">
    </head>
    <body>
        <div class="profile-container">
            <div class="form-container">
                <form method="POST" action="${pageContext.servletContext.contextPath}/PerfilServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}" enctype="multipart/form-data"">
                    <div class="input-group">
                        <img src="${pageContext.servletContext.contextPath}/ImageControlerServlet?id=${sessionScope.usuarioLogeado}${usuarioLogeado.getIdUsuario()}" alt="Foto de perfil" class="profile-img">
                        <input type="file" data-buttonText="Foto" name="imagefile" id="imageFile">                        
                    </div>
                    <div class="input-group">
                        <label for="nombre">Nombre del Usuario:</label>
                        <input type="text" id="nombre" name="nombre" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getNombre()}"/>
                    </div>
                    <div class="input-group">
                        <label for="hobbies">Hobbies del Usuario:</label>
                        <input type="text" id="hobbies" name="hobbies" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getHobbies()}"/>
                    </div>
                    <div class="input-group">
                        <label for="temasInteres">Temas de Interes del Usuario:</label>
                        <input type="text" id="temasInteres" name="temasInteres" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getTemasInteres()}"/>
                    </div>
                    <div class="input-group">
                        <label for="descripcion">Descripcion del Usuario:</label>
                        <input type="text" id="descripcion" name="descripcion" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getDescripcion()}"/>
                    </div>
                    <div class="input-group">
                        <label for="gustos">Gustos del Usuario:</label>
                        <input type="text" id="gustos" name="gustos" value="${sessionScope.usuarioLogeado}${usuarioLogeado.getGustos()}"/>
                    </div>
                    <button type="submit" id="contact-btn">Guardar</button>
                </form>
            </div>
        </div>
    </body>
</html>
