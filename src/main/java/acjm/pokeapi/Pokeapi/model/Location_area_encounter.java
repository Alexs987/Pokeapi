package acjm.pokeapi.Pokeapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="location_area_encounter")
public class Location_area_encounter implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable=false)
	private Long id;
	
	@Column
	private String location;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pokemon_id")
	private Pokemon pokemon;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Pokemon getPokemon() {
		return pokemon;
	}


	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}


	@Override
	public String toString() {
		return "Location_area_encounter [id=" + id + ", location=" + location + ", pokemon=" + pokemon + "]";
	}
	
	
	

}
