package View;

import DAO.UserDao;

import javax.swing.*;

public class Login extends JFrame {
    private JLabel LabelName;
    private JTextField textName;
    private JPasswordField passwordField1;
    private JButton logarButton;
    private JButton btnCancel;
    private JPanel jpLogin;
    private JLabel warninLabel;

    UserDao dao = new UserDao();
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
                     Janela principal = new Janela();
                     principal.setVisible(true);
                     this.dispose();
                 }
            }

        });
        btnCancel.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) throws Exception {
        Login login = new Login();
    }
}
