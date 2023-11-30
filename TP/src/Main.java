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
        Argentina.addJugador(new Jugador("Damián Emiliano Martínez", 23, "Arquero"));

        Uruguay.addJugador(new Jugador("Federico Valverde", 15, "Centrocampista"));
        Uruguay.addJugador(new Jugador("Luis Suárez", 9, "Delantero"));

        Paraguay.addJugador(new Jugador("Matías Espinoza", 4, "Defensa"));
        Paraguay.addJugador(new Jugador("Matías Nicolás Rojas", 18, "Centrocampista"));

        Chile.addJugador(new Jugador("Ben Brereton", 22, "Delantero"));
        Chile.addJugador(new Jugador("Claudio Bravo", 1, "Arquero"));

        Bolivia.addJugador(new Jugador("Ramiro Vaca", 20, "Centrocampista"));
        Bolivia.addJugador(new Jugador("Henry Vaca", 10, "Delantero"));

        Brasil.addJugador(new Jugador("Lucas Perri", 12, "Portero"));
        Brasil.addJugador(new Jugador("Neymar", 10, "Delantero"));

        Peru.addJugador(new Jugador("Oliver Sonne", 13, "Defensa"));
        Peru.addJugador(new Jugador("Paolo Guerrero", 9, "Delantero"));

        Colombia.addJugador(new Jugador("Luis Fernando Díaz", 14, "Delantero"));
        Colombia.addJugador(new Jugador("Radamel Falcao García", 9, "Delantero"));

        Ecuador.addJugador(new Jugador("Leonardo Campana", 9, "Delantero"));
        Ecuador.addJugador(new Jugador("Kendry Páez", 16, "Centrocampista"));

        Venezuela.addJugador(new Jugador("Yeferson Soteldo", 10, "Centrocampista"));
        Venezuela.addJugador(new Jugador("Josef Martínez", 17, "Delantero"));


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

        // Agregar equipos a los octavos de final
        FaseCuartos.addEquipo(Peru);
        FaseCuartos.addEquipo(Paraguay);
        FaseCuartos.addEquipo(Brasil);
        FaseCuartos.addEquipo(Chile);
        FaseCuartos.addEquipo(Uruguay);
        FaseCuartos.addEquipo(Colombia);
        FaseCuartos.addEquipo(Argentina);
        FaseCuartos.addEquipo(Ecuador);

        // Agregar equipos a la Semifinal
        FaseSemifinal.addEquipo(Brasil);
        FaseSemifinal.addEquipo(Peru);
        FaseSemifinal.addEquipo(Argentina);
        FaseSemifinal.addEquipo(Colombia);

        // Agregar equipos a la Final
        FaseFinal.addEquipo(Argentina);
        FaseFinal.addEquipo(Brasil);


        //Llaves
        Llave Cuartos1 = new Llave("Llave 1 (Cuartos)");
        Cuartos1.addEquipo(Peru);
        Cuartos1.addEquipo(Paraguay);

        Llave Cuartos2 = new Llave("Llave 2 (Cuartos)");
        Cuartos2.addEquipo(Brasil); // Aquí debes usar Cuartos2
        Cuartos2.addEquipo(Chile); // Aquí debes usar Cuartos2

        Llave Cuartos3 = new Llave("Llave 3 (Cuartos)");
        Cuartos3.addEquipo(Uruguay); // Aquí debes usar Cuartos2
        Cuartos3.addEquipo(Colombia); // Aquí debes usar Cuartos2

        Llave Cuartos4 = new Llave("Llave 4 (Cuartos)");
        Cuartos4.addEquipo(Argentina); // Aquí debes usar Cuartos2
        Cuartos4.addEquipo(Ecuador); // Aquí debes usar Cuartos2

        Cuartos1.generateMatches();
        Cuartos2.generateMatches();
        Cuartos3.generateMatches();
        Cuartos4.generateMatches();

        // Mostrar los partidos generados
        Cuartos1.mostrarPartidosGenerados();
        Cuartos2.mostrarPartidosGenerados();
        Cuartos3.mostrarPartidosGenerados();
        Cuartos4.mostrarPartidosGenerados();

        //Crear Partidos de las Clases Cuartos
        Partido Cuarto1P = Cuartos1.getPartidosGenerados().get(0);
        Partido Cuarto2P = Cuartos2.getPartidosGenerados().get(0);
        Partido Cuarto3P = Cuartos3.getPartidosGenerados().get(0);
        Partido Cuarto4P = Cuartos4.getPartidosGenerados().get(0);

        //Goles de Equipo (Cuartos)
        Cuarto1P.getResultado().setGolesVisitante(3);
        Cuarto1P.getResultado().setGolesLocal(3);

        Cuarto2P.getResultado().setGolesVisitante(1);

        Cuarto3P.getResultado().setGolesVisitante(4);

        Cuarto4P.getResultado().setGolesVisitante(3);

        //Llaves (Semifinal)
        Llave Semi1 = new Llave("Llave 1 (Semifinal)");
        Semi1.addEquipo(Brasil);
        Semi1.addEquipo(Peru);

        Llave Semi2 = new Llave("Llave 2 (Semifinal)");
        Semi2.addEquipo(Argentina);
        Semi2.addEquipo(Colombia);

        Semi1.generateMatches();
        Semi2.generateMatches();

        // Mostrar los partidos generados
        Semi1.mostrarPartidosGenerados();
        Semi2.mostrarPartidosGenerados();

        Partido Semi1P = Semi1.getPartidosGenerados().get(0);
        Partido Semi2P = Semi2.getPartidosGenerados().get(0);

        //Goles de Equipo (Semifinal)
        Semi1P.getResultado().setGolesVisitante(1);

        Semi2P.getResultado().setGolesLocal(3);
        Semi2P.getResultado().setGolesVisitante(2);


        //Llaves (Final)
        Llave Final1 = new Llave("Llave 1 (Final)");
        Final1.addEquipo(Brasil);
        Final1.addEquipo(Argentina);

        Final1.generateMatches();

        // Mostrar los partidos generados
        Final1.mostrarPartidosGenerados();

        Partido Final1P = Final1.getPartidosGenerados().get(0);

        //Goles de Equipo (Final)
        Final1P.getResultado().setGolesVisitante(1);

        //Resultados
        mostrarResultadoPartido(Cuarto1P);
        mostrarResultadoPartido(Cuarto2P);
        mostrarResultadoPartido(Cuarto3P);
        mostrarResultadoPartido(Cuarto4P);

        mostrarResultadoPartido(Semi1P);
        mostrarResultadoPartido(Semi2P);

        mostrarResultadoPartido(Final1P);

        int GolesLocalFinal = Final1P.getResultado().getGolesLocal();
        int GolesVisitantesFinal = Final1P.getResultado().getGolesVisitante();

        if (GolesLocalFinal > GolesVisitantesFinal) {
            System.out.println(Final1P.getLocal().getName() + " ganó la Copa América 2021");
        } else if (GolesLocalFinal < GolesVisitantesFinal) {
            System.out.println(Final1P.getVisitante().getName() + " ganó la Copa América 2021");
        }
        else {
            System.out.println("El partido terminó en empate");
        }

    }
}