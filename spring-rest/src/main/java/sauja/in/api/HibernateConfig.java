package sauja.in.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:hibernate.properties")
public class HibernateConfig {

    @Autowired
    private Environment environment;
    @Bean
    public LocalContainerEntityManagerFactoryBean emf()
    {
        LocalContainerEntityManagerFactoryBean entityManager=new LocalContainerEntityManagerFactoryBean();
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setDataSource(getDataSource());
        entityManager.setPackagesToScan("sauja.in.api.entities");
        entityManager.setJpaProperties(getJPAProperties());
        return entityManager;
    }
    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource dataSource =new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory)
    {
        return new JpaTransactionManager(entityManagerFactory);
    }

    public Properties getJPAProperties()
    {
        Properties properties=new Properties();
        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql","false"));
        properties.setProperty("hibernate.format_sql",environment.getProperty("hibernate.format_sql","false"));
        return properties;
    }
}
