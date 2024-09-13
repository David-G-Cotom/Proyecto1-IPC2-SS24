/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1_ss24.backend.data;

import com.mycompany.proyecto1_ss24.backend.model.Pago;
import com.mycompany.proyecto1_ss24.backend.model.anuncios.Anuncio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos Cotom
 */
public class CompraAnuncioDB {
    
    private final Connection connection = ConexionDB.getConnection();
    
    public void crearAnuncio(Anuncio anuncio, int idInversionista) {
        String query = "INSERT INTO anuncio (costo, tipo_anuncio, inversionista, vigencia_dias, estado, id_periodo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setDouble(1, anuncio.getPrecio());
            prepared.setInt(2, anuncio.getIdTipoAnuncio());
            prepared.setInt(3, anuncio.getIdInversionista());
            prepared.setInt(4, anuncio.getVigenciaDias());
            prepared.setBoolean(5, anuncio.isIsActivo());
            prepared.setInt(6, anuncio.getIdPeriodoTiempo());
            prepared.executeUpdate();
            System.out.println("Anuncio Creado!!!");
        } catch (SQLException e) {
            System.out.println("Error en crear un Anuncio: " + e);
        }
    }
    
    public void crearApago(Pago pago) {
        String query = "INSERT INTO pago (inversionista, monto, fecha_pago) VALUES (?, ?, ?)";
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, pago.getIdInversionista());
            prepared.setDouble(2, pago.getCantidadPaog());
            prepared.setString(3, pago.getFechaPago().toString());
            prepared.executeUpdate();
            System.out.println("Pago Creado!!!");
        } catch (SQLException e) {
            System.out.println("Error en crear un Pago: " + e);
        }
    }
    
    public void actualizarCreditoInversionistaCompra(double gasto, int idInversionista) {
        String query = "UPDATE inversionista SET credito= ? WHERE id_inversionista = ?";
        double creditoActual = this.getCredito(idInversionista);
        creditoActual -= gasto;
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setDouble(1, creditoActual);
            prepared.setInt(2, idInversionista);
            prepared.executeUpdate();
            System.out.println("Credito del Inversionista actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Credito del Inversionista: " + e);
        }
    }
    
    public void actualizarCreditoInversionistaAbono(double abono, int idInversionista) {
        String query = "UPDATE inversionista SET credito= ? WHERE id_inversionista = ?";
        double creditoActual = this.getCredito(idInversionista);
        creditoActual += abono;
        try (PreparedStatement prepared = connection.prepareStatement(query)) {
            prepared.setDouble(1, creditoActual);
            prepared.setInt(2, idInversionista);
            prepared.executeUpdate();
            System.out.println("Credito del Inversionista actualizado");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Credito del Inversionista: " + e);
        }
    }
    
    public int getIdInversionista(int idUsuario) {
        String query = "SELECT id_inversionista FROM inversionista WHERE usuario = ?";
        int idInversionista = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idUsuario);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idInversionista = resul.getInt("id_inversionista");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el ID del Inversionista: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el ID del Inversionista: " + e);
        }
        return idInversionista;
    }
    
    public double getCostoCompra(String tipoAnuncio, String duracionTiempo) {
        double costoTipoAnuncio = this.getPrecioTipoAnuncio(tipoAnuncio);
        double costoPeriodoTiempo = this.getPrecioPeriodoTiempo(duracionTiempo);
        return costoTipoAnuncio + costoPeriodoTiempo;
    }
    
    private double getPrecioTipoAnuncio(String tipoAnuncio) {
        String query = "SELECT precio FROM tipo_anuncio WHERE tipo = ?";
        double precioTipoAnuncio = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, tipoAnuncio);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    precioTipoAnuncio = resul.getDouble("precio");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el Precio de un Tipo de Anuncio: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el Precio de un Tipo de Anuncio: " + e);
        }
        return precioTipoAnuncio;
    }
    
    private double getPrecioPeriodoTiempo(String peridoTiempo) {
        int cantidadDias = Integer.parseInt(peridoTiempo);
        String query = "SELECT precio FROM periodo_tiempos WHERE tiempo_dias = ?";
        double precioPeriodoTiempo = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, cantidadDias);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    precioPeriodoTiempo = resul.getDouble("precio");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el Precio de un Periodo de Tiempo: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el Precio de un Periodo de Tiempo: " + e);
        }
        return precioPeriodoTiempo;
    }
    
    public double getCredito(int idInversionista) {
        String query = "SELECT credito FROM inversionista WHERE id_inversionista = ?";
        double credito = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, idInversionista);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    credito = resul.getDouble("credito");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el Credito del Inversionista: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el Credito del Inversionista: " + e);
        }
        return credito;
    }
    
    public int getIdTipoAnuncio(String tipoAnuncio) {
        String query = "SELECT id_tipo FROM tipo_anuncio WHERE tipo = ?";
        int idTipoAnuncio = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setString(1, tipoAnuncio);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idTipoAnuncio = resul.getInt("id_tipo");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el ID de un Tipo de Anuncio: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el ID de un Tipo de Anuncio: " + e);
        }
        return  idTipoAnuncio;
    }
    
    public int getIdPeriodoTiempo(String peridoTiempo) {
        int cantidadDias = Integer.parseInt(peridoTiempo);
        String query = "SELECT id_periodo FROM periodo_tiempos WHERE tiempo_dias = ?";
        int idPeriodoTiempo = 0;
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            prepared.setInt(1, cantidadDias);
            try (ResultSet resul = prepared.executeQuery()) {
                if (resul.next()) {
                    idPeriodoTiempo = resul.getInt("id_periodo");
                }
            } catch (SQLException e) {
                System.out.println("Error en recibir el ID de un Periodo de Tiempo: " + e);
            }
        } catch (SQLException e) {
            System.out.println("Error en recibir el ID de un Periodo de Tiempo: " + e);
        }
        return idPeriodoTiempo;
    }
    
}
