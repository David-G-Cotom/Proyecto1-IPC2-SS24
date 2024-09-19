/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import com.mycompany.proyecto1_ss24.backend.data.LogInUsuarioDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserActionInvalidException;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorUsuario {
    
    private final LogInUsuarioDB dataUsuario = new LogInUsuarioDB();
    
    public UsuarioAplicacion crearUsuario(HttpServletRequest request) throws UserDataInvalidException, UserActionInvalidException {
        UsuarioAplicacion nuevoUsuario = this.extraerYValidar(request);
        this.isUsuarioExistente(nuevoUsuario.getUserName(), nuevoUsuario.getPassword());
        this.dataUsuario.crearUsuario(nuevoUsuario);
        return nuevoUsuario;
    }
    
    private UsuarioAplicacion extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        UsuarioAplicacion usuario = new UsuarioAplicacion();
        usuario.setUserName(request.getParameter("username"));
        usuario.setPassword(request.getParameter("password"));
        usuario.setNombre(request.getParameter("name"));
        Part filePart;
        InputStream inputStream;
        try {
            filePart = request.getPart("imageFile");
            inputStream = filePart.getInputStream();
            usuario.setFoto(inputStream);
        } catch (ServletException | IOException e) {
            throw new UserDataInvalidException("Error en el Campo para Seleccionar el Archivo");
        }
        String tipoUsuario = request.getParameter("usertype");
        this.isValidateCreation(usuario, filePart.getSubmittedFileName(), tipoUsuario);
        String codificado = Base64.getEncoder().encodeToString(usuario.getPassword().getBytes());
        usuario.setPassword(codificado);
        int idTipoUsuario = this.dataUsuario.getIdTipoUsuario(tipoUsuario);
        usuario.setIdTipoUsuario(idTipoUsuario);
        return usuario;
    }
    
    private void isValidateCreation(UsuarioAplicacion usuario, String fileName, String tipoUsuario) throws UserDataInvalidException {
        if (usuario.getUserName().equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Usuario");
        }
        if (usuario.getPassword().equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Password");
        }
        if (usuario.getNombre().equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Nombre");
        }
        if (fileName.equals("")) {
            throw new UserDataInvalidException("Debe Seleccionar una Imagen para su Perfil");
        }
        if (!this.extensCorrect(fileName)) {
            throw new UserDataInvalidException("El Archivo Seleccionado debe de ser en formato: .ico .png .jpg .jpeg");
        }
        if (tipoUsuario.equals("")) {
            throw new UserDataInvalidException("Debe Eleguir un Tipo de Usuario");
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
    
    private void isUsuarioExistente(String userName, String password) throws UserActionInvalidException {
        UsuarioAplicacion usuarioExistente = this.dataUsuario.getUsuario(userName, password);
        if (usuarioExistente != null) {
            throw new UserActionInvalidException("Los Datos del Username y el Passwor son Incorrectas. Intente con otros Datos");
        }
    }
    
}
