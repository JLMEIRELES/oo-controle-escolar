package dao;

import model.Records;

import javax.persistence.EntityManager;

public class RecordsDAO {

    private final EntityManager entityManager;

    public RecordsDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createRecords(Records records){
        this.entityManager.persist(records);
    }
}
