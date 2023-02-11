package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import model.Note;
import model.Team;
import vo.StudentsByTeamVo;

public class NotesDAO {

    private final EntityManager entityManager;

    public NotesDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controle-escolar");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void updateNote(Note newNote) {
        entityManager.getTransaction().begin();
        Note note = new Note();
        note.setNotes(newNote.getNotes());
        entityManager.merge(note);
        entityManager.getTransaction().commit();
    }

    public List<?> getTeamNotes(Team team) {
        String jpql = "SELECT u.nome, s.matricula, n.note FROM notes n " +
                "INNER JOIN users u " +
                "ON u.id = n.student_id " +
                "INNER JOIN teams t " +
                "ON t.id = n.team_id " +
                "INNER JOIN students s " +
                "on u.id = s.user_id " +
                "WHERE n.team_id = ?";
        return entityManager.createNativeQuery(jpql).setParameter(1, team.getId()).getResultList();
    }
}
