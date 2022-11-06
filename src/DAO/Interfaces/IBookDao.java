/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import model.Book;

import java.util.List;
import model.Author;

/**
 *
 * @author gabri
 */
public interface IBookDao {
    
    void insertBook(String title, String isbn, int publisherId, double price,  List<Author> authors);
    
    void editBook(String title, double price, int publisherId, String isbn);
    
    Book getBookByIsbn(String isbn);
    
    Book getBooksByTitle(String title);

    List<Book> getAllBooks() throws Exception;
    
    void deleteBook(String isbn);
    
    void deleteRelationBooksAuthors(String isbn);
    
    void insertRelationBookAuthors(String isbn, List<Author> authors);
}
