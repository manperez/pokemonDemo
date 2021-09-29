package com.manuel.pokemonDemo.services;

import com.manuel.pokemonDemo.Pokemon;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * A service is an interface from which different implementations of the same functions can be made.
 */
public interface PokemonService {
    List<Pokemon> getPokemons(Pageable pageable);

    Pokemon getPokemonById(Long id);

    Pokemon insertPokemon(Pokemon todo);

    void updatePokemon(Long id, Pokemon todo);

    void deletePokemon(Long todoId);
}

/*
* The interface above defines the base CRUD operations that we will implement in our PokemonServiceImpl class
* */