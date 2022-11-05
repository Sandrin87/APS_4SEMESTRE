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
        url = "jdbc:mysql://localhost:3306/livraria";
        driver = "com.mysql.jdbc.Driver";
        password = "";
        
        //conexão sandrin
<<<<<<< HEAD
//        url = "jdbc:mysql://localhost:3306/livrariadb";
//        password = "Admin@1234";
=======
        //url = "jdbc:mysql://localhost:3306/livrariadb";
        //password = "Admin@1234";
>>>>>>> parent of f988021 (refatorando e adicionando edit e busca de entidades)
        
        //conexão bia
        url = "jdbc:mysql://localhost:3306/Livraria";
        password = "";
        
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (SQLException e) {
           throw new SQLException("Sem conexao ao banco!!!");
        }
    }
}