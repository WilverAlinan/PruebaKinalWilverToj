package modelo;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class MConsultarInstrumentos extends Conexion {

    public boolean registrar(MInstrumentos Instr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "insert into pruebaKinal.tienda (codigo, marca, modelo, tipo_instrumento, precio, meses_garantia, pais_procedencia \n"
                + "			) VALUES (?,?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Instr.getCodigo());
            ps.setString(2, Instr.getMarca());
            ps.setInt(3, Instr.getModelo());
            ps.setString(4, Instr.getTipoInstrumento());
            ps.setDouble(5, Instr.getPrecio());
            ps.setInt(6, Instr.getMesesGarantia());
            ps.setString(7, Instr.getPaisProcedencia());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public boolean modificar(MInstrumentos Instr) {
    PreparedStatement ps = null;
    Connection con = getConexion();

    String sql = "UPDATE pruebaKinal.tienda SET codigo=?, marca=?, modelo=?, tipo_instrumento=?, precio=?, meses_garantia=?, pais_procedencia=? WHERE id=?";
    
    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, Instr.getCodigo());
        ps.setString(2, Instr.getMarca());
        ps.setInt(3, Instr.getModelo());
        ps.setString(4, Instr.getTipoInstrumento());
        ps.setDouble(5, Instr.getPrecio());
        ps.setInt(6, Instr.getMesesGarantia());
        ps.setString(7, Instr.getPaisProcedencia());
        ps.setInt(8, Instr.getId());
        
        int filasActualizadas = ps.executeUpdate(); // Usar executeUpdate para sentencias SQL de actualización
        
        if (filasActualizadas > 0) {
            return true;
        } else {
            return false;
        }
   
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }


    public boolean eliminar(MInstrumentos Instr) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pruebaKinal.tienda WHERE id=?;";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, Instr.getId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public boolean buscar(MInstrumentos Instr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM pruebaKinal.tienda WHERE codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Instr.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {

                Instr.setId(Integer.parseInt(rs.getString("id")));
                Instr.setCodigo(rs.getString("codigo"));
                Instr.setMarca(rs.getString("marca"));
                Instr.setTipoInstrumento(rs.getString("tipo_instrumento"));
                Instr.setPrecio(rs.getDouble("precio"));
                Instr.setMesesGarantia(rs.getInt("meses_garantia"));
                Instr.setPaisProcedencia(rs.getString("pais_procedencia"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

}
