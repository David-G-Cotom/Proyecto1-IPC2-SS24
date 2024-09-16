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
public class ActualizadorPrecioPeriodoTiempo {
    
    private final PreciosAnuncioDB dataPrecios = new PreciosAnuncioDB();
    
    public void actualizarPreciosTiempo(HttpServletRequest request) throws UserDataInvalidException {
        double[] precios = this.extraerYValidar(request);
        this.dataPrecios.actualizarPrecioPeriodoTiempo(precios);
    }
    
    private double[] extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        double[] precios = new double[4];
        String[] preciosdata = new String[4];
        preciosdata[0] = request.getParameter("precio-1");
        preciosdata[1] = request.getParameter("precio-3");
        preciosdata[2] = request.getParameter("precio-7");
        preciosdata[3] = request.getParameter("precio-14");
        this.isValidateCreation(preciosdata);
        for (int i = 0; i < preciosdata.length; i++) {
            precios[i] = Double.parseDouble(preciosdata[i]);
        }
        return precios;
    }
    
    private void isValidateCreation(String[] preciosdata) throws UserDataInvalidException {
        for (String precioData : preciosdata) {
            try {
                double precio = Double.parseDouble(precioData);
                if (precio < 0) {
                    throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio a un Periodo de Tiempo");
                }
            }catch (NumberFormatException e) {
                throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio a un Periodo de Tiempo");
            }
        }
    }
    
}
