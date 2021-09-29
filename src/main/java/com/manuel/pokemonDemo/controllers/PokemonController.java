package com.manuel.pokemonDemo.controllers;

import com.manuel.pokemonDemo.Pokemon;
import com.manuel.pokemonDemo.services.PokemonService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

    PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //The function receives a GET request, processes it and gives back a list of Pokemons as a response.
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Pokemon> pokemons = pokemonService.getPokemons(pageable);
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    //The function receives a GET request, processes it, and gives back a Pokemon as a response.
    @GetMapping({"/{pokemonId}"})
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Long pokemonId) {
        return new ResponseEntity<>(pokemonService.getPokemonById(pokemonId), HttpStatus.OK);
    }

    //The function receives a POST request, processes it, creates a new Pokemon and saves it to the database, and returns a resource link to the created pokemon.
    @PostMapping
    public ResponseEntity<Pokemon> savePokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = pokemonService.insertPokemon(pokemon);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("pokemon", "/api/v1/pokemon/" + createdPokemon.getId().toString());
        return new ResponseEntity<>(createdPokemon, httpHeaders, HttpStatus.CREATED);
    }

    //The function receives a PUT request, updates the Pokemon with the specified Id and returns the updated Pokemon
    @PutMapping({"/{pokemonId}"})
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("pokemonId") Long pokemonId, @RequestBody Pokemon pokemon) {
        pokemonService.updatePokemon(pokemonId, pokemon);
        return new ResponseEntity<>(pokemonService.getPokemonById(pokemonId), HttpStatus.OK);
    }

    //The function receives a DELETE request, deletes the Pokemon with the specified Id.
    @DeleteMapping({"/{pokemonId}"})
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable("pokemonId") Long pokemonId) {
        pokemonService.deletePokemon(pokemonId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
