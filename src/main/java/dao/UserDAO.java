package dao;

import model.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO()  {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public void createUser(User user) throws UnsupportedEncodingException {
        this.entityManager.persist(user);
    }

    public void updateUser(User user){
        entityManager.getTransaction().begin();
        this.entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public List<User> findUserByEmailAndPassword(String email, String password){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        Predicate filtros = builder.and();
        if (email != null && !email.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("email"), email));
        }
        if (password != null && !password.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("senha"), password));
        }
        query.where(filtros);


        return entityManager.createQuery(query).getResultList();
    }

}
