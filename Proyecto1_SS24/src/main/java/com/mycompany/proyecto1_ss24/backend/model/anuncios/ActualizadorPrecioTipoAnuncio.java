/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;

import com.mycompany.proyecto1_ss24.backend.data.PreciosAnuncioDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Cotom
 */
public class ActualizadorPrecioTipoAnuncio {
    
    private final PreciosAnuncioDB dataPrecios = new PreciosAnuncioDB();
    
    public void actualizarPreciosTipo(HttpServletRequest request) throws UserDataInvalidException {
        double[] precios = this.extraerYValidar(request);
        this.dataPrecios.actualizarPrecioTipoAnuncios(precios);
    }
    
    private double[] extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        double[] precios = new double[3];
        String precioTexto = request.getParameter("precio-texto");
        String precioTextoImagen = request.getParameter("precio-texto-imagen");
        String precioVideo = request.getParameter("precio-video");
        this.isValidateCreation(precioTexto, precioTextoImagen, precioVideo);
        double precioAnuncioTexto = Double.parseDouble(precioTexto);
        precios[0] = precioAnuncioTexto;
        double precioAnuncioTextoImagen = Double.parseDouble(precioTextoImagen);
        precios[1] = precioAnuncioTextoImagen;
        double precioAnuncioVideo = Double.parseDouble(precioVideo);
        precios[2] = precioAnuncioVideo;
        return precios;
    }
    
    private void isValidateCreation(String precioTexto, String precioTextoImagen, String precioVideo) throws UserDataInvalidException {
        try {
            double precioAnuncioTexto = Double.parseDouble(precioTexto);
            if (precioAnuncioTexto < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio del Anuncio de Texto");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio del Anuncio de Texto");
        }
        try {
            double precioAnuncioTextoImagen = Double.parseDouble(precioTextoImagen);
            if (precioAnuncioTextoImagen < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio del Anuncio de Texto e Imagen");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio del Anuncio de Texto e Imagen");
        }
        try {
            double precioAnuncioVideo = Double.parseDouble(precioVideo);
            if (precioAnuncioVideo < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio del Anuncio de Video");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio del Anuncio de Video");
        }
    }
    
}
