package Test;

import Controller.Controller;
import DAO.AuthorDao;
import DAO.BookDao;
import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IBookDao;
import DAO.Interfaces.IPublisherDao;
import DAO.PublisherDao;
import View.Janela;

public class Aplication {
    public static void main(String args[]) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Janela j = new Janela();
                j.setVisible(true);
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
                new Controller(authorDao, bookDao, publisherDao, j).init();
            }
        });
    }
}

