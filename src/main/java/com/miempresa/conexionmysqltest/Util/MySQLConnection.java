/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.Util;

/**
 *
 * @author Luc-j
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Solicitudes"; // Cambia "Solicitudes" por tu base de datos
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = "1234"; // Cambia por tu contraseña

    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver manualmente
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Obtener la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


