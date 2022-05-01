package acjm.pokeapi.Pokeapi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable=false)
	private Long id;
	
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pokemon", orphanRemoval=true, cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Habilidades> habilidad;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pokemon", orphanRemoval=true, cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Held_items> held_items;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="pokemon", orphanRemoval=true, cascade = CascadeType.ALL)
	@Fetch(value=FetchMode.SUBSELECT)
	private List<Location_area_encounter> location;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="puntos_base_id")
	private PuntosBase puntos_base;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Habilidades> getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(List<Habilidades> habilidad) {
		this.habilidad = habilidad;
	}

	

	public List<Held_items> getHeld_items() {
		return held_items;
	}

	public void setHeld_items(List<Held_items> held_items) {
		this.held_items = held_items;
	}

	public List<Location_area_encounter> getLocation() {
		return location;
	}

	public void setLocation(List<Location_area_encounter> location) {
		this.location = location;
	}

	public PuntosBase getPuntos_base() {
		return puntos_base;
	}

	public void setPuntos_base(PuntosBase puntos_base) {
		this.puntos_base = puntos_base;
	}
	
	
}
