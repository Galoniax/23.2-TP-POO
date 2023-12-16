package Mundial;

import java.util.Date;

public class Partido {
    private Date fecha; //Fecha en la que tiene el partido
    private Equipo local; //Declara uno de los equipos como local
    private Equipo visitante; //Declara uno de los equipos como visitante
    private Resultado resultado; //Pasa los elementos de Resultado como resultado

    public Partido(Date fecha, Equipo local, Equipo visitante) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;

    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

}
