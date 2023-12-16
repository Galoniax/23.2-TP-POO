package Mundial;

import java.util.ArrayList;

public class Grupo extends EtapaMundial {
    private ArrayList<Equipo> equipos;
    private String nombreGrupo;
    private ArrayList<Partido> partidos;

    public Grupo(String nombreGrupo) {
        super();
        this.nombreGrupo = nombreGrupo;
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }


    public void addEquipos(Equipo equipo) {
        equipos.add(equipo);
    }


    public ArrayList<Equipo> getEquiposConformados() {
        return equipos;
    }

    public void setEquiposConformados(ArrayList<Equipo> equiposConformados) {
        this.equipos = equiposConformados;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }


}
