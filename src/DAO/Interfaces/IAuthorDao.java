/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import java.util.List;
import java.util.Map;
import model.Author;

/**
 *
 * @author gabri
 */
public interface IAuthorDao {
    
    void insertAuthor(String name, String fName);
    
    void editAuthor(String name, String fName);
    
    Author getAuthorById(int id);
    
    List<Author> getAllAuthors();
    
    void deleteBook(int id);
}
