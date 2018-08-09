/**
 * 
 */
package br.com.brbs.catalogo.negocio.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.brbs.catalogo.modelo.entidade.Foto;
import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.modelo.enums.StatusPessoaEnum;
import br.com.brbs.catalogo.negocio.util.DataUtil;

/**
 * @author claudiouft@gmail.com
 *
 */
@Repository
@Transactional
public class PessoaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Pessoa pessoa) {
		pessoa.setAtivo(StatusPessoaEnum.ATIVO.getValor());
		pessoa.setDataCadastro(DataUtil.obterDataAtual());
		pessoa.setDataAlteracao(DataUtil.obterDataAtual());	
		manager.persist(pessoa);
	}
	
	public Pessoa gravarRetorno(Pessoa pessoa) {		
		pessoa.setAtivo(StatusPessoaEnum.ATIVO.getValor());
		pessoa.setDataCadastro(DataUtil.obterDataAtual());
		pessoa.setDataAlteracao(DataUtil.obterDataAtual());		
		manager.persist(pessoa);
		return pessoa;
	}

	public List<Pessoa> findAllPessoa() {
		TypedQuery<Pessoa> lista = manager.createQuery(" SELECT p FROM Pessoa p",Pessoa.class);
		return lista.getResultList();	
	}

	public void alterar(Pessoa pessoa) {
		pessoa.setDataAlteracao(DataUtil.obterDataAtual());	
		manager.merge(pessoa);
	}

	public List<Pessoa> pesquisarPessoaFiltro(Pessoa filtro) {
		TypedQuery<Pessoa> lista = manager.createQuery(""
				+ " SELECT p "
				+ " FROM Pessoa p "
				+ " WHERE lower(p.nome) like :nome ",Pessoa.class);
		
		lista.setParameter("nome","%"+filtro.getNome().toLowerCase()+"%");
		return lista.getResultList();
	}
	
	

	public Pessoa obterPessoa(Long idPessoa) {
		return manager.find(Pessoa.class, idPessoa);
	}
	
	public Pessoa obterPessoaAtiva(Long idPessoa) {
		TypedQuery<Pessoa> lista = manager.createQuery(""
				+ " SELECT p "
				+ " FROM Pessoa p "
				+ " LEFT JOIN FETCH p.listaFotos f "
				+ " WHERE p.id = :id ",Pessoa.class);
		
		lista.setParameter("id",idPessoa);
		return lista.getSingleResult();
	}

	public Pessoa obterPessoaTotalAtiva(Long idPessoa) {
		TypedQuery<Pessoa> lista = manager.createQuery(""
				+ " SELECT p "
				+ " FROM Pessoa p "
				+ " JOIN FETCH p.listaFotos f "
				+ " WHERE p.id = :id "
				+ "	AND p.ativo='S' "
				+ " AND f.ativo='S' ",Pessoa.class);
		
		lista.setParameter("id",idPessoa);
		return lista.getSingleResult();
	}

	public void editarPessoa(Pessoa pessoa) {
		pessoa.setDataAlteracao(DataUtil.obterDataAtual());	
		manager.merge(pessoa);
	}

	public List<Pessoa> pessoasPainel() {
		return findAllPessoaAtivasFotosAtivas2();
	}

	/**
	 * Listará apenas pessoas ativas que possuirem fotos ativas;
	 * @return
	 */
	private List<Pessoa> findAllPessoaAtivasFotosAtivas() {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		Join<Pessoa,Foto> join = root.join("listaFotos", JoinType.LEFT);
		
		Predicate predicados = builder.and(
				builder.equal(root.get("ativo"), "S")
				,builder.equal(join.get("ativo"), "S")
				);
		criteria.where(builder.and(predicados));
		List<Pessoa> lista = manager.createQuery(criteria).getResultList();
        return lista;
	}
	
	public List<Pessoa> findAllPessoaAtivasFotosAtivas2() {
		TypedQuery<Pessoa> lista = manager.createQuery(""
				+ " SELECT DISTINCT(p) "
				+ " FROM Pessoa p "
				+ " JOIN FETCH p.listaFotos f "
				+ " WHERE p.ativo = :ativo"
				+ " AND f.ativo = :ativof ",Pessoa.class);
		
		lista.setParameter("ativo","S");
		lista.setParameter("ativof","S");
		return lista.getResultList();
	}
	
	public List<Pessoa> findAllPessoaAtivasFotosAtivasDestaque() {
		TypedQuery<Pessoa> lista = manager.createQuery(""
				+ " SELECT DISTINCT(p) "
				+ " FROM Pessoa p "
				+ " JOIN FETCH p.listaFotos f "
				+ " WHERE p.ativo = :ativo "
				+ " AND f.ativo = :ativof "
				+ "	AND p.destaque = :destaque",Pessoa.class);
		
		lista.setParameter("ativo","S");
		lista.setParameter("ativof","S");
		lista.setParameter("destaque","S");
		return lista.getResultList();
	}

	public List<Pessoa> pessoasDestaque() {
		return findAllPessoaAtivasFotosAtivasDestaque();
	}

}
