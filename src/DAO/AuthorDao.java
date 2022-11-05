/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.Interfaces.IAuthorDao;
import database.ConectionDB;
import model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class AuthorDao implements IAuthorDao {

    Connection conexao = ConectionDB.conector();

    public AuthorDao() throws Exception {
    }

    @Override
    public void insertAuthor(String name, String fName) { //FEITO
        String sql = "INSERT INTO Authors (name, fName) VALUES (?, ?)";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, name);
                ps.setString(2, fName);

                ps.execute();

                System.out.println("Autor(a) " + name + " " + fName + " foi incluído com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }    
    
    }

    @Override
    public void editAuthor(String name, String fName, int id) throws Exception {
        String sql = "UPDATE Authors set name = ?, fname = ?" +
                "WHERE author_id = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, fName);

            Author author = getAuthorById(id);
            if(author != null){
                ps.setInt(3, author.getAuthor_id());
                ps.execute();
                System.out.println("O autor com o id " + id + " foi alterado!");
            }

        }catch (Exception e){
            throw new Exception("ERRO");
        }
    }

    @Override
    public Author getAuthorById(int id) {
        String sql = "SELECT * FROM Authors WHERE author_id = ?";

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            Author author = null;
            if(rs.next()){
               int author_id = rs.getInt("author_id");
               String name = rs.getString("name");
               String firstName = rs.getString("fname");

               author = new Author(author_id, name, firstName);
               System.out.println("foi encontrado o autor com o nome: " + name);

               return author;

            } else {
                System.out.println("Não foi encontrado um autor com o id: " + id);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Author> getAllAuthors() throws Exception {
        String sql = "SELECT * FROM Authors";

        List<Author> authorsList = new ArrayList<>();

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
                int author_id = rs.getInt("author_id");
                String name = rs.getString("name");
                String firstName = rs.getString("fname");

                Author author = new Author(author_id, name, firstName);
                authorsList.add(author);
            }

            return authorsList;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public List<Author> getByFilter(String fName, String name) {
        
        List<Author> authors = new ArrayList<>();
        
        String sql = "SELECT * FROM Authors WHERE ";
        String nameFilter = "";
        String fNameFilter = "";
        
        try {
            if(name != null || !name.equals(""))
                nameFilter = " name LIKE ? ";
            
            if(fName != null || !fName.equals(""))
            {
                if(nameFilter.equals(""))
                    fNameFilter = " fname LIKE ?";
                
                fNameFilter = " AND fname LIKE ?";
            }
            
            sql += nameFilter + fNameFilter;
            
            PreparedStatement pstm = conexao.prepareStatement(sql);

            pstm.setString(1, "%"+name+"%");

            if(nameFilter.equals(""))
                pstm.setString(1, "%"+fName+"%");

            pstm.setString(2, "%"+fName+"%");

            ResultSet rs = pstm.executeQuery();

            while(rs.next()){
               int author_id = rs.getInt("author_id");
               String names = rs.getString("name");
               String firstName = rs.getString("fname");

               authors.add(new Author(author_id, names, firstName));
               System.out.println("foi encontrado o autor com o nome: " + names + " " + firstName);
               
            } 
            return authors;

        } catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
  
    @Override
    public void deleteAuthor(int author_id) {
        String sql = "DELETE FROM Authors WHERE author_id = ?";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, author_id);
                ps.execute();

                System.out.println("Autor: " + author_id + " foi excluído com sucesso");
            } catch (Exception e) {
                e.printStackTrace();
            }    
    }
}