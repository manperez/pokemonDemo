package com.manuel.pokemonDemo.controllers.exception;

public class PokemonNotFoundException extends Throwable {
    public PokemonNotFoundException(String s) {
        super(s);
    }
}
