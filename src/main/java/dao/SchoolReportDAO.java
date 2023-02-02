package dao;

import model.SchoolReport;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SchoolReportDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public SchoolReportDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(SchoolReport _schoolreport) {
        em.getTransaction().begin();
        em.merge(_schoolreport);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(SchoolReport _schoolreport) {
        em.getTransaction().begin();
        em.merge(_schoolreport);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(SchoolReport _schoolreport) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM school_report WHERE id = " + _schoolreport.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
