/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyecto1_ss24.mvc.controllers;

import com.mycompany.proyecto1_ss24.backend.data.PerfilDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserActionInvalidException;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.AnuncioTexto;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.CreadorBuyAdText;
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
@WebServlet(name = "BuyAdTextServlet", urlPatterns = {"/BuyAdTextServlet"})
public class BuyAdTextServlet extends HttpServlet {

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
        CreadorBuyAdText creadorCompra = new CreadorBuyAdText();
        try {
            AnuncioTexto anuncioCreado = creadorCompra.crearCompra(request, idUsuario);
            System.out.println(anuncioCreado);
            System.out.println("ANUNCIO DE TEXTO REGISTRADO EXITOSAMENTE");
            PerfilDB data = new PerfilDB();
            UsuarioAplicacion usuario = data.getUsuario(idUsuario);
            request.setAttribute("usuarioLogeado", usuario);
            request.getRequestDispatcher("/inversionista/interfaz-principal.jsp").forward(request, response);
        } catch (UserDataInvalidException | UserActionInvalidException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>ERROR!!! " + e.getMessage() + "</h1>");
            }
        }
    }

}
