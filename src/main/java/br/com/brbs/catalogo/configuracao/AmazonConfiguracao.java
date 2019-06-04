package br.com.brbs.catalogo.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfiguracao {

	/** Chave acesso do projeto ElasDemais */
	private static final String ACCESS_KEY = "AKIAZI33JRPA247SGVFU";
	
											  
												                                          
	/** Valor da chave do projeto ElasDemais */				
	private static final String SECRET_KEY = "ETw14834Fpy4rLxbJ7YDPxn4Acld4wE05G0PyJgw";
	
	/**
	 * Leste dos EUA (Ohio)
	 * apigateway.us-east-2.amazonaws.com
	*/
	//private static final String REGION = "us-east-2";
	private static final String REGION = Regions.US_EAST_2.getName();
	
	@Bean
	public AWSCredentials basicAWSCredentials() {
	    return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
	}
	
	@Bean
	public AmazonS3 amazonS3() { 
		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);
		
	    return AmazonS3ClientBuilder
	    		.standard()	    		
	            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials()))
	            .withRegion(REGION)
	            .build();
	}
}
