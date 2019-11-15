package com.example.pokedexteambackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pokemon",
      produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class PokemonController {
  @Autowired
  private TeamPokemonRepository teamPokemonRepository;

  @GetMapping(path="")
  @ResponseBody
  public List<TeamPokemon> listAllTeamPokemon() {
    List<TeamPokemon> pokes = (List<TeamPokemon>) teamPokemonRepository.findAll();
    return pokes;
  }

  @GetMapping(path="{id}")
  @ResponseBody
  public TeamPokemon returnPokemon(
      @PathVariable("id") Long id
  ) {
    Optional<TeamPokemon> res = teamPokemonRepository.findById(id);
    return (res.isPresent() ? res.get() : null);
  }

  @PutMapping(path="{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<TeamPokemon> updatePokemon(
      @PathVariable("id") Long id,
      @RequestBody TeamPokemon pokemon
  ) {
    if (!pokemon.getId().equals(id)) return null;
    if (teamPokemonRepository.findById(id).isPresent()) teamPokemonRepository.deleteById(id);
    teamPokemonRepository.save(pokemon);
    return (List<TeamPokemon>) teamPokemonRepository.findAll();
  }

  @PostMapping(path="",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List<TeamPokemon> addPokemon(
      @RequestBody TeamPokemon pokemon
  ) {
    teamPokemonRepository.save(pokemon);
    return (List<TeamPokemon>) teamPokemonRepository.findAll();
  }

  @DeleteMapping(path="{id}")
  @ResponseBody
  public List<TeamPokemon> deletePokemon(
      @PathVariable("id") Long id
  ) {
    teamPokemonRepository.deleteById(id);
    return (List<TeamPokemon>) teamPokemonRepository.findAll();
  }
}
