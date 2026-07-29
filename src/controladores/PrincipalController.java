package controladores;

import estructuras.ArbolRankings;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;

public class PrincipalController {

    public ColaJugadores colaEspera;
    public ArbolRankings arbolRanking;
    public ListaPartidas historialPartidas;

    public JugadorController jugadorController;
    public PartidaController partidaController;

    public PrincipalController() {

        colaEspera = new ColaJugadores();
        arbolRanking = new ArbolRankings();
        historialPartidas = new ListaPartidas();

        jugadorController = new JugadorController(this);
        partidaController = new PartidaController(this);
    }
}