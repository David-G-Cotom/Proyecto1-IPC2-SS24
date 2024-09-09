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
public class LogUsuarioDB {

    private Connection connection = ConexionDB.getConnection();

    public UsuarioAplicacion getUsuario(String userName, String password) {
        String query = "SELECT * FROM usuario WHERE user_name = ? AND password = ?";
        UsuarioAplicacion usuario = null;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, userName);
            prepared.setString(2, password);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    String pathPhoto = resul.getString("foto");
                    String hobbies = resul.getString("hobbies");
                    String temasInteres = resul.getString("temas_interes");
                    String descripcion = resul.getString("descripcion");
                    String gustos = resul.getString("gustos");
                    int tipoUsuairo = resul.getInt("tipo_usuario");
                    usuario = new UsuarioAplicacion(pathPhoto, hobbies, temasInteres, descripcion, gustos, userName, password, tipoUsuairo);                    
                }
            } catch (SQLException e) {
                
            }
        } catch (SQLException e) {
            
        }
        return usuario;
    }

}
