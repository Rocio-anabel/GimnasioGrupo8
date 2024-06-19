package gimnasiogrupo8.accesoAData;

import gimnasiogrupo8.entidad.Clase;
import gimnasiogrupo8.entidad.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClaseData {
 
    Connection con= null;

    public ClaseData() {
        
        con=Conexion.getConexion();
    }
    
    public void guardarClase(Clase clase){
        
        String sql = "INSERT INTO clases(Nombre, ID_Entrenador, Horario, Capacidad, Estado) VALUES (?,?,?,?,?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getId_Entrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4,clase.getCapacidad());
            ps.setBoolean(5, clase.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                clase.setId_clase(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Clase Guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la Clase");
        }
    
    
    }
    
    public List<Clase> listaClase(){
        
        String sql = "SELECT  ID_Clase,Nombre, ID_Entrenador, Horario,Capacidad, Estado FROM clases WHERE Estado=1";
        List<Clase> clases= new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            EntrenadoresData ed = new EntrenadoresData();
            while(rs.next()){
                Entrenador entrenador = ed.buscarPorID(rs.getInt("ID_Entrenador"));
                Clase clase = new Clase();
                clase.setId_clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(true);
                clases.add(clase);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
        return clases;
    }
    
    public Clase buscarClasePorNombre(String nombre){
        
        Clase clase = null;
        String sql = "SELECT  ID_Clase,Nombre, ID_Entrenador, Horario,Capacidad, Estado FROM clases WHERE Estado=1 AND Nombre like ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                EntrenadoresData ed = new EntrenadoresData();
                Entrenador entrenador = ed.buscarPorID(rs.getInt("ID_Entrenador"));
                clase = new Clase();
                clase.setId_clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(true); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Clase");    
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
            return clase;
    
    
    }
    public Clase buscarClasePorEntrenador(int entrenador){
        
        Clase clase = null;
        String sql = "SELECT  ID_Clase,Nombre, ID_Entrenador, Horario,Capacidad, Estado FROM clases WHERE Estado=1"
                + " AND ID_Entrenador = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,entrenador);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                EntrenadoresData ed = new EntrenadoresData();
                Entrenador entre = ed.buscarPorID(entrenador);
                clase = new Clase();
                clase.setId_clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(entre);
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Clase");    
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
            return clase;
    
    
    }
    public Clase buscarClasePorHorario(LocalTime horario){
        
        Clase clase = null;
        String sql = "SELECT  ID_Clase,Nombre, ID_Entrenador, Horario,Capacidad, Estado FROM clases WHERE Estado=1 AND Horario = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setTime(1,Time.valueOf(horario));
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                EntrenadoresData ed = new EntrenadoresData();
                Entrenador entrenador = ed.buscarPorID(rs.getInt("ID_Entrenador"));
                clase = new Clase();
                clase.setId_clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Clase");    
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
            return clase;
    
    
    }
    
    public Clase buscarClasePorID(int idClase){
        Clase clase = null;
        String sql = "SELECT  ID_Clase,Nombre, ID_Entrenador, Horario,Capacidad, Estado FROM clases WHERE Estado=1 AND ID_Clase = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idClase);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                EntrenadoresData ed = new EntrenadoresData();
                Entrenador entrenador = ed.buscarPorID(rs.getInt("ID_Entrenador"));
                clase = new Clase();
                clase.setId_clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setEntrenador(entrenador);
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la Clase");    
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
            return clase;
    }
    
    public void modificarClase(Clase clase){ 
        String sql = "UPDATE clases SET Nombre=?,ID_Entrenador=?,Horario=?,Capacidad=? WHERE Estado=1 AND ID_Clase=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNombre());
            ps.setInt(2, clase.getEntrenador().getId_Entrenador());
            ps.setTime(3, Time.valueOf(clase.getHorario()));
            ps.setInt(4,clase.getCapacidad());
            ps.setInt(5, clase.getId_clase());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Clase Modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
    }
    
    public void eliminarClase(int id){
        String sql = "UPDATE clases SET Estado=0 WHERE ID_Clase=?";
        PreparedStatement ps ;
        try {
             ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             int exito=ps.executeUpdate();
                if (exito==1) {
                    JOptionPane.showMessageDialog(null,"Clase eliminado");
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Clase "+ex.getMessage());
        }
    
    }
}
