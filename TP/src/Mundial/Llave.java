package Mundial;

import java.util.ArrayList;
import java.util.Date;

public class Llave extends EtapaMundial  {
    private ArrayList<Equipo> equiposEnfrentados;
    private String nombreEtapa;
    private ArrayList<Partido> partidosGenerados;

    public Llave(String nombreEtapa) {
        super(nombreEtapa); // Asigna el nombre de la etapa a la superclase
        this.nombreEtapa = nombreEtapa;
        equiposEnfrentados = new ArrayList<>();
        this.partidosGenerados = new ArrayList<>();
    }

    public void addEquipo(Equipo equipo) {
        equiposEnfrentados.add(equipo);
    }

    public ArrayList<Equipo> getEquiposEnfrentados() {
        return equiposEnfrentados;
    }

    public ArrayList<Partido> getPartidosGenerados() {
        return partidosGenerados;
    }

    public void setEquiposEnfrentados(ArrayList<Equipo> equiposEnfrentados) {
        this.equiposEnfrentados = equiposEnfrentados;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public void generateMatches() {
        int cantidadEquipos = equiposEnfrentados.size();
        int cantidadPartidos = cantidadEquipos / 2;
        for (int i = 0; i < cantidadPartidos; i++) {
            Partido partido = new Partido(
                    new Date(),
                    equiposEnfrentados.get(i * 2),
                    equiposEnfrentados.get((i * 2) + 1)
            );
            partidosGenerados.add(partido);
        }
    }

    public void mostrarPartidosGenerados() {
        if (partidosGenerados != null) {
            System.out.println("Partido Generado:");
            for (Partido partido : partidosGenerados) {
                System.out.println(partido.getLocal().getName() + " vs " + partido.getVisitante().getName() + "\n");
            }
        } else {
            System.out.println("No se han generado partidos.");
        }
    }

}
