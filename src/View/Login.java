package View;

import DAO.AuthorDao;
import DAO.Interfaces.IAuthorDao;
import DAO.Interfaces.IPublisherDao;
import DAO.Interfaces.IUserDao;
import DAO.PublisherDao;
import DAO.UserDao;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Login extends JFrame {
    private JLabel LabelName;
    private JTextField textName;
    private JPasswordField passwordField1;
    private JButton logarButton;
    private JButton btnCancel;
    private JPanel jpLogin;
    private JLabel warninLabel;

    IUserDao dao = new UserDao();
    IAuthorDao aDao = new AuthorDao();
    IPublisherDao pDao = new PublisherDao();
    public Login() throws Exception {
        setContentPane(jpLogin);
        setTitle("Tela de Login");
        setSize(450,300);

        setLocationRelativeTo(jpLogin);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        logarButton.addActionListener(e -> {
            String name = textName.getText();
            String pass = passwordField1.getText();
            if(name.equals("") || pass.equals("")){
                warninLabel.setText("Preencha todos os campos");
            } else {
                 final var resp = dao.logar(name, pass);
                 if("Sucesso".equals(resp)){
                     try {
                         Janela principal = new Janela(aDao, pDao);
                         principal.setVisible(true);
                         this.dispose();
                     } catch (Exception ex) {
                         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
            }

        });
        btnCancel.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) throws Exception {
        Login login = new Login();
    }
}
