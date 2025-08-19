package com.superior.dslist.services;



import com.superior.dslist.Dto.GameDTO;
import com.superior.dslist.Dto.GameMinDTO;
import com.superior.dslist.GameMinProjection;
import com.superior.dslist.entities.Game;
import com.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Aqui vao ficar as regras de negocio
// A anotacao @Service indica que esta classe e um componente de servico do Spring,
// o que permite que o Spring a reconheca e a injete onde for necessario.
// Isso e util para separar a logica de negocio da logica de apresentacao e persistencia.
// A anotacao @Autowired permite que o Spring injete automaticamente uma instancia do GameRepository
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Indica que o metodo nao ira modificar o banco de dados, apenas ler
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        List <Game> result = gameRepository.findAll();
        List <GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;
    }
    @Transactional (readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();


}
}

