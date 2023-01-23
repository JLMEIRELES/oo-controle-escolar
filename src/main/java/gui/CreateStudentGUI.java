package gui;

import dao.StudentDAO;
import dao.UserDAO;
import model.User;
import util.JPAUtil;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

    private MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

    public CreateStudentGUI() throws ParseException {
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputCpf.setText("");
                dataFormatter.install(inputDtNasc);
                inputDtNasc.setText("");
                inputEndereco.setText("");
                inputEmail.setText("");
                inputName.setText("");
                inputResponsavel.setText("");
                inputSenha.setText("");
            }
        });
    }

    private void onClickSalvar() {
        StudentDAO studentDAO = new StudentDAO(JPAUtil.getEntityManager());
        UserDAO userDAO = new UserDAO(JPAUtil.getEntityManager());
        try {
            User user = new User();
            userDAO.createUser(inputCpf.getText(), inputDtNasc.getText(),);
            studentDAO.createStudent(txtNome.getText(), txtApelido.getText(), txtDtNascimento.getText());
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
            clearFields();
            contatoList = new ContatoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Nao foi possivel salvar contato!n" +
                            e.getLocalizedMessage()
            );
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Data possui formato inválido!n" +
                            e.getLocalizedMessage()
            );
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastrar Aluno");
        frame.setContentPane(new CreateStudentGUI().cadastroAPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
