package Mundial;

import java.util.ArrayList;

public class EtapaMundial {
    private String descripcionEtapa; //Declara la descripción de la Etapa (Cuartos, Semis, Final)
    private ArrayList<Partido> partidos; //Permite el uso de los partidos sobre sus herencias
    private ArrayList<Llave> llaves; //Similar a partidos
    private ArrayList<Equipo> equiposQueAvanzan;



    //Constructor
    public EtapaMundial(){
        this.setDescripcionEtapa(descripcionEtapa);
        this.partidos = new ArrayList<>();
        this.llaves = new ArrayList<>();
        this.equiposQueAvanzan = new ArrayList<>();
    }



    //Getters & Setters
    public String getDescripcionEtapa() {
        return descripcionEtapa;
    }

    public void setDescripcionEtapa(String descripcionEtapa) {
        this.descripcionEtapa = descripcionEtapa;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Equipo> getEquiposQueAvanzan() {
        return equiposQueAvanzan;
    }

    public void setEquiposQueAvanzan(ArrayList<Equipo> equiposQueAvanzan) {
        this.equiposQueAvanzan = equiposQueAvanzan;
    }

    public void addEquipoQueAvanza(Equipo equipo) {
        if (!equiposQueAvanzan.contains(equipo)) {
            equiposQueAvanzan.add(equipo);
        }
    }

    public ArrayList<Llave> getLlaves() {
        return llaves;
    }

    public void setLlaves(ArrayList<Llave> llaves) {
        this.llaves = llaves;
    }


    //Methods
    public void agregarLlave(Llave llave) {
        llaves.add(llave);
    }

}
