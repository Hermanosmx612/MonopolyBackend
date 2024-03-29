package edu.proyecto.monopoly.proyecto_monopoly.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.proyecto.monopoly.proyecto_monopoly.model.db.PartidaDb;
import edu.proyecto.monopoly.proyecto_monopoly.model.dto.ListaPartidasDto;
import edu.proyecto.monopoly.proyecto_monopoly.repository.PartidaRepository;
import edu.proyecto.monopoly.proyecto_monopoly.srv.PartidaService;
import edu.proyecto.monopoly.proyecto_monopoly.srv.mapper.PartidaMapper;

@Service
public class PartidaServiceImpl implements PartidaService{


    private final PartidaRepository partidaRepository;

    


    public PartidaServiceImpl(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }




    @Override
    public PartidaDb crearPartidaDb() {
       PartidaDb nuevaPartida = new PartidaDb();
       return partidaRepository.save(nuevaPartida);
    }

    @Override
    public Optional<PartidaDb> getById(Integer id){
        return partidaRepository.findById(id);
    }




    @Override
    public List<ListaPartidasDto> obtenerPartidasNoAsociadasAUsuario(int idUsuario) {
        return PartidaMapper.INSTANCE.partidaDbToPartidaList(partidaRepository.findPartidasNoAsociadasAUsuario(idUsuario));
    }



    
}
