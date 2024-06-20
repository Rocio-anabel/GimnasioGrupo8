
package gimnasiogrupo8.entidad;


import java.time.LocalTime;


public class Clase {
    
    private int id_clase;
    private String nombre;
    private Entrenador entrenador;
    private LocalTime horario;
    private int capacidad;
    private boolean estado;

    public Clase() {
    }

    public Clase(String nombre, Entrenador entrenador, LocalTime horario, int capacidad,boolean estado) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Clase(int id_clase, String nombre, Entrenador entrenador, LocalTime horario, int capacidad,boolean estado) {
        this.id_clase = id_clase;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.horario = horario;
        this.capacidad = capacidad;
        this.estado = estado;
    }
    
    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id_clase;
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
        final Clase other = (Clase) obj;
        if (this.id_clase != other.id_clase) {
            return false;
        }
        return true;
    }
    
    
  
    @Override
    public String toString() {
        return nombre + " " + entrenador.getNombre() + " " + entrenador.getApellido() + " " + horario;
    }
    
    
    
}
