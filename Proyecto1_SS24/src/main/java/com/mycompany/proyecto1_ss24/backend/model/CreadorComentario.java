/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.SuscriptorDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorComentario {
    
    private final SuscriptorDB dataSuscripcion = new SuscriptorDB();

    public Comentario crearComentario(HttpServletRequest request, int idUsuario, int idRevista) throws UserDataInvalidException {
        Comentario nuevoComentario = this.extraerYValidar(request, idRevista);
        dataSuscripcion.crearComentario(nuevoComentario, idUsuario);
        return nuevoComentario;
    }

    private Comentario extraerYValidar(HttpServletRequest request, int idRevista) throws UserDataInvalidException {
        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setRevista(idRevista);
        nuevoComentario.setContenido(request.getParameter("comentario"));
        this.isValidateCreation(nuevoComentario);
        return nuevoComentario;
    }

    private void isValidateCreation(Comentario comentario) throws UserDataInvalidException {
        if (comentario.getContenido().equals("")) {
            throw new UserDataInvalidException("Debe completar el Campo para el Contenido del Comentario para la Revista");
        }
    }
    
}
