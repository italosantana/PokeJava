package br.com.pokejava.PokeJava.resouce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokejava.PokeJava.models.Pokemon;
import br.com.pokejava.PokeJava.repository.PokeRepositroy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST PokeDex")
@CrossOrigin(origins="*")
public class PokeResource {
	
	@Autowired
	PokeRepositroy pokerepository;
	
	@GetMapping("/pokemon")
	@ApiOperation(value="Retorna uma lista dos Pokemons")
	public List<Pokemon> ListaPokemon(){
		return pokerepository.findAll();
	}
	
	@GetMapping("/pokemon/{id}")
	@ApiOperation(value="Retorna um pokémon individual")
	public Pokemon listaPokemonUnico(@PathVariable(value="id") long id) {
		return pokerepository.findById(id);
	}

}
