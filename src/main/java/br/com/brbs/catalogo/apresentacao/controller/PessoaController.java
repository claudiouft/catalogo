package br.com.brbs.catalogo.apresentacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.negocio.persistencia.PessoaDAO;
import br.com.brbs.catalogo.negocio.persistencia.UfDAO;
import br.com.brbs.catalogo.negocio.service.PessoaService;
import br.com.brbs.catalogo.negocio.util.Constantes;

/**
 * 
 * @author @author claudiouft@gmail.com
 *
 */
@Controller
public class PessoaController {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private UfDAO ufDao;

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping("/pessoas/prepararCadastro")
	public String prepararCadastro() {
		return "/pessoas/cadastro";
	}

	@RequestMapping("/pessoas/consulta")
	public ModelAndView listar() {
		List<Pessoa> lista = pessoaDAO.findAllPessoa();
		ModelAndView view = new ModelAndView("/pessoas/lista");
		view.addObject("pessoas", lista);
		return view;
	}

	@RequestMapping("/pessoas/cadastro")
	public String gravar(@RequestParam("filep") MultipartFile fotoPrincipal,
			@RequestParam("filed") MultipartFile fotoDestaque, 
			Pessoa pessoa) {		
		pessoaService.gravar(fotoPrincipal,fotoDestaque, pessoa);
		return "/pessoas/ok";
	}

	@RequestMapping("/pessoas/pesquisas")
	public String pesquisaInicio() {
		return "/pessoas/pesquisa";
	}

	@RequestMapping("/pessoas/pesquisa")
	public ModelAndView pesquisa(Pessoa filtroPessoa) {
		List<Pessoa> lista = pessoaService.pesquisarPessoa(filtroPessoa);
		ModelAndView view = new ModelAndView("pessoas/pesquisa");
		view.addObject("pessoas", lista);
		return view;
	}
	
	@RequestMapping("/pessoas/prepararAlterar")
	public ModelAndView prepararAlterar(@RequestParam Long idPessoa) {
		
		Pessoa pessoaTemp = pessoaService.obterPessoa(idPessoa);
		ModelAndView view = new ModelAndView("pessoas/editar");
		view.addObject("ufs", ufDao.allUf());
		view.addObject("pessoa", pessoaTemp);
		return view;
	}
	
	
	@RequestMapping("/pessoas/editar")
	public String editar(@RequestParam("filep") MultipartFile fotoPrincipal,
			@RequestParam("filed") MultipartFile fotoDestaque,
			Pessoa pessoa) {
		pessoaService.editarPessoa(fotoPrincipal,fotoDestaque,pessoa);
		return "/pessoas/ok";
	}
	
	public ModelAndView obterPessoaDirecionar(Long idPessoa, String direcao) {
		//Pessoa pessoaTemp = pessoaService.obterPessoa(idPessoa);
		Pessoa pessoaTemp = pessoaService.obterPessoaAtivaFotoAtiva(idPessoa);
		ModelAndView view = new ModelAndView(direcao);
		view.addObject("pessoa", pessoaTemp);
		return view;
	}
	

	@RequestMapping("/pessoas/prepararAdicionarFoto")
	public ModelAndView prepararAdicionarFoto(@RequestParam Long idPessoa) {
		Pessoa pessoaTemp = pessoaService.obterPessoaAtivaFotoAtiva(idPessoa);
		ModelAndView view = new ModelAndView("pessoas/adicionar_fotos");
		view.addObject("pessoa", pessoaTemp);
		return view;
	}
	
	@RequestMapping("/pessoas/adicionar_fotos")
	public String fotos(@RequestParam("file") List<MultipartFile> files, Pessoa pessoa) {
		pessoaService.gravarFotos(files,pessoa);
		return "/pessoas/ok";
	}
	
	@RequestMapping("/pessoas/prepararPainel")
	public ModelAndView prepararPainel() {
		List<Pessoa> lista = pessoaDAO.pessoasPainel();
		ModelAndView view = new ModelAndView("/pessoas/painel");
		view.addObject("pessoas", lista);
		view.addObject("titulo", Constantes.TITULO_PROJETO);
		return view;
	}
	
	@RequestMapping("/pessoas/desativarFoto")
	public String desativarFoto(@RequestParam Long idFoto) {
		pessoaService.desativarFotoPessoa(idFoto);
		return "/pessoas/ok";
	}
	
	@RequestMapping("/pessoas/prepararPerfil")
	public ModelAndView prepararPerfil(@RequestParam Long idPessoa) {
		return obterPessoaDirecionar(idPessoa,"pessoas/perfil");
	}
	
	
	
}
