package com.manuel.pokemonDemo.util;

import com.manuel.pokemonDemo.Pokemon;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import java.util.List;

public class CSVHelper {

    public static List<Pokemon> csvToPokemons(Reader reader) {
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Pokemon.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        // convert `CsvToBean` object to list of pokemons
        List<Pokemon> pokemons = csvToBean.parse();
        return pokemons;
    }

}