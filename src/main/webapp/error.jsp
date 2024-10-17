<%-- 
    Document   : error
    Created on : 15 oct 2024, 17:06:39
    Author     : Luc-j
--%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <p>Lo sentimos, ha ocurrido un error al procesar tu solicitud.</p>
    <h2>Detalles del error:</h2>
    <p><strong>Mensaje:</strong> <%= (exception != null) ? exception.getMessage() : "No hay detalles disponibles para este error." %></p>
    
    <h3>Traza de la excepción:</h3>
    <pre>
        <%= (exception != null) ? exception.getStackTrace() : "No hay detalles disponibles para esta traza." %>
    </pre>
</body>
</html>
