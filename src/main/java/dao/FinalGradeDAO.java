package dao;

import model.FinalGrade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FinalGradeDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public FinalGradeDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(FinalGrade _finalgrade) {
        em.getTransaction().begin();
        em.merge(_finalgrade);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(FinalGrade _finalgrade) {
        em.getTransaction().begin();
        em.merge(_finalgrade);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(FinalGrade _finalgrade) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM final_grade WHERE id = " + _finalgrade.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}