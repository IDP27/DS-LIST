package com.superior.dslist.Dto;
// Pacote onde a classe está localizada (organização do projeto)

import com.superior.dslist.entities.Game;   // Importa a entidade Game (origem dos dados)
import org.springframework.beans.BeanUtils; // Classe utilitária para copiar propriedades entre objetos

public class GameDTO {
// DTO (Data Transfer Object) → serve para transportar os dados do Game sem expor a entidade diretamente

    private Long id;                 // Identificador do jogo
    private String title;            // Título do jogo
    private Integer year;            // Ano de lançamento
    private String genre;            // Gênero do jogo (ex: Ação, RPG)
    private String platforms;        // Plataformas (ex: PC, Xbox, PlayStation)
    private Double score;            // Nota/avaliação do jogo
    private String imgUrl;           // URL da imagem de capa
    private String shortDescription; // Descrição curta
    private String longDescription;  // Descrição longa

    public GameDTO() {
    }
    // Construtor vazio → usado pelo Spring e frameworks que precisam criar objetos sem argumentos

    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
    // Construtor que recebe um objeto Game (entidade)
    // Usa BeanUtils.copyProperties para copiar os valores da entidade para o DTO automaticamente

    // =====================================
    // Getters e Setters (acessores e mutadores)
    // Servem para acessar e modificar os atributos privados
    // =====================================

    public Long getId() {
        return id; // Retorna o ID do jogo
    }

    public void setId(Long id) {
        this.id = id; // Define o ID do jogo
    }

    public String getLongDescription() {
        return longDescription; // Retorna a descrição longa
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription; // Define a descrição longa
    }

    public String getShortDescription() {
        return shortDescription; // Retorna a descrição curta
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription; // Define a descrição curta
    }

    public String getImgUrl() {
        return imgUrl; // Retorna a URL da imagem
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl; // Define a URL da imagem
    }

    public Double getScore() {
        return score; // Retorna a nota
    }

    public void setScore(Double score) {
        this.score = score; // Define a nota
    }

    public String getPlatforms() {
        return platforms; // Retorna as plataformas
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms; // Define as plataformas
    }

    public String getGenre() {
        return genre; // Retorna o gênero
    }

    public void setGenre(String genre) {
        this.genre = genre; // Define o gênero
    }

    public Integer getYear() {
        return year; // Retorna o ano de lançamento
    }

    public void setYear(Integer year) {
        this.year = year; // Define o ano de lançamento
    }

    public String getTitle() {
        return title; // Retorna o título
    }

    public void setTitle(String title) {
        this.title = title; // Define o título
    }

}
// Fim da classe GameDTO

/*📌 Resumo para fixar:
	•	DTO = objeto que transporta dados de forma controlada (não expõe a entidade inteira).
	•	Aqui o GameDTO pega os dados de Game e copia com BeanUtils.copyProperties.
	•	Ele tem todos os atributos do jogo + getters e setters.*/