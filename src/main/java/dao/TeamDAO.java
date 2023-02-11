package dao;

import model.Student;
import model.Teacher;
import model.Team;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TeamDAO {

    private final EntityManager entityManager;

    public TeamDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Teacher getTeacher(Team team){
        String jpql = "SELECT t FROM Teacher t WHERE t.id = :id";
        List<Teacher> teacherList = entityManager.createQuery(jpql,Teacher.class).setParameter("id", team.getTeacher().getId()).getResultList();
        Optional<Teacher> teacher = teacherList.stream().findFirst();
        return teacher.orElse(null);
    }

    public Team getTeamByCode(String code){
        String jpql = "SELECT t FROM Team t WHERE t.codigo =:code";
        List<Team> teamList = entityManager.createQuery(jpql, Team.class).setParameter("code", code).getResultList();
        Optional<Team> team = teamList.stream().findFirst();
        return team.orElse(null);
    }

    public Team createTeam(Team team) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(team);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return team;
    }

}
