package com.tcs.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{

    Logger logger = LogManager.getLogger(DbConnection.class);

    private Connection dbconnection;

    public Connection getDbconnection()
    {
        return dbconnection;
    }

    public DbConnection()
    {
        //System.out.println("Connection is established");

        String url = "jdbc:postgresql://localhost:5432/cbt";
        try
        {
            dbconnection = DriverManager.getConnection(url,"postgres","Dedsec@7");
            //System.out.println("Connection is established");
            logger.info("Connection Successfully Established");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
