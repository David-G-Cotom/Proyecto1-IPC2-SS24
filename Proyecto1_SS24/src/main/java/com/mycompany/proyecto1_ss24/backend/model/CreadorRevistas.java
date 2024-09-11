/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.RevistaDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorRevistas {
    
    private RevistaDB dataRevista = new RevistaDB();
    
    public Revista crearRevista(HttpServletRequest request) throws UserDataInvalidException {
        Revista nuevaRevista = this.extraerYValidar(request);        
        dataRevista.crearRevista(nuevaRevista);        
        return nuevaRevista;
    }
    
    private Revista extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        Revista nuevaRevista = new Revista();
        nuevaRevista.setNombreRevista(request.getParameter("nombreRevista"));
        nuevaRevista.setDescripcion(request.getParameter("descripcionRevista"));
        
        
        
        try {
            nuevaRevista.setFechaCreacion(LocalDate.parse(request.getParameter("fecha")));            
        } catch (DateTimeParseException e) {
            throw new UserDataInvalidException("Error en el Campo de la Fecha");
        }
        nuevaRevista.setCategoria(CategoriaEnum.valueOf(request.getParameter("categoria")));
        String[] etiquetas = request.getParameterValues("tags");
        nuevaRevista.setEtiquetas(this.extraerEtiquetas(etiquetas));                
        String respuestaComentarios = request.getParameter("comentarios");
        nuevaRevista.setPuedeComentarse(respuestaComentarios.equals("SI"));
        String respuestaLikes = request.getParameter("likes");
        nuevaRevista.setPuedeTenerLikes(respuestaLikes.equals("SI"));
        String respuestaSuscripciones = request.getParameter("suscripciones");
        nuevaRevista.setPuedeSuscribirse(respuestaSuscripciones.equals("SI"));        
        this.isValidateCreation(nuevaRevista);
        return nuevaRevista;        
    }
    
    private ArrayList<EtiquetaEnum> extraerEtiquetas(String[] etiquetas) {        
        if (etiquetas.length > 0) {
            ArrayList<EtiquetaEnum> etiquetasEnum = new ArrayList<>();
            for (String etiqueta : etiquetas) {                
                etiquetasEnum.add(EtiquetaEnum.valueOf(etiqueta));
            }
            return etiquetasEnum;          
        }
        return null;
    }
    
    private void isValidateCreation(Revista revista) throws UserDataInvalidException {
        if (revista.getNombreRevista() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para el Nombre de la Revista");
        }
        if (revista.getDescripcion() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Descripcion de la Revista");
        }
        
        
        
        if (revista.getFechaCreacion() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Fecha de Creacion de la Revista");
        }
        if (revista.getCategoria() == null) {
            throw new UserDataInvalidException("Debe Eleguir una Categoria para la Revista");
        }
        if (revista.getEtiquetas()== null) {
            throw new UserDataInvalidException("Debe Eleguir al menos una Etiqueta  para la Revista");
        }
    }
    
}
