package pe.edu.pucp.iweb.lab7.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.iweb.lab7.beans.EquipoRed;
import pe.edu.pucp.iweb.lab7.beans.Sede;

public class EquipoDao extends BaseDao{ // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna los equipos de la sede indicada, ordenados por sede y modelo.
     * Si idSede es 0, retorna todos los equipos.
     *
     * Según la columna tipo, cree un objeto EquipoSwitch ('SWITCH') o EquipoAP ('AP').
     * Use PreparedStatement.
     */
    public ArrayList<EquipoRed> listarPorSede(int idSede) {
        ArrayList<EquipoRed> lista = new ArrayList<>();
        String sql = "SELECT e.idequipo,e.modelo,e.tipo,e.precio,e.cantidad"
                + "s.idsede , s.nombre "
                + "FROM equipo e "
                + "INNER JOIN sede s ON e.idsede = s.idsede ";




        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                EquipoRed eq = new EquipoRed();
                eq.setIdEquipo(rs.getInt("idequipo"));
                eq.setModelo(rs.getString("modelo"));
                eq.setTipo(rs.getString("tipo"));
                eq.setPrecio(rs.getDouble("precio"));
                eq.setCantidad(rs.getInt("cantidad"));
                // para el otro objeto
                Sede sede = new Sede();
                sede.setIdSede(rs.getInt("idsede"));
                sede.setNombre(rs.getString("nombre"));
                eq.setSede(sede); // aqui se conectan Employee y Job
                lista.add(eq);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }




    // TODO 2c

    }

