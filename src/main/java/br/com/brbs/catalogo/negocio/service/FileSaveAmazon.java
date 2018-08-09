package br.com.brbs.catalogo.negocio.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.brbs.catalogo.modelo.entidade.Pessoa;
import br.com.brbs.catalogo.modelo.enums.TipoFotoEnum;

@Service
public class FileSaveAmazon {

	@Autowired
	private AmazonS3 amazonS3;
	 
	private static final String BUCKET = "catalogo100fotospessoas";
	
	public String salvarImagem(MultipartFile multipartFile,Pessoa pessoa,TipoFotoEnum tipoEnum) {
        
		String nomeArquivo = pessoa.getId()+"_"+tipoEnum.getValor()+"_"+ multipartFile.getOriginalFilename();
		
		try {
        	
            amazonS3.putObject(new PutObjectRequest(BUCKET, nomeArquivo, multipartFile.getInputStream(),null)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

            return "http://s3.amazonaws.com/"+BUCKET+"/"+nomeArquivo;

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
