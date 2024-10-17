/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.controllers;

/**
 *
 * @author Luc-j
 */


import com.miempresa.conexionmysqltest.models.User;
import com.miempresa.conexionmysqltest.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(); // Inicializa el servicio
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        // Agrega depuración
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);

        // Crear un nuevo usuario
        User user = new User(username, password, email, role);

        // Registrar el usuario
        boolean registered = userService.registerUser(user);

        // Agrega depuración
        System.out.println("Registered: " + registered);

        if (registered) {
            response.sendRedirect("index.jsp"); // Redirigir a una página de éxito
        } else {
            response.sendRedirect("error.jsp"); // Redirigir a una página de error
        }
    }

}


