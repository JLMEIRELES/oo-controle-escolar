package gui;

import helper.ButtonHelper;
import model.User;
import model.UserType;

import javax.swing.*;
import java.text.ParseException;

public class MenuFrame extends JFrame {

    JButton teacherBtn, studentBtn;

    public MenuFrame(User user) throws ParseException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        teacherBtn = ButtonHelper.createButtonToRedirect("Cadastrar Professor", this, new TeachersRegisterFrame(user));
        studentBtn = ButtonHelper.createButtonToRedirect("Cadastrar Aluno", this, new CreateStudentGUI(user));

        teacherBtn.setBounds(200,100,300,40);

        studentBtn.setBounds(200,200,300,40);

        if(user.getUserType() == UserType.ADM){
            this.add(teacherBtn);
            this.add(studentBtn);
        }

        this.setVisible(true);

    }


}
