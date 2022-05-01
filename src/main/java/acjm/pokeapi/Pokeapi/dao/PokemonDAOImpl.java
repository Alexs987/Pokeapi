package acjm.pokeapi.Pokeapi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.sql.RowSet;
import javax.transaction.Transactional;

import org.apache.logging.log4j.Level;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import acjm.pokeapi.Pokeapi.config.HibernateConf;
import acjm.pokeapi.Pokeapi.dao.services.PokemonServiceDAO;
import acjm.pokeapi.Pokeapi.model.Habilidades;
import acjm.pokeapi.Pokeapi.model.Held_items;
import acjm.pokeapi.Pokeapi.model.Location_area_encounter;
import acjm.pokeapi.Pokeapi.model.Pokemon;
import acjm.pokeapi.Pokeapi.model.PuntosBase;

@Repository
public class PokemonDAOImpl implements PokemonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
	

	public Long save(Pokemon pokemon) {
		Long idResp=0L;
		Session session=null;
		
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(pokemon);
			idResp = pokemon.getId();
			session.getTransaction().commit();
			session.close();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		
		return idResp;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Pokemon getPokemon(Long id) {
		Pokemon pokemon=null;
		
		CriteriaBuilder criteriaBuilder =getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Pokemon> criteriaQuery = criteriaBuilder.createQuery(Pokemon.class);
		
		Root<Pokemon> root = criteriaQuery.from(Pokemon.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
		
		Query<Pokemon> query = getCurrentSession().createQuery(criteriaQuery);
		pokemon=(Pokemon) query.uniqueResult();
		
		return pokemon;
	}
	
	
	public Habilidades abilities(String name) {
		
		Habilidades habilidad = new Habilidades();
		
		String sql ="SELECT h.id,h.habilidad FROM habilidades as h INNER JOIN pokemon as p on p.id = h.pokemon_id WHERE p.nombre ='"+name+"';";
		//System.out.println("sql: "+sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			System.out.println("habilidad_: "+rs.getString("habilidad"));
			habilidad.setId(rs.getLong("id"));
			habilidad.setHabilidad(rs.getString("habilidad"));
		}
		
		return habilidad;
	}


	public PuntosBase base_experiences(String name) {
		PuntosBase puntosBase=new PuntosBase();
		
		String sql ="SELECT pb.id, pb.ps, pb.ataque, pb.defensa, pb.ataque_especial, pb.defensa_especial, pb.velocidad FROM puntos_base as pb INNER JOIN pokemon as p on p.puntos_base_id = pb.id WHERE p.nombre ='"+name+"';";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			//System.out.println("puntos base: "+rs.getInt("ps"));
			puntosBase.setId(rs.getLong("id"));
			puntosBase.setPs(rs.getInt("ps"));
			puntosBase.setAtaque(rs.getInt("ataque"));
			puntosBase.setDefensa(rs.getInt("defensa"));
			puntosBase.setAtaque_especial(rs.getInt("ataque_especial"));
			puntosBase.setDefensa_especial(rs.getInt("defensa_especial"));
			puntosBase.setVelocidad(rs.getInt("velocidad"));
		}
		
		return puntosBase;
	}


	@Override
	public List<Held_items> held_items(String name) {
		List<Held_items> list =new ArrayList<Held_items>();
		String sql = "SELECT hi.id, hi.item, hi.effect, hi.description FROM held_items as hi "
				+ "INNER JOIN pokemon AS p ON p.id=hi.pokemon_id "
				+ "WHERE p.nombre= '"+name+"';";
		//System.out.println("SQL: "+sql);
		try {
			list = jdbcTemplate.query(sql, new RowMapper<Held_items>() {

				public Held_items mapRow(ResultSet rs, int rowNum) throws SQLException {
					Held_items items = new Held_items();
					items.setId(rs.getLong("id"));
					items.setItem(rs.getString("item"));
					items.setEffect(rs.getString("effect"));
					items.setDescription(rs.getString("description"));
					return items;
				}	
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}


	@Override
	public Long id(String name) {
		Long id=0L;
		String sql ="SELECT id FROM pokemon WHERE nombre ='"+name+"';";
		//System.out.println("sql: "+sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			System.out.println("ID : "+rs.getLong("id"));
			id= rs.getLong("id");
		}
		return id;
	}


	@Override
	public String name(String name) {
		String nombre="";
		String sql ="SELECT nombre FROM pokemon WHERE nombre ='"+name+"';";
		//System.out.println("sql: "+sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			nombre= rs.getString("nombre");
		}
		return nombre;
	}


	@Override
	public Location_area_encounter location_area_encounters(String name) {
		Location_area_encounter location = new Location_area_encounter(); 
		
		String sql ="SELECT l.id, l.location FROM location_area_encounter as l INNER JOIN pokemon as p on p.id = l.pokemon_id WHERE p.nombre ='"+name+"';";
		//System.out.println("sql: "+sql);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			location.setId(rs.getLong("id"));
			location.setLocation(rs.getString("location"));
		}
		return location;
	}
	
	

}
