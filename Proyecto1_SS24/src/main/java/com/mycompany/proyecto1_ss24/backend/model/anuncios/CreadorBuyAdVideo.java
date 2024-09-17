/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;

import com.mycompany.proyecto1_ss24.backend.data.CompraAnuncioDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserActionInvalidException;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import com.mycompany.proyecto1_ss24.backend.model.Pago;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorBuyAdVideo {
    
    private final CompraAnuncioDB dataCompra = new CompraAnuncioDB();
    private AnuncioVideo anuncio;
    private Pago pago;

    public AnuncioVideo crearCompra(HttpServletRequest request, int idUsuario) throws UserDataInvalidException, UserActionInvalidException {
        int idInversionista = dataCompra.getIdInversionista(idUsuario);
        this.extraerYValidar(request, idInversionista);
        dataCompra.crearAnuncio(this.anuncio, idInversionista);
        dataCompra.crearAnuncioVideo(anuncio);
        dataCompra.crearApago(pago);
        dataCompra.actualizarCreditoInversionistaCompra(pago.getCantidadPaog(), idInversionista);
        return this.anuncio;
    }

    private void extraerYValidar(HttpServletRequest request, int idInversionista) throws UserDataInvalidException, UserActionInvalidException {
        String tipoAnuncio = request.getParameter("tipoanuncio");
        String duracionDias = request.getParameter("duracion");
        String tituloAnuncio = request.getParameter("titulo");
        LocalDate fecha;
        Part filePart;
        InputStream inputStream;
        try {
            fecha = LocalDate.parse(request.getParameter("fecha"));
            filePart = request.getPart("videoFile");
            inputStream = filePart.getInputStream();
        } catch (DateTimeParseException e) {
            throw new UserDataInvalidException("Error en el Campo de la Fecha, Debe Eleguir una Fecha Valida");
        } catch (ServletException | IOException e) {
            throw new UserDataInvalidException("Error en el Campo para Seleccionar el Archivo de Video");
        }
        this.isValidateCreation(fecha, duracionDias, tituloAnuncio, filePart.getSubmittedFileName());
        double costoCompra = dataCompra.getCostoCompra(tipoAnuncio, duracionDias);
        double creditoInversionista = dataCompra.getCredito(idInversionista);
        if (costoCompra > creditoInversionista) {
            throw new UserActionInvalidException("No se Puede Ejecutar la Compra, Necesitas mas Credito para la Compra, Antes Recarga Credito a tu Cartera Digital");
        }
        int idTipoAnuncio = dataCompra.getIdTipoAnuncio(tipoAnuncio);
        int idPeriodoTiempo = dataCompra.getIdPeriodoTiempo(duracionDias);
        int vigenciaDias = Integer.parseInt(duracionDias);
        this.anuncio = new AnuncioVideo(inputStream, costoCompra, vigenciaDias, true, idInversionista, idPeriodoTiempo, idTipoAnuncio);
        this.anuncio.setTitulo(tituloAnuncio);
        this.pago = new Pago(costoCompra, fecha, idInversionista);
    }

    private void isValidateCreation(LocalDate fecha, String duracionDias, String titulo, String fileName) throws UserDataInvalidException {
        if (fecha == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Fecha de Compra del Anuncio");
        }
        if (duracionDias.equals("")) {
            throw new UserDataInvalidException("Debe Eleguir una Duracion para el Anuncio");
        }
        if (titulo.equals("")) {
            throw new UserDataInvalidException("Debe Completar el Campo para el Titulo del Anuncio");
        }
        if (fileName.equals("")) {
            throw new UserDataInvalidException("Debe Seleccionar un Video para el Anuncio");
        }
        if (!this.extensCorrect(fileName)) {
            throw new UserDataInvalidException("El Archivo Seleccionado debe de ser en formato: .avi .mp4 .mkv .webm .ogg .flv .mov .wmv");
        }
    }

    private boolean extensCorrect(String fileName) {
        String[] extens = {".avi", ".mp4", ".mkv", ".webm", ".ogg", ".flv", ".mov", ".wmv"};
        for (String exten : extens) {
            if (fileName.toLowerCase().endsWith(exten)) {
                return true;
            }
        }
        return false;
    }
    
}
