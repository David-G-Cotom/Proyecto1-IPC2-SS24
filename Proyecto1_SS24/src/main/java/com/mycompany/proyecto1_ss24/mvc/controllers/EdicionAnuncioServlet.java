/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.AnuncioDB;
import com.mycompany.proyecto1_ss24.backend.data.PerfilDB;
import com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos Cotom
 */
@WebServlet(name = "EdicionAnuncioServlet", urlPatterns = {"/EdicionAnuncioServlet"})
public class EdicionAnuncioServlet extends HttpServlet {

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
        int idAnuncio = Integer.parseInt(request.getParameter("idAnuncio"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        boolean puedeMostrarse = request.getParameter("estado").equals("SI");
        AnuncioDB dataRevista = new AnuncioDB();
        if (!dataRevista.editarAnuncio(idAnuncio, puedeMostrarse)) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>NO Se pudo Cambiar el Estado del Anuncio</h1>");
            }
        }
        PerfilDB data = new PerfilDB();
            UsuarioAplicacion usuario = data.getUsuario(idUsuario);
            request.setAttribute("usuarioLogeado", usuario);
            request.getRequestDispatcher("/inversionista/interfaz-principal.jsp").forward(request, response);
    }

}
