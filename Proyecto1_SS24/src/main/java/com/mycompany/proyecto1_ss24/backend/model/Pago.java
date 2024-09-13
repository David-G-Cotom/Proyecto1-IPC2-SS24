/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import java.time.LocalDate;

/**
 *
 * @author Carlos Cotom
 */
public class Pago {
    
    private double cantidadPaog;
    private LocalDate fechaPago;
    private int idInversionista;

    public Pago() {
    }

    public Pago(double cantidadPaog, LocalDate fechaPago, int idInversionista) {
        this.cantidadPaog = cantidadPaog;
        this.fechaPago = fechaPago;
        this.idInversionista = idInversionista;
    }

    public double getCantidadPaog() {
        return cantidadPaog;
    }

    public void setCantidadPaog(double cantidadPaog) {
        this.cantidadPaog = cantidadPaog;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }        

    public int getIdInversionista() {
        return idInversionista;
    }

    public void setIdInversionista(int idInversionista) {
        this.idInversionista = idInversionista;
    }
    
}
