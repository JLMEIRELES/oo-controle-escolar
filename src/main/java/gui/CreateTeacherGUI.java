package gui;

import helper.ButtonHelper;
import helper.DataHelper;
import helper.FormatHelper;
import model.Teacher;
import model.User;
import service.TeacherService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class CreateTeacherGUI extends JFrame {
    private JPanel cadastroAPanel;
    private final TeacherService teacherService = new TeacherService();
    private JTextField inputName;
    private JTextField inputEmail;
    private JTextField inputFormacao;
    private JButton confirmButton;
    private JButton cleanButton, turnBackButton;
    private JPasswordField inputSenha;
    private JFormattedTextField inputDtNasc;
    JFormattedTextField inputCpf;
    MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
    MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

    public CreateTeacherGUI(User user, JFrame pastFrame) throws ParseException {
        this.setTitle("Cadastrar Professor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.cadastroAPanel);
        this.pack();
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickClear();
            }
        });
        confirmButton.addActionListener(e -> onClickConfirm());
        inputCpf.setFormatterFactory(FormatHelper.generateFomatter(cpfFormatter));
        inputDtNasc.setFormatterFactory(FormatHelper.generateFomatter(dataFormatter));
        turnBackButton.addActionListener(ButtonHelper.buttonToTurnBack(this, pastFrame));
    }

    private void onClickClear() {
        inputCpf.setText("");
        inputDtNasc.setText("");
        inputEmail.setText("");
        inputName.setText("");
        inputFormacao.setText("");
        inputSenha.setText("");
    }

    private void onClickConfirm(){
        Teacher teacher = new Teacher();
        teacher.setNome(inputName.getText());
        teacher.setCpf(inputCpf.getText());
        teacher.setEmail(inputEmail.getText());
        teacher.setSenha(inputSenha.getText());
        teacher.setFormacao(inputFormacao.getText());
        try {
            teacher.setDataNascimento(DataHelper.stringToDate(inputDtNasc.getText()));
            try {
                Teacher persistedTeacher = teacherService.createTeacher(teacher);
                JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso! Matricula: " + persistedTeacher.getMatricula());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor: " + ex.getMessage());
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida: " + ex.getMessage() + ". Tente inserir no formato dd/mm/aaaa");
        }
    }
}
