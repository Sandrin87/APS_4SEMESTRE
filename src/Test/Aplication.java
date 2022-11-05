package Test;

import Controller.Controller;
import DAO.AuthorDao;
import DAO.BookDao;
import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IBookDao;
import DAO.Interfaces.IPublisherDao;
import DAO.PublisherDao;
import View.Janela;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplication {
    public static void main(String args[]) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IAuthorDao authorDao = null;
                    try {
                        authorDao = new AuthorDao();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    IBookDao bookDao = null;
                    try {
                        bookDao = new BookDao();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    IPublisherDao publisherDao = null;
                    try {
                        publisherDao = new PublisherDao();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    Janela j = new Janela();
                    j.setVisible(true);
                    new Controller(authorDao, bookDao, publisherDao, j).init();
                } catch (Exception ex) {
                    Logger.getLogger(Aplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

