package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import model.Note;

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

    public List<Note> buscarTodos(){
        Query query = entityManager.createQuery("SELECT n FROM Note n");
        return query.getResultList();
    }
    public List<Note> findNoteByStudentId(Long studentId, int semester){
        Query query = entityManager.createQuery("SELECT n FROM Note n WHERE n.student.id = :studentId AND n.semester = :semester");
        query.setParameter("studentId", studentId);
        query.setParameter("semester", semester);
        return query.getResultList();
    }
}
