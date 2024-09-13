/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.anuncios;


/**
 *
 * @author Carlos Cotom
 */
public class AnuncioVideo extends Anuncio {
    
    private String pathVideo;

    public AnuncioVideo(double precio, int vigenciaDias, boolean isActivo, int idInversionista, int idPeriodoTiempo, int idTipoAnuncio) {
        super(precio, vigenciaDias, isActivo, idInversionista, idPeriodoTiempo, idTipoAnuncio);
    }

    public AnuncioVideo(String pathVideo, double precio, int vigenciaDias, boolean isActivo, int idInversionista, int idPeriodoTiempo, int idTipoAnuncio) {
        super(precio, vigenciaDias, isActivo, idInversionista, idPeriodoTiempo, idTipoAnuncio);
        this.pathVideo = pathVideo;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }        
    
}
