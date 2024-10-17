<%-- 
    Document   : index
    Created on : 14 oct 2024, 19:34:32
    Author     : Luc-j
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Bienvenido a Digit@l123</title>
</head>
<body>
    <header>
        <h1>Bienvenido a Digit@l123</h1>
        <p>Su solución integral para la gestión de solicitudes de soporte.</p>
    </header>
    
    <div class="contenido-empresa">
        <section class="info-empresa">
            <h2>Sobre Digit@l123</h2>
            <p>En Digit@l123, nos dedicamos a ofrecer un soporte excepcional a nuestros clientes, facilitando la gestión de solicitudes y mejorando la eficiencia del servicio.</p>
            <p>Nuestra plataforma permite a los usuarios registrar, seguir y gestionar solicitudes de soporte, garantizando una respuesta rápida y efectiva a sus necesidades.</p>
            <img src="img/soportefondo1.png" alt="Soporte Digital" class="empresa-img"> 
        </section>

        <main>
            <section class="autenticacion">
                <h2>Iniciar Sesión</h2>
                <form action="login" method="POST">
                    <div class="form-group">
                        <label for="username">Nombre de Usuario:</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <button type="submit">Iniciar Sesión</button>
                </form>

                <p style="color: red;">
                    <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                </p>

                <p style="color: white">¿No tienes una cuenta? <a href="register.jsp">Regístrate aquí</a></p>
            </section>

        </main>
    </div>

    <footer>
        <p>&copy; 2024 Digit@l123. Todos los derechos reservados.</p>
    </footer>
</body>
</html>
