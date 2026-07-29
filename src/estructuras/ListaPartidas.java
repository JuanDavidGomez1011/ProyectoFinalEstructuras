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

        String acumulado = "";

        NodoLista actual = primero;

        while (actual != null) {

            acumulado = acumulado + "Jugador 1: " +
                    actual.partida.jugador1.nombre +
                    "\n";

            acumulado = acumulado + "Jugador 2: " +
                    actual.partida.jugador2.nombre +
                    "\n";

            acumulado = acumulado + "Ganador: " +
                    actual.partida.ganador +
                    "\n";

            acumulado = acumulado + "---------------------------------\n";

            actual = actual.siguiente;
        }

        return acumulado;
    }
}