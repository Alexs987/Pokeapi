package acjm.pokeapi.Pokeapi.dao.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import acjm.pokeapi.Pokeapi.dao.PokemonDAO;
import acjm.pokeapi.Pokeapi.model.Habilidades;
import acjm.pokeapi.Pokeapi.model.Held_items;
import acjm.pokeapi.Pokeapi.model.Location_area_encounter;
import acjm.pokeapi.Pokeapi.model.Pokemon;
import acjm.pokeapi.Pokeapi.model.PuntosBase;

@Service
@Component
public class PokemonServiceDAOImpl implements PokemonServiceDAO{

	@Autowired
	private PokemonDAO pokemonDAO;
	
	//@Transactional
	public Long save(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return pokemonDAO.save(pokemon);
	}
	
	//@Transactional
	public Pokemon getPokemon(Long id) {
		return pokemonDAO.getPokemon(id);
	}

	//@Transactional
	public Habilidades abilities(String name) {
		return pokemonDAO.abilities(name);
	}


	//@Transactional
	public PuntosBase base_experiences(String name) {
		return pokemonDAO.base_experiences(name);
	}

	//@Transactional
	public List<Held_items> held_items(String name) {
		return pokemonDAO.held_items(name);
	}

	//@Transactional
	public Long id(String name) {
		return pokemonDAO.id(name);
	}

	//@Transactional
	public String name(String name) {
		return pokemonDAO.name(name);
	}

	//@Transactional
	public Location_area_encounter location_area_encounters(String name) {
		return pokemonDAO.location_area_encounters(name);
	}

}
