/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.Interfaces;

import model.Author;

import java.util.List;

/**
 *
 * @author gabri
 */
public interface IAuthorDao {
    
    void insertAuthor(String name, String fName);
    
    void editAuthor(String name, String fName, int id) throws Exception;
    
    Author getAuthorById(int id);
    
    List<Author> getAllAuthors() throws Exception;
    
    void deleteBook(int id);
}
