/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.PerfilDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.CreadorRevistas;
import com.mycompany.proyecto1_ss24.backend.model.Revista;
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
@WebServlet(name = "NuevaRevistaServlet", urlPatterns = {"/NuevaRevistaServlet"})
@MultipartConfig
public class NuevaRevistaServlet extends HttpServlet {

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
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        CreadorRevistas creadorRevistas = new CreadorRevistas();
        try {
            Revista revistaCreada = creadorRevistas.crearRevista(request, idUsuario);
            System.out.println(revistaCreada);
            System.out.println("REVISTA REGISTRADA EXITOSAMENTE");
            PerfilDB data = new PerfilDB();
            UsuarioAplicacion usuario = data.getUsuario(idUsuario);
            request.setAttribute("usuarioLogeado", usuario);
            request.getRequestDispatcher("/editor/interfaz-principal.jsp").forward(request, response);
        } catch (UserDataInvalidException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>ERROR!!! " + e.getMessage() + "</h1>");
            }
        }
    }

}
