/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.model.users.Suscriptor;
import java.time.LocalDate;

/**
 *
 * @author Carlos Cotom
 */
public class Suscripcion {
    
    private Suscriptor suscriptor;
    private LocalDate fechaSuscripcion;

    public Suscripcion(Suscriptor suscriptor, LocalDate fechaSuscripcion) {
        this.suscriptor = suscriptor;
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Suscriptor getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(Suscriptor suscriptor) {
        this.suscriptor = suscriptor;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }        
    
}
