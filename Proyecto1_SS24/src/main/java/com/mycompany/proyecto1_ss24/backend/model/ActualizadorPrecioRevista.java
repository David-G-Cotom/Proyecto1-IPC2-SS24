/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.PreciosRevistaDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Cotom
 */
public class ActualizadorPrecioRevista {
    
    private final PreciosRevistaDB dataPrecios = new PreciosRevistaDB();
    
    public void actualizarPrecioRevista(HttpServletRequest request, int idRevista) throws UserDataInvalidException {
        double[] precio = this.extraerYValidar(request);
        this.dataPrecios.actualizarPrecioRevista(precio[0], precio[1], idRevista);
    }
    
    private double[] extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        double precioDia;
        double precioGlobal;
        double[] precios = new double[2];
        String precioDiaData = request.getParameter("precio");
        String precioGlogalData = request.getParameter("precioGlobal");
        this.isValidateCreation(precioDiaData, precioGlogalData);
        precioDia = Double.parseDouble(precioDiaData);
        precioGlobal = Double.parseDouble(precioGlogalData);
        precios[0] = precioDia;
        precios[1] = precioGlobal;
        return precios;
    }
    
    private void isValidateCreation(String precioDia, String precioGlobal) throws UserDataInvalidException {
        try {
            double precioAnuncioTexto = Double.parseDouble(precioDia);
            if (precioAnuncioTexto < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio por Dia de la Revista");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio por Dia de la Revista");
        }
        try {
            double precioAnuncioTexto = Double.parseDouble(precioGlobal);
            if (precioAnuncioTexto < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio Global de la Revista");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio Global de la Revista");
        }
    }
    
}
