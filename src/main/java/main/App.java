package main;

import dao.UserDAO;
import gui.LoginFrame;
import util.JPAUtil;

import java.security.NoSuchAlgorithmException;

public class App {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Hello World");
        LoginFrame frame = new LoginFrame(new UserDAO(JPAUtil.getEntityManager()));
    }

}
