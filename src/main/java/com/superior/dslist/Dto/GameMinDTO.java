package com.superior.dslist.Dto;
// Pacote onde essa classe está localizada

import com.superior.dslist.GameMinProjection; // Interface usada para consultas SQL customizadas (projection)
import com.superior.dslist.entities.Game;     // Entidade Game (origem dos dados)

public class GameMinDTO {
    // DTO (Data Transfer Object) → versão simplificada de um jogo
    // Transporta apenas alguns campos essenciais

    private Long id;                // Identificador do jogo
    private String title;           // Título do jogo
    private Integer year;           // Ano de lançamento
    private String imgUrl;          // URL da imagem
    private String shortDescription; // Descrição curta do jogo

    public GameMinDTO() {
        // Construtor vazio → usado por frameworks que precisam instanciar a classe
    }

    public GameMinDTO(Game entity) {
        // Construtor que recebe uma entidade Game
        // Copia os dados diretamente do objeto Game

        id = entity.getId();                       // Copia o ID
        title = entity.getTitle();                 // Copia o título
        year = entity.getYear();                   // Copia o ano
        imgUrl = entity.getImgUrl();               // Copia a URL da imagem
        shortDescription = entity.getShortDescription(); // Copia a descrição curta
    }

    public GameMinDTO (GameMinProjection projection) {
        // Construtor que recebe um objeto de projection
        // Usado quando fazemos consultas customizadas no banco
        // (por exemplo, com SQL nativo ou JPQL projetando apenas alguns campos)

        id = projection.getId();                       // Pega o ID da projection
        title = projection.getTitle();                 // Pega o título
        year = projection.getGameYear();               // Pega o ano (aqui o nome no banco pode ser diferente)
        imgUrl = projection.getImgUrl();               // Pega a URL da imagem
        shortDescription = projection.getShortDescription(); // Pega a descrição curta
    }

    // =============================
    // Getters (não há setters, logo o objeto é imutável depois de criado)
    // =============================

    public Long getId() {
        return id; // Retorna o ID
    }

    public String getTitle() {
        return title; // Retorna o título
    }

    public Integer getYear() {
        return year; // Retorna o ano
    }

    public String getImgUrl() {
        return imgUrl; // Retorna a URL da imagem
    }

    public String getShortDescription() {
        return shortDescription; // Retorna a descrição curta
    }
}
// Fim da classe GameMinDTO

/*	•	GameMinDTO → versão reduzida do jogo (usada para listagens).
	•	Tem dois construtores:
	•	Um baseado na entidade Game (quando carregamos o objeto inteiro).
	•	Outro baseado em GameMinProjection (quando buscamos só alguns campos no banco).
	•	Não tem setters → o objeto é imutável depois de criado (boa prática para DTOs).*/