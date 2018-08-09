/**
 * 
 */
package br.com.brbs.catalogo.configuracao;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author claudiouft@gmail.com
 *
 */
@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        /**
         * MYSQL - INICIO
         */
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//
//        factoryBean.setDataSource(dataSource);
//
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "update");
        /**
         * MYSQL - FIM
         */

        /**
         * POSTGRES - INICIO
         */
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();        
//        dataSource.setUrl("jdbc:postgresql://instanciacatalogodb.ccq6fbjxrb4c.us-east-2.rds.amazonaws.com:5432/dbcatalogo");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("12345678");
//        dataSource.setDriverClassName("org.postgresql.Driver");
        
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();        
	    dataSource.setUrl("jdbc:postgresql://myinstanciacatalogo.c2vwp9gmpgu8.us-east-1.rds.amazonaws.com:5432/dbcatalogo");
	    //dataSource.setUrl("jdbc:postgresql://localhost:5432/dbcatalogo");
	    dataSource.setUsername("postgres");
	    dataSource.setPassword("12345678");
	    dataSource.setDriverClassName("org.postgresql.Driver");

        factoryBean.setDataSource(dataSource);

        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        /**
         * POSTGRES - FIM
         */
        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("br.com.brbs.catalogo.modelo.entidade");

        return factoryBean;
	}
        
}
