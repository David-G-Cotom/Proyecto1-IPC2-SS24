/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.exceptions.UserActionInvalidException;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioVideo;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.CreadorBuyAdVideo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos Cotom
 */
@WebServlet(name = "BuyAdVideoServlet", urlPatterns = {"/BuyAdVideoServlet"})
@MultipartConfig
public class BuyAdVideoServlet extends HttpServlet {

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
        CreadorBuyAdVideo creadorCompra = new CreadorBuyAdVideo();
        try {
            AnuncioVideo anuncioCreado = creadorCompra.crearCompra(request, idUsuario);
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>Se Compro el Anuncio: " + anuncioCreado.toString() + "</h1>");
            }
        } catch (UserDataInvalidException | UserActionInvalidException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>ERROR!!! " + e.getMessage() + "</h1>");
            }
        }
    }

}
