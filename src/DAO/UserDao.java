package DAO;

import DAO.Interfaces.IUserDao;
import database.ConectionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao implements IUserDao {
    Connection conexao = ConectionDB.conector();
    @Override
    public void logar(String name, String password) {

        String sql = "SELECT * FROM Usuario WHERE name=? AND password=?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(4);
                if(perfil.equals("admin")){
                    JOptionPane.showMessageDialog(null, "Aqui telas administradores");
                } else {
                    JOptionPane.showMessageDialog(null, "Aqui telas Usuarios");
                }

                JOptionPane.showMessageDialog(null, "Usuario Logado");
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
}
