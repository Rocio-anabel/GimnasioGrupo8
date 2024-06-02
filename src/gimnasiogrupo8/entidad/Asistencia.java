
package gimnasiogrupo8.entidad;

import java.time.LocalDateTime;


public class Asistencia {
    private int idAsistencia;
    private Socio socio;
    private Clase clase;
    private Membresia membresia;
    private LocalDateTime fechaHora;

    public Asistencia(int idAsistencia, Socio socio, Clase clase, Membresia membresia, LocalDateTime fechaHora) {
        this.idAsistencia = idAsistencia;
        this.socio = socio;
        this.clase = clase;
        this.membresia = membresia;
        this.fechaHora = fechaHora;
    }

    public Asistencia(Socio socio, Clase clase, Membresia membresia, LocalDateTime fechaHora) {
        this.socio = socio;
        this.clase = clase;
        this.membresia = membresia;
        this.fechaHora = fechaHora;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    
    
}
