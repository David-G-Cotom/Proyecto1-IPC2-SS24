<%-- 
    Document   : inicioSesion
    Created on : 5/09/2024, 21:16:02
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
            <h2>Iniciar Sesión</h2>
            <form id="loginForm">
                <div class="input-group">
                    <label for="username">Usuario</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit">Entrar</button>
            </form>
        </div>
        <script>
            document.getElementById('loginForm').addEventListener('submit', function (event) {
                event.preventDefault();
                const username = document.getElementById('username').value;
                const password = document.getElementById('password').value;

                // Aquí puedes agregar la lógica para validar el usuario y la contraseña
                if (username === 'admin' && password === 'admin') {
                    alert('Inicio de sesión exitoso');
                } else {
                    alert('Usuario o contraseña incorrectos');
                }
            });
        </script>
    </body>
</html>
