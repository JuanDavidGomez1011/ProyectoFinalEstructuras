package modelo;

public class Partida {

    public Jugador jugador1;
    public Jugador jugador2;
    public Jugador ganador;
    public String resultado;

    public int puntosExtraJugador1;
    public int puntosExtraJugador2;

    public Partida(Jugador jugador1,
                   Jugador jugador2,
                   Jugador ganador,
                   String resultado,
                   int puntosExtraJugador1,
                   int puntosExtraJugador2) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.resultado = resultado;
        this.puntosExtraJugador1 = puntosExtraJugador1;
        this.puntosExtraJugador2 = puntosExtraJugador2;
    }
}