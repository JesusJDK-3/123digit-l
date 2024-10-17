<%-- 
    Document   : createRequest
    Created on : 14 oct 2024, 19:30:06
    Author     : Luc-j
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Solicitud</title>
    <link rel="stylesheet" href="css/createRequest.css"> <!-- Asegúrate de tener tu archivo de estilos -->
</head>
<body>
    <div class="container">
        <h1>Registrar Nueva Solicitud</h1>

        <!-- Mostrar mensaje de éxito o error -->
        <% if (request.getAttribute("message") != null) { %>
            <p><%= request.getAttribute("message") %></p>
        <% } %>

        <form method="POST" enctype="multipart/form-data" action="registerRequest">
            <!-- Campo de descripción -->
            <div class="form-group">
                <label for="description">Descripción de la solicitud:</label>
                <textarea id="description" name="description" rows="4" required></textarea>
            </div>

            <!-- Tipo de solicitud -->
            <div class="form-group">
                <label for="type">Tipo de solicitud:</label>
                <select id="type" name="type" required>
                    <option value="incident">Incidente</option>
                    <option value="task">Tarea</option>
                    <option value="requirement">Requisito</option>
                </select>
            </div>

            <!-- Prioridad -->
            <div class="form-group">
                <label for="priority">Prioridad:</label>
                <select id="priority" name="priority">
                    <option value="low">Baja</option>
                    <option value="medium" selected>Media</option>
                    <option value="high">Alta</option>
                </select>
            </div>

            <!-- Campo para adjuntar archivo -->
            <div class="form-group">
                <label for="attachment">Adjuntar archivo:</label>
                <input type="file" id="attachment" name="attachment">
            </div>

            <button type="submit">Enviar Solicitud</button>
        </form>

        <!-- Enlace para ver el estado de las solicitudes -->
        <p><a href="viewRequests.jsp" class="link">Ver Estado de Solicitudes</a></p>
    </div>
</body>
</html>
