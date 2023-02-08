package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import model.Note;

public class NotesDAO {

    private EntityManager entityManager;

    public NotesDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save(Note note){
        entityManager.persist(note);
    }

    public Note atualizar(Note note){
        return entityManager.merge(note);
    }

    public void excluir(Note note){
        entityManager.remove(note);
    }

    public Note buscarPorId(Long id){
        return entityManager.find(Note.class, id);
    }

    public List<Note> buscarTodos(){
        Query query = entityManager.createQuery("SELECT n FROM Note n");
        return query.getResultList();
    }
    public List<Note> findNote(String student, String subject){
        Query query = entityManager.createQuery("SELECT n FROM Note n WHERE n.Student = :Student AND n.Subject = :subject");
        query.setParameter("student", student);
        query.setParameter("subject", subject);
        return query.getResultList();
    }
}
