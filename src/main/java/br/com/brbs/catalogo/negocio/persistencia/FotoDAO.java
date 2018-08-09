/**
 * 
 */
package br.com.brbs.catalogo.negocio.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.brbs.catalogo.modelo.entidade.Foto;

/**
 * @author claudiouft@gmail.com
 *
 */
@Repository
@Transactional
public class FotoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Foto foto) {
		manager.persist(foto);
	}
	
	public Foto gravarRetorno(Foto foto) {
		manager.persist(foto);
		return foto;
	}

	public void desativarFoto(Long idFoto) {
		Foto fotoTemp = obterFoto(idFoto);
		fotoTemp.setAtivo("N");
		manager.merge(fotoTemp);
	}
	
	public Foto obterFoto(Long idFoto) {
		 return manager.find(Foto.class, idFoto); 
	}

	public List<Foto> obterFotosPessoa(Long idPessoa) {
		TypedQuery<Foto> lista = manager.createQuery(" "
				+ "	SELECT f "
				+ "	FROM Foto f "
				+ "	WHERE "
				+ "		f.ativo = 'S' "
				+ "	AND f.pessoa.id = :id", Foto.class);
		
		lista.setParameter("id", idPessoa);
		return lista.getResultList();
	}
	
	
}
