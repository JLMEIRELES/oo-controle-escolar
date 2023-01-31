package dao;

import model.Aula;
import model.SchoolClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AulaDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public AulaDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Aula _aula) {
        em.getTransaction().begin();
        em.merge(_aula);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Aula _aula) {
        em.getTransaction().begin();
        em.merge(_aula);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Aula _aula) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM aula WHERE id = " + _aula.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
