/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import model.Book;

/**
 *
 * @author gabri
 */
public interface IBookDao {
    
    void insertBook(String title, String isbn, int publisherId, double price);
    
    void editBook(String title, double price, int publisherId, String isbn);
    
    Book getBookById(int id);
    
    Book getBooksByTitle(String title);
    
    void deleteBook(int id);
}
