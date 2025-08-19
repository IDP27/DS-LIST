package com.superior.dslist.repositories;

import com.superior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository <GameList, Long> {

    // Aqui você pode adicionar métodos personalizados se necessário
    // Exemplo: List<GameList> findByNameContaining(String name);
}
