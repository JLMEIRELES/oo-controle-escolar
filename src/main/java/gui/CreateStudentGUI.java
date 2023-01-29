package gui;

import dao.StudentDAO;
import dao.UserDAO;
import dao.UserDAO.*;
import model.Student;
import model.User;
import util.JPAUtil;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import javax.persistence.EntityManager;

public class CreateStudentGUI extends JFrame {
    private JTextField inputName;
    private JButton confirmButton;
    private JTextField inputCpf;
    private JTextField inputEmail;
    private JTextField inputSenha;
    private JTextField inputEndereco;
    private JTextField inputResponsavel;
    private JFormattedTextField inputDtNasc;
    private JButton cleanButton;
    private JPanel cadastroAPanel;

    //private MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

    public CreateStudentGUI() {

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputCpf.setText("");
                inputDtNasc.setText("");
                inputEndereco.setText("");
                inputEmail.setText("");
                inputName.setText("");
                inputResponsavel.setText("");
                inputSenha.setText("");
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                UserDAO dao = new UserDAO();
                user.setNome(inputName.getText());
                user.setCpf(inputCpf.getText());
                user.setEmail(inputEmail.getText());
                user.setSenha(inputSenha.getText());
                user.setDataNascimento(LocalDate.parse("2016-02-06"));
                dao.createUser(user);
                JOptionPane.showMessageDialog(null, "Student saved successfully");

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastrar Aluno");
        frame.setContentPane(new CreateStudentGUI().cadastroAPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
