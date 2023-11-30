package Mundial;

public class Resultado {
    private int golesLocal;
    private int golesVisitante;


    //Getters
    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }


    //Setters
    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }


    //Functions
    public boolean ganoLocal() {
        return golesLocal > golesVisitante;
    };

    public boolean ganoVisitante() {
        return golesLocal < golesVisitante;
    };

    public boolean empate() {
        return golesVisitante == golesLocal;
    }




    //public void incrementVisitantGoals() {setGolesVisitante(getGolesVisitante() + 1);}

    // public void incrementLocalGoals() {setGolesLocal(getGolesLocal() + 1);}
}
