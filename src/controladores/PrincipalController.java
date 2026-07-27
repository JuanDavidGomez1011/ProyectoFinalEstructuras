package controladores;

import estructuras.ArbolRanking;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;

public class PrincipalController {
    public ColaJugadores colaEspera;
    public ArbolRanking arbolRanking;
    public ListaPartidas historialPartidas;

    public PrincipalController() {
        this.colaEspera = new ColaJugadores();
        this.arbolRanking = new ArbolRanking();
        this.historialPartidas = new ListaPartidas();
    }
}