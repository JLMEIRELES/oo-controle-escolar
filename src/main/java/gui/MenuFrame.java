package gui;

import model.User;

import javax.swing.*;

public class MenuFrame extends JFrame {

    JLabel test;

    public MenuFrame(User user) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        test = new JLabel("Email");
        test.setBounds(200,150,100,40);

        this.setVisible(true);

    }
}
