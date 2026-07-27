package estructuras;

import modelo.Partida;

public class ListaPartidas {
    public NodoLista primero;
    public NodoLista ultimo;

    public void insertar(Partida partida) {
        NodoLista nuevoNodo = new NodoLista(partida);
        if (primero == null) {
            primero = ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
            ultimo = nuevoNodo;
        }
    }

    public void eliminar(Partida partida) {
        NodoLista actual = primero;

        while (actual != null && actual.partida != partida) {
            actual = actual.siguiente;
        }

        if (actual == null) return;

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            primero = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            ultimo = actual.anterior;
        }
    }
}