/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}
