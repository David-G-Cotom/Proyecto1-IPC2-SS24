/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.PerfilDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.ActualizadorPerfil;
import com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author Carlos Cotom
 */
@WebServlet(name = "PerfilServlet", urlPatterns = {"/PerfilServlet"})
@MultipartConfig
public class PerfilServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idUsuario =Integer.parseInt(request.getParameter("id"));
        PerfilDB dataPerfil = new PerfilDB();        
        UsuarioAplicacion usuario = dataPerfil.getUsuario(idUsuario);
        request.setAttribute("usuarioLogeado", usuario);
        request.getRequestDispatcher("/perfil/perfil-usuarios.jsp").forward(request, response);
    }

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
        processRequest(request, response);
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
        try {
            ActualizadorPerfil actualizadorPerfil = new ActualizadorPerfil();
            UsuarioAplicacion usuario = actualizadorPerfil.actualizarUsuario(request);
            request.setAttribute("usuarioLogeado", usuario);
            request.getRequestDispatcher("/perfil/perfil-usuarios.jsp").forward(request, response);
        } catch (UserDataInvalidException ex) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>ERROR!!! " + ex.getMessage() + "</h1>");
            }
        }
        
    }

}
