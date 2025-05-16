<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!-- Directiva JSP que define el tipo de contenido (HTML con codificación UTF-8) y la codificación de página -->
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Declaración de codificación HTML para el navegador -->
    <meta charset="UTF-8">

    <!-- Título de la pestaña del navegador -->
    <title>Login</title>
</head>
<body>

<!-- Título principal de la página -->
<h1>Login de usuario</h1>

<!-- Contenedor del formulario -->
<div>
    <!-- Formulario de inicio de sesión -->
    <!-- Usa método POST para enviar datos al servlet LoginServlet -->
    <!-- La acción apunta a /webapp_cookies_ronny/login, que es el endpoint del servlet -->
    <form action="/webapp_cookies_ronny/login" method="post">

        <!-- Campo para ingresar el nombre de usuario -->
        <div>
            <label for="username">Nombre de usuario:</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>

        <!-- Campo para ingresar la contraseña -->
        <div>
            <label for="pass">Password:</label>
            <div>
                <input type="password" name="password" id="pass">
            </div>
        </div>

        <!-- Botón para enviar el formulario -->
        <div>
            <input type="submit" value="Enviar">
        </div>
    </form>
</div>

</body>
</html>
