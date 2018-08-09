package br.com.brbs.catalogo.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfiguracao {

	private static final String ACCESS_KEY = "AKIAJ2UXYP3J7SHAFVCQ";
	private static final String SECRET_KEY = "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";
	private static final String REGION = "us-east-1";
	
	@Bean
	public BasicAWSCredentials basicAWSCredentials() {
	    return new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
	}
	
	@Bean
	public AmazonS3 amazonS3() { 
	    return AmazonS3ClientBuilder.standard().withRegion(REGION)
	            .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).build();
	}
}
