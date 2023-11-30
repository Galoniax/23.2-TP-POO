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


    }
}