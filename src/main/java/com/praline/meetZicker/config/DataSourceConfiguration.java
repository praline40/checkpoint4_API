package com.praline.meetZicker.config;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.username(System.getenv("db_meetZicker_username"));
        dataSourceBuilder.password(System.getenv("db_meetZicker_password"));
        dataSourceBuilder.url(System.getenv("db_meetZicker_url"));

        return dataSourceBuilder.build();
    }
}
