package Mundial;

import java.util.ArrayList;

public class Llave extends EtapaMundial {
    private String NombreLlave; //Nombre de la Llave en cuestión (Cuartos 1, 2, Semis 1, etc)
    private ArrayList<Equipo> equiposEnfrentados; //Declara los equipos que se enfrentar en una llave


    //Constructor
    public Llave(String NombreLlave) {
        super();
        this.setNombreLlave(NombreLlave);
        this.equiposEnfrentados = new ArrayList<>();

    }


    //Getters & Setters
    public String getNombreLlave() {
        return NombreLlave;
    }

    public void setNombreLlave(String nombreLlave) {
        NombreLlave = nombreLlave;
    }

    public ArrayList<Equipo> getEquiposEnfrentados() {
        return equiposEnfrentados;
    }

    public void setEquiposEnfrentados(ArrayList<Equipo> equiposEnfrentados) {
        this.equiposEnfrentados = equiposEnfrentados;
    }

    //Methods
    public void addEquipo(Equipo equipo) {
        getEquiposEnfrentados().add(equipo);
    }

    public void removeEquipo(Equipo equipo) {
        getEquiposEnfrentados().add(equipo);
    }


    public static void simularPartidos(Equipo equipoLocal, Equipo equipoVisitante, EtapaMundial etapa) {
        ArrayList<Partido> partidosPorJugarLlave = etapa.getPartidos();

        for (Partido partido : partidosPorJugarLlave) {
            int golesLocal = (int) (Math.random() * 5);
            int golesVisitante = (int) (Math.random() * 5);

            Resultado resultado = new Resultado(golesLocal, golesVisitante);
            partido.setResultado(resultado);

            System.out.println("Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());

            SubirPuntajes(partido);

            Equipo ganador = null;
            if (resultado.empate()) {

                int golesLocalVuelta = (int) (Math.random() * 5 + 1);
                int golesVisitanteVuelta = (int) (Math.random() * 5 + 1);

                if (golesLocalVuelta > golesVisitanteVuelta) {
                    ganador = equipoLocal;
                } else if (golesVisitanteVuelta > golesLocalVuelta) {
                    ganador = equipoVisitante;
                }
            }
            else if (resultado.ganoLocal()) {
                ganador = equipoLocal;
            } else if (resultado.ganoVisitante()) {
                ganador = equipoVisitante;
            }
            else {
                System.out.println(" Resultado: Empate");
            }

            if (ganador != null) {
                System.out.println(" Ganador: " + ganador.getNombre());
                ganador.agregarPartido(partido);
            }

        }
    }

    public static void SubirPuntajes (Partido partido) {
        Resultado resultado = partido.getResultado();
        Equipo equipoLocal = partido.getLocal();
        Equipo equipoVisitante = partido.getVisitante();

        if (resultado.ganoLocal()) {
            equipoLocal.addPuntaje(3);
        } else if (resultado.ganoVisitante()) {
            equipoVisitante.addPuntaje(3);
        } else {
            equipoLocal.addPuntaje(1);
            equipoVisitante.addPuntaje(1);
        }
    }




    /*
    public void simularPartido(Equipo equipoLocal, Equipo equipoVisitante, EtapaMundial etapa) {
        ArrayList<Partido> partidosPorJugar = etapa.getPartidos();
        Equipo[] ganadores = new Equipo[partidosPorJugar.size()];

        int index = 0;
        for (Partido partido : partidosPorJugar) {
            int golesLocal = (int) (Math.random() * 5);
            int golesVisitante = (int) (Math.random() * 5);

            Resultado resultado = new Resultado(golesLocal, golesVisitante);
            partido.setResultado(resultado);

            System.out.println("Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());

            this.getPartidos().add(partido); // Agregar el partido a la lista de partidos de la etapa

            Equipo ganador = null;
            if (golesLocal == golesVisitante) {
                int golesLocalVuelta = (int) (Math.random() * 5 + 1);
                int golesVisitanteVuelta = (int) (Math.random() * 5 + 1);

                if (golesLocalVuelta != golesVisitanteVuelta) {
                    if (golesLocalVuelta > golesVisitanteVuelta) {
                        ganador = equipoLocal;
                    } else if (golesVisitanteVuelta > golesLocalVuelta) {
                        ganador = equipoVisitante;
                    }
                }
            } else { // No hay empate, determinar al ganador directamente
                if (golesLocal > golesVisitante) {
                    ganador = equipoLocal;
                } else if (golesLocal < golesVisitante) {
                    ganador = equipoVisitante;
                }
            }

            System.out.print("Resultado de " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + ": " + golesLocal + " - " + golesVisitante);

            if (ganador != null) {
                System.out.println(" Ganador: " + ganador.getNombre());
                ganadores[index++] = ganador; // Agregar el ganador al array
                ganador.agregarPartido(partido);
            } else {
                System.out.println(" Resultado: Empate");
            }
        }


        // Agregar los ganadores a la etapa
        for (Equipo ganador : ganadores) {
            if (ganador != null) {
                etapa.addEquipoQueAvanza(ganador);
            }
        }*/

        /*public void mostrarPartidos (Equipo equipoLocal, Equipo equipoVisitante){
            for (Partido partido : this.getPartidos()) {
                Resultado resultado = partido.getResultado();

                System.out.println("Partido: WACHO " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() +
                        " - Resultado: " + resultado.getGolesLocal() + " - " + resultado.getGolesVisitante());
            }
        }*/



    /*public void simularPartido(Equipo equipoLocal, Equipo equipoVisitante, EtapaMundial etapa) {

        ArrayList<Partido> partidosPorJugar = grupo.getPartidos();

        Equipo[] ganadores = new Equipo[partidosPorJugar.size()];

        int golesLocal = (int) (Math.random() * 5);
        int golesVisitante = (int) (Math.random() * 5);

        Partido partido = new Partido(new Date(), equipoLocal, equipoVisitante);
        Resultado resultado = new Resultado(golesLocal, golesVisitante);

        partido.setResultado(resultado);

        this.getPartidos().add(partido); // Agregar el partido a la lista de partidos de la etapa

        Equipo ganador = null;
        if (golesLocal == golesVisitante) {
            int golesLocalVuelta = (int) (Math.random() * 5 + 1);
            int golesVisitanteVuelta = (int) (Math.random() * 5 + 1);

            if (golesLocalVuelta != golesVisitanteVuelta) {
                if (golesLocalVuelta > golesVisitanteVuelta) {
                    ganador = equipoLocal;
                } else if (golesVisitanteVuelta > golesLocalVuelta) {
                    ganador = equipoVisitante;
                }
            }
        } else { // No hay empate, determinar al ganador directamente
            if (golesLocal > golesVisitante) {
                ganador = equipoLocal;
            } else if (golesLocal < golesVisitante) {
                ganador = equipoVisitante;
            }
        }

        System.out.print("Resultado de " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + ": " + golesLocal + " - " + golesVisitante);

    }*/
    }

