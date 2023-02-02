package dao;

import model.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddressDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public AddressDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Address _address) {
        em.getTransaction().begin();
        em.merge(_address);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Address _address) {
        em.getTransaction().begin();
        em.merge(_address);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Address _address) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM address WHERE id = " + _address.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
