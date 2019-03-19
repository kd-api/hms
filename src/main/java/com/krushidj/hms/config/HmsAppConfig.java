package com.krushidj.hms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "hmsAppEntityManagerFactory",
        transactionManagerRef = "hmsAppTransactionManager",
        basePackages = {"com.krushidj.hms.modules.owner.entity", "com.krushidj.hms.modules.owner.dao"}
)
@PropertySource("classpath:application.properties")

public class HmsAppConfig {

    private Logger LOG = LoggerFactory.getLogger(HmsAppConfig.class);


    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Primary
    @Bean(name = "hmsAppDataSource", destroyMethod = "")
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource hmsAppDataSource() {

        //try {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
        //---
//            JndiTemplate jndi = new JndiTemplate();
//            dataSource = jndi.lookup(jndiName, DataSource.class);
//        } catch (NamingException e) {
//            LOG.error("NamingException for {}", jndiName, e);
//        }
        // return dataSource;
    }

    @Primary
    @Bean(name = "hmsAppEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("hmsAppDataSource") DataSource dataSource
    ) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
        return builder
                .dataSource(dataSource)
                .packages("com.krushidj.hms.modules.owner.entity", "com.krushidj.hms.modules.owner.dao")
                .persistenceUnit("hmsAppUnit")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "hmsAppEntityManager")
    public EntityManager
    buildEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("hmsAppEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return entityManagerFactory.createEntityManager();

    }

    @Primary
    @Bean
    public PlatformTransactionManager racingAppTransactionManager(
            @Qualifier("hmsAppEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);

    }
}