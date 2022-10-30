package DAO;

import DAO.Interfaces.IUserDao;
import database.ConectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao implements IUserDao {
    Connection conexao = ConectionDB.conector();

    public UserDao() throws Exception {
    }

    @Override
    public String logar(String name, String password) {

        String sql = "SELECT * FROM Usuario WHERE name=? AND password=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return "Sucesso";
            }
        } catch (Exception e) {
            e.getMessage();

        }
     return "null";
    }
}
