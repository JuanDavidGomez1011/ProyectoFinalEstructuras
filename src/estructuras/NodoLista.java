package estructuras;

import modelo.Partida;

public class NodoLista {
    public Partida partida;
    public NodoLista siguiente;
    public NodoLista anterior;

    public NodoLista(Partida partida) {
        this.partida = partida;
        this.siguiente = null;
        this.anterior = null;
    }
}