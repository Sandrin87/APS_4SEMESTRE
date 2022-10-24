package DAO;

import DAO.Interfaces.IUserDao;
import database.ConectionDB;

import javax.swing.*;
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
                JOptionPane.showMessageDialog(null, "Usuario Logado");
                return "Sucesso";
            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido");
                return "falha";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
 return "null";
    }
}
