/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.Revista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Carlos Cotom
 */
public class PreciosRevistaDB {
    
    private final Connection connection = ConexionDB.getConnection();
    
    public ArrayList<Revista> getAllRevistas() {
        String query = "SELECT * FROM revista";
        ArrayList<Revista> revistas = new ArrayList<>();
        try (Statement state = this.connection.createStatement();
                ResultSet resul = state.executeQuery(query)){
            while (resul.next()) {
                Revista revista = new Revista();
                revista.setIdRevista(resul.getInt("id_revista"));
                revista.setDescripcion(resul.getString("descripcion"));
                revista.setLikes(resul.getInt("likes"));
                revista.setCosto(resul.getDouble("costo"));
                revista.setNombreRevista(resul.getString("nombre"));
                revistas.add(revista);
            }
        } catch (SQLException e) {
            System.out.println("Error al Consultar todas las Revistas Registradas en Sistema: " + e);
        }
        return revistas;
    }
    
}
