package controladores;

import estructuras.ArbolRanking;
import estructuras.ColaJugadores;
import estructuras.ListaPartidas;

public class PrincipalController {

    public ColaJugadores colaEspera;
    public ArbolRanking arbolRanking;
    public ListaPartidas historialPartidas;

    public JugadorController jugadorController;
    public PartidaController partidaController;

    public PrincipalController() {

        colaEspera = new ColaJugadores();
        arbolRanking = new ArbolRanking();
        historialPartidas = new ListaPartidas();

        jugadorController = new JugadorController(this);
        partidaController = new PartidaController(this);
    }
}