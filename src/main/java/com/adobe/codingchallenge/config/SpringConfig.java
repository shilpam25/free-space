package com.adobe.codingchallenge.config;

import com.adobe.codingchallenge.repository.blog.BlogRepositoryDao;
import com.adobe.codingchallenge.repository.blog.BlogRepositoryDaoImpl;
import com.adobe.codingchallenge.repository.comment.CommentRepositoryDao;
import com.adobe.codingchallenge.repository.comment.CommentRepositoryDaoImpl;
import com.adobe.codingchallenge.repository.user.UserRepositoryDao;
import com.adobe.codingchallenge.repository.user.UserRepositoryDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan("com.adobe.codingchallenge.model")
public class SpringConfig {

    @Value("${spring.datasource.driverClassName}") String driverClassName;
    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;
    @Value("${spring.datasource.password}") String password;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.adobe.codingchallenge.model");
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager txManager= new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public UserRepositoryDao getUserRepositoryDao(){
        return new UserRepositoryDaoImpl();
    }

    @Bean
    public BlogRepositoryDao getBlogRepositoryDao(){
        return new BlogRepositoryDaoImpl();
    }

    @Bean
    public CommentRepositoryDao getCommentRepositoryDao(){
        return new CommentRepositoryDaoImpl();
    }

}
