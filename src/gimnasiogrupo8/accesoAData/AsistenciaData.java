
package gimnasiogrupo8.accesoAData;

import gimnasiogrupo8.entidad.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


public class AsistenciaData {
    Connection con = null;

    public AsistenciaData() {
        con = Conexion.getConexion();
    }
    
    public void registrarAsistencia(Asistencia asistencia){
        String sql = "INSERT INTO asistencia (ID_Clase, ID_Membresia, ID_Socio, FechaHora) VALUES (?,?,?,?)";
        
        Membresia membresia = asistencia.getMembresia();
        Clase clase = asistencia.getClase();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            if (membresia.getCantidadPases() == 0 || membresia.getFecha_fin().isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "No se puede anotar a la clase.Por Favor renueve su membresía!");
            } else {
                
                if (cantPersonasporClaseHoy(clase.getId_clase()) == clase.getCapacidad()) {
                    JOptionPane.showMessageDialog(null, "La clase está completa. No se permiten más personas.");
                } else {
                    
                    int idClase = asistencia.getClase().getId_clase();
                    int idMembresia = membresia.getId_membresia();
                    int idSocio = asistencia.getSocio().getId_socio();
                    Timestamp ts = Timestamp.valueOf(LocalDateTime.now());

                    ps.setInt(1, idClase);
                    ps.setInt(2, idMembresia);
                    ps.setInt(3, idSocio);
                    ps.setTimestamp(4, ts);

                    ps.executeUpdate();

                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                         asistencia.setIdAsistencia(rs.getInt(1));
                         JOptionPane.showMessageDialog(null, "Asistencia Registrada");
                    }

                    int cantPases = membresia.getCantidadPases();
                    membresia.setCantidadPases(cantPases--);
                     if (cantPases == 0) {
                         membresia.setEstado(false);
                         JOptionPane.showMessageDialog(null, "Membresía caducada");
                     }

                    ps.close(); 
                }
            }
                
               
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asistencia");
            ex.printStackTrace();
        }
    }
    
    public int cantPersonasporClaseHoy(int idClase){
        int cantPersonas = 0;
        
         String sql = "SELECT * FROM asistencia WHERE ID_Clase = ? AND DATE(FechaHora) = ?";
         
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            
            ResultSet rs = ps.executeQuery();
            ClaseData cd = new ClaseData();
            while(rs.next()) {
                cantPersonas++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Asistencia");
        }
         return cantPersonas;
    }
    
}
