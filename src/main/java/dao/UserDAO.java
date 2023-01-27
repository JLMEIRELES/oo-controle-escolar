package dao;

import model.User;
import javax.persistence.EntityManager;

public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createUser(User user){
        this.entityManager.persist(user);
    }

}
