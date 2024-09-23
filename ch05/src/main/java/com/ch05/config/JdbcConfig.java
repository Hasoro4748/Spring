package com.ch05.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://15.164.213.166:3306/studydb");
        dataSource.setUsername("root");
        dataSource.setPassword("Hasorocom7.");

        dataSource.setMaxTotal(13); // 최대 연결 커넥션 갯수
        dataSource.setMaxIdle(13); // 최대 유휴 커넥션 갯수

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
