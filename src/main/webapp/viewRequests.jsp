<%-- 
    Document   : viewRequests
    Created on : 14 oct 2024, 20:18:52
    Author     : Luc-j
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ver Solicitudes</title>
</head>
<body>
    <h1>Solicitudes</h1>

    <!-- Mostrar mensaje de éxito -->
    <c:if test="${not empty sessionScope.message}">
        <div style="color: green; font-weight: bold;">
            ${sessionScope.message}
        </div>
        <c:remove var="message" scope="session" /> <!-- Limpiar mensaje de la sesión -->
    </c:if>

    <!-- Aquí va el resto de tu contenido de solicitudes -->
    <table>
        <tr>
            <th>ID</th>
            <th>Descripción</th>
            <th>Tipo</th>
            <th>Prioridad</th>
            <th>Estado</th>
        </tr>
        <c:forEach var="request" items="${requests}">
            <tr>
                <td>${request.requestId}</td>
                <td>${request.description}</td>
                <td>${request.type}</td>
                <td>${request.priority}</td>
                <td>${request.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

