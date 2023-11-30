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

    }
}