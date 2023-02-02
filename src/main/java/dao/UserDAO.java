package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAO {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UserDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("controle-escolar");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void createUser(User user){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }    }

}
