package com.anthropocene.changement.conf;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {
        @Bean
        public DataSource getDataSource() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/cloud");
            dataSourceBuilder.username("root");
            dataSourceBuilder.password("");
            return dataSourceBuilder.build();
        }
}
