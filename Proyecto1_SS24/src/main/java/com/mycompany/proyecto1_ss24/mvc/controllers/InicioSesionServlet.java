/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.LogUsuarioDB;
import com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Carlos Cotom
 */
@WebServlet(name = "InicioSesionServlet", urlPatterns = {"/InicioSesionServlet"})
public class InicioSesionServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        LogUsuarioDB dataUsuario = new LogUsuarioDB();
        UsuarioAplicacion usuario = dataUsuario.getUsuario(userName, password);
        if (usuario == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>NO EXISTE EL USUARIO</>");
            }
            return;
        }
        request.setAttribute("usuarioLogeado", usuario);
        redireccionarRespones(request, response, usuario);
    }
    
    private void redireccionarRespones(HttpServletRequest request, HttpServletResponse response, UsuarioAplicacion usuario)
            throws ServletException, IOException {
        switch (usuario.getTipoUsuario()) {
            case 1://editor
                request.getRequestDispatcher("/editor/interfaz-principal.jsp").forward(request, response);
                break;
            case 2://suscriptor
                request.getRequestDispatcher("/suscriptor/interfaz-principal.jsp").forward(request, response);
                break;
            case 3://inversionista
                request.getRequestDispatcher("/inversionista/interfaz-principal.jsp").forward(request, response);
                break;
            case 4://administrador
                request.getRequestDispatcher("/admin/interfaz-principal.jsp").forward(request, response);
                break;
        }
    }

}
