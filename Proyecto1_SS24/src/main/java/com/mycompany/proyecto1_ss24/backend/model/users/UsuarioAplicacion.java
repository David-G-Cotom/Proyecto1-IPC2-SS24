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
    private String userName;
    private String password;
    private int tipoUsuario;
    private String nombre;

    public UsuarioAplicacion(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre) {
        this.pathPhoto = pathPhoto;
        this.hobbies = hobbies;
        this.temasInteres = temasInteres;
        this.descripcion = descripcion;
        this.gustos = gustos;
        this.userName = userName;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
    }

    public UsuarioAplicacion(String userName, String password, int tipoUsuario, String nombre) {
        this.userName = userName;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
