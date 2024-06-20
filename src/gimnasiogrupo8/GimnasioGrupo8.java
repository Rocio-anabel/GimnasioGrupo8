
package gimnasiogrupo8;

import gimnasiogrupo8.accesoAData.AsistenciaData;
import gimnasiogrupo8.accesoAData.ClaseData;
import gimnasiogrupo8.accesoAData.EntrenadoresData;
import gimnasiogrupo8.accesoAData.MembresiaData;
import gimnasiogrupo8.accesoAData.SociosData;
import gimnasiogrupo8.entidad.Asistencia;
import gimnasiogrupo8.entidad.Clase;
import gimnasiogrupo8.entidad.Entrenador;
import gimnasiogrupo8.entidad.Membresia;
import gimnasiogrupo8.entidad.Socio;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;



public class GimnasioGrupo8 {

    
    public static void main(String[] args) {
        
        //Están en mi base de datos los creé manualmente:
        Socio laura = new Socio(1,"38654221", "Laura", "Martinez", 30, "lauritamarr001@gmail.com", "2665312040", true);
        Membresia memb = new Membresia(1, laura, 4560, 12, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 6, 15), true);
        Entrenador mariana = new Entrenador(1, "32678542", "Mariana", "Ochoa", "Relajación", true);
        Clase pilates = new Clase(2, "Pilates", mariana, LocalTime.of(18, 00), 3,true);
//        Asistencia asis = new Asistencia(laura, pilates, memb, LocalDateTime.now());
        //
        
        SociosData sd = new SociosData();
        Socio nicole = new Socio("39765882", "Nicole", "Galvez", 37,"nicolee55@gmail.com" , "2665843213", true);
//        sd.guardarSocio(nicole);
        System.out.println("Socios:");
        System.out.println(sd.buscarSocioPorId(2));
        System.out.println(sd.buscarSocioPorNombre("Nicole"));
        
        sd.eliminarSocio(3);
        System.out.println("Lista de socios:");
        List<Socio> socios = sd.listarSocios();;
        for (Socio socio : socios) {
            System.out.println(socio);
        }
        
        laura = new Socio(1, "38654221", "Laura", "Martinez", 31, "lauritamarr001@gmail.com", "2665312040", true);
        sd.modificarSocio(laura);
        
        System.out.println("----------------------------------------------");
        System.out.println("Entrenador:");
        EntrenadoresData ed = new EntrenadoresData();
        Entrenador pablo = new Entrenador(2,"39843222", "Pablo", "Mendoza", "Musculatura", true);
//        ed.guardarEntrenador(pablo);

        System.out.println("Listado entrenadores:");
        List<Entrenador> entrenadores = ed.listarEntrenadores();
        for (Entrenador e : entrenadores) {
            System.out.println(e);
        }
        
        System.out.println("Listado entrenadores por especialidad:");
        List<Entrenador> entrenadoresPor = ed.listarEntrenadoresPorEspecialidad("Musculatura");
        for (Entrenador e : entrenadoresPor) {
            System.out.println(e);
        }
        
        System.out.println("----------------------------------------------");
        System.out.println("Clases:");
        ClaseData cd = new ClaseData();
        pablo = new Entrenador(2,"39843222", "Pablo", "Mendoza", "Musculatura", true);
        Clase musculacion = new Clase("Musculación", pablo, LocalTime.of(16, 00), 10,true);
        cd.guardarClase(musculacion);
        
        System.out.println(cd.buscarClasePorNombre("pilates"));
        System.out.println(cd.buscarClasePorHorario(LocalTime.of(18, 00)));
        System.out.println(cd.buscarClasePorEntrenador(1));
        
        System.out.println("Lista de clases");
        List<Clase> clases = cd.listaClase();
        for (Clase clase : clases) {
            System.out.println(clase);
        }
        
        pilates = new Clase(1, "Pilates", mariana, LocalTime.of(18,00), 10,true);
        cd.modificarClase(pilates);
        cd.eliminarClase(13);
        
        System.out.println("---------------------------------------------");
        System.out.println("Membresías: ");
        
        MembresiaData md = new MembresiaData();
        Membresia nuevaMemb = new Membresia(laura, 10000, 20, LocalDate.of(2024, 7, 5), LocalDate.of(2024, 8, 5), true);
//        md.guardarMembresia(nuevaMemb);
        System.out.println(md.buscarMembresiaPorSocio(1));
        
        System.out.println("Lista de membresías:");
        List<Membresia> membresias = md.listarMembresiasActivas();
        for (Membresia membresia : membresias) {
            System.out.println(membresia);
        }
        
        memb = new Membresia(1, laura, 4560, 12, LocalDate.of(2024, 5, 10), LocalDate.of(2024, 6, 10), true);
        md.modificarMembresia(memb);
                
        
        AsistenciaData ad = new AsistenciaData();
        //ad.registrarAsistencia(asis);
    }
    
}
