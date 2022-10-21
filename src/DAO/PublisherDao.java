/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.Interfaces.IPublisherDao;
import database.ConectionDB;
import model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class PublisherDao implements IPublisherDao{

    Connection conexao = ConectionDB.conector();

    public PublisherDao() throws Exception {
    }

    @Override
    public void insertPublisher(String name, String url) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void editPublisher(String name, String url, int publisher_id) throws SQLException {
        String sql = "UPDATE Publishers SET name = ?, url = ? " +
                "WHERE publisher_id = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, url);

            Publisher p = getPublisherById(publisher_id);
            if(p != null){
                ps.setInt(3, p.getPublisher_id());
                ps.execute();
                System.out.println("A Editora " + name + " foi alterada!");
            }

        } catch (SQLException e){
            throw new SQLException("Erro");
        }

    }

    @Override
    public Publisher getPublisherById(int publisher_id) throws SQLException {
        String sql = "SELECT * FROM Publishers WHERE publisher_id = ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, publisher_id);

            rs = pstm.executeQuery();

            Publisher publisher = null;
            if (rs.next()) {
                String name = rs.getString("name");
                String url = rs.getString("url");
                int publisherP = rs.getInt("publisher_id");

                publisher = new Publisher(name, url, publisherP);
                publisher.setPublisher_id(rs.getInt("publisher_id"));

                System.out.println("Foi encontrado um Editora com o id " + publisher_id);
                return publisher;
            } else {
                System.out.println("Nao foi encontrado um Editora com o id " + publisher_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Publisher> getAllPublishers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePublisher(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
