package Mundial;

public class Jugador {
    private String Nombre; //Declara el nombre del jugador
    private int Numero; //Declara el número del dorsal del jugador
    private String Posicion; //Declara la posición del jugador
    private Equipo equipo; //Agrega los valores de Equipo a Jugaror

    public Jugador(String nombre, int numero, String posicion) {
        this.setNombre(nombre);
        this.setNumero(numero);
        this.setPosicion(posicion);
        this.addToTeamList(); //Al crear el jugador, se añade automáticamente al equipo
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public Equipo getEquipo() {return equipo;}

    public void setEquipo(Equipo equipo) {this.equipo = equipo;}


    //Methods
    public void addToTeamList() {
        if(equipo != null) {
            equipo.addJugador(this);
        }
    }
}
