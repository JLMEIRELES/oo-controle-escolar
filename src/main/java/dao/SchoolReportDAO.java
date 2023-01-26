package dao;

import model.SchoolReport;
import model.Student;

import javax.persistence.EntityManager;

public class SchoolReportDAO {
    private final EntityManager entityManager;

    public SchoolReportDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createSchoolReport(SchoolReport schoolreport){
        this.entityManager.persist(schoolreport);
    }

}
