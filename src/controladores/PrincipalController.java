package controladores;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;

public class PrincipalController {

    private ColaJugadores colaJugadores;
    private ArbolRankings arbolRankings;
    private ListaPartidas historialPartidas;

    public PrincipalController() {
        this.colaJugadores = new ColaJugadores();
        this.arbolRankings = new ArbolRankings();
        this.historialPartidas = new ListaPartidas();
    }

    public ColaJugadores getColaJugadores() {
        return colaJugadores;
    }

    public ArbolRankings getArbolRankings() {
        return arbolRankings;
    }

    public ListaPartidas getHistorialPartidas() {
        return historialPartidas;
    }
}