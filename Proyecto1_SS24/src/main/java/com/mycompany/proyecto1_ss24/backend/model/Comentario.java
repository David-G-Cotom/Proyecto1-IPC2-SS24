/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.model.users.Suscriptor;

/**
 *
 * @author Carlos Cotom
 */
public class Comentario {
    
    private String contenido;
    private Suscriptor comentarista;

    public Comentario(String contenido, Suscriptor comentarista) {
        this.contenido = contenido;
        this.comentarista = comentarista;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Suscriptor getComentarista() {
        return comentarista;
    }

    public void setComentarista(Suscriptor comentarista) {
        this.comentarista = comentarista;
    }        
    
}
