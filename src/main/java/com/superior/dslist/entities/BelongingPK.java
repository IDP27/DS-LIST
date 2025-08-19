package com.superior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;


@Embeddable // Essa anotação indica que essa classe é um tipo incorporável e pode ser embutida em outras entidades.
// Isso é útil para criar chaves compostas, onde a combinação de dois ou mais campos
// é usada como chave primária de uma entidade.
// Nesse caso, a classe BelongingPK é usada como chave primária composta para a
// entidade Belonging, que representa a relação entre um jogo (Game) e uma lista
// de jogos (GameList). A anotação @Embeddable permite que o JPA
// reconheça essa classe como um componente que pode ser incorporado em outras entidades.
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    BelongingPK (){

    }
    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
