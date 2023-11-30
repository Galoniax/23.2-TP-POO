package Mundial;
import java.util.ArrayList;

public class Equipo {
    private String Name;
    private ArrayList<Partido> PartidosJugados;
    private ArrayList<Jugador> Jugadores;

    //Constructor
    public Equipo(String Name) {
        this.Jugadores = new ArrayList<Jugador>();
        this.PartidosJugados = new ArrayList<Partido>();
        this.setName(Name);

    }


    //Getters
    public String getName() {
        return Name;
    }

    public ArrayList<Partido> getPartidosJugados() {
        return PartidosJugados;
    }


    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }



    //Setters
    public void setPartidosJugados(ArrayList<Partido> partidosJugados) {
        PartidosJugados = partidosJugados;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        Jugadores = jugadores;
    }

}
