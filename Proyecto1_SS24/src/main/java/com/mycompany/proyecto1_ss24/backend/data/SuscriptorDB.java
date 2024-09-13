/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class SuscriptorDB {
    
    private final Connection connection = ConexionDB.getConnection();
    
    public void crearComentario(Comentario comentario, int idUsuario) {
        String query = "INSERT INTO comentario (revista, contenido, suscriptor) VALUES (?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            int idSuscriptor = this.getIdSuscriptor(idUsuario);
            prepared.setInt(1, comentario.getRevista());
            prepared.setString(2, comentario.getContenido());
            prepared.setInt(3, idSuscriptor);
            prepared.executeUpdate();
            System.out.println("Comentario Creado!!!");
        } catch (SQLException e) {
            System.out.println("Error en crear un Comentario: " + e);
        }
    }
    
    public int getIdSuscriptor(int idUsuario) {
        String query = "SELECT id_suscriptor FROM suscriptor WHERE usuario = ?";
        int idSuscriptor = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idSuscriptor = resul.getInt("id_suscriptor");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el id del Suscriptor: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el id del Suscriptor: " + e);
        }
        return idSuscriptor;
    }
    
    public boolean crearLike(int idUsuario, int idRevista) {
        String query = "INSERT INTO likes (revista, suscriptor) VALUES (?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            int idSuscriptor = this.getIdSuscriptor(idUsuario);
            prepared.setInt(1, idRevista);
            prepared.setInt(2, idSuscriptor);
            prepared.executeUpdate();
            System.out.println("Like Creado!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("Error en crear un Like: " + e);
            return false;
        }
    }
    
    public boolean revistaConLike(int idRevista, int idSuscriptor) {
        String query = "SELECT * FROM likes WHERE revista = ? AND suscriptor = ?";
        boolean tieneLike = false;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idRevista);
            prepared.setInt(2, idSuscriptor);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    tieneLike = true;
                }
            } catch (SQLException e) {
                System.out.println("Error en saber si la Revista Tiene LIke: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en saber si la Revista Tiene LIke: " + e);
        }
        return tieneLike;
    }
    
}
