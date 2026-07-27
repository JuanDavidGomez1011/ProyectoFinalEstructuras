package modelo;

public class Partida {
    public Jugador jugador1;
    public Jugador jugador2;
    public String resultado;
    public int puntosExtra;

    public Partida(Jugador jugador1, Jugador jugador2, String resultado, int puntosExtra) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.resultado = resultado;
        this.puntosExtra = puntosExtra;
    }
}