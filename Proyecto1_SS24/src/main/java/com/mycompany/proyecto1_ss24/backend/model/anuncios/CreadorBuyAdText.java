/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;

import com.mycompany.proyecto1_ss24.backend.data.CompraAnuncioDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserActionInvalidException;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.Pago;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorBuyAdText {

    private final CompraAnuncioDB dataCompra = new CompraAnuncioDB();
    private AnuncioTexto anuncio;
    private Pago pago;

    public AnuncioTexto crearCompra(HttpServletRequest request, int idUsuario) throws UserDataInvalidException, UserActionInvalidException {
        int idInversionista = dataCompra.getIdInversionista(idUsuario);
        this.extraerYValidar(request, idInversionista);
        dataCompra.crearAnuncio(this.anuncio, idInversionista);
        dataCompra.crearAnuncioTexto(anuncio);
        dataCompra.crearApago(pago);
        dataCompra.actualizarCreditoInversionistaCompra(pago.getCantidadPaog(), idInversionista);
        return this.anuncio;
    }

    private void extraerYValidar(HttpServletRequest request, int idInversionista) throws UserDataInvalidException, UserActionInvalidException {        
        String tipoAnuncio = request.getParameter("tipoanuncio");
        String duracionDias = request.getParameter("duracion");
        String tituloAnuncio = request.getParameter("titulo");
        String contenidoAnuncio = request.getParameter("contenido");
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(request.getParameter("fecha"));
        } catch (DateTimeParseException e) {
            throw new UserDataInvalidException("Error en el Campo de la Fecha");
        }
        this.isValidateCreation(fecha, duracionDias, contenidoAnuncio, tituloAnuncio);
        double costoCompra = dataCompra.getCostoCompra(tipoAnuncio, duracionDias);
        double creditoInversionista = dataCompra.getCredito(idInversionista);
        if (costoCompra > creditoInversionista) {
            throw new UserActionInvalidException("No se Puede Ejecutar la Compra, Necesitas mas Credito para la Compra, Antes Recarga Credito a tu Cartera Digital");
        }
        int idTipoAnuncio = dataCompra.getIdTipoAnuncio(tipoAnuncio);
        int idPeriodoTiempo = dataCompra.getIdPeriodoTiempo(duracionDias);
        int vigenciaDias = Integer.parseInt(duracionDias);
        this.anuncio = new AnuncioTexto(contenidoAnuncio, costoCompra, vigenciaDias, true, idInversionista, idPeriodoTiempo, idTipoAnuncio);
        this.anuncio.setTitulo(tituloAnuncio);
        this.pago = new Pago(costoCompra, fecha, idInversionista);
    }

    private void isValidateCreation(LocalDate fecha, String duracionDias, String contenido, String titulo) throws UserDataInvalidException {        
        if (fecha == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Fecha de Compra del Anuncio");
        }
        if (duracionDias.equals("")) {
            throw new UserDataInvalidException("Debe Eleguir una Duracion para el Anuncio");
        }
        if (contenido.equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Contenido del Anuncio");
        }
        if (titulo.equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Titulo del Anuncio");
        }
    }

}
