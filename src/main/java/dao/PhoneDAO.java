package dao;

import model.Phone;
import model.Student;

import javax.persistence.EntityManager;

public class PhoneDAO {

    private final EntityManager entityManager;

    public PhoneDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createPhone(Phone phone){
        this.entityManager.persist(phone);
    }

}
