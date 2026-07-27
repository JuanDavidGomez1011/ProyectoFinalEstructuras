package modelo;

public class Jugador {
    public String nombre;
    public String cedula;
    public int puntaje;

    public Jugador(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.puntaje = 0;
    }
}