/**
 * 
 */
package br.com.brbs.catalogo.apresentacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author claudio.barbosa
 *
 */
@Controller
public class AdministracaoController {
	
	@RequestMapping("/adm")
	public String prepararCadastro() {
		return "/administracao";
	}
}
