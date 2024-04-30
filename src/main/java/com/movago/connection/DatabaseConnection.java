package com.movago.connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arca
 */
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConnection {

    private static final HikariDataSource DATASOURCE;
    
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mysql");
        config.setUsername("root");
        config.setPassword("rootroot");
        config.setMaximumPoolSize(10);
        
        DATASOURCE = new HikariDataSource(config);
    }
    
    public static HikariDataSource getDataSource(){
        return DATASOURCE;
    }
}
    