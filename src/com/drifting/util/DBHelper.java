package com.drifting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/anymall?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    private DBHelper(){

    }
    static {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            synchronized (DBHelper.class){
                try {
                    connection = DriverManager.getConnection(URL,USER,PASSWORD);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }

}
