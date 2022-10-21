import DAO.BookDao;
import DAO.PublisherDao;
import DAO.UserDao;

public class Aplication {

    private static UserDao userDao;
    public static void main(String args[]) throws Exception {


        PublisherDao publisherDao = new PublisherDao();
        BookDao dao = new BookDao();
        UserDao userDao = new UserDao();
        //dao.insertBook("TESTE", "0-201-456-0", 13, 10.00);
        //dao.editBook("TESTE2", 20.00, 13, "0-201-456-0");
        dao.getBooksByTitle("TESTE2");
        //userDao.logar("admin", "123");

        publisherDao.editPublisher("teste", "teste.com.br", 201);
        //publisherDao.getPublisherById(201);
    }


}

