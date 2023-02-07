package service;

import dao.StudentDAO;
import dao.UserDAO;
import helper.FormatHelper;
import model.Student;
import model.User;
import model.UserType;

import java.io.UnsupportedEncodingException;


public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    private final UserDAO userDAO = new UserDAO();

    public Student createStudent(Student student) throws UnsupportedEncodingException {
        student.setMatricula(generateMatricula());
        Student persistedStudent = this.studentDAO.createStudent(student);
        User user = this.studentDAO.getUser(persistedStudent);
        user.setUserType(UserType.STUDENT);
        userDAO.updateUser(user);
        return student;
    }

    public String generateMatricula(){
        String numMatricula = FormatHelper.generateMatricula();
        return studentDAO.getStudentByMatricula(numMatricula) == null ? numMatricula : generateMatricula();
    }


}
