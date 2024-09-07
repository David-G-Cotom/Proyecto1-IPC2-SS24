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
            <form id="loginForm">
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
                        <option value="EDITOR">EDITOR</option>
                        <option value="SUSCRIPTOR">SUSCRIPTOR</option>
                        <option value="INVERSIONISTA">INVERSIONISTA</option>
                        <option value="ADMINISTRADOR">ADMINISTRADOR</option>
                    </select>
                </div>                
                <button type="submit">Registrar</button>
            </form>
        </div>
        <script>
            document.getElementById('loginForm').addEventListener('submit', function (event) {
                event.preventDefault();
                const username = document.getElementById('username').value;
                const password = document.getElementById('password').value;

                // Aquí puedes agregar la lógica para validar el usuario y la contraseña
                if (username === '' && password === '') {
                    alert('Debe completar los campos');
                } else {
                    alert('Registro de Usuario Exitoso');
                }
            });
        </script>
    </body>
</html>
