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
    public void editBook(String title, double price,int publisherId, String isbn) {

        String sql = "UPDATE Books SET title = ?, price = ?, publisher_id = ? " +
                "WHERE isbn = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, publisherId);

            ps.setString(4, isbn);
            ps.execute();

            System.out.println("livro editado");

        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public Book getBookById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Book> getAllBooks() {

        String sql = "SELECT * FROM Books";

        List<Book> books = new ArrayList<>();

        try {
            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String isbn = rs.getString("isbn");
                double price = rs.getDouble("price");
                int publishers = rs.getInt("publisher_id");

                Book book = new Book(title, isbn, price, publishers);
                book.setPublisher_id(rs.getInt("publisher_id"));
                books.add(book);

            }

            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
