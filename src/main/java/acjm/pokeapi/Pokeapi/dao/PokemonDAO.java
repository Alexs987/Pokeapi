package acjm.pokeapi.Pokeapi.dao;

import java.util.List;

import acjm.pokeapi.Pokeapi.model.Habilidades;
import acjm.pokeapi.Pokeapi.model.Held_items;
import acjm.pokeapi.Pokeapi.model.Location_area_encounter;
import acjm.pokeapi.Pokeapi.model.Pokemon;
import acjm.pokeapi.Pokeapi.model.PuntosBase;

public interface PokemonDAO {

	
	public Long save(Pokemon pokemon);
	public Pokemon getPokemon(Long id);
	public Habilidades abilities(String name);
	public PuntosBase base_experiences(String name);
	public List<Held_items> held_items(String name);
	public Long id(String name);
	public String name(String name);
	public Location_area_encounter location_area_encounters(String name);
	
}
