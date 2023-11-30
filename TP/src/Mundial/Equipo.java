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

    //Addons
    public void addJugador (Jugador Jugador){
        getJugadores().add(Jugador);
    }

    public void removeJugador (Jugador Jugador){
        getJugadores().remove(Jugador);
    }



    //Functions
    public void showListPlayer() {
        int lenght = this.getJugadores().size();
        String message = "En %s hay %d jugadores\n";
        System.out.println(
                String.format(message,getName(),lenght)
        );
        getJugadores().forEach(Jugador -> {
            String playerText = Jugador.getNombre() + " " + Jugador.getContadorGoles();
            System.out.println(playerText);
        });
    }

}
