package main;

import dao.UserDAO;
import util.JPAUtil;
import javax.persistence.EntityManager;

public class main {
    public static void main(String args[]){
        EntityManager em = JPAUtil.getEntityManager();
        System.out.println("Hello World");
    }
}
