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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Cotom
 */
public class RevistaDB {

    private final Connection connection = ConexionDB.getConnection();

    public void crearRevista(Revista revista, int idUsuario) {
        String query = "INSERT INTO revista (editor, descripcion, likes, costo, fecha_creacion, nombre, estado_comentarios, estado_likes, estado_suscripcion, categoria, archivo_pdf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            int idAutor = this.getIdEditor(idUsuario);
            prepared.setInt(1, idAutor);
            prepared.setString(2, revista.getDescripcion());
            prepared.setInt(3, 0);
            prepared.setDouble(4, 0);
            prepared.setString(5, revista.getFechaCreacion().toString());
            prepared.setString(6, revista.getNombreRevista());
            prepared.setBoolean(7, revista.isPuedeComentarse());
            prepared.setBoolean(8, revista.isPuedeTenerLikes());
            prepared.setBoolean(9, revista.isPuedeSuscribirse());
            int idCategoria = this.getIdCategoria(revista.getCategoria());
            prepared.setInt(10, idCategoria);
            prepared.setBlob(11, revista.getArchivoPDF());
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

    public int getIdEditor(int idUsuario) {
        String query = "Select id_editor FROM editor WHERE usuario = ?";
        int idAutor = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idAutor = resul.getInt("id_editor");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el id del Autor: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el id del Autor: " + e);
        }
        return idAutor;
    }

    public boolean editarRevista(int idRevista, boolean comentarios, boolean likes, boolean suscripciones) {
        String query = "UPDATE revista SET estado_comentarios = ?, estado_likes = ?, estado_suscripcion = ? WHERE id_revista = ?";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setBoolean(1, comentarios);
            prepared.setBoolean(2, likes);
            prepared.setBoolean(3, suscripciones);
            prepared.setInt(4, idRevista);
            prepared.execute();
            System.out.println("Estados de la Revista Actualizada!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al Actualizar los Estados de la Revista " + e);
            return false;
        }
    }

    public ArrayList<Revista> getRevistas(int idEditor) {
        String query = "SELECT * FROM revista WHERE editor = ?";
        ArrayList<Revista> revistas = new ArrayList<>();
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idEditor);
            try (ResultSet resul = prepared.executeQuery()) {
                while (resul.next()) {
                    int idRevista = resul.getInt("id_revista");
                    String descripcion = resul.getString("descripcion");
                    int likes = resul.getInt("likes");
                    String nombre = resul.getString("nombre");
                    int idCategoria = resul.getInt("categoria");
                    String categoria = this.getCategoria(idCategoria);
                    Revista revista = new Revista(descripcion, CategoriaEnum.valueOf(categoria), likes, nombre, idRevista);
                    revistas.add(revista);
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir las revistas de un autor " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir las revistas de un autor " + e);
        }

        return revistas;
    }
    
    private String getCategoria(int idCategoria) {
        String query = "SELECT tipo FROM categoria WHERE id_categoria = ?";
        String categoria = "";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idCategoria);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    categoria = resul.getString("tipo");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el tipo de Categoria: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el tipo de Categoria: " + e);
        }
        return categoria;
    }
    
    private void getEtiquetas() {
        
    }

}
