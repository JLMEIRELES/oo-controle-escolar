package service;

import dao.TeacherDAO;
import dao.UserDAO;
import helper.FormatHelper;
import model.Teacher;
import model.User;
import model.UserType;


public class TeacherService {

    private final TeacherDAO teacherDAO = new TeacherDAO();

    private final UserDAO userDAO = new UserDAO();

    public Teacher createTeacher(Teacher teacher) {
        teacher.setMatricula(generateMatricula());
        Teacher persistedTeacher = this.teacherDAO.createTeacher(teacher);
        User user = this.teacherDAO.getUser(persistedTeacher);
        user.setUserType(UserType.TEACHER);
        userDAO.updateUser(user);
        return teacher;
    }

    private String generateMatricula(){
        String numMatricula = FormatHelper.generateMatriculaStudent();
        return teacherDAO.getTeacherByMatricula(numMatricula) == null ? numMatricula : generateMatricula();
    }

}
