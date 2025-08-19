package com.superior.dslist.services;



import com.superior.dslist.Dto.GameMinDTO;
import com.superior.dslist.entities.Game;
import com.superior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Aqui vao ficar as regras de negocio
// A anotacao @Service indica que esta classe e um componente de servico do Spring,
// o que permite que o Spring a reconheca e a injete onde for necessario.
// Isso e util para separar a logica de negocio da logica de apresentacao e persistencia.
// A anotacao @Autowired permite que o Spring injete automaticamente uma instancia do GameRepository
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {

        List <Game> result = gameRepository.findAll();
        List <GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

        return dto;





}
}

