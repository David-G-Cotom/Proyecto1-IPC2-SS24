<%-- 
    Document   : registroUsuario
    Created on : 5/09/2024, 21:30:11
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="login-container">
            <h2>Registrar Usuario</h2>
            <form id="loginForm" method="POST" action="${pageContext.servletContext.contextPath}/RegistroUsuarioServlet">
                <div class="input-group">
                    <label for="username">Usuario</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="input-group">
                    <label for="usertype">Tipo de Usuario</label>
                    <select id="usertype" name="usertype">
                        <option value="editor">EDITOR</option>
                        <option value="suscriptor">SUSCRIPTOR</option>
                        <option value="inversionista">INVERSIONISTA</option>
                        <option value="administrador_sistema">ADMINISTRADOR</option>
                    </select>
                </div>
                <div class="input-group">
                    <label for="name">Nombre</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <button type="submit">Registrar</button>
            </form>
        </div>
    </body>
</html>
