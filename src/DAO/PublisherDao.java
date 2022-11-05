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
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO Publishers (name, url) VALUES (?, ?)";

          try {

              PreparedStatement ps = conexao.prepareStatement(sql);
              ps.setString (1, name);
              ps.setString (2, url);

              ps.execute();

              System.out.println ("Editora " + name + " foi incluída com sucesso!");

          }catch (Exception e){

           e.printStackTrace();

          }

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

                publisher = new Publisher(publisherP, name, url);
                publisher.setPublisher_id(rs.getInt("publisher_id"));

                System.out.println("Foi encontrado uma Editora com o id " + publisher_id);
                return publisher;
            } else {
                System.out.println("Nao foi encontrado uma Editora com o id " + publisher_id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Publisher> getAllPublishers() throws Exception {
        String sql = "SELECT * FROM Publishers";

        List<Publisher> publisherList = new ArrayList<>();

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                int publisherId = rs.getInt("publisher_id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                Publisher publisher = new Publisher(publisherId, name, url);
                publisherList.add(publisher);
            }

            return publisherList;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Publisher> getPublisherByName(String name) {
        
        if(name == null || name.equals("") || name.trim().equals(""))
        {
            try {
                return this.getAllPublishers();
            } catch (Exception ex) {
                System.out.println("Erro interno, não foi possivel carregar nenhuma editora");
            }
        }
        
        List<Publisher> publishers = new ArrayList<>();
        String sql = "SELECT * FROM Publishers WHERE name LIKE ?";

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, "%"+name+"%");

            rs = pstm.executeQuery();

            Publisher publisher = null;
            while (rs.next()) {
                String names = rs.getString("name");
                String url = rs.getString("url");
                int publisherP = rs.getInt("publisher_id");
                
                publishers.add(new Publisher(publisherP, names, url));

                System.out.println("Foi encontrado uma Editora com o nome " + names);
            } 
            return publishers;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
        

    }
    
    @Override
    public void deletePublisher(int publisher_id) { //Testar essa parte
        String sql = "DELETE FROM Publishers WHERE publisher_id = ?";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, publisher_id);
                ps.execute();

                System.out.println("Editora: " + publisher_id + " foi excluída com sucesso!");
            } catch (Exception e) {
                    e.printStackTrace();
            }   
   }
    
}