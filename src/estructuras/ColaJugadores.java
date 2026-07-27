package estructuras;

import modelo.Jugador;

public class ColaJugadores {
    public NodoCola frente;
    public NodoCola finalCola;

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(Jugador jugador) {
        NodoCola nuevoNodo = new NodoCola(jugador);
        if (isEmpty()) {
            frente = finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    public Jugador dequeue() {
        if (isEmpty()) return null;
        Jugador jugador = frente.jugador;
        frente = frente.siguiente;
        if (frente == null) finalCola = null;
        return jugador;
    }
}