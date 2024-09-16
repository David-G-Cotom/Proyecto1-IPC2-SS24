/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.CompraAnuncioDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Carlos Cotom
 */
public class CarteraControler {
    
    private final CompraAnuncioDB dataRecarga = new CompraAnuncioDB();
    private Pago pago;
    
    public void crearRecargarCredito(HttpServletRequest request, int idUsuario) throws UserDataInvalidException {
        int idInversionista = this.dataRecarga.getIdInversionista(idUsuario);
        this.extraerYValidar(request, idInversionista);
        dataRecarga.crearApago(pago);
        dataRecarga.actualizarCreditoInversionistaAbono(pago.getCantidadPaog(), idInversionista);
    }
    
    private void extraerYValidar(HttpServletRequest request, int idInversionista) throws UserDataInvalidException {        
        LocalDate fecha;
        String cantidadAbono;
        try {
            fecha = LocalDate.parse(request.getParameter("fecha"));
            cantidadAbono = request.getParameter("cantidad");
        } catch (DateTimeParseException e) {
            throw new UserDataInvalidException("Error en el Campo de la Fecha");
        }
        this.isValidateCreation(fecha, cantidadAbono);
        double abono = Double.parseDouble(cantidadAbono);
        this.pago = new Pago(abono, fecha, idInversionista);
    }

    private void isValidateCreation(LocalDate fecha, String cantidadAbono) throws UserDataInvalidException {
        if (cantidadAbono == null || cantidadAbono.equals("")) {
            throw new UserDataInvalidException("Debe Llenar el Campo para la Cantidad a Recargar");
        } else {
            try {
                double cantidad = Double.parseDouble(cantidadAbono);
                if (cantidad < 0) {
                    throw new UserDataInvalidException("El Campo para la Cantidad a Recargar debe de ser Positivo");
                }
            } catch (NumberFormatException e) {
                throw new UserDataInvalidException("El Campo para la Cantidad a Recargar debe de ser un Numero Positivo");
            }
        }
        if (fecha == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Fecha de Compra del Anuncio");
        }
    }
    
}
