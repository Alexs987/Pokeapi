package acjm.pokeapi.Pokeapi.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import acjm.pokeapi.Pokeapi.config.HibernateConf;
import acjm.pokeapi.Pokeapi.dao.services.PokemonServiceDAO;
import acjm.pokeapi.Pokeapi.model.Habilidades;
import acjm.pokeapi.Pokeapi.model.Held_items;
import acjm.pokeapi.Pokeapi.model.Location_area_encounter;
import acjm.pokeapi.Pokeapi.model.Pokemon;
import acjm.pokeapi.Pokeapi.model.PuntosBase;

public class Test {

public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConf.class);
	PokemonServiceDAO service = context.getBean(PokemonServiceDAO.class);
		/*Pokemon pokemon = new Pokemon();
		
		pokemon= service.getPokemon(1L);
		System.out.println("POKEMON: "+pokemon.getNombre());
		
		pokemon.setNombre("Squirtle");
	
		List<Habilidades> listHabilidades = new ArrayList<Habilidades>();
		
		Habilidades habilidad = new Habilidades();
		habilidad.setHabilidad("Torrente");
		habilidad.setPokemon(pokemon);
		
		listHabilidades.add(habilidad);
		pokemon.setHabilidad(listHabilidades);
		
		PuntosBase puntosBase = new PuntosBase();
		
		puntosBase.setPs(3);
		puntosBase.setAtaque(3);
		puntosBase.setDefensa(4);
		puntosBase.setAtaque_especial(3);
		puntosBase.setDefensa_especial(4);
		puntosBase.setVelocidad(3);
		puntosBase.setPokemon(pokemon);
		pokemon.setPuntos_base(puntosBase);
		
		
		List<Held_items> listItems = new ArrayList<Held_items>();
		Held_items item1 = new Held_items();
		item1.setItem("Choice Specs");
		item1.setEffect("Sp. Atk +10 (+39)");
		item1.setDescription("Increases the damage of moves by a minimum of 40/50/60 when they hit. The higher the Pokemon's Sp. Atk, the more the damage is increased.");
		item1.setPokemon(pokemon);
		Held_items item2 = new Held_items();
		item2.setItem("Wise Glasses");
		item2.setEffect("Sp. Atk +10 (+39)");
		item2.setDescription("Increases Sp. Atk by 3/5/7%");
		item2.setPokemon(pokemon);
		
		listItems.add(item1);
		listItems.add(item2);
		pokemon.setHeld_items(listItems);
		
		List<Location_area_encounter> listUbicacion = new ArrayList<Location_area_encounter>();
		Location_area_encounter ubicacion = new Location_area_encounter();
		ubicacion.setLocation("Ciudad Luminalia");
		ubicacion.setPokemon(pokemon);
		
		listUbicacion.add(ubicacion);
		pokemon.setLocation(listUbicacion);
		
		
		Long idresp = 0l;
		
		
		
		idresp = service.save(pokemon);
		
		System.out.println("RESP : "+idresp);*/
		
		Habilidades habilidad=null;
		
		habilidad= service.abilities("Squirtle");
		System.out.println("HABILIDAD: "+habilidad.toString());
		
		PuntosBase puntosBase=null;
		puntosBase = service.base_experiences("Squirtle");
		System.out.println("PUNTOS BASE: "+puntosBase.toString());
		
		List<Held_items> listItems = new ArrayList<Held_items>();
				
		listItems = service.held_items("Squirtle");
		
		for (Held_items held_items : listItems) {
			System.out.println("HELD ITEMS: "+held_items.toString());
		}
				
		Long id=0L;
		
		id =service.id("Squirtle");
		System.out.println("Squirtle ID: "+id);
		
		String nombre="";
		
		nombre = service.name("Squirtle");
		System.out.println("NOMBRE: "+nombre);
		
		Location_area_encounter location = new Location_area_encounter();
		
		location =service.location_area_encounters("Squirtle");
		
		System.out.println("LOCATION: "+location.toString());
		
		
		
		
		
		
	}
}
