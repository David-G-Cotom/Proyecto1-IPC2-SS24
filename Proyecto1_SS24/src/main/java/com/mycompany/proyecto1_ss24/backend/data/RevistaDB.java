/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.CategoriaEnum;
import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class RevistaDB {
    
    private Connection connection = ConexionDB.getConnection();
    
    public void crearRevista(Revista revista) {
        String query = "INSERT INTO revista (descripcion, fecha_creacion, nombre, estado_comentarios, estado_likes, estado_suscripcion, categoria, archivo_pdf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            //editor
            prepared.setString(1, revista.getDescripcion());
            prepared.setString(2, revista.getFechaCreacion().toString());
            prepared.setString(3, revista.getNombreRevista());
            prepared.setBoolean(4, revista.isPuedeComentarse());
            prepared.setBoolean(5, revista.isPuedeTenerLikes());
            prepared.setBoolean(6, revista.isPuedeSuscribirse());
            int idCategoria = this.getIdCategoria(revista.getCategoria());
            prepared.setInt(7, idCategoria);
            prepared.setBlob(8, revista.getArchivoPDF());
            prepared.executeUpdate();
            System.out.println("Revista Creada!!!");
        } catch (SQLException e) {
            System.out.println("Error en crear una Revista: " + e);
        }
    }
    
    private int getIdCategoria(CategoriaEnum categoria) {
        String query = "SELECT id_categoria FROM categoria WHERE tipo = ?";
        int id = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, categoria.toString());
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    id = resul.getInt("id_categoria");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el id de la categoria: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el id de la categoria: " + e);
        }
        return id;
    }
    
    private int getIdEditor() {
        String query = "";
        int idAutor = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el id del Autor: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el id del Autor: " + e);
        }
        return idAutor;
    }
    
}
