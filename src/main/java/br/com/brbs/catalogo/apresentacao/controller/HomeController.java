/**
 * 
 */
package br.com.brbs.catalogo.apresentacao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.negocio.persistencia.PessoaDAO;

/**
 * @author claudiouft@gmail.com
 *
 */
@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@RequestMapping("/")
	public ModelAndView index() {
		
		ModelAndView view = new ModelAndView("index");
		try {
			List<Pessoa> lista = pessoaDAO.pessoasPainel();		
			view.addObject("pessoas", lista);
			
			List<Pessoa> listaDestaque = pessoaDAO.pessoasDestaque();
			view.addObject("pessoasd", listaDestaque);
		} catch (Exception e) {
			
			LOG.info("Problema na consulta inicial:", e);
			return new ModelAndView("erro");
		}
		
		return view;
	}
	
	
	@RequestMapping("/t2")
	public ModelAndView index2() {
		List<Pessoa> lista = null;	
		List<Pessoa> listaDestaque = null;
		ModelAndView view = new ModelAndView("index2");
		try {
			lista = pessoaDAO.pessoasPainel();		
			view.addObject("pessoas", lista);
			
			listaDestaque = pessoaDAO.pessoasDestaque();
			view.addObject("pessoasd", listaDestaque);
		} catch (Exception e) {
			
			LOG.info("Problema na consulta inicial:", e);
			return new ModelAndView("erro");
		}
		
		if(listaDestaque!=null) {
			for(Pessoa pessoa:listaDestaque) {
				System.out.println(pessoa.getLocalFotoDestaque());
			}
		}
		return view;
	}
}
