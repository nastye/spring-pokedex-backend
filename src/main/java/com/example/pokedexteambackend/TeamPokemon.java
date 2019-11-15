package com.example.pokedexteambackend;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TeamPokemon {
  @Id
  @JsonInclude
  private Long id;
  @JsonInclude
  private Integer sortId;
  @JsonInclude
  private String name;
  @ElementCollection(targetClass=String.class)
  @JsonInclude
  private List<String> moves;

  protected TeamPokemon() {};

  public TeamPokemon(Long id, Integer sortId, String name, List<String> moves) {
    this.id = id;
    this.sortId = sortId;
    this.name = name;
    this.moves = moves;
  }

  public Long getId() {
    return id;
  }

  public Integer getSortId() {
    return sortId;
  }

  public String getName() {
    return name;
  }

  public List<String> getMoves() {
    return moves;
  }

  @Override
  public String toString() {
    return "TeamPokemon{" +
        "id=" + id +
        ", sortId=" + sortId +
        ", name='" + name + '\'' +
        ", moves=" + moves +
        '}';
  }
}
