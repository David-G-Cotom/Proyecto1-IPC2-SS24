/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.model.users;

import com.mycompany.proyecto1_ss24.backend.model.Pago;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class Inversionista extends UsuarioAplicacion {
    
    private double credito;
    private ArrayList<Anuncio> anunciosComprados;
    private ArrayList<Pago> pagosHechos;

    public Inversionista(String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
    }

    public Inversionista(double credito, ArrayList<Anuncio> anunciosComprados, ArrayList<Pago> pagosHechos, String pathPhoto, String hobbies, String temasInteres, String descripcion, String gustos, String userName, String password, int tipoUsuario, String nombre, int idUsuario) {
        super(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuario, nombre, idUsuario);
        this.credito = credito;
        this.anunciosComprados = anunciosComprados;
        this.pagosHechos = pagosHechos;
    }        

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public ArrayList<Anuncio> getAnunciosComprados() {
        return anunciosComprados;
    }

    public void setAnunciosComprados(ArrayList<Anuncio> anunciosComprados) {
        this.anunciosComprados = anunciosComprados;
    }

    public ArrayList<Pago> getPagosHechos() {
        return pagosHechos;
    }

    public void setPagosHechos(ArrayList<Pago> pagosHechos) {
        this.pagosHechos = pagosHechos;
    }
    
    public boolean comprarAnuncio(Anuncio anuncio) {
        
        return false;
        
    }
    
    public boolean recargarCredito() {
        
        return false;
        
    }
    
    public void desactivarAnuncio(Anuncio anuncio) {
        
    }
    
    public String establecerFechaPago() {
        
        return null;
        
    }
    
}
