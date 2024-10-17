<%-- 
    Document   : register
    Created on : 15 oct 2024, 17:05:02
    Author     : Luc-j
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <title>Registro - Digit@l123</title>
</head>
<body>
    <div class="register-container">
        <section class="register-form">
            <h1>Crear una Cuenta</h1>
            <p>Únete a Digit@l123 y gestiona tus solicitudes de soporte fácilmente.</p>
            <form action="register" method="POST">
                
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="username">Nombre de Usuario:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="role">Rol:</label>
                    <select id="role" name="role" required>
                        <option value="customer">Cliente</option>
                        <option value="collaborator">Colaborador</option>
                        <option value="admin">Administrador</option>
                    </select>
                </div>

                <button type="submit">Registrar</button>
            </form>
            <p>¿Ya tienes una cuenta? <a href="createRequest.jsp">Inicia sesión aquí</a></p>
        </section>
        <aside class="register-info">
            <img src="img/soportefondo1.png" alt="Registro" class="register-img">
            <p>Con tu cuenta en Digit@l123 podrás gestionar y hacer seguimiento de todas tus solicitudes de soporte.</p>
        </aside>
    </div>
</body>
</html>
