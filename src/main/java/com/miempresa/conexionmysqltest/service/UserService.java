/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.service;

import com.miempresa.conexionmysqltest.dao.UserDAO;
import com.miempresa.conexionmysqltest.models.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO(); 
    }

    // Método para registrar un nuevo usuario
    public boolean registerUser(User user) {
    UserDAO userDAO = new UserDAO(); // Asegúrate de tener una instancia de UserDAO
    return userDAO.saveUser(user); // Verifica que saveUser retorne verdadero si se registra correctamente
}


    // Método para validar un usuario
    public boolean validateUser(String username, String password) {
        return userDAO.validateUser(username, password);
    }

    // Método para obtener un usuario por nombre de usuario
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }
}
