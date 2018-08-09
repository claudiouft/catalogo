package br.com.brbs.catalogo.negocio.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.brbs.catalogo.modelo.entidade.Uf;

/**
 * 
 * @author claudiouft@gmail.com
 *
 */
@Repository
@Transactional
public class UfDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Uf> allUf() {
		TypedQuery<Uf> lista = manager.createQuery(" SELECT uf FROM Uf uf",Uf.class);
		return lista.getResultList();	
	}
}
