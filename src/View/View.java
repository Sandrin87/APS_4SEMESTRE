/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package View;

import java.awt.event.ActionListener;
import java.util.List;
import model.Author;
import model.Book;
import model.Publisher;

/**
 *
 * @author gabri
 */
public interface View {
    public Author getAddAuthor();
    
    public Author getAuthorSelected();
    
    public Author getListAuthors();
    
    public Boolean getEditAuthors();
    
    public Boolean getDeleteAuthor();
    
    public void addActionListnerAuthor(ActionListener al);
    
    public void editActionListnerAuthor(ActionListener al);
    
    public void excludeActionListnerAuthor(ActionListener al);
    
    public void addExistentAuthorsToListActionListner(ActionListener al);
    
    public Book getAddBook(List<Author> authors, Publisher publisher);
    
    public String getListBooks();
    
    public void getEditBooks();
    
    public void getDeleteBook();
    
    public void addActionListnerBook(ActionListener al);
    
    public void editActionListnerBook(ActionListener al);
    
    public void excludeActionListnerBook(ActionListener al);
    
    public Publisher getAddPublisher();
    
    public String getListPublishers();
    
    public Publisher getPublisherSelected();
    
    public void getEditPublishers();
    
    public void getDeletePublishers();
    
    public void addActionListnerPublisher(ActionListener al);
    
    public void editActionListnerPublisher(ActionListener al);
    
    public void excludeActionListnerPublisher(ActionListener al);
}
