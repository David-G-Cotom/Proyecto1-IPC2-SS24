/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.RevistaDB;
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
@WebServlet(name = "EdicionRevistaServlet", urlPatterns = {"/EdicionRevistaServlet"})
public class EdicionRevistaServlet extends HttpServlet {

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
        int idRevista = Integer.parseInt(request.getParameter("idRevista"));
        boolean puedeComentarse = request.getParameter("comentarios").equals("SI");
        boolean puedeTenerLikes = request.getParameter("likes").equals("SI");
        boolean puedeSuscribirse = request.getParameter("suscripciones").equals("SI");
        RevistaDB dataRevista = new RevistaDB();
        if (!dataRevista.editarRevista(idRevista, puedeComentarse, puedeTenerLikes, puedeSuscribirse)) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>NO Se cambiaron los Estados de la Revista</h1>");
            }
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Se cambiaron los Estados de la Revista Correctamente</h1>");
        }
    }

}
