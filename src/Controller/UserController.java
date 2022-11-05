package Controller;

import DAO.AuthorDao;
import DAO.BookDao;
import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IBookDao;
import DAO.Interfaces.IPublisherDao;
import DAO.PublisherDao;
import DAO.UserDao;
import View.Janela;
import View.ViewLogin;

public class UserController implements ViewLogin {

    @Override
    public boolean logarController(String usuario, String password) {
        try {
            UserDao dao = new UserDao();
                String user = dao.logar(usuario, password);
                if(user.equals("Sucesso")){
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
                        return true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
