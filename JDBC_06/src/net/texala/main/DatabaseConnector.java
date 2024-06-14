package net.texala.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    private static final String CONFIG_FILE = "config.txt";

    public Connection connect() throws Exception {
        String[] dbConfig = readConfigFile(CONFIG_FILE);
        String url = dbConfig[0];
        String username = dbConfig[1];
        String password = dbConfig[2];
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    private String[] readConfigFile(String fileName) throws Exception {
        String[] config = new String[3];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            config[0] = br.readLine().trim(); 
            config[1] = br.readLine().trim();  
            config[2] = br.readLine().trim();  
        }
        return config;
    }
}

