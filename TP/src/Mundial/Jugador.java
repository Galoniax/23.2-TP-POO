package Mundial;

public class Jugador {
    private String Nombre;
    private int Numero;
    private String Posicion;
    private Equipo Equipo;

    public Jugador(String Nombre, int Numero, String Posicion) {
        this.setNombre(Nombre);
        this.setNumero(Numero);
        this.setPosicion(Posicion);
        this.addToTeamList();
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


    public void setEquipo(Equipo equipo) {
        Equipo = equipo;
    }

    //Opcional
    public void addToTeamList (Equipo Equipo){
        if(this.getEquipo() == null) {
            Equipo.addJugador(this);
        } else {
            this
                    .getEquipo()    //Team
                    .getJugadores() //ArrayList<Player>
                    .add(this);  //add(Player)
        }

    }

    public void addToTeamList() {
        if(this.getEquipo() == null) return;
        getEquipo().addJugador(this);
    }
}
