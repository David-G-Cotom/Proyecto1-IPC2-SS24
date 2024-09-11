/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model;

import com.mycompany.proyecto1_ss24.backend.model.users.Editor;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class Revista {
    
    private boolean puedeComentarse;
    private boolean puedeTenerLikes;
    private boolean puedeSuscribirse;
    private String descripcion;
    private CategoriaEnum categoria;
    private ArrayList<EtiquetaEnum> etiquetas;
    private Editor autor;
    private int likes;
    private ArrayList<Comentario> comentarios;
    private int costo;
    private LocalDate fechaCreacion;
    private ArrayList<Suscripcion> suscripciones;
    private String nombreRevista;
    private InputStream archivoPDF;
    private byte[] bytesArchivo;

    public Revista() {
    }
    
    public Revista(boolean puedeComentarse, boolean puedeTenerLikes, boolean puedeSuscribirse, String descripcion, CategoriaEnum categoria, ArrayList<EtiquetaEnum> etiquetas, Editor autor, int likes, ArrayList<Comentario> comentarios, int costo, LocalDate fechaCreacion, ArrayList<Suscripcion> suscripciones, String nombreRevista, InputStream archivoPDF, byte[] bytesArchivo) {
        this.puedeComentarse = puedeComentarse;
        this.puedeTenerLikes = puedeTenerLikes;
        this.puedeSuscribirse = puedeSuscribirse;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
        this.autor = autor;
        this.likes = likes;
        this.comentarios = comentarios;
        this.costo = costo;
        this.fechaCreacion = fechaCreacion;
        this.suscripciones = suscripciones;
        this.nombreRevista = nombreRevista;
        this.archivoPDF = archivoPDF;
        this.bytesArchivo = bytesArchivo;
    }

    public boolean isPuedeComentarse() {
        return puedeComentarse;
    }

    public void setPuedeComentarse(boolean puedeComentarse) {
        this.puedeComentarse = puedeComentarse;
    }

    public boolean isPuedeTenerLikes() {
        return puedeTenerLikes;
    }

    public void setPuedeTenerLikes(boolean puedeTenerLikes) {
        this.puedeTenerLikes = puedeTenerLikes;
    }

    public boolean isPuedeSuscribirse() {
        return puedeSuscribirse;
    }

    public void setPuedeSuscribirse(boolean puedeSuscribirse) {
        this.puedeSuscribirse = puedeSuscribirse;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public ArrayList<EtiquetaEnum> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<EtiquetaEnum> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Editor getAutor() {
        return autor;
    }

    public void setAutor(Editor autor) {
        this.autor = autor;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Suscripcion> getSuscripciones() {
        return suscripciones;
    }

    public void setSuscripciones(ArrayList<Suscripcion> suscripciones) {
        this.suscripciones = suscripciones;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public InputStream getArchivoPDF() {
        return archivoPDF;
    }

    public void setArchivoPDF(InputStream archivoPDF) {
        this.archivoPDF = archivoPDF;
    }

    public byte[] getBytesArchivo() {
        return bytesArchivo;
    }

    public void setBytesArchivo(byte[] bytesArchivo) {
        this.bytesArchivo = bytesArchivo;
    }

    @Override
    public String toString() {
        return "Revista{ "
                + "<br>puedeComentarse = " + puedeComentarse
                + "<br>puedeTenerLikes = " + puedeTenerLikes
                + "<br>puedeSuscribirse = " + puedeSuscribirse
                + "<br>descripcion = " + descripcion
                + "<br>categoria = " + categoria
                + "<br>etiquetas = " + etiquetas
                + "<br>fechaCreacion = " + fechaCreacion
                + "<br>nombreRevista = " + nombreRevista + '}';
    }
    
}
