
package gimnasiogrupo8.entidad;

import java.time.LocalDate;


public class Membresia {
    private int id_membresia;
    private Socio socio;
    private double costo;
    private int cantidadPases;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private boolean estado;

    public Membresia() {
    }

    public Membresia(int id_membresia, Socio socio, double costo, int cantidadPases, LocalDate fecha_inicio, LocalDate fecha_fin, boolean estado) {
        this.id_membresia = id_membresia;
        this.socio = socio;
        this.costo = costo;
        this.cantidadPases = cantidadPases;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public Membresia(Socio socio, double costo, int cantidadPases, LocalDate fecha_inicio, LocalDate fecha_fin, boolean estado) {
        this.socio = socio;
        this.costo = costo;
        this.cantidadPases = cantidadPases;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidadPases() {
        return cantidadPases;
    }

    public void setCantidadPases(int cantidadPases) {
        this.cantidadPases = cantidadPases;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresia{" + "id_membresia=" + id_membresia + ", socio=" + socio + ", costo=" + costo + ", cantidadPases=" + cantidadPases + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", estado=" + estado + '}';
    }
    
    
    
    
}
