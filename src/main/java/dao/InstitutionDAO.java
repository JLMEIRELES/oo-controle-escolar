package dao;

import model.Institution;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InstitutionDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public InstitutionDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Institution _institution) {
        em.getTransaction().begin();
        em.merge(_institution);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Institution _institution) {
        em.getTransaction().begin();
        em.merge(_institution);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(Institution _institution) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM institution WHERE id = " + _institution.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}