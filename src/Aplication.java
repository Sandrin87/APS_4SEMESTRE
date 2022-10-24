import DAO.AuthorDao;
import DAO.BookDao;
import DAO.PublisherDao;
import DAO.UserDao;

public class Aplication {

    private static UserDao userDao;
    public static void main(String args[]) throws Exception {


        PublisherDao publisherDao = new PublisherDao();
        BookDao dao = new BookDao();
        UserDao userDao = new UserDao();
        AuthorDao authorDao = new AuthorDao();

        //dao.getBookByIsbn("0-201-96426-0");
        //authorDao.editAuthor("teste", "teste1", 5698);
        //dao.insertBook("TESTE", "0-201-456-0", 13, 10.00);
        //dao.editBook("Clean Code", 50.00, 13, "1");
        //dao.getBooksByTitle("TESTE2");
        //userDao.logar("admin", "123");

        //publisherDao.editPublisher("teste", "teste.com.br", 201);
        //publisherDao.getPublisherById(201);
        //authorDao.getAllAuthors();
        //publisherDao.getAllPublishers();
        dao.getAllBooks();
    }


}

