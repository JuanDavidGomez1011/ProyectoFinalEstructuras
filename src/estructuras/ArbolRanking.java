package estructuras;

import modelo.Jugador;

public class ArbolRanking {
    public NodoArbol raiz;

    public void insertar(Jugador jugador) {
        if (raiz == null) {
            raiz = new NodoArbol(jugador);
        } else {
            insertarRec(raiz, jugador);
        }
    }

    private void insertarRec(NodoArbol nodo, Jugador jugador) {
        if (jugador.puntaje > nodo.jugador.puntaje ||
                (jugador.puntaje == nodo.jugador.puntaje && jugador.cedula.compareTo(nodo.jugador.cedula) > 0)) {
            if (nodo.derecho == null) {
                nodo.derecho = new NodoArbol(jugador);
            } else {
                insertarRec(nodo.derecho, jugador);
            }
        } else {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = new NodoArbol(jugador);
            } else {
                insertarRec(nodo.izquierdo, jugador);
            }
        }
    }

    public Jugador buscar(String cedula) {
        return buscarRec(raiz, cedula);
    }

    private Jugador buscarRec(NodoArbol nodo, String cedula) {
        if (nodo == null) return null;
        if (nodo.jugador.cedula.equals(cedula)) return nodo.jugador;

        Jugador encontrado = buscarRec(nodo.izquierdo, cedula);
        if (encontrado != null) return encontrado;

        return buscarRec(nodo.derecho, cedula);
    }

    public void inOrder() {
        System.out.println("--- RANKING DE JUGADORES ---");
        inOrderRec(raiz);
    }

    private void inOrderRec(NodoArbol nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izquierdo);
            System.out.println(nodo.jugador.nombre + " - Puntos: " + nodo.jugador.puntaje);
            inOrderRec(nodo.derecho);
        }
    }

    public void eliminar(Jugador jugador) {
        raiz = eliminarRec(raiz, jugador);
    }

    private NodoArbol eliminarRec(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) return null;

        if (jugador.puntaje > nodo.jugador.puntaje ||
                (jugador.puntaje == nodo.jugador.puntaje && jugador.cedula.compareTo(nodo.jugador.cedula) > 0)) {
            nodo.derecho = eliminarRec(nodo.derecho, jugador);
        }
        else if (jugador.puntaje < nodo.jugador.puntaje ||
                (jugador.puntaje == nodo.jugador.puntaje && jugador.cedula.compareTo(nodo.jugador.cedula) < 0)) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, jugador);
        }
        else {
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

            nodo.jugador = minValor(nodo.derecho).jugador;
            nodo.derecho = eliminarRec(nodo.derecho, nodo.jugador);
        }
        return nodo;
    }

    private NodoArbol minValor(NodoArbol nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo;
    }
}