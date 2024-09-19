/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import java.io.InputStream;

/**
 *
 * @author Carlos Cotom
 */
public class SisAdmin extends UsuarioAplicacion {

    public SisAdmin(InputStream pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
    }
    
}
