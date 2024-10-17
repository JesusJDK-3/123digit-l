/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.conexionmysqltest.controllers;

/**
 *
 * @author Luc-j
 */

import com.miempresa.conexionmysqltest.dao.UserDAO;
import com.miempresa.conexionmysqltest.models.User;
import com.miempresa.conexionmysqltest.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificación de las credenciales
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsernameAndPassword(username, password);

        if (user != null) {
            // Si el usuario es encontrado y la contraseña es correcta
            request.getSession().setAttribute("user", user);
            response.sendRedirect("createRequest.jsp"); // Redirige a la página de solicitudes
        } else {
            // Si el nombre de usuario o la contraseña no son correctos
            request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response); // Volver a la página de inicio
        }
    }
}
