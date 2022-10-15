/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import java.util.Map;
import model.Book;

/**
 *
 * @author gabri
 */
public interface IBookDao {
    
    void insertBook(String title, String isbn, double price, int publisherId);
    
    void editBook(String title, double price, int publisherId);
    
    Book getBookById(int id);
    
    Map<String, Book> getAllBooks();
    
    void deleteBook(int id);
}
