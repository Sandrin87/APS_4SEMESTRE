package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {

    public static Connection conector() throws Exception {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        
        String url;
        String password;

        //conexão vitória:
        //String url = "jdbc:mysql://localhost:3306/livraria";
        //driver = "com.mysql.jdbc.Driver";
        //password = "";
        
        //conexão sandrin
        url = "jdbc:mysql://localhost:3306/livrariadb";
        password = "Admin@1234";
        
        
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (SQLException e) {
           throw new SQLException("Sem conexao ao banco!!!");
        }
    }
}