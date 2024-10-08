/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class Suscriptor extends UsuarioAplicacion {
    
    private ArrayList<Revista> revistasSuscritas;

    public Suscriptor(InputStream pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
    }    

    public Suscriptor(ArrayList<Revista> revistasSuscritas, InputStream pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
        this.revistasSuscritas = revistasSuscritas;
    }        

    public ArrayList<Revista> getRevistasSuscritas() {
        return revistasSuscritas;
    }

    public void setRevistasSuscritas(ArrayList<Revista> revistasSuscritas) {
        this.revistasSuscritas = revistasSuscritas;
    }
    
}
