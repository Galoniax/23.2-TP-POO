package Mundial;

import java.util.ArrayList;
import java.util.Date;

public class Grupo extends EtapaMundial {
    private String NombreGrupo; //Declara el Nombre del Grupo (A, B)
    private ArrayList<Equipo> equiposConformados; //Declara los Equipos Conformados en un Grupo



    //Constructor
    public Grupo(String NombreGrupo, String descripcionEtapa) {
        super();
        this.setNombreGrupo(NombreGrupo);
        this.setDescripcionEtapa(descripcionEtapa);
        this.equiposConformados = new ArrayList<>();

    }


    //Getters & Setters
    public String getNombreGrupo() {
        return NombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        NombreGrupo = nombreGrupo;
    }

    public ArrayList<Equipo> getEquiposConformados() {
        return equiposConformados;
    }

    public void setEquiposConformados(ArrayList<Equipo> equiposConformados) {
        this.equiposConformados = equiposConformados;
    }


    //Methods
    public void addEquipo(Equipo equipo) {
        equiposConformados.add(equipo);
    }

    public void removeEquipo(Equipo equipo) {
        equiposConformados.remove(equipo);
    }

    /*public static void crearPartidos(Grupo grupo) { //Metodo para crear los Partidos en Grupo
        ArrayList<Equipo> equipos = grupo.getEquiposConformados();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo equipoLocal = equipos.get(i);
                Equipo equipoVisitante = equipos.get(j);

                Partido partido = new Partido(new Date(), equipoLocal, equipoVisitante);
                grupo.getPartidos().add(partido);
            }
        }
    }*/

