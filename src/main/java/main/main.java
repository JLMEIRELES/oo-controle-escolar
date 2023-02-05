package main;

import dao.UserDAO;
import gui.LoginFrane;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.security.NoSuchAlgorithmException;

public class main {

    public static void main(String args[]) throws NoSuchAlgorithmException {
        System.out.println("Hello World");
        LoginFrane frame = new LoginFrane(new UserDAO(JPAUtil.getEntityManager()));
    }

}
