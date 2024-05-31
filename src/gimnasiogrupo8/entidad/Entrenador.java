package gimnasiogrupo8.entidad;
public class Entrenador {
    private int id_Entrenador;
    private String dni;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String disponibilidad;

    public Entrenador() {
    }

    public Entrenador(int id_Entrenador, String dni, String nombre, String apellido, String especialidad, String disponibilidad) {
        this.id_Entrenador = id_Entrenador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.disponibilidad = disponibilidad;
    }

    public Entrenador(String dni, String nombre, String apellido, String especialidad, String disponibilidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.disponibilidad = disponibilidad;
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

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Entrenador{" + "id_Entrenador=" + id_Entrenador + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad + ", disponibilidad=" + disponibilidad + '}';
    }
}
