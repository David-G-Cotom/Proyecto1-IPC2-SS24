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
public class Suscriptor extends UsuarioAplicacion {
    
    private ArrayList<Revista> revistasSuscritas;
    
    public Suscriptor(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos);
    }

    public Suscriptor(ArrayList<Revista> revistasSuscritas, String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos);
        this.revistasSuscritas = revistasSuscritas;
    }

    public ArrayList<Revista> getRevistasSuscritas() {
        return revistasSuscritas;
    }

    public void setRevistasSuscritas(ArrayList<Revista> revistasSuscritas) {
        this.revistasSuscritas = revistasSuscritas;
    }
    
    public boolean suscribirse(Revista revista) {
        
        return false;
        
    }
    
    public void leerRevista(Revista revista) {
        
    }
    
    public Revista buscarRevista() {
        
        return null;
        
    }
    
    public void hacerComentario(Revista revista) {
        
    }
    
    public void verPerfilAutor(Revista revista) {
        
    }
    
    public void darLike(Revista revsita) {
        
    }
    
    public void descargarRevista(Revista revsita) {
        
    }
    
    public String establecerFechaSuscripcion() {
        
        return null;
        
    }
    
}
