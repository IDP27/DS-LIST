package com.superior.dslist.controllers;
// Define o pacote onde essa classe está localizada (organização do projeto)

import com.superior.dslist.Dto.GameListDTO;  // DTO para representar listas de jogos
import com.superior.dslist.Dto.GameMinDTO;   // DTO para representar jogos em formato resumido
import com.superior.dslist.Dto.ReplacementDTO;
import com.superior.dslist.services.GameListService; // Serviço que cuida da lógica de listas
import com.superior.dslist.services.GameService;     // Serviço que cuida da lógica dos jogos

import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência
import org.springframework.web.bind.annotation.*;

import java.util.List; // Estrutura de lista do Java

@RestController
// Diz ao Spring que essa classe é um controlador REST (responde a chamadas HTTP com JSON)

@RequestMapping(value = "/lists")
// Define que todas as rotas deste controller começam com "/lists"

public class GameListController {
// Declaração da classe responsável por controlar as rotas de listas de jogos

    @Autowired
    private GameListService gameListService;
    // Injeta automaticamente o serviço que cuida das listas de jogos

    @Autowired
    private GameService gameService;
    // Injeta automaticamente o serviço que cuida dos jogos

    @GetMapping
    // Esse método vai responder a requisições GET em "/lists"

    public List<GameListDTO> findAll(){
        // Método que retorna todas as listas de jogos

        List<GameListDTO> result = gameListService.findAll();
        // Chama o serviço que busca todas as listas no banco de dados

        return result;
        // Retorna a lista de GameListDTO em formato JSON
    }

    @GetMapping(value = "/{listId}/games")
    // Esse método responde a GET em "/lists/{listId}/games"

    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        // @PathVariable → pega o valor de {listId} na URL e coloca na variável listId

        List<GameMinDTO> result = gameService.findByList(listId);
        // Chama o serviço que retorna os jogos dessa lista específica

        return result;
        // Retorna a lista de jogos resumidos (GameMinDTO) em formato JSON
    }
    @PostMapping (value = "/{listId}/replacement")

    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        // Método que recebe uma requisição POST para mover jogos dentro de uma lista

        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
        // Chama o serviço para mover o jogo da posição sourceIndex para destinationIndex na lista especificada
    }


}
// Fim da classe GameListController

// Essa classe controla as rotas relacionadas às listas de jogos, permitindo buscar todas as listas e os jogos de uma lista específica.

// Ela usa os serviços GameListService e GameService para acessar os dados necessários.
// As respostas são retornadas em formato JSON, facilitando a integração com front-ends e outras aplicações.

/*📌 Resumo rápido:
	•	GET /lists → retorna todas as listas de jogos.
	•	GET /lists/{listId}/games → retorna todos os jogos de uma lista específica.
	•	GameListService → cuida das listas.
	•	GameService → cuida dos jogos.*/