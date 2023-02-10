package gui;

import helper.ButtonHelper;
import helper.DataHelper;
import helper.FormatHelper;
import model.Student;
import model.User;
import service.StudentService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
public class CreateStudentGUI extends JFrame {
    private JTextField inputName;
    private final StudentService studentService = new StudentService();
    private JButton confirmButton;
    private JTextField inputEmail;
    private JTextField inputSenha;
    private JTextField inputResponsavel;
    private JFormattedTextField inputDtNasc;
    private JButton cleanButton;

    private JButton turnBackButton;
    private JPanel cadastroAPanel;
    JFormattedTextField inputCpf;
    MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
    MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

    public CreateStudentGUI(User user, JFrame pastFrame) throws ParseException {
        this.setTitle("Cadastrar Aluno");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.cadastroAPanel);
        this.pack();
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
        inputCpf.setFormatterFactory(FormatHelper.generateFomatter(cpfFormatter));
        inputDtNasc.setFormatterFactory(FormatHelper.generateFomatter(dataFormatter));
        turnBackButton.addActionListener(ButtonHelper.buttonToTurnBack(this, pastFrame));
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
        Student student = new Student();
        student.setNome(inputName.getText());
        student.setCpf(inputCpf.getText());
        student.setEmail(inputEmail.getText());
        student.setSenha(inputSenha.getText());
        student.setFiliacao(inputResponsavel.getText());
        try {
            student.setDataNascimento(DataHelper.stringToDate(inputDtNasc.getText()));
            try {
                Student persistedStudent = studentService.createStudent(student);
                JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso! Matricula: " + persistedStudent.getMatricula());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar estudante: " + ex.getMessage());
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida: " + ex.getMessage() + ". Tente inserir no formato dd/mm/aaaa");
        }

    }
}
