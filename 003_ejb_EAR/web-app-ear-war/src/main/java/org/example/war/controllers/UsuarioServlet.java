package org.example.war.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.example.ejb.services.UsuarioService;

/**
 * this is our servlet that will list all users
 */
@WebServlet({"/listar", "/"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usuarios", service.listar()); 
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
