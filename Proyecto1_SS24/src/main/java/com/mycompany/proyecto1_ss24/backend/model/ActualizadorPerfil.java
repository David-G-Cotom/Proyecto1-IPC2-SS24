/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.PerfilDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Carlos Cotom
 */
public class ActualizadorPerfil {

    private final PerfilDB dataPerfil = new PerfilDB();

    public UsuarioAplicacion actualizarUsuario(HttpServletRequest request) throws UserDataInvalidException {
        UsuarioAplicacion usuarioActualizado = this.extraerYValidar(request);
        this.dataPerfil.actualizarPerfil(usuarioActualizado);
        return usuarioActualizado;
    }

    private UsuarioAplicacion extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        UsuarioAplicacion usuario = new UsuarioAplicacion();
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setHobbies(request.getParameter("hobbies"));
        usuario.setTemasInteres(request.getParameter("temasInteres"));
        usuario.setDescripcion(request.getParameter("descripcion"));
        usuario.setGustos(request.getParameter("gustos"));
        Part filePart;
        InputStream inputStream;
        try {
            filePart = request.getPart("imagefile");
            inputStream = filePart.getInputStream();
            usuario.setFoto(inputStream);
        } catch (ServletException | IOException e) {
            throw new UserDataInvalidException("Error en el Campo para Seleccionar el Archivo");
        }
        this.isValidateCreation(usuario, filePart.getSubmittedFileName());
        return usuario;
    }

    private void isValidateCreation(UsuarioAplicacion usuario, String fileName) throws UserDataInvalidException {
        if (!fileName.equals("")) {
            if (!this.extensCorrect(fileName)) {
                throw new UserDataInvalidException("El Archivo Seleccionado debe de ser en formato: .ico .png .jpg .jpeg");
            }
        } else {
            byte[] dataImage = this.dataPerfil.getImageUsuario(usuario.getIdUsuario());
            InputStream streamImage = new ByteArrayInputStream(dataImage);
            usuario.setFoto(streamImage);
        }
    }

    private boolean extensCorrect(String fileName) {
        String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
        for (String exten : extens) {
            if (fileName.toLowerCase().endsWith(exten)) {
                return true;
            }
        }
        return false;
    }

}
