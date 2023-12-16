package Mundial;

import java.util.ArrayList;

public class Equipo {
    private String Nombre; //Nombre del Equipo
    private ArrayList<Partido> Partidos; // Partidos Jugados por el Equipo
    private ArrayList<Jugador> Jugadores; //Lista de jugadores
    private int puntaje;


    public Equipo(String nombre) {
        this.setNombre(nombre);
        this.Partidos = new ArrayList<>();
        this.Jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public ArrayList<Partido> getPartidos() {
        return Partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        Partidos = partidos;
    }

    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        Jugadores = jugadores;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Methods
    public void addJugador(Jugador jugador) {
        getJugadores().add(jugador);
    }

    public void removeJugador(Jugador jugador) {
        getJugadores().remove(jugador);
    }

    public void agregarPartido(Partido partido) {
        Partidos.add(partido);
    }

    public void addPuntaje(int cont) {
        puntaje+= cont;
    }


}
