/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class Editor extends UsuarioAplicacion {
    
    private ArrayList<Revista> revistas;

    public Editor(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
    }

    public Editor(ArrayList<Revista> revistas, String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
        this.revistas = revistas;
    }        

    public ArrayList<Revista> getRevistas() {
        return revistas;
    }

    public void setRevistas(ArrayList<Revista> revistas) {
        this.revistas = revistas;
    }
    
    public void publicarRevista() {
        
    }
    
    public void permitirComentarios(Revista revista) {
        
    }
    
    public void permitirLikes(Revista revista) {
        
    }
    
    public void permitirSuscripciones(Revista revista) {
        
    }
    
    public void verReporteComentarios() {
        
    }
    
    public void verReporteSuscripciones() {
        
    }
    
    public void verReporteTopRevistas() {
        
    }
    
    public void establecerFechaCreacion(Revista revista) {
        
    }
            
    public boolean exportarReporte() {
        
        return false;
        
    }
    
}
