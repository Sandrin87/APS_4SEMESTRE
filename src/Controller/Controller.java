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
    List<Book> books = new ArrayList<>();
    List<Publisher> publishers = new ArrayList<>();
    
    public Controller(IAuthorDao _authorDao, IBookDao _bookDao, IPublisherDao _publisherDao, View _view){
        this.authorDao = _authorDao;
        this.bookDao = _bookDao;
        this.publisherDao = _publisherDao;
        this.view = _view;
    }
    
    public void init() throws Exception{
        view.initVisualComponents(bookDao.getAllBooks(), publisherDao.getAllPublishers(), authorDao.getAllAuthors());
        
        view.searchActionListnerAutor(new ActionSearchListnerAuthor());
        view.addActionListnerAuthor(new ActionInsertAuthor());
        view.editActionListnerAuthor(new ActionEditAuthor());
        view.excludeActionListnerAuthor(new ActionExcludeAuthor());
        
        view.searchActionListnerBook(new ActionSearchListnerBook());
        view.addActionListnerBook(new ActionInsertBook());
        view.addExistentAuthorsToListActionListner(new ActionAddExistentAuthorsToListActionListner());
        view.removeExistentAuthorsToListActionListner(new ActionRemoveExistentAuthorsToListActionListner());
        view.editActionListnerBook(new ActionEditBook());
        view.excludeActionListnerBook(new ActionExcludeBook());
        
        view.searchActionListnerPublisher(new ActionSearchPublisher());
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
    
    class ActionEditAuthor implements ActionListener{ //AQ 

        @Override
        public void actionPerformed(ActionEvent e) {
            Author a = view.getEditAuthors();
            if(a != null){
              try {
                    authorDao.editAuthor(a.getFirstName(), a.getLastName(), a.getAuthor_id());
                    view.refreshVisualComponents(null, null, authorDao.getAllAuthors());
                } catch (Exception ex) {
                    System.out.println("Erro do sistema.");
                }  
            }
        }
        
    }
    
    class ActionExcludeAuthor implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            authorDao.deleteAuthor(view.getDeleteAuthor());
        }
        
    }
    
    class ActionInsertBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Book bookToInsert = view.getAddBook(authors, view.getPublisherSelected());
            
            bookDao.insertBook(bookToInsert.getTitle(), bookToInsert.getIsbn(), bookToInsert.getPublisher_id(), bookToInsert.getPrice());
        }        
    }
    
    class ActionEditBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Book b = view.getEditBooks();
            if(b != null){
                try {
                    bookDao.editBook(b.getTitle(), b.getPrice(), b.getIsbn());
                    view.refreshVisualComponents(bookDao.getAllBooks(), null, null);
                } catch (Exception ex) {
                    System.out.println("Erro do sistema.");
                }
            }
        }
        
    }
    
    class ActionExcludeBook implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            bookDao.deleteBook(view.getDeleteBook());
        }
        
    }
    
    class ActionInsertPublisher implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Publisher publisherToInsert = view.getAddPublisher();
            
            publisherDao.insertPublisher(publisherToInsert.getUrl(), publisherToInsert.getName());
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
            publisherDao.deletePublisher(view.getDeletePublishers());
        
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
            
            publisherDao.deletePublisher(view.getDeletePublishers());
            
            if(authors.size() > 0)
                authors.remove((authors.size()-1));
            
            view.atualizaTextoListaAutores(authors);
        }
        
    }
    
    class ActionSearchPublisher implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Publisher> publisherFiltered = publisherDao.getPublisherByName(view.getSearchPublishers());
                view.refreshVisualComponents(null, publisherFiltered, null);
            } catch (Exception ex) {
                System.out.println("Erro ao buscar Publishers");
            }
        }
    }
    
    class ActionSearchListnerBook implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Book> booksFiltered = bookDao.getBooksByTitle(view.getSearchBooks());
                view.refreshVisualComponents(booksFiltered, null, null);
            } catch (Exception ex) {
                System.out.println("Erro ao buscar Livros");
            }
        }
        
    }
    
    class ActionSearchListnerAuthor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Author a = view.getSearchAuthors();
                
                List<Author> authorsFiltered = authorDao.getByFilter(a.getFirstName(), a.getLastName());
                view.refreshVisualComponents(null, null, authorsFiltered);
            } catch (Exception ex) {
                System.out.println("Erro ao buscar Autores");
            }
        }
        
    }
    
}
