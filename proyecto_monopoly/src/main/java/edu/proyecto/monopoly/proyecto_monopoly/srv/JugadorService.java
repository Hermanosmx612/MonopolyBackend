package edu.proyecto.monopoly.proyecto_monopoly.srv;


import java.util.List;
import java.util.Optional;

import edu.proyecto.monopoly.proyecto_monopoly.model.db.JugadorDb;
import edu.proyecto.monopoly.proyecto_monopoly.model.db.PartidaDb;
import edu.proyecto.monopoly.proyecto_monopoly.model.db.UsuarioDb;
import edu.proyecto.monopoly.proyecto_monopoly.model.dto.JugadorAddPartidaDto;

public interface JugadorService {
    public JugadorAddPartidaDto save(JugadorAddPartidaDto jugadorAddPartidaDto);
    public Optional<JugadorDb> buscarJugadorPorUsuarioYPartida(UsuarioDb usuario, PartidaDb partida);
    public int contarIdPartida(PartidaDb partida);
    public void avanzarJugador(Integer idUsuario, Integer idPartida, Integer casillasAvanzar);
    public void avanzarJugadorReset(Integer idUsuario, Integer idPartida, Integer casillasAvanzar);
    public Integer obtenerPosicionJugador(Integer idUsuario, Integer idPartida);
    public List<Object[]> getColorFichaByPartidaId(Integer idPartida);
    public void restarDinero(Integer idUser, Integer idPartida, Integer dineroArestar);
}
