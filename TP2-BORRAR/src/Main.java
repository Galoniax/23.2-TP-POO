import Mundial.*;

import java.util.ArrayList;
import java.util.Date;

import static Mundial.Grupo.*;

public class Main {
    public static void main(String[] args) {
        //Equipos
        Equipo Argentina = new Equipo("Argentina");
        Argentina.addJugador(new Jugador("Lionel Messi", 10, "Delantero"));
        Argentina.addJugador(new Jugador("Damián Emiliano Martínez", 23, "Arquero"));

        Equipo Uruguay = new Equipo("Uruguay");
        Uruguay.addJugador(new Jugador("Federico Valverde", 15, "Centrocampista"));
        Uruguay.addJugador(new Jugador("Luis Suárez", 9, "Delantero"));

        Equipo Paraguay = new Equipo("Paraguay");
        Paraguay.addJugador(new Jugador("Matías Espinoza", 4, "Defensa"));
        Paraguay.addJugador(new Jugador("Matías Nicolás Rojas", 18, "Centrocampista"));

        Equipo Chile = new Equipo("Chile");
        Chile.addJugador(new Jugador("Ben Brereton", 22, "Delantero"));
        Chile.addJugador(new Jugador("Claudio Bravo", 1, "Arquero"));

        Equipo Bolivia = new Equipo("Bolivia");
        Bolivia.addJugador(new Jugador("Ramiro Vaca", 20, "Centrocampista"));
        Bolivia.addJugador(new Jugador("Henry Vaca", 10, "Delantero"));

        Equipo Brasil = new Equipo("Brasil");
        Brasil.addJugador(new Jugador("Lucas Perri", 12, "Portero"));
        Brasil.addJugador(new Jugador("Neymar", 10, "Delantero"));

        Equipo Peru = new Equipo("Perú");
        Peru.addJugador(new Jugador("Oliver Sonne", 13, "Defensa"));
        Peru.addJugador(new Jugador("Paolo Guerrero", 9, "Delantero"));

        Equipo Colombia = new Equipo("Colombia");
        Colombia.addJugador(new Jugador("Luis Fernando Díaz", 14, "Delantero"));
        Colombia.addJugador(new Jugador("Radamel Falcao García", 9, "Delantero"));

        Equipo Ecuador = new Equipo("Ecuador");
        Ecuador.addJugador(new Jugador("Leonardo Campana", 9, "Delantero"));
        Ecuador.addJugador(new Jugador("Kendry Páez", 16, "Centrocampista"));

        Equipo Venezuela = new Equipo("Venezuela");
        Venezuela.addJugador(new Jugador("Yeferson Soteldo", 10, "Centrocampista"));
        Venezuela.addJugador(new Jugador("Josef Martínez", 17, "Delantero"));

        //Grupos
        Grupo Grupo1 = new Grupo("Grupo A", "Fase Grupos");
        Grupo Grupo2 = new Grupo("Grupo B", "Fase Grupos");


        Grupo1.addEquipo(Argentina);
        Grupo1.addEquipo(Uruguay);
        Grupo1.addEquipo(Paraguay);
        Grupo1.addEquipo(Chile);
        Grupo1.addEquipo(Bolivia);

        Grupo2.addEquipo(Brasil);
        Grupo2.addEquipo(Peru);
        Grupo2.addEquipo(Colombia);
        Grupo2.addEquipo(Ecuador);
        Grupo2.addEquipo(Venezuela);

        EtapaMundial FaseGrupos = new EtapaMundial();
        FaseGrupos.setDescripcionEtapa("Etapa donde participan todos los equipos amistosamente");

        EtapaMundial cuartos = new EtapaMundial();
        cuartos.setDescripcionEtapa("En Cuartos, los equipos vuelven a participar, solo 4 equipos clasificarán");

        EtapaMundial semifinales = new EtapaMundial();
        semifinales.setDescripcionEtapa("En la Semifinal, los equipos vencedores, participan nuevamente, solo 2 equipos clasificarán");

        EtapaMundial finalEtapa = new EtapaMundial();
        finalEtapa.setDescripcionEtapa("En la Final, se define quien es el ganador, siendo solamente un equipo en pie");

        Llave[] llaveCuartos = new Llave[5];
        Llave[] llaveSemifinales = new Llave[2];
        Llave[] llaveFinal = new Llave[1];

        Grupo.crearPartidos(Grupo1, FaseGrupos); //Crear Partidos Grupo A
        Grupo.crearPartidos(Grupo2, FaseGrupos); //Crear Partidos Grupo B

        Grupo.simularPartidos(Grupo1, FaseGrupos); //Simulando Partidos de Grupo A
        Grupo.simularPartidos(Grupo2, FaseGrupos); //Simulando Partidos de Grupo B

        System.out.println("\nTabla Grupo 1:");
        Grupo.TablaPosiciones(Grupo1);

        System.out.println("\nTabla Grupo 2:");
        Grupo.TablaPosiciones(Grupo2);

        //Etapa Cuartos
        ArrayList<Equipo> equiposQueAvanzan = FaseGrupos.getEquiposQueAvanzan();
        ejecutarCuartos(cuartos, llaveCuartos, equiposQueAvanzan);

        //Etapa SemiFinal
        ArrayList<Equipo> equiposQueAvanzanSemis = cuartos.getEquiposQueAvanzan();
        ejecutarSemifinales(semifinales, llaveSemifinales, equiposQueAvanzanSemis);

        //Etapa Final
        ArrayList<Equipo> equiposQueAvanzanFinal = semifinales.getEquiposQueAvanzan();
        ejecutarFinal(finalEtapa, llaveFinal, equiposQueAvanzanFinal);

    }
}

