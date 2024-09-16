/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.SuscriptorDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
@WebServlet(name = "FiltroRevistasServlet", urlPatterns = {"/FiltroRevistasServlet"})
public class FiltroRevistasServlet extends HttpServlet {

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
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        String[] etiquetas = request.getParameterValues("tags");
        String[] categorias = request.getParameterValues("categorias");
        if (etiquetas == null && categorias == null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>Si quiere ver Todas las Revistas Regrese a la interfaz principal en la Parte de Aabajo</h1>");
            }
            return;
        }
        SuscriptorDB dataSuscriptor = new SuscriptorDB();
        int idSuscriptor = dataSuscriptor.getIdSuscriptor(idUsuario);
        ArrayList<Revista> revistas;
        try {
            revistas = dataSuscriptor.getRevistasSuscritasFiltro(idSuscriptor, etiquetas, categorias);            
        } catch (UserDataInvalidException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>" + e.getMessage() + "</h1>");
            }
            return;
        }
        if (revistas.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>NO Hay Revistas Suscritas que cumplan con los Filtros</h1>");
            }
            return;
        }
        request.setAttribute("revistasFiltradas", revistas);
        request.setAttribute("idUsuario", idUsuario);
        request.getRequestDispatcher("/suscriptor/revistas-filtradas.jsp").forward(request, response);
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
    }

}
