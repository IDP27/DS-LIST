package com.superior.dslist.Dto;
// Pacote onde essa classe está localizada (organização do projeto)

import com.superior.dslist.entities.GameList;
// Importa a entidade GameList → de onde os dados serão copiados para o DTO

public class GameListDTO {
// DTO (Data Transfer Object) usado para transportar dados de uma lista de jogos
// Aqui ele só carrega os campos "id" e "name"

    private Long id;    // Identificador único da lista
    private String name; // Nome da lista (ex: "Favoritos", "Aventura", etc.)

    public GameListDTO (){
        // Construtor vazio → necessário para frameworks como Spring instanciar o objeto
    }

    public GameListDTO (GameList entity) {
        // Construtor que recebe uma entidade GameList
        // Copia manualmente os dados da entidade para o DTO

        id = entity.getId();     // Copia o ID da entidade
        name = entity.getName(); // Copia o nome da entidade
    }

    public Long getId() {
        return id; // Retorna o ID da lista
    }

    public String getName() {
        return name; // Retorna o nome da lista
    }
}
// Fim da classe GameListDTO

/*📌 Resumo para fixar:
	•	GameListDTO → carrega apenas os dados essenciais da lista (id e name).
	•	O construtor recebe um objeto GameList e copia os valores.
	•	Tem apenas getters (sem setters) → isso torna o DTO imutável depois de criado (boa prática quando só precisamos exibir dados).*/