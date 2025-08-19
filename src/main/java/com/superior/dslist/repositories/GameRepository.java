package com.superior.dslist.repositories;

import com.superior.dslist.GameMinProjection;
import com.superior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);

}

/*No Spring Boot (com Spring Data JPA), o Repository é uma interface que representa a camada de acesso aos dados (DAO – Data Access Object) e faz o “meio-de-campo” entre a aplicação e o banco de dados.

O que ele faz?
	•	Abstrai toda a lógica de conexão com o banco
	•	Permite salvar, buscar, atualizar e deletar entidades
	•	Usa o JPA por baixo dos panos para transformar objetos Java em registros no banco e vice-versa


 */

