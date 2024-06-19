package gimnasiogrupo8.accesoAData;

import gimnasiogrupo8.entidad.Socio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SociosData {
    
    Connection con = null;

    public SociosData() {
        con=Conexion.getConexion();
    }
    
        //Guardar Socio
    
        public void guardarSocio(Socio socio){
        String sql = "INSERT INTO socios(Dni,Nombre,Apellido,Edad,Correo,Telefono,Estado) VALUES (?,?,?,?,?,?,?)";   
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,socio.getDni());
            ps.setString(2,socio.getNombre());
            ps.setString(3,socio.getApellido());
            ps.setInt(4,socio.getEdad());
            ps.setString(5,socio.getCorreo());
            ps.setString(6,socio.getTelefono());
            ps.setBoolean(7, true);
            ps.executeUpdate();
         
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                socio.setId_socio(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Socio guardado con exito");
            }  
            
            ps.close();  
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
    }
        //Buscar Socio por ID
        
       public Socio buscarSocioPorId(int ID){
           Socio socio = null;
           String sql = "SELECT Dni,Nombre,Apellido,Edad,Correo,Telefono FROM socios WHERE ID_Socio = ? AND Estado = 1";
           PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,ID);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                socio = new Socio();
                socio.setId_socio(ID);
                socio.setDni(rs.getString("Dni"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Telefono"));
                socio.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "Socio no existente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
          return socio; 
       }
       
       //Buscar Socio por DNI
       
       public Socio buscarSocioPorDNI(String dni){
           Socio socio = null;
           String sql = "SELECT ID_Socio,Nombre,Apellido,Edad,Correo,Telefono FROM socios WHERE Dni = ? AND Estado = 1";
           PreparedStatement ps = null; 
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                socio = new Socio();
                socio.setId_socio(rs.getInt("ID_Socio"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Telefono"));
                socio.setEstado(true);
                socio.setDni(dni);
            }else{
              JOptionPane.showMessageDialog(null, "Socio no existente");
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
        return socio;
       }    
       //Buscar Socio por Nombre
       
       public Socio buscarSocioPorNombre(String nombre){
           Socio socio = null;
           String sql = "SELECT ID_Socio,Dni,Apellido,Edad,Correo,Telefono FROM socios WHERE Nombre = ? AND Estado = 1";
           PreparedStatement ps = null;       
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                socio = new Socio();
                socio.setNombre(nombre);
                socio.setId_socio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getString("Dni"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Telefono"));
                socio.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"Socio no existente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
        return socio;
       }
       
       //Modificar Socio
       
       public void modificarSocio(Socio socio){
           String sql = "UPDATE socios SET Dni = ? , Nombre = ? , Apellido = ? , Edad = ? , Correo = ? , Telefono = ? WHERE Estado = 1 AND ID_Socio = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,socio.getDni());
            ps.setString(2,socio.getNombre());
            ps.setString(3,socio.getApellido());
            ps.setInt(4,socio.getEdad());
            ps.setString(5,socio.getCorreo());
            ps.setString(6,socio.getTelefono());
            ps.setInt(7,socio.getId_socio());
            int exito = ps.executeUpdate();
            if(exito == 1){
                JOptionPane.showMessageDialog(null, "Socio Modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
       }
       
       //Eliminar Socio por ID
       
       public void eliminarSocio(int ID){
           String sql="UPDATE socios SET Estado = 0 WHERE ID_Socio = ?";
           PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            int exito = ps.executeUpdate();
            if(exito == 1){
                 JOptionPane.showMessageDialog(null, "Socio Eliminado");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
       }
       
       public List<Socio> listarSocios(){
           String sql = "SELECT ID_Socio, Dni, Nombre, Apellido, Edad, Correo, Telefono FROM socios WHERE Estado = 1";
           List<Socio> socios = new ArrayList<>();
           
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Socio socio = new Socio();
                socio.setId_socio(rs.getInt("ID_Socio"));
                socio.setDni(rs.getString("Dni"));
                socio.setNombre(rs.getString("Nombre"));
                socio.setApellido(rs.getString("Apellido"));
                socio.setEdad(rs.getInt("Edad"));
                socio.setCorreo(rs.getString("Correo"));
                socio.setTelefono(rs.getString("Telefono"));
                socio.setEstado(true);
                socios.add(socio);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla Socios");
        }
        return socios;
       }
    
    
    
    
}
