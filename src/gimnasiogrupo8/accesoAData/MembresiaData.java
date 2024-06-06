/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gimnasiogrupo8.accesoAData;

import gimnasiogrupo8.entidad.Membresia;
import gimnasiogrupo8.entidad.Socio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class MembresiaData {
    Connection con=null;
     public MembresiaData() {
        con=Conexion.getConexion();
    }
     //Guardar Membresia  
     public void guardarMembresia(Membresia membresia) {
         String sql="INSERT INTO `membresias`(`ID_Membresía`, `ID_Socio`, `Costo`, `CantidadPases`, `Fecha_Inicio`, `Fecha_Fin`, `Estado`) VALUES (?,?,?,?,?,?,?)";    
       
        
         try {
             PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1,membresia.getId_membresia());
             ps.setInt(2,membresia.getSocio().getId_socio());
             ps.setDouble(3,membresia.getCosto());
             ps.setInt(4, membresia.getCantidadPases());
             ps.setDate(5,Date.valueOf(membresia.getFecha_inicio()));
             ps.setDate(6,Date.valueOf(membresia.getFecha_fin()));
             ps.setBoolean(7,membresia.isEstado());
             
              ps.executeUpdate();
              
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                membresia.setId_membresia(rs.getInt(1)); // Asigna la clave generada al objeto membresia
                JOptionPane.showMessageDialog(null, "Membresía guardada con éxito");
            }
            ps.close();
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla Membresías");
        }
     }
      // Buscar membresía por socio
    public Membresia buscarMembresiaPorSocio(int idSocio) {
        Membresia membresia = null;
        String sql = "SELECT * FROM membresias WHERE ID_Socio = ? AND Estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSocio);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                SociosData sd = new SociosData();
                Socio socio = sd.buscarSocioPorId(idSocio);
                membresia = new Membresia();
                membresia.setId_membresia(rs.getInt("ID_Membresía"));
                membresia.setSocio(socio);
                membresia.setCosto(rs.getDouble("Costo"));
                membresia.setCantidadPases(rs.getInt("CantidadPases"));
                membresia.setFecha_inicio(rs.getDate("Fecha_Inicio").toLocalDate());
                membresia.setFecha_fin(rs.getDate("Fecha_Fin").toLocalDate());
                membresia.setEstado(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Membresía no existente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar membresía en la tabla Membresías");
        }
        return membresia;
    }

    // Listar membresías activas
    public List<Membresia> listarMembresiasActivas() {
        String sql = "SELECT * FROM membresias WHERE Estado = 1";
        List<Membresia> membresias = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SociosData sd = new SociosData();
                Socio socio=sd.buscarSocioPorId(rs.getInt("ID_socio"));
                Membresia membresia = new Membresia();
                membresia.setId_membresia(rs.getInt("ID_Membresía"));
                membresia.setSocio(socio);
                membresia.setCosto(rs.getDouble("Costo"));
                membresia.setCantidadPases(rs.getInt("CantidadPases"));
                membresia.setFecha_inicio(rs.getDate("Fecha_Inicio").toLocalDate());
                membresia.setFecha_fin(rs.getDate("Fecha_Fin").toLocalDate());
                membresia.setEstado(rs.getBoolean("Estado"));
                membresias.add(membresia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las membresías en la tabla Membresías");
        }
        return membresias;
    }

    // Modificar membresía
    public void modificarMembresia(Membresia membresia) {
        String sql = "UPDATE membresias SET Costo = ?, CantidadPases = ?, Fecha_Inicio = ?, Fecha_Fin = ?, Estado = ? WHERE ID_Membresía = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, membresia.getCosto());
            ps.setInt(2, membresia.getCantidadPases());
            ps.setDate(3, Date.valueOf(membresia.getFecha_inicio()));
            ps.setDate(4, Date.valueOf(membresia.getFecha_fin()));
            ps.setBoolean(5, membresia.isEstado());
            ps.setInt(6, membresia.getId_membresia());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Membresía modificada con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la membresía en la tabla Membresías");
        }
    }

    
}
