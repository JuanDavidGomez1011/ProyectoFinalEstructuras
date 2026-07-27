package estructuras;

import modelo.Jugador;

public class NodoArbol {
    public Jugador jugador;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Jugador jugador) {
        this.jugador = jugador;
        this.izquierdo = null;
        this.derecho = null;
    }
}