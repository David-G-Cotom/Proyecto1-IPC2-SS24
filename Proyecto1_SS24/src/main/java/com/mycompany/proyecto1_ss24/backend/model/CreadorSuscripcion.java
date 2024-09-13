/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.SuscripcionDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorSuscripcion {

    private final SuscripcionDB dataSuscripcion = new SuscripcionDB();

    public Suscripcion crearSuscripcion(HttpServletRequest request, int idUsuario, int idRevista) throws UserDataInvalidException {
        Suscripcion nuevaSuscripcion = this.extraerYValidar(request, idRevista);
        dataSuscripcion.crearSuscripcion(nuevaSuscripcion, idUsuario);
        return nuevaSuscripcion;
    }

    private Suscripcion extraerYValidar(HttpServletRequest request, int idRevista) throws UserDataInvalidException {
        Suscripcion nuevaSuscripcion = new Suscripcion();
        nuevaSuscripcion.setRevista(idRevista);
        try {
            nuevaSuscripcion.setFechaSuscripcion(LocalDate.parse(request.getParameter("fecha")));
        } catch (DateTimeParseException e) {
            throw new UserDataInvalidException("Error en el Campo de la Fecha");
        }
        this.isValidateCreation(nuevaSuscripcion);
        return nuevaSuscripcion;
    }

    private void isValidateCreation(Suscripcion suscripcion) throws UserDataInvalidException {
        if (suscripcion.getFechaSuscripcion() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Fecha de Creacion de la Revista");
        }
    }

}
