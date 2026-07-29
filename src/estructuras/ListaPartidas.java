package estructuras;

import modelo.Partida;

public class ListaPartidas {

    public NodoLista primero;
    public NodoLista ultimo;

    public ListaPartidas() {
        primero = null;
        ultimo = null;
    }

    public void insertar(Partida partida) {

        NodoLista nuevo = new NodoLista(partida);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
    }

    public void eliminar(Partida partida) {

        NodoLista actual = primero;

        while (actual != null && actual.partida != partida) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            return;
        }

        if (actual.anterior == null) {
            primero = actual.siguiente;
        } else {
            actual.anterior.siguiente = actual.siguiente;
        }

        if (actual.siguiente == null) {
            ultimo = actual.anterior;
        } else {
            actual.siguiente.anterior = actual.anterior;
        }
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {

        int contador = 0;
        NodoLista actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }

    public String mostrarHistorial() {

        if (isEmpty()) {
            return "No hay partidas registradas.";
        }

        StringBuilder sb = new StringBuilder();

        NodoLista actual = primero;

        while (actual != null) {

            sb.append("Jugador 1: ")
                    .append(actual.partida.jugador1.nombre)
                    .append("\n");

            sb.append("Jugador 2: ")
                    .append(actual.partida.jugador2.nombre)
                    .append("\n");

            sb.append("Ganador: ")
                    .append(actual.partida.ganador)
                    .append("\n");

            sb.append("---------------------------------\n");

            actual = actual.siguiente;
        }

        return sb.toString();
    }
}