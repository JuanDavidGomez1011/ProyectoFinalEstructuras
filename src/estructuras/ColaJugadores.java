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

        if (frente.jugador.cedula.equals(cedula)) {
            dequeue();
            return true;
        }

        NodoCola anterior = frente;
        NodoCola actual = frente.siguiente;

        while (actual != null) {

            if (actual.jugador.cedula.equals(cedula)) {

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

        StringBuilder sb = new StringBuilder();

        NodoCola actual = frente;

        while (actual != null) {

            sb.append("Nombre: ")
                    .append(actual.jugador.nombre)
                    .append(" | Cédula: ")
                    .append(actual.jugador.cedula)
                    .append(" | Puntaje: ")
                    .append(actual.jugador.puntaje)
                    .append("\n");

            actual = actual.siguiente;
        }

        return sb.toString();
    }
}