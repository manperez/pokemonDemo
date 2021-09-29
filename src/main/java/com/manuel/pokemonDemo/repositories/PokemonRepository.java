package com.manuel.pokemonDemo.repositories;

import com.manuel.pokemonDemo.Pokemon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
* The CrudRespository interface takes in the model and the type of the ID, in our case the model is Pokemon and the ID type is Long.
* We are now able to use all the CrudRepository methods save(), findOne(), findById(), findAll(), count(), delete(), deleteById()
* without providing implementation.
* */
@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {

}
