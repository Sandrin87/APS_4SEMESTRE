import DAO.BookDao;
import DAO.Interfaces.IBookDao;

public class Aplication {

    private IBookDao iBookDao;
    public static void main(String args[]) {

        BookDao dao = new BookDao();
        //dao.insertBook("TESTE", "0-201-456-0", 13, 10.00);
        //dao.editBook("TESTE2", 20.00, 13, "0-201-456-0");
        dao.getAllBooks();

    }

}
