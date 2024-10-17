/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.service;

/**
 *
 * @author Luc-j
 */




import com.miempresa.conexionmysqltest.Util.MySQLConnection;
import com.miempresa.conexionmysqltest.models.Request;
import com.miempresa.conexionmysqltest.dao.RequestDAO;

public class RequestService {
    private RequestDAO requestDAO;

    public RequestService() {
        requestDAO = new RequestDAO();
    }

    public boolean createRequest(Request request) {
        // Validación de campos antes de crear la solicitud
        if (request.getDescription() == null || request.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        if (!("incident".equals(request.getType()) || "task".equals(request.getType()) || "requirement".equals(request.getType()))) {
            throw new IllegalArgumentException("Tipo de solicitud no válido.");
        }

        if (!("low".equals(request.getPriority()) || "medium".equals(request.getPriority()) || "high".equals(request.getPriority()))) {
            throw new IllegalArgumentException("Prioridad no válida.");
        }

        // Llamar al método del DAO para registrar la solicitud
        return requestDAO.registrarSolicitud(
            request.getUserId(),
            request.getDescription(),
            request.getType(),
            request.getPriority(),
            request.getAttachmentPath()  // Puedes pasar null si no hay adjunto
        );
    }
}
