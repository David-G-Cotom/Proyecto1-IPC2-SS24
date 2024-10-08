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
public class PerfilDB {
    
    private final Connection connection = ConexionDB.getConnection();
    
    public byte[] getImageUsuario(int idUsuario) {
        String query = "SELECT foto FROM usuario WHERE id_usuario = ?";
        byte[] dataImage = null;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    dataImage = resul.getBytes("foto");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el Contenido de la Foto: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el Contenido de la Foto: " + e);
        }
        return dataImage;
    }
    
    public UsuarioAplicacion getUsuario(int idUsuario) {
        String query = "SELECT * FROM usuario WHERE id_usuario = ?";
        UsuarioAplicacion usuario = null;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    usuario = new UsuarioAplicacion();
                    usuario.setIdUsuario(idUsuario);
                    usuario.setHobbies(resul.getString("hobbie"));
                    usuario.setTemasInteres(resul.getString("temas_interes"));
                    usuario.setDescripcion(resul.getString("descripcion"));
                    usuario.setGustos(resul.getString("gustos"));
                    usuario.setNombre(resul.getString("nombre"));
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir a un Usuario " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir a un Usuario " + e);
        }
        return usuario;
    }
    
    public void actualizarPerfil(UsuarioAplicacion nuevoUsuario) {
        String query = "UPDATE usuario SET foto = ?, hobbie = ?, temas_interes = ?, descripcion = ?, gustos = ?, nombre = ? WHERE id_usuario = ?";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setBlob(1, nuevoUsuario.getFoto());
            prepared.setString(2, nuevoUsuario.getHobbies());
            prepared.setString(3, nuevoUsuario.getTemasInteres());
            prepared.setString(4, nuevoUsuario.getDescripcion());
            prepared.setString(5, nuevoUsuario.getGustos());
            prepared.setString(6, nuevoUsuario.getNombre());
            prepared.setInt(7, nuevoUsuario.getIdUsuario());
            prepared.executeUpdate();
            System.out.println("Perfil del Usuario Actualizado!!!");
        } catch (SQLException e) {
            System.out.println("Error al Actualizar los Datos del Usuario " + e);
        }
    }
    
}
