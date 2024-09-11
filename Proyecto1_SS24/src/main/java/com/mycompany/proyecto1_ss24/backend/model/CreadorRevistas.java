/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.data.RevistaDB;
import com.mycompany.proyecto1_ss24.backend.exceptions.UserDataInvalidException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class CreadorRevistas {
    
    private RevistaDB dataRevista = new RevistaDB();
    
    public Revista crearRevista(HttpServletRequest request, int idUsuario) throws UserDataInvalidException {
        Revista nuevaRevista = this.extraerYValidar(request);        
        dataRevista.crearRevista(nuevaRevista, idUsuario);        
        return nuevaRevista;
    }
    
    private Revista extraerYValidar(HttpServletRequest request) throws UserDataInvalidException {
        Revista nuevaRevista = new Revista();
        nuevaRevista.setNombreRevista(request.getParameter("nombreRevista"));
        nuevaRevista.setDescripcion(request.getParameter("descripcionRevista"));
        Part filePart;
        InputStream inputStream;
        try {
            filePart = request.getPart("pdfFile");
            inputStream = filePart.getInputStream();
            nuevaRevista.setArchivoPDF(inputStream);        
            nuevaRevista.setFechaCreacion(LocalDate.parse(request.getParameter("fecha")));            
        } catch (IOException | ServletException ex) {
            throw new UserDataInvalidException("Error en el Campo para Seleccionar el Archivo");
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
        this.isValidateCreation(nuevaRevista, filePart.getSubmittedFileName());
        return nuevaRevista;        
    }
    
    private ArrayList<EtiquetaEnum> extraerEtiquetas(String[] etiquetas) {        
        if (etiquetas != null) {
            ArrayList<EtiquetaEnum> etiquetasEnum = new ArrayList<>();
            for (String etiqueta : etiquetas) {                
                etiquetasEnum.add(EtiquetaEnum.valueOf(etiqueta));
            }
            return etiquetasEnum;          
        }
        return null;
    }
    
    private void isValidateCreation(Revista revista, String fileName) throws UserDataInvalidException {
        if (revista.getNombreRevista() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para el Nombre de la Revista");
        }
        if (revista.getDescripcion() == null) {
            throw new UserDataInvalidException("Debe completar el Campo para la Descripcion de la Revista");
        }
        if (revista.getArchivoPDF() == null) {
            throw new UserDataInvalidException("Debe Seleccionar un Archivo PDF para la Revista");
        }
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            throw new UserDataInvalidException("El Archivo Seleccionado debe de ser en Formato PDF");
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
