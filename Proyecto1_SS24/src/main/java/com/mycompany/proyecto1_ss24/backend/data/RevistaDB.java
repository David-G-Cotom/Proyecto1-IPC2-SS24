/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class RevistaDB {
    
    private Connection connection = ConexionDB.getConnection();
    
    public void crearRevista(Revista revista) {
        String query = "INSERT INTO revista (descripcion, nombre, estado_comentarios, estado_likes, estado_suscripcion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, revista.getDescripcion());
            prepared.setString(2, revista.getNombreRevista());
            prepared.setBoolean(3, revista.isPuedeComentarse());
            prepared.setBoolean(4, revista.isPuedeTenerLikes());
            prepared.setBoolean(5, revista.isPuedeSuscribirse());
            prepared.executeUpdate();
            System.out.println("Revista Creada!!!");
        } catch (SQLException e) {
            System.out.println("Error en crear una Revista: " + e);
        }
    }
    
}
