/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;

import java.time.LocalDate;

/**
 *
 * @author Carlos Cotom
 */
public class AnuncioTextoImagen extends Anuncio {
    
    private String contenido;
    private String pathImage;

    public AnuncioTextoImagen(double precio, int vigenciaDias, boolean isActivo, LocalDate fechaCompra) {
        super(precio, vigenciaDias, isActivo, fechaCompra);
    }
    public AnuncioTextoImagen(String contenido, String pathImage, double precio, int vigenciaDias, boolean isActivo, LocalDate fechaCompra) {
        super(precio, vigenciaDias, isActivo, fechaCompra);
        this.contenido = contenido;
        this.pathImage = pathImage;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }    
    
}
