package com.manuel.pokemonDemo.services;

import com.manuel.pokemonDemo.Pokemon;
import com.manuel.pokemonDemo.controllers.exception.PokemonNotFoundException;
import com.manuel.pokemonDemo.repositories.PokemonRepository;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonServiceImp implements PokemonService {
    PokemonRepository pokemonRepository;

    public PokemonServiceImp(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getPokemons(Pageable pageable) {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll(pageable).forEach(pokemons::add);
        return pokemons;
    }

    @SneakyThrows
    @Override
    public Pokemon getPokemonById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if(pokemon.isPresent()){
            return pokemon.get();
        }else {
            throw new PokemonNotFoundException("Poke with id-" + id+ " missing.");
        }
    }

    @Override
    public Pokemon insertPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @SneakyThrows
    @Override
    public void updatePokemon(Long id, Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);
        if (!pokemonOptional.isPresent())
            throw new PokemonNotFoundException("Poke with id-" + id+ " missing.");
        pokemon.setId(id);
        pokemonRepository.save(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonId) {
        pokemonRepository.deleteById(pokemonId);
    }
}




