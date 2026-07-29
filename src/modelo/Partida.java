package modelo;

public class Partida {

    public Jugador jugador1;
    public Jugador jugador2;
    public Jugador ganador;
    public String resultado;
    public int puntosExtra;

    public Partida(Jugador jugador1, Jugador jugador2, Jugador ganador,
                   String resultado, int puntosExtra) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.resultado = resultado;
        this.puntosExtra = puntosExtra;
    }
}