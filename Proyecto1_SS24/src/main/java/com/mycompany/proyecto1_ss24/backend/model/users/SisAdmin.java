/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import com.mycompany.proyecto1_ss24.backend.model.Revista;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio;

/**
 *
 * @author Carlos Cotom
 */
public class SisAdmin extends UsuarioAplicacion {
    
    public SisAdmin(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos);
    }
    
    public boolean ponerPrecioAnuncio(Anuncio anuncio) {
        
        return false;
        
    }
    
    public boolean ponerPrecioTimepoAnuncio(Anuncio anuncio) {
        
        return false;
        
    }
    
    public boolean modificarCostoRevista(Revista revista) {
        
        return false;
        
    }
    
    public void verReporteGanancias() {
        
    }
    
    public void verReporteAnuncios() {
        
    }
    
    public void verReporteTopRevistasPopulares() {
        
    }
    
    public void verReporteTopRevistasComentadas() {
        
    }
    
    public void exportarReporte() {
        
    }
    
}
