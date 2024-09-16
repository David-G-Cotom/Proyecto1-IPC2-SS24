/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.ActualizadorPrecioTipoAnuncio;
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
@WebServlet(name = "EdicionPrecioTipoAnuncioServlet", urlPatterns = {"/EdicionPrecioTipoAnuncioServlet"})
public class EdicionPrecioTipoAnuncioServlet extends HttpServlet {

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
        try {
            ActualizadorPrecioTipoAnuncio actualizador = new ActualizadorPrecioTipoAnuncio();
            actualizador.actualizarPreciosTipo(request);
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>Se Actualizaron Los Precios para los Diferentes Tipos de Anuncios Correctamente</h1>");
            }
        } catch (UserDataInvalidException ex) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>ERROR!!! " + ex.getMessage() + "</h1>");
            }
        }
    }

}
