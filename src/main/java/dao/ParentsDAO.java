package dao;

import model.Parents;
import model.Student;
import model.User;

import javax.persistence.EntityManager;

public class ParentsDAO {

    private final EntityManager entityManager;

    public ParentsDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createParents(Parents parents){
        this.entityManager.persist(parents);
    }

}
