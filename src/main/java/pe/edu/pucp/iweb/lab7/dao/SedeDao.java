package pe.edu.pucp.iweb.lab7.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.iweb.lab7.beans.Sede;

public class SedeDao extends BaseDao { // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna todas las sedes ordenadas por nombre.
     */
    public ArrayList<Sede> listar() {
        ArrayList<Sede> lista = new ArrayList<>();
        String sql = "SELECT idsede, nombre FROM sede";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Sede sede = new Sede();
                sede.setIdSede(rs.getInt("idsede"));
                sede.setNombre(rs.getString("nombre"));
                lista.add(sede);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * Apoyo para el Ejercicio 4: retorna la sede con el id indicado,
     * o null si no existe.
     */
    public Sede buscarPorId(int idSede) {
        // TODO 4
        return null;
    }
}
