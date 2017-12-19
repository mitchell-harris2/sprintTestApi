package config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"repositories"})
@EntityScan(basePackages = {"entities"})
class DatabaseConfig {

    @Bean
    DataSource dataSource(Environment env) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getRequiredProperty("spring.datasource.jdbc-url"));
        dataSource.setUsername(env.getRequiredProperty("spring.datasource.password"));
        dataSource.setPassword(env.getRequiredProperty("spring.datasource.jdbc-url"));
        dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));

        return dataSource;
    }
}