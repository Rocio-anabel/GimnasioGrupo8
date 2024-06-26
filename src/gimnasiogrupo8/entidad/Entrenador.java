package gimnasiogrupo8.entidad;

import java.util.Objects;

public class Entrenador {
    private int id_Entrenador;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean estado;

    public Entrenador() {
    }

    public Entrenador(int id_Entrenador, String dni, String nombre, String apellido, String especialidad,boolean estado) {
        this.id_Entrenador = id_Entrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Entrenador(String dni, String nombre, String apellido, String especialidad,boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    public int getId_Entrenador() {
        return id_Entrenador;
    }

    public void setId_Entrenador(int id_Entrenador) {
        this.id_Entrenador = id_Entrenador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_Entrenador;
        hash = 71 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entrenador other = (Entrenador) obj;
        if (this.id_Entrenador != other.id_Entrenador) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return dni + " " +nombre + " " +apellido;
    }
}
