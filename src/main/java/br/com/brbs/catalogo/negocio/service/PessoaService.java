/**
 * 
 */
package br.com.brbs.catalogo.negocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.brbs.catalogo.modelo.entidade.Foto;
import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.modelo.enums.TipoFotoEnum;
import br.com.brbs.catalogo.negocio.persistencia.FotoDAO;
import br.com.brbs.catalogo.negocio.persistencia.PessoaDAO;
import br.com.brbs.catalogo.negocio.util.TelefoneUtil;

/**
 * @author claudiouft@gmail.com
 *
 */
@Service
public class PessoaService {

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private FotoDAO fotoDAO;
	
	//@Autowired
	//private FileSave fileSave;
	
	@Autowired
	private FileSaveAmazon fileSaveAmazon; 
	
	public void gravar(MultipartFile fotoPrincipal, MultipartFile fotoDestaque, Pessoa pessoa) {
		retirarMascara(pessoa);
		Pessoa pessoaRetorno = pessoaDAO.gravarRetorno(pessoa);
		String localFotoPrincipal = fileSaveAmazon.salvarImagem(fotoPrincipal, pessoaRetorno,TipoFotoEnum.PRINCIPAL);
		String localFotoDestaque = fileSaveAmazon.salvarImagem(fotoDestaque, pessoaRetorno,TipoFotoEnum.DESTAQUE);
		pessoaRetorno.setLocalFotoPrincipal(localFotoPrincipal);
		pessoaRetorno.setLocalFotoDestaque(localFotoDestaque);		
		pessoaDAO.alterar(pessoaRetorno);
		
	}	

	public List<Pessoa> pesquisarPessoa(Pessoa filtro) {
		List<Pessoa> lista =  pessoaDAO.pesquisarPessoaFiltro(filtro);
		return lista;
	}

	public Pessoa obterPessoa(Long idPessoa) {
		return pessoaDAO.obterPessoa(idPessoa);
	}

	public void editarPessoa(MultipartFile filePrincipal,MultipartFile fileDestaque, Pessoa pessoa) {
		
		Pessoa pessoaBanco = obterPessoa(pessoa.getId());
		if(houveAlteracaoNaFotoPrincipal(filePrincipal)) {
			
			String localFoto = fileSaveAmazon.salvarImagem(filePrincipal, pessoa,TipoFotoEnum.PRINCIPAL);
			pessoa.setLocalFotoPrincipal(localFoto);
		}else {
			pessoa.setLocalFotoPrincipal(pessoaBanco.getLocalFotoPrincipal());
		}
		
		if(houveAlteracaoNaFotoPrincipal(fileDestaque)) {
			
			String localFoto = fileSaveAmazon.salvarImagem(fileDestaque, pessoa,TipoFotoEnum.DESTAQUE);
			pessoa.setLocalFotoDestaque(localFoto);
		}else {
			pessoa.setLocalFotoDestaque(pessoaBanco.getLocalFotoDestaque());
		}

		retirarMascara(pessoa);
		pessoaDAO.editarPessoa(pessoa);
		
	}

	private void retirarMascara(Pessoa pessoa) {
		if(pessoa.getTelefoneFormatado()!=null) {
			pessoa.setTelefone(TelefoneUtil.retirarMascaraTelefone(pessoa.getTelefoneFormatado()));
		}
		
	}
	private Boolean houveAlteracaoNaFotoPrincipal(MultipartFile file) {
		if(file==null || file.getSize()==0) {
			return false;
		}
		return true;
	}

	public void gravarFotos(List<MultipartFile> listaFotos, Pessoa pessoa) {
		String localFoto = "";
		Pessoa pessoaTemp = obterPessoa(pessoa.getId());
		for(MultipartFile foto:listaFotos) {
			localFoto = fileSaveAmazon.salvarImagem(foto, pessoaTemp,TipoFotoEnum.SECUNDARIO);
			Foto fotoTemp = prepararFoto(pessoaTemp,localFoto);
			fotoDAO.gravar(fotoTemp);
		}
		
	}

	private Foto prepararFoto(Pessoa pessoaTemp, String localFoto) {
		Foto foto = new Foto();
		foto.setAtivo("S");
		foto.setLocalFoto(localFoto);
		foto.setPessoa(pessoaTemp);
		return foto;
	}

	public void desativarFotoPessoa(Long idFoto) {
		fotoDAO.desativarFoto(idFoto);
	}

	public Pessoa obterPessoaAtivaFotoAtiva(Long idPessoa) {
		//return pessoaDAO.obterPessoaTotalAtiva(idPessoa);
		Pessoa pessoa = pessoaDAO.obterPessoaAtiva(idPessoa);
		if(pessoa!=null
				&& pessoa.getId()!=null) {
			pessoa.setListaFotos(fotoDAO.obterFotosPessoa(pessoa.getId()));
		}
		return pessoa;
	}
}
