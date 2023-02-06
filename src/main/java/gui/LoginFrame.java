package gui;

import dao.UserDAO;
import model.User;
import util.JPAUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class LoginFrame extends JFrame implements ActionListener {

    private final UserDAO userDAO = new UserDAO(JPAUtil.getEntityManager());
    JPasswordField password;
    JTextField username;
    JLabel label_password, label_username,message,title;
    JButton btn;

    public LoginFrame(UserDAO userDAO) throws NoSuchAlgorithmException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        label_password = new JLabel("Password");
        label_password.setBounds(200,200,100,40);

        label_username = new JLabel("Email");
        label_username.setBounds(200,150,100,40);

        username = new JTextField();
        username.setBounds(300,150,300,40);

        password = new JPasswordField();
        password.setBounds(300,200,300,40);

        message = new JLabel("Message Here");
        message.setBounds(300,330,300,40);


        btn = new JButton("Sign In");
        btn.setBounds(300,270,100,40);

        btn.addActionListener(this);

        this.add(label_username);
        this.add(username);
        this.add(label_password);
        this.add(password);
        this.add(btn);
        this.add(message);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameText = username.getText();
        String passwordValue = new String(password.getPassword());
        if (Objects.equals(usernameText, "") || Objects.equals(passwordValue, "")){
            message.setText("Usuário e/ou senha em branco");
            return;
        }
       User user = getUser(usernameText, passwordValue);
       String msg = "Usuário e/ou senha incorretos";
        if (user == null) {
            message.setText(msg);
        } else {
            this.setVisible(false);
            MenuFrame menuFrame = new MenuFrame(user);
            menuFrame.setVisible(true);
        }
    }

    public User getUser(String username, String password){
        List<User> userList = userDAO.findUserByEmailAndPassword(username, password);
        if (userList.stream().findFirst().isPresent()){
            return userList.stream().findFirst().get();
        }
        return null;
    }
}
