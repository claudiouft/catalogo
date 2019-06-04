/**
 * 
 */
package br.com.brbs.catalogo.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.brbs.catalogo.apresentacao.controller.AdministracaoController;
import br.com.brbs.catalogo.apresentacao.controller.HomeController;
import br.com.brbs.catalogo.modelo.entidade.Foto;
import br.com.brbs.catalogo.negocio.persistencia.PessoaDAO;
import br.com.brbs.catalogo.negocio.service.FileSaveAmazon;
import br.com.brbs.catalogo.negocio.service.PessoaService;
import br.com.brbs.catalogo.negocio.util.Constantes;

/**
 * @author claudiouft@gmail.com
 *
 */
@EnableWebMvc
@ComponentScan(basePackageClasses = { 
		HomeController.class, 
		AdministracaoController.class,
		PessoaDAO.class,
		PessoaService.class,
		Foto.class,
		AmazonConfiguracao.class,
		FileSaveAmazon.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

//	@Bean
//	public MultipartResolver multipartResolver() {
//		return new StandardServletMultipartResolver();
//	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(2000000);
	    return multipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler(Constantes.LOCAL_IMAGEM_CONFIGURACAO_HANDLER)
	            .addResourceLocations(Constantes.LOCAL_IMAGEM_CONFIGURACAO_LOCATION);	    
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
