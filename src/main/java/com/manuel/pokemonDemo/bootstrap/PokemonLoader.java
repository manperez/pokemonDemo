package com.manuel.pokemonDemo.bootstrap;

import com.manuel.pokemonDemo.Pokemon;
import com.manuel.pokemonDemo.repositories.PokemonRepository;
import com.manuel.pokemonDemo.util.CSVHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/*
* Data bootstrapper creates and loads the initial data whenever the application runs.
* When we start the application we will read csv file provided and will load it into our H2 in-memory DB.
* */

@Component
public class PokemonLoader implements CommandLineRunner {
    private static final String FILE_NAME = "pokemon.csv";
    public final PokemonRepository pokemonRepository;

    public PokemonLoader(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPokemons();
    }

    private void loadPokemons() throws IOException, URISyntaxException {
        if (pokemonRepository.count() == 0) {
            List<Pokemon> pokemonsFromCsv;
            try (Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()))) {
                pokemonsFromCsv = CSVHelper.csvToPokemons(reader);
            }
            pokemonRepository.saveAll(pokemonsFromCsv);
            System.out.println("Sample Pokemons Loaded in H2 DB");
        }
    }

}
