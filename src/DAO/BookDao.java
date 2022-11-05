/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.Interfaces.IBookDao;
import database.ConectionDB;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class BookDao implements IBookDao{
    Connection conexao = ConectionDB.conector();

    public BookDao() throws Exception {
    }

    @Override
    public void insertBook(String title, String isbn, int publisherId, double price) {

       String sql = "INSERT INTO Books (title, isbn, publisher_id, price) VALUES (?, ?, ?, ?) ";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, isbn);
            ps.setInt(3, publisherId);
            ps.setDouble(4, price);

            ps.execute();

            System.out.println(title + " Livro inserido com sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editBook(String title, double price, String isbn) {

        String sql = "UPDATE Books SET title = ?, price = ? " +
                "WHERE isbn = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDouble(2, price);

            Book book = getBookByIsbn(isbn);
            if(book != null){
                ps.setString(3, book.getIsbn());
                ps.execute();
                System.out.println("livro editado");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        String sql = "SELECT * FROM Books WHERE isbn = ?";

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, isbn);

            ResultSet rs = pstm.executeQuery();

            Book book = null;
            if(rs.next()){
                String title = rs.getString("title");
                String bookNumber = rs.getString("isbn");
                Double price = rs.getDouble("price");
                int publisher_id = rs.getInt("publisher_id");

                book = new Book(title, bookNumber, price, publisher_id);
                System.out.println("foi encontrado o livro com o isbn: " + isbn);

                return book;

            } else {
                System.out.println("Não foi encontrado um livro com o isbn: " + isbn);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getBooksByTitle(String titles) {
        
        if(titles == null || titles.equals("") || titles.trim().equals(""))
        {
            try {
                return this.getAllBooks();
            } catch (Exception ex) {
                System.out.println("Erro interno, não foi possivel carregar nenhuma editora");
            }
        }
        
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Books WHERE title LIKE ?";

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, "%"+titles+"%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                double price = rs.getDouble("price");
                int publishers = rs.getInt("publisher_id");

                Book book = new Book(title, isbn, price, publishers);
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        String sql = "SELECT * FROM Books";

        List<Book> bookList = new ArrayList<>();

        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                
                Double price = rs.getDouble("price");
                int publisherId = rs.getInt("publisher_id");

                Book book = new Book(title, isbn, price, publisherId);
                bookList.add(book);
            }

            return bookList;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    

    @Override
    public void deleteBook(String isbn) {
        String sql = "DELETE FROM Books WHERE isbn = ?";

                try {
                    PreparedStatement ps = conexao.prepareStatement(sql);

                    ps.setString(1, isbn);
                    ps.execute();

                    System.out.println("Livro: " + isbn + " foi excluído com sucesso");
                } catch (Exception e) {
                    e.printStackTrace();
                }    
    }
    
}