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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;

public class CreateStudentGUI extends JFrame {
    private JTextField inputName;
    private JButton confirmButton;
    private JTextField inputEmail;
    private JTextField inputSenha;
    private JTextField inputResponsavel;
    private JFormattedTextField inputDtNasc;
    private JButton cleanButton;
    private JPanel cadastroAPanel;
    MaskFormatter formatter = null;
    JFormattedTextField inputCpf;

    public CreateStudentGUI() throws ParseException {


        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickClear();

            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickConfirm();
            }
        });
    }


    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame("Cadastrar Aluno");
        try {
            frame.setContentPane(new CreateStudentGUI().cadastroAPanel);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void onClickClear() {
        inputCpf.setText("");
        inputDtNasc.setText("");
        inputEmail.setText("");
        inputName.setText("");
        inputResponsavel.setText("");
        inputSenha.setText("");
    }

    private void onClickConfirm(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Student student = new Student();
        StudentDAO dao = new StudentDAO();
        student.setNome(inputName.getText());
        student.setCpf(inputCpf.getText());
        student.setEmail(inputEmail.getText());
        student.setSenha(inputSenha.getText());
        student.setFiliacao(inputResponsavel.getText());
        try {
            Date parsedDate = dateFormat.parse(inputDtNasc.getText());
            student.setDataNascimento(parsedDate);
            try {
                dao.createStudent(student);
                JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar estudante: " + ex.getMessage());
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida: " + ex.getMessage() + ". Tente inserir no formato dd/mm/aaaa");
        }

    }
}


