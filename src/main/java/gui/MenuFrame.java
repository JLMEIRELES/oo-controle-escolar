package gui;

import helper.ButtonHelper;
import model.User;
import model.UserType;
import model.Team;

import javax.swing.*;
import java.text.ParseException;

public class MenuFrame extends JFrame {

    JButton teacherBtn, studentBtn, teamBtn, myTeams;

    public MenuFrame(User user) throws ParseException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        teacherBtn = ButtonHelper.createButtonToRedirect("Cadastrar Professor", this, new CreateTeacherGUI(user, this));
        studentBtn = ButtonHelper.createButtonToRedirect("Cadastrar Aluno", this, new CreateStudentGUI(user, this));
        teamBtn = ButtonHelper.createButtonToRedirect("Cadastrar Turma", this, new CreateTeamGUI(user, this));


        teacherBtn.setBounds(200,100,300,40);

        studentBtn.setBounds(200,200,300,40);

        teamBtn.setBounds(200,300,300,40);

        if(user.getUserType() == UserType.ADM){
            this.add(teacherBtn);
            this.add(studentBtn);
        } else if (user.getUserType() == UserType.TEACHER) {
            this.add(teamBtn);
            //myTeams = ButtonHelper.createButtonToRedirect("Minhas Turmas", this, new TeamsForTeacherFrame(user, this));
        }
    }


}
