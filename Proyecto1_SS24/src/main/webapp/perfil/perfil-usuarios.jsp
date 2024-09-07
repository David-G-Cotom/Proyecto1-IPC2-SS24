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
        <link rel="stylesheet" href="style-perfil-usuarios.css">
    </head>
    <body>
        <div class="profile-container">
            <div class="form-container">
                <form method="POST" action="">
                    <div class="input-group">
                        <img src="https://www.okchicas.com/wp-content/uploads/2018/01/Poses-para-una-buena-foto-de-perfil-1-1.jpg" alt="Foto de perfil" class="profile-img">
                        <input type="file" data-buttonText="Foto" name="imagefile" id="imageFile">                        
                    </div>
                    <div class="input-group">
                        <label for="nombre">Nombre del Usuario:</label>
                        <input type="text" id="nombre" name="nombre"/>
                    </div>
                    <div class="input-group">
                        <label for="hobbies">Hobbies del Usuario:</label>
                        <input type="text" id="hobbies" name="hobbies"/>
                    </div>
                    <div class="input-group">
                        <label for="temasInteres">Temas de Interes del Usuario:</label>
                        <input type="text" id="temasInteres" name="temasInteres"/>
                    </div>
                    <div class="input-group">
                        <label for="descripcion">Descripcion del Usuario:</label>
                        <input type="text" id="descripcion" name="descripcion"/>
                    </div>
                    <div class="input-group">
                        <label for="gustos">Gustos del Usuario:</label>
                        <input type="text" id="gustos" name="gustos"/>
                    </div>
                    <button type="submit" id="contact-btn">Guardar</button>
                </form>
            </div>
        </div>
    </body>
</html>
