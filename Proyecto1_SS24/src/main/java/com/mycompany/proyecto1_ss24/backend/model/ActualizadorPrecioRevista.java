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
        double precio = this.extraerYValidar(request);
        this.dataPrecios.actualizarPrecioRevista(precio, idRevista);
    }
    
    private double extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        double precio;
        String precioData = request.getParameter("precio");
        this.isValidateCreation(precioData);
        precio = Double.parseDouble(precioData);
        return precio;
    }
    
    private void isValidateCreation(String preciodata) throws UserDataInvalidException {
        try {
            double precioAnuncioTexto = Double.parseDouble(preciodata);
            if (precioAnuncioTexto < 0) {
                throw new UserDataInvalidException("Debe Colocar un Numero Positivo en el Campo para el Precio de la Revista");
            }
        } catch (NumberFormatException e) {
            throw new UserDataInvalidException("Debe Colocar un Numero en el Campo para el Precio de la Revista");
        }
    }
    
}
