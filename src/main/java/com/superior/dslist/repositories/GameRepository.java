package com.superior.dslist.repositories;

import com.superior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}

/*No Spring Boot (com Spring Data JPA), o Repository é uma interface que representa a camada de acesso aos dados (DAO – Data Access Object) e faz o “meio-de-campo” entre a aplicação e o banco de dados.

O que ele faz?
	•	Abstrai toda a lógica de conexão com o banco
	•	Permite salvar, buscar, atualizar e deletar entidades
	•	Usa o JPA por baixo dos panos para transformar objetos Java em registros no banco e vice-versa


 */

