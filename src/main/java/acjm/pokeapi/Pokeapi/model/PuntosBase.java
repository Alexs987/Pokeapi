package acjm.pokeapi.Pokeapi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="puntos_base")
public class PuntosBase implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable=false)
	private Long id;
	
	@Column(length = 2)
	private Integer ps;
	
	@Column(length = 2)
	private Integer ataque;
	
	@Column(length = 2)
	private Integer defensa;
	
	@Column(length = 2)
	private Integer ataque_especial;
	
	@Column(length = 2)
	private Integer defensa_especial;
	
	@Column(length = 2)
	private Integer velocidad;
	
	
	@OneToOne(mappedBy = "puntos_base")
	private Pokemon pokemon;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getPs() {
		return ps;
	}


	public void setPs(Integer ps) {
		this.ps = ps;
	}


	public Integer getAtaque() {
		return ataque;
	}


	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}


	public Integer getDefensa() {
		return defensa;
	}


	public void setDefensa(Integer defensa) {
		this.defensa = defensa;
	}


	public Integer getAtaque_especial() {
		return ataque_especial;
	}


	public void setAtaque_especial(Integer ataque_especial) {
		this.ataque_especial = ataque_especial;
	}


	public Integer getDefensa_especial() {
		return defensa_especial;
	}


	public void setDefensa_especial(Integer defensa_especial) {
		this.defensa_especial = defensa_especial;
	}


	public Integer getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}


	public Pokemon getPokemon() {
		return pokemon;
	}


	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}


	@Override
	public String toString() {
		return "PuntosBase [id=" + id + ", ps=" + ps + ", ataque=" + ataque + ", defensa=" + defensa
				+ ", ataque_especial=" + ataque_especial + ", defensa_especial=" + defensa_especial + ", velocidad="
				+ velocidad + ", pokemon=" + pokemon + "]";
	}
	
	
}
