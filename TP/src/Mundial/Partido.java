package Mundial;

import java.util.Date;

public class Partido {
    private Date fecha;
    private Equipo local;
    private Equipo visitante;
    private Resultado resultado;

    public Partido(Date fecha, Equipo local, Equipo visitante) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.resultado = new Resultado(); // Inicializar el objeto resultado
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public Resultado getResultado() {
        return resultado;
    }


    //public void incrementLocalGoals() {resultado.setGolesLocal(resultado.getGolesLocal() + 1);}

    //public void incrementVisitantGoals() {resultado.setGolesVisitante(resultado.getGolesVisitante() + 1);}


}
