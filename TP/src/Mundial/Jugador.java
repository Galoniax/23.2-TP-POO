package Mundial;

public class Jugador {
    private String Nombre;
    private int Numero;
    private String Posicion;
    private int ContadorGoles;
    private Equipo Equipo;

    public Jugador(String Nombre, int Numero, String Posicion) {
        this.setNombre(Nombre);
        this.setNumero(Numero);
        this.setPosicion(Posicion);
    }

    //Getters

    public String getNombre() {
        return Nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public String getPosicion() {
        return Posicion;
    }

    public int getContadorGoles() {
        return ContadorGoles;
    }

    public Equipo getEquipo() {
        return Equipo;
    }


    //Setters

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public void setContadorGoles(int contadorGoles) {
        ContadorGoles = contadorGoles;
    }

    public void setEquipo(Equipo equipo) {
        Equipo = equipo;
    }

}