    public static void crearPartidos(Grupo grupo, EtapaMundial etapa) {
        ArrayList<Equipo> equipos = grupo.getEquiposConformados();
        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo equipoLocal = equipos.get(i);
                Equipo equipoVisitante = equipos.get(j);

                Partido partido = new Partido(new Date(), equipoLocal, equipoVisitante);
                grupo.getPartidos().add(partido);
            }
        }
    }


    public static void simularPartidos(Grupo grupo, EtapaMundial etapa) {
        ArrayList<Partido> partidosPorJugar = grupo.getPartidos();

        for (Partido partido : partidosPorJugar) {
            int golesLocal = (int) (Math.random() * 5);
            int golesVisitante = (int) (Math.random() * 5);

            Resultado resultado = new Resultado(golesLocal, golesVisitante);
            partido.setResultado(resultado);

            Equipo equipoLocal = partido.getLocal();
            Equipo equipoVisitante = partido.getVisitante();

            System.out.println("Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());

            SubirPuntajes(partido);

            Equipo ganador = null;
            if (golesLocal == golesVisitante) {
                System.out.println("Resultado: Empate");
                etapa.addEquipoQueAvanza(equipoLocal);
                etapa.addEquipoQueAvanza(equipoVisitante);
            } else {

                if (golesLocal > golesVisitante) {
                    ganador = equipoLocal;
                } else {
                    ganador = equipoVisitante;
                }

                System.out.println("Resultado: " + ganador.getNombre() + " gana");
                etapa.addEquipoQueAvanza(ganador);
            }



            if (ganador != null) {
                System.out.println(" Ganador: " + ganador.getNombre());
                ganador.agregarPartido(partido);
            }

            if (ganador != null) {
                etapa.addEquipoQueAvanza(ganador);
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


        public static void TablaPosiciones (Grupo grupo) {
            ArrayList<Equipo> equipos = grupo.getEquiposConformados();

            for (Equipo equipo : equipos) {
                System.out.println(equipo.getNombre() + " Puntuación: \n" + equipo.getPuntaje());
            }
        }

        //Cuartos
    public static void ejecutarCuartos(EtapaMundial cuartos, Llave[] llaveCuartos, ArrayList<Equipo> equiposQueAvanzan) {
        cuartos.setEquiposQueAvanzan(equiposQueAvanzan);

        // Agregar Llaves de Cuartos
        for (int i = 0; i < llaveCuartos.length; i++) {
            llaveCuartos[i] = new Llave("Cuartos " + (i + 1));
            cuartos.agregarLlave(llaveCuartos[i]);
        }

        // Asignar equipos a las llaves de cuartos
        for (int i = 0; i < equiposQueAvanzan.size(); i += 2) {
            llaveCuartos[i / 2].addEquipo(equiposQueAvanzan.get(i));
            llaveCuartos[i / 2].addEquipo(equiposQueAvanzan.get(i + 1));
        }

        // Simular y mostrar los partidos de cuartos
        for (Llave llave : llaveCuartos) {
            Equipo equipoLocal = llave.getEquiposEnfrentados().get(0);
            Equipo equipoVisitante = llave.getEquiposEnfrentados().get(1);
            llave.simularPartidos(equipoLocal, equipoVisitante, cuartos);
        }

        // Eliminar equipos con puntaje más bajo hasta que queden 4 equipos
        for (Llave llave : llaveCuartos) {
            while (equiposQueAvanzan.size() > 4) {
                Equipo equipoMenorPuntaje = null;
                int menorPuntaje = 999999;

                // Encontrar el equipo con el puntaje más bajo actualmente
                for (Equipo equipo : equiposQueAvanzan) {
                    int puntaje = equipo.getPuntaje();
                    if (puntaje < menorPuntaje) {
                        menorPuntaje = puntaje;
                        equipoMenorPuntaje = equipo;
                    }
                }

                // Remover el equipo con el puntaje más bajo
                if (equipoMenorPuntaje != null) {
                    equiposQueAvanzan.remove(equipoMenorPuntaje);
                }
            }
        }
    }

    //Semifinal
    public static void ejecutarSemifinales(EtapaMundial semifinales, Llave[] llaveSemifinales, ArrayList<Equipo> equiposQueAvanzanSemis) {
        semifinales.setEquiposQueAvanzan(equiposQueAvanzanSemis);

        // Agregar Llaves de Semifinales
        for (int i = 0; i < llaveSemifinales.length; i++) {
            llaveSemifinales[i] = new Llave("Semis " + (i + 1));
            semifinales.agregarLlave(llaveSemifinales[i]);
        }

        // Asignar equipos a las llaves de semifinales
        for (int i = 0; i < equiposQueAvanzanSemis.size(); i += 2) {
            llaveSemifinales[i / 2].addEquipo(equiposQueAvanzanSemis.get(i));
            llaveSemifinales[i / 2].addEquipo(equiposQueAvanzanSemis.get(i + 1));
        }

        // Simular y mostrar los partidos de semifinales
        for (Llave llave : llaveSemifinales) {
            Equipo equipoLocal = llave.getEquiposEnfrentados().get(0);
            Equipo equipoVisitante = llave.getEquiposEnfrentados().get(1);
            llave.simularPartidos(equipoLocal, equipoVisitante, semifinales);
        }

        // Eliminar equipos con puntaje más bajo hasta que queden 2 equipos
        for (Llave llave : llaveSemifinales) {
            while (equiposQueAvanzanSemis.size() > 2) {
                Equipo equipoMenorPuntaje = null;
                int menorPuntaje = 999999;

                // Encontrar el equipo con el puntaje más bajo actualmente
                for (Equipo equipo : equiposQueAvanzanSemis) {
                    int puntaje = equipo.getPuntaje();
                    if (puntaje < menorPuntaje) {
                        menorPuntaje = puntaje;
                        equipoMenorPuntaje = equipo;
                    }
                }

                // Remover el equipo con el puntaje más bajo
                if (equipoMenorPuntaje != null) {
                    equiposQueAvanzanSemis.remove(equipoMenorPuntaje);
                }
            }
        }
    }

    //Final
    public static void ejecutarFinal(EtapaMundial finalEtapa, Llave[] llaveFinal, ArrayList<Equipo> equiposQueAvanzanFinal) {
        finalEtapa.setEquiposQueAvanzan(equiposQueAvanzanFinal);

        // Agregar Llaves de la Final
        for (int i = 0; i < llaveFinal.length; i++) {
            llaveFinal[i] = new Llave("Final " + (i + 1));
            finalEtapa.agregarLlave(llaveFinal[i]);
        }

        // Asignar equipos a las llaves de la Final
        for (int i = 0; i < equiposQueAvanzanFinal.size(); i += 2) {
            llaveFinal[i / 2].addEquipo(equiposQueAvanzanFinal.get(i));
            llaveFinal[i / 2].addEquipo(equiposQueAvanzanFinal.get(i + 1));
        }

        // Simular y mostrar los partidos de la Final
        for (Llave llave : llaveFinal) {
            Equipo equipoLocal = llave.getEquiposEnfrentados().get(0);
            Equipo equipoVisitante = llave.getEquiposEnfrentados().get(1);
            llave.simularPartidos(equipoLocal, equipoVisitante, finalEtapa);
        }

        // Eliminar equipos con puntaje más bajo hasta que quede un solo equipo (el ganador)
        while (equiposQueAvanzanFinal.size() > 1) {
            Equipo equipoMenorPuntaje = null;
            int menorPuntaje = 999999;

            // Encontrar el equipo con el puntaje más bajo actualmente
            for (Equipo equipo : equiposQueAvanzanFinal) {
                int puntaje = equipo.getPuntaje();
                if (puntaje < menorPuntaje) {
                    menorPuntaje = puntaje;
                    equipoMenorPuntaje = equipo;
                }
            }

            // Remover el equipo con el puntaje más bajo
            if (equipoMenorPuntaje != null) {
                equiposQueAvanzanFinal.remove(equipoMenorPuntaje);
            }
        }
    }





    /*public static void simularPartidos(Grupo grupo, EtapaMundial etapa) {
        ArrayList<Partido> partidosPorJugar = grupo.getPartidos();

        for (Partido partido : partidosPorJugar) {
            int golesLocal = (int) (Math.random() * 5+1);
            int golesVisitante = (int) (Math.random() * 5+1);

            Resultado resultado = new Resultado(golesLocal, golesVisitante);
            partido.setResultado(resultado);

            Equipo equipoLocal = partido.getLocal();
            Equipo equipoVisitante = partido.getVisitante();

            System.out.println("Partido: " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre());

            Equipo ganador = null;
            if (golesLocal == golesVisitante) {
                int golesLocalVuelta = (int) (Math.random() * 5 + 1);
                int golesVisitanteVuelta = (int) (Math.random() * 5 + 1);

            if (golesLocalVuelta!=golesVisitanteVuelta) {
                if (golesLocalVuelta > golesVisitanteVuelta) {
                    ganador = equipoLocal;
                } if (golesVisitanteVuelta > golesLocalVuelta) {
                    ganador = equipoVisitante;
                }

            }

            } else { // No hay empate, determinar al ganador directamente
                if (golesLocal > golesVisitante) {
                    ganador = equipoLocal;
                } if (golesLocal < golesVisitante){
                    ganador = equipoVisitante;
                }
            }

            System.out.print("Resultado de " + equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + ": " + golesLocal + " - " + golesVisitante);

            if (ganador != null) {
                System.out.println(" Ganador: " + ganador.getNombre());
                ganador.agregarPartido(partido);
            }
            if (ganador != null && etapa != null) {
                etapa.addEquipoQueAvanza(ganador);
            }
        }
    }*/

}
