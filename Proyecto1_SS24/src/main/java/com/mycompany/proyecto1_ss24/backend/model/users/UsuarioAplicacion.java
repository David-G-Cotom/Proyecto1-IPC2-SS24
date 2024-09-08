/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

/**
 *
 * @author Carlos Cotom
 */
public class UsuarioAplicacion {
    
    private String pathPhoto;
    private String hobbies;
    private String temasInteres;
    private String descripcion;
    private String gustos;

    public UsuarioAplicacion(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos) {
        this.pathPhoto = pathPhoto;
        this.hobbies = hobbies;
        this.temasInteres = temasInteres;
        this.descripcion = descripcion;
        this.gustos = gustos;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getTemasInteres() {
        return temasInteres;
    }

    public void setTemasInteres(String temasInteres) {
        this.temasInteres = temasInteres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGustos() {
        return gustos;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }
    
    public void actualizarPerfil() {
        
    }
    
    public void verPerfil() {
        
    }
    
}
