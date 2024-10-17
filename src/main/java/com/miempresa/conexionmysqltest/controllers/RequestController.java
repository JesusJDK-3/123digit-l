/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.controllers;

/**
 *
 * @author Luc-j
 */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.miempresa.conexionmysqltest.dao.RequestDAO;
import java.io.IOException;

@WebServlet("/registerRequest")
public class RequestController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int userId = Integer.parseInt(request.getParameter("userId"));  // Asumiendo que ya tienes el ID del usuario
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String priority = request.getParameter("priority");
        String attachmentPath = request.getParameter("attachmentPath");  // Si se adjunta un archivo

        // Llamar al DAO para registrar la solicitud
        RequestDAO dao = new RequestDAO();
        boolean isRegistered = dao.registrarSolicitud(userId, description, type, priority, attachmentPath);

        // Generar mensaje dependiendo del éxito de la operación
        if (isRegistered) {
            // Si la solicitud se registró correctamente, mostrar mensaje de éxito
            request.setAttribute("message", "¡La solicitud fue registrada exitosamente!");
        } else {
            // Si hubo un error, mostrar mensaje de error
            request.setAttribute("message", "Hubo un error al registrar la solicitud. Por favor, inténtelo nuevamente.");
        }

        // Redirigir a la página de creación de solicitudes o una página de confirmación
        request.getRequestDispatcher("/createRequest.jsp").forward(request, response);
    }
}

