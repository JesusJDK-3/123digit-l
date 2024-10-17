/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.dao;

/**
 *
 * @author Luc-j
 */



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.miempresa.conexionmysqltest.Util.MySQLConnection;

public class RequestDAO {

    // Método para insertar una solicitud en la base de datos
    public boolean registrarSolicitud(int userId, String description, String type, String priority, String attachmentPath) {
        String sql = "INSERT INTO requests (user_id, description, type, priority, attachment_path) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = MySQLConnection.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);  // ID del usuario que hace la solicitud
            stmt.setString(2, description);
            stmt.setString(3, type);
            stmt.setString(4, priority);
            stmt.setString(5, attachmentPath);  // Adjuntar archivo si es necesario
            
            int rowsInserted = stmt.executeUpdate();
            
            // Si la inserción fue exitosa (al menos 1 fila afectada)
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

