/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.dao;

import com.miempresa.conexionmysqltest.Util.MySQLConnection;
import com.miempresa.conexionmysqltest.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;

public class UserDAO {

    // Método para encriptar la contraseña
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Manejo de errores
        }
    }

    // Método para registrar un nuevo usuario
    public boolean registerUser(User user) {
    String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
    try (Connection conn = MySQLConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        System.out.println("Intentando registrar el usuario con los siguientes datos:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Role: " + user.getRole());

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, encryptPassword(user.getPassword())); 
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getRole());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Usuario registrado exitosamente.");
            return true;
        } else {
            System.out.println("No se pudo registrar el usuario.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Error al registrar el usuario:");
        e.printStackTrace(); // Imprime el error exacto
        return false;
    }
}
    
    
    public boolean saveUser(User user) {
    // Lógica para conectarse a la base de datos y ejecutar la inserción
    try (Connection connection = MySQLConnection.getConnection()) {
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getRole());
        int rowsInserted = preparedStatement.executeUpdate();
        return rowsInserted > 0; // Retorna verdadero si la inserción fue exitosa
    } catch (SQLException e) {
        e.printStackTrace(); // Loguear el error para poder ver qué salió mal
        return false; // Retornar falso si hubo un error
    }
}



    // Método para buscar un usuario por nombre de usuario
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encontró el usuario
    }

    // Método para validar el inicio de sesión
    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptPassword(password)); // Comparar las contraseñas encriptadas

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Retorna true si el usuario existe
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                // otros atributos del usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}

