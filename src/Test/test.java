/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Controller.Controller;
import DAO.AuthorDao;
import DAO.BookDao;
import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IBookDao;
import DAO.Interfaces.IPublisherDao;
import DAO.PublisherDao;
import View.Janela;

/**
 *
 * @author gabri
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Janela j = new Janela();
                j.setVisible(true);
                    IAuthorDao authorDao = new AuthorDao();
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
