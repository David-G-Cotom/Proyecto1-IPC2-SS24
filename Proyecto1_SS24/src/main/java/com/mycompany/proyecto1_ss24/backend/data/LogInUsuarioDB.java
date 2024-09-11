/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.users.UsuarioAplicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class LogInUsuarioDB {

    private Connection connection = ConexionDB.getConnection();

    public UsuarioAplicacion getUsuario(String userName, String password) {
        String query = "SELECT * FROM usuario WHERE user_name = ? AND user_password = ?";
        UsuarioAplicacion usuario = null;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, userName);
            prepared.setString(2, password);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    String pathPhoto = resul.getString("foto");
                    String hobbies = resul.getString("hobbie");
                    String temasInteres = resul.getString("temas_interes");
                    String descripcion = resul.getString("descripcion");
                    String gustos = resul.getString("gustos");
                    int tipoUsuairo = resul.getInt("tipo_usuario");
                    String nombre = resul.getString("nombre");
                    usuario = new UsuarioAplicacion(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuairo, nombre);                    
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir usuario: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir usuario: " + e);
        }
        return usuario;
    }
    
    public int getTipoUsuario(String tipoUsuario) {
        String query = "SELECT id_tipo FROM tipo_usuario WHERE tipo = ?";
        int idTipo = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, tipoUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idTipo = resul.getInt("id_tipo");                    
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el id del tipo de usuario: " + e);
            }
        } catch (SQLException e) {            
            System.out.println("Error en recibir el id del tipo de usuario: " + e);
        }
        return idTipo;
    }
    
    public UsuarioAplicacion crearUsuario(String userName, String password, int tipoUsuario, String nombre) {
        String query = "INSERT INTO usuario (tipo_usuario, user_name, user_password, nombre) VALUES (?, ?, ?, ?)";
        UsuarioAplicacion usuario = null;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, tipoUsuario);
            prepared.setString(2, userName);
            prepared.setString(3, password);
            prepared.setString(4, nombre);
            prepared.executeUpdate();
            usuario = new UsuarioAplicacion(userName, password, tipoUsuario, nombre);
            System.out.println("Nuevo Usuario Creado");
        } catch (SQLException e) {
            System.out.println("Error en crear un Usuario: " + e);
        }
        return usuario;
    }

}
