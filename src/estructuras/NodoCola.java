package estructuras;

import modelo.Jugador;

public class NodoCola {
    public Jugador jugador;
    public NodoCola siguiente;

    public NodoCola(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}