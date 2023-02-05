package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) throws NoSuchAlgorithmException {
        this.entityManager = entityManager;
    }

    public void createUser(User user) throws UnsupportedEncodingException {
        this.entityManager.persist(user);
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
