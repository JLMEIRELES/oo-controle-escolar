package dao;

import model.Address;
import model.Student;

import javax.persistence.EntityManager;

public class AddressDAO {
    private final EntityManager entityManager;

    public AddressDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createAddress(Address address){
        this.entityManager.persist(address);
    }
}
