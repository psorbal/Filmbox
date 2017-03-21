package pl.filmbox.configurations;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("pl.filmbox.repositories")
@EnableTransactionManagement
public class PersistenceJPAConfig implements EnvironmentAware {

    private Environment env;

    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setPackagesToScan("pl.filmbox.models");
        entityManager.setDataSource(getDataSource());
        entityManager.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManager.setJpaProperties(getProperties());
        return entityManager;
    }

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("database.driver"));
        dataSource.setJdbcUrl(env.getProperty("database.url"));
        dataSource.setUser(env.getProperty("database.user"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(env.getProperty("hibernate.database", Database.class));
        jpaVendorAdapter.setDatabasePlatform(env.getProperty("hibernate.dialect"));
        jpaVendorAdapter.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));
        jpaVendorAdapter.setGenerateDdl(env.getProperty("hibernate.generate_ddl", Boolean.class));
        return jpaVendorAdapter;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}

