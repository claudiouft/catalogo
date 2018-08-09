package br.com.brbs.catalogo.negocio.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.modelo.enums.TipoFotoEnum;
import br.com.brbs.catalogo.negocio.util.Constantes;

@Component
public class FileSave {

	
	public String salvarImagem(MultipartFile multipartFile, Pessoa pessoa,TipoFotoEnum tipoEnum) {
		String nomeArquivo = pessoa.getId()+"_"+tipoEnum.getValor()+"_"+ multipartFile.getOriginalFilename();
		String localArquivo = Constantes.LOCAL_IMAGEM+"\\" + nomeArquivo;
		File file = new File(localArquivo);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeArquivo;
	}
}
