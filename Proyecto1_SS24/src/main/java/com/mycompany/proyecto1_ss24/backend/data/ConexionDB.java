/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class ConexionDB {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/blog_revistas_bd";
    private static final String USER = "root";
    private static final String PASSWORD = "uipc2w8e9u1ner";
    private static Connection connection;

    public ConexionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectarse con MySQL");
        }
    }
    
    public static Connection getConnection() {
        if (connection == null) {
            new ConexionDB();
            System.out.println("Conexion Exitosa");
        }
        return connection;
    }
    
}
