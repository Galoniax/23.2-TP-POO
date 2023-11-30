import Mundial.*;
import java.util.ArrayList;

public class Main {
    public static void mostrarResultadoPartido(Partido partido) {
        if (partido.getResultado().ganoLocal()) {
            System.out.println("Ganó " + partido.getLocal().getName());
        } else if (partido.getResultado().ganoVisitante()) {
            System.out.println("Ganó " + partido.getVisitante().getName());
        } else {
            System.out.println("Empate entre " + partido.getLocal().getName() + " y " + partido.getVisitante().getName());
        }
    }

    public static void main(String[] args) {

        //Mundial
        EtapaMundial FaseCuartos = new EtapaMundial("Cuartos de Final");

        EtapaMundial FaseSemifinal = new EtapaMundial("Semifinal");

        EtapaMundial FaseFinal = new EtapaMundial("Final");

        //Equipos
        Equipo Argentina = new Equipo("Argentina");
        Equipo Uruguay = new Equipo("Uruguay");
        Equipo Paraguay = new Equipo("Paraguay");
        Equipo Chile = new Equipo("Chile");
        Equipo Bolivia = new Equipo("Bolivia");

        Equipo Brasil = new Equipo("Brasil");
        Equipo Peru = new Equipo("Perú");
        Equipo Colombia = new Equipo("Colombia");
        Equipo Ecuador = new Equipo("Ecuador");
        Equipo Venezuela = new Equipo("Venezuela");


        // Agregar jugadores a los equipos
        Argentina.addJugador(new Jugador("Lionel Messi", 10, "Delantero"));
        Uruguay.addJugador(new Jugador("Federico Valverde", 15, "Centrocampista"));
        Paraguay.addJugador(new Jugador("Matías Espinoza", 4, "Defensa"));
        Chile.addJugador(new Jugador("Ben Brereton", 22, "Delantero"));
        Bolivia.addJugador(new Jugador("Ramiro Vaca", 20, "Centrocampista"));
        Brasil.addJugador(new Jugador("Lucas Perri", 12, "Portero"));
        Peru.addJugador(new Jugador("Oliver Sonne", 13, "Defensa"));
        Colombia.addJugador(new Jugador("Luis Fernando Díaz", 14, "Delantero"));
        Ecuador.addJugador(new Jugador("Leonardo Campana", 9, "Delantero"));
        Venezuela.addJugador(new Jugador("Yeferson Soteldo", 10, "Centrocampista"));


        // Crear grupos y asignar equipos

        //Grupo A
        Grupo grupoA = new Grupo("Grupo A");
        grupoA.addEquipos(Argentina);
        grupoA.addEquipos(Uruguay);
        grupoA.addEquipos(Paraguay);
        grupoA.addEquipos(Chile);
        grupoA.addEquipos(Bolivia);

        //Grupo B
        Grupo grupoB = new Grupo("Grupo B");
        grupoB.addEquipos(Brasil);
        grupoB.addEquipos(Peru);
        grupoB.addEquipos(Colombia);
        grupoB.addEquipos(Ecuador);
        grupoB.addEquipos(Venezuela);


    }
}