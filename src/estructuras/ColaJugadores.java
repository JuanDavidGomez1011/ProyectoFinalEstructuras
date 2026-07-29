package estructuras;

import modelo.Jugador;

public class ColaJugadores {

    public NodoCola frente;
    public NodoCola finalCola;

    public ColaJugadores() {
        frente = null;
        finalCola = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(Jugador jugador) {

        NodoCola nuevo = new NodoCola(jugador);

        if (isEmpty()) {
            frente = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.siguiente = nuevo;
            finalCola = nuevo;
        }
    }

    public Jugador dequeue() {

        if (isEmpty()) {
            return null;
        }

        Jugador jugador = frente.jugador;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;
        }

        return jugador;
    }

    public Jugador peek() {

        if (isEmpty()) {
            return null;
        }

        return frente.jugador;
    }

    public boolean eliminar(String cedula) {

        if (isEmpty()) {
            return false;
        }

        boolean sonIgualesFrente = true;
        if (frente.jugador.cedula.length() != cedula.length()) {
            sonIgualesFrente = false;
        } else {
            for (int i = 0; i < cedula.length(); i++) {
                if (frente.jugador.cedula.charAt(i) != cedula.charAt(i)) {
                    sonIgualesFrente = false;
                    break;
                }
            }
        }

        if (sonIgualesFrente) {
            dequeue();
            return true;
        }

        NodoCola anterior = frente;
        NodoCola actual = frente.siguiente;

        while (actual != null) {

            boolean sonIgualesActual = true;
            if (actual.jugador.cedula.length() != cedula.length()) {
                sonIgualesActual = false;
            } else {
                for (int i = 0; i < cedula.length(); i++) {
                    if (actual.jugador.cedula.charAt(i) != cedula.charAt(i)) {
                        sonIgualesActual = false;
                        break;
                    }
                }
            }

            if (sonIgualesActual) {

                anterior.siguiente = actual.siguiente;

                if (actual == finalCola) {
                    finalCola = anterior;
                }

                return true;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    public int size() {

        int contador = 0;
        NodoCola actual = frente;

        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }

    public String mostrarCola() {

        if (isEmpty()) {
            return "No hay jugadores en espera.";
        }

        String acumulado = "";

        NodoCola actual = frente;

        while (actual != null) {

            acumulado = acumulado + "Nombre: " +
                    actual.jugador.nombre +
                    " | Cédula: " +
                    actual.jugador.cedula +
                    " | Puntaje: " +
                    actual.jugador.puntaje +
                    "\n";

            actual = actual.siguiente;
        }

        return acumulado;
    }
}