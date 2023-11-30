package Mundial;

import java.util.ArrayList;

public class EtapaMundial {
    private String name; // Nombre de etapa (Cuartos, Octavos, Final, Semi)
    private ArrayList<Equipo> equiposInvolucrados; // Lista de equipos involucrados en la etapa

    public EtapaMundial(String name) {
        setName(name);
        equiposInvolucrados = new ArrayList<>();
    }

    public EtapaMundial() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Equipo> getEquiposInvolucrados() {
        return equiposInvolucrados;
    }

    public void addEquipo(Equipo equipo) {
        equiposInvolucrados.add(equipo);
    }
}
