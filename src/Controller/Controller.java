/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IBookDao;
import DAO.Interfaces.IPublisherDao;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Author;
import model.Book;
import model.Publisher;

/**
 *
 * @author gabri
 */
public class Controller {
    IAuthorDao authorDao;
    IBookDao bookDao;
    IPublisherDao publisherDao;
    
    View view;
    
    List<Author> authors = new ArrayList<>();
    
    public Controller(IAuthorDao _authorDao, IBookDao _bookDao, IPublisherDao _publisherDao, View _view){
        this.authorDao = _authorDao;
        this.bookDao = _bookDao;
        this.publisherDao = _publisherDao;
        this.view = _view;
    }
    
    public void init() throws Exception{
        view.initVisualComponents(bookDao.getAllBooks(), publisherDao.getAllPublishers(), authorDao.getAllAuthors());
        
        view.addActionListnerAuthor(new ActionInsertAuthor());
        view.editActionListnerAuthor(new ActionEditAuthor());
        view.excludeActionListnerAuthor(new ActionExcludeAuthor());
        
        view.addActionListnerBook(new ActionInsertAuthor());
        view.addExistentAuthorsToListActionListner(new ActionAddExistentAuthorsToListActionListner());
        view.removeExistentAuthorsToListActionListner(new ActionRemoveExistentAuthorsToListActionListner());
        view.editActionListnerBook(new ActionEditBook());
        view.excludeActionListnerBook(new ActionExcludeBook());
        
        view.addActionListnerPublisher(new ActionInsertPublisher());
        view.editActionListnerPublisher(new ActionEditPublisher());
        view.excludeActionListnerPublisher(new ActionExcludePublisher());
    }
    
    class ActionInsertAuthor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Author authorToInsert = view.getAddAuthor();
            
            authorDao.insertAuthor(authorToInsert.getFirstName(), authorToInsert.getLastName());
        }
        
    }
    
    class ActionEditAuthor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionExcludeAuthor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class AcaoInsertAuthor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionInsertBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Book bookToInsert = view.getAddBook(authors, view.getPublisherSelected());
            
            bookDao.insertBook(bookToInsert.getTitle(), bookToInsert.getIsbn(), bookToInsert.getPublisher_id(), bookToInsert.getPrice());
            authors = new ArrayList<>();
        }
        
    }
    
    class ActionEditBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionExcludeBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionInsertPublisher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionEditPublisher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Publisher p = view.getEditPublishers();
            if(p != null){
                try {
                    publisherDao.editPublisher(p.getName(), p.getUrl(), p.getPublisher_id());
                    view.refreshVisualComponents(null,publisherDao.getAllPublishers(), null);
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    class ActionExcludePublisher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    class ActionAddExistentAuthorsToListActionListner implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            authors.add(view.getAuthorSelected());
            view.atualizaTextoListaAutores(authors);
        }
        
    }
    
    class ActionRemoveExistentAuthorsToListActionListner implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(authors.size() > 0)
                authors.remove((authors.size()-1));
            
            view.atualizaTextoListaAutores(authors);
        }
        
    }
}
