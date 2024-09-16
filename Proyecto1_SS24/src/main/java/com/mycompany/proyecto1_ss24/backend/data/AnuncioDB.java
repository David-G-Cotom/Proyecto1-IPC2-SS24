/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class AnuncioDB {
    
    private final Connection connection = ConexionDB.getConnection();
    
    public boolean editarAnuncio(int idAnuncio, boolean estado) {
        String query = "UPDATE anuncio SET estado = ? WHERE id_anuncio = ?";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setBoolean(1, estado);
            prepared.setInt(2, idAnuncio);
            prepared.execute();
            System.out.println("Estados del Anuncio Actualizado!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al Actualizar el Estado del Anuncio: " + e);
            return false;
        }
    }
    
    public int getIdInversionista(int idUsuario) {
        String query = "SELECT id_inversionista FROM inversionista WHERE usuario = ?";
        int idInversionista = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idInversionista = resul.getInt("id_inversionista");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el ID del Inversionista: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el ID del Inversionista: " + e);
        }
        return idInversionista;
    }
    
    public ArrayList<Anuncio> getAnuncios(int idInversionista) {
        String query = "SELECT * FROM anuncio WHERE inversionista = ?";
        ArrayList<Anuncio> anuncios = new ArrayList<>();
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idInversionista);
            try (ResultSet resul = prepared.executeQuery()) {
                while (resul.next()) {
                    int idAnuncio = resul.getInt("id_anuncio");
                    double costo = resul.getDouble("costo");
                    int idTipoAnuncio = resul.getInt("tipo_anuncio");                    
                    int vigencia = resul.getInt("vigencia_dias");
                    boolean estado = resul.getBoolean("estado");
                    int idPeriodo = resul.getInt("id_periodo");
                    Anuncio anuncio = new Anuncio(costo, vigencia, estado, idInversionista, idPeriodo, idTipoAnuncio);
                    anuncio.setIdAnuncio(idAnuncio);
                    anuncios.add(anuncio);
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir los Anuncios de un Inversionista: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir los Anuncios de un Inversionista: " + e);
        }
        return anuncios;
    }
    
    public double[] getPreciosTipoAnuncios() {
        String query = "SELECT precio FROM tipo_anuncio";
        double[] precios = new double[3];   //PORQUE SON 3 TIPOS DE ANUNCIOS
        int i = 0;
        try (Statement state = this.connection.createStatement();
                ResultSet resul = state.executeQuery(query)) {
            while (resul.next()) {
                precios[i] = resul.getDouble("precio");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error al Consulta los Precios de los Diferentes Tipos de Anuncios: " + e);
        }
        return precios;
    }
    
    public double[] getPreciosPeriodoTiempo() {
        String query = "SELECT precio FROM periodo_tiempos";
        double[] precios = new double[4];   //PORQUE SON 4 PERIODOS DE TIEMPO
        int i = 0;
        try (Statement state = this.connection.createStatement();
                ResultSet resul = state.executeQuery(query)) {
            while (resul.next()) {
                precios[i] = resul.getDouble("precio");
                i++;
            }
        } catch (SQLException e) {
            System.out.println("Error al Consulta los Precios de los Diferentes Periodos de Tiempo: " + e);
        }
        return precios;
    }
    
}
