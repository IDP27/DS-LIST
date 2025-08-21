package com.superior.dslist.controllers;
// Define o pacote onde essa classe está localizada (organização do projeto)

import com.superior.dslist.Dto.GameDTO;    // DTO com dados completos do jogo
import com.superior.dslist.Dto.GameMinDTO; // DTO com dados resumidos do jogo
import com.superior.dslist.entities.Game;  // Entidade que representa a tabela Game no banco
import com.superior.dslist.services.GameService; // Classe de serviço que contém a lógica de negócio

import org.springframework.beans.factory.annotation.Autowired; // Permite injeção de dependência
import org.springframework.web.bind.annotation.GetMapping;     // Mapeia requisições HTTP GET
import org.springframework.web.bind.annotation.PathVariable;   // Captura parâmetros da URL
import org.springframework.web.bind.annotation.RequestMapping; // Define o caminho base da API
import org.springframework.web.bind.annotation.RestController; // Define a classe como um controlador REST

import java.util.List; // Estrutura de lista do Java

@RestController
// Diz ao Spring que essa classe é um controlador REST → responde com JSON para as requisições HTTP

@RequestMapping(value = "/games")
// Define que todas as rotas desse controller começam com "/games"

public class GameController {
// Declaração da classe que vai controlar as rotas de jogos

    @Autowired
    private GameService gameService;
    // Injeta automaticamente o GameService (não precisa criar com "new")

    @GetMapping
    // Esse método será chamado quando acessarem GET /games

    public List<GameMinDTO> findAll(){
        // Retorna uma lista de jogos resumidos (GameMinDTO)

        List<GameMinDTO> result = gameService.findAll();
        // Chama o método findAll() do service, que busca os jogos no banco

        return result;
        // Retorna a lista em formato JSON
    }

    @GetMapping(value = "/{id}")
    // Esse método será chamado quando acessarem GET /games/{id}

    public GameDTO findById(@PathVariable Long id) {
        // @PathVariable → pega o valor do {id} da URL e coloca na variável "id"

        GameDTO result = gameService.findById(id);
        // Chama o service para buscar o jogo completo pelo ID

        return result;
        // Retorna os dados completos do jogo em JSON
    }

}
// Fecha a classe GameController

/*📌 Resumo final para você decorar:
	•	@RestController → transforma a classe em um controlador REST.
	•	@RequestMapping("/games") → todas as rotas começam com /games.
	•	@GetMapping → responde a requisições GET.
	•	@PathVariable → pega valores da URL e joga no método.
	•	GameService → faz a lógica e busca os dados no banco.*/