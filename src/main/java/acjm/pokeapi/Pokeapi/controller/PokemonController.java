package acjm.pokeapi.Pokeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acjm.pokeapi.Pokeapi.dao.services.PokemonServiceDAOImpl;
import acjm.pokeapi.Pokeapi.model.Habilidades;
import acjm.pokeapi.Pokeapi.model.Held_items;
import acjm.pokeapi.Pokeapi.model.Location_area_encounter;
import acjm.pokeapi.Pokeapi.model.PuntosBase;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonServiceDAOImpl service;
	
	@GetMapping("/hola")
	public String hola() {
		return "hola servicio";
	}
	
	@GetMapping("/abilities/{name}")
	public Habilidades abilities(@PathVariable String name) {
		return service.abilities(name);
	}
	
	@GetMapping("/base-experiences/{name}")
	public PuntosBase base_experiences(@PathVariable String name) {
		return service.base_experiences(name);
	}
	
	@GetMapping("/held-items/{name}")
	public List<Held_items> held_items(@PathVariable String name){
		return service.held_items(name);
	}
	
	@GetMapping("/id/{name}")
	public Long id(@PathVariable String name) {
		return service.id(name);
	}
	
	@GetMapping("/name/{name}")
	public String name(@PathVariable String name) {
		return service.name(name);
	}
	
	@GetMapping("/location-area-encounters/{name}")
	public Location_area_encounter location_area_encounters(@PathVariable String name) {
		return service.location_area_encounters(name);
		
	}
	
	
}
