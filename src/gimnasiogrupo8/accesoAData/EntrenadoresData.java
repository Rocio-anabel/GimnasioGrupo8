package gimnasiogrupo8.accesoAData;

import gimnasiogrupo8.entidad.Entrenador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EntrenadoresData {
    Connection con = null;

    public EntrenadoresData() {
        con=Conexion.getConexion();
    }
    
    //Guardar Entrenador
    
    public void guardarEntrenador(Entrenador entrenador){
        String sql = "INSERT INTO entrenadores(Dni,Nombre,Apellido,Especialidad,Estado) VALUES (?,?,?,?,?)"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,entrenador.getDni());
            ps.setString(2,entrenador.getNombre());
            ps.setString(3,entrenador.getApellido());
            ps.setString(4,entrenador.getEspecialidad());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
             if(rs.next()){
                entrenador.setId_Entrenador(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Entrenador guardado con exito");
            }       
             ps.close();     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }    
    }
    
    //Buscar entrenador por nombre
    
    public Entrenador buscarEntrenadorPorNombre(String nombre){
        Entrenador entrenador = null;
        String sql = "SELECT ID_Entrenador,Dni,Apellido,Especialidad FROM entrenadores WHERE Nombre = ? AND Estado = 1";
        PreparedStatement ps = null;  
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                entrenador = new Entrenador();
                entrenador.setNombre(nombre);
                entrenador.setId_Entrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getString("Dni"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setEspecialidad("Especialidad");
                entrenador.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"Entrenador no existente"); 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }
        
        return entrenador;
    }
    
    //Listar entrenadores por especialidad
    
    public List<Entrenador>listarEntrenadoresPorEspecialidad(String especialidad){
        String sql = "SELECT ID_Entrenador,Dni,Apellido,Nombre FROM entrenadores WHERE Especialidad = ? AND Estado = 1";
        List<Entrenador> entrenadoresPorEspecialidad = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,especialidad);
            ResultSet rs = ps.executeQuery();   
            while(rs.next()){
             Entrenador entrenador = new Entrenador();
             entrenador.setId_Entrenador(rs.getInt("ID_Entrenador"));
             entrenador.setDni(rs.getString("Dni"));
             entrenador.setApellido(rs.getString("Apellido"));
             entrenador.setNombre(rs.getString("Nombre"));
             entrenadoresPorEspecialidad.add(entrenador);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }   
        return entrenadoresPorEspecialidad;
    }
    
    //Listar entrenadores
    
    public List<Entrenador>listarEntrenadores(){
        String sql = "SELECT ID_Entrenador,Dni,Apellido,Nombre,Especialidad FROM entrenadores WHERE Estado = 1";
        List<Entrenador> entrenadores = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            while(rs.next()){
                Entrenador entrenador = new Entrenador();
                entrenador.setId_Entrenador(rs.getInt("ID_Entrenador"));
                entrenador.setDni(rs.getString("Dni"));
                entrenador.setApellido(rs.getString("Apellido"));
                entrenador.setNombre(rs.getString("Nombre"));
                entrenador.setEspecialidad(rs.getString("Especialidad"));
                entrenador.setEstado(true);
                entrenadores.add(entrenador);   
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }
        return entrenadores;
    }
    
    //Modificar Entrenador
    
    public void modificarEntrenador(Entrenador entrenador){
        String sql = "UPDATE entrenadores SET Dni = ? , Nombre = ? , Apellido = ?, Especialidad = ? WHERE Estado = 1 AND ID_Entrenador = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,entrenador.getDni());
            ps.setString(2,entrenador.getNombre());
            ps.setString(3,entrenador.getApellido());
            ps.setString(4,entrenador.getEspecialidad());
            ps.setInt(5,entrenador.getId_Entrenador());
            int exito = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Entrenador Modificado");
            }     
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }
    }
    
    //Eliminar Entrenador
    
    public void eliminarEntrenador(int ID){
        String sql="UPDATE entrenadores SET Estado = 0 WHERE ID_Entrenador = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            int exito = ps.executeUpdate();
            if(exito == 1){
                 JOptionPane.showMessageDialog(null, "Entrenador Eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Entrenadores");
        }
        
    }
    
    
    

    
    
    
    
    
    
}
