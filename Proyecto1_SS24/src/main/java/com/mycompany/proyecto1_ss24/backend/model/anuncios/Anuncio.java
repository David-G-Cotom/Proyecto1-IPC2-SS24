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
public class Anuncio {
    
    private double precio;
    private int vigenciaDias;
    private boolean isActivo;
    private LocalDate fechaCompra;

    public Anuncio(double precio, int vigenciaDias, boolean isActivo, LocalDate fechaCompra) {
        this.precio = precio;
        this.vigenciaDias = vigenciaDias;
        this.isActivo = isActivo;
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVigenciaDias() {
        return vigenciaDias;
    }

    public void setVigenciaDias(int vigenciaDias) {
        this.vigenciaDias = vigenciaDias;
    }

    public boolean isIsActivo() {
        return isActivo;
    }

    public void setIsActivo(boolean isActivo) {
        this.isActivo = isActivo;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public void cambiarEstado() {
        
    }
    
}
