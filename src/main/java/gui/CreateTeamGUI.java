package gui;

import helper.ButtonHelper;
import helper.DataHelper;
import helper.FormatHelper;
import model.Teacher;
import model.Team;
import model.User;
import service.TeamService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class CreateTeamGUI extends JFrame {
    private JPanel cadastroAPanel;
    private final TeamService teamService = new TeamService();
    private JTextField inputCode;
    private JTextField inputName;
    private JTextField inputTurno;
    private JButton confirmButton;
    private JButton cleanButton;
    private JFormattedTextField inputDtInicio;
    private JFormattedTextField inputDtFim;
    private JButton turnBackButton;

    MaskFormatter dataFormatter = new MaskFormatter("##/##/####");

    /*public CreateTeacherGUI(User user) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }*/

    public CreateTeamGUI(User user, JFrame pastFrame) throws ParseException {
        this.setTitle("Cadastrar Turma");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.cadastroAPanel);
        this.pack();
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickClear();
            }
        });
        confirmButton.addActionListener(e -> onClickConfirm(user));
        inputDtInicio.setFormatterFactory(FormatHelper.generateFomatter(dataFormatter));
        inputDtFim.setFormatterFactory(FormatHelper.generateFomatter(dataFormatter));
        turnBackButton.addActionListener(ButtonHelper.buttonToTurnBack(this, pastFrame));
    }

    private void onClickClear() {
        inputCode.setText("");
        inputName.setText("");
        inputTurno.setText("");
        inputName.setText("");
        inputDtInicio.setText("");
        inputDtFim.setText("");
    }

    private void onClickConfirm(User user){
        Team team = new Team();
        team.setNome(inputName.getText());
        team.setCodigo(inputCode.getText());
        team.setTurno(inputTurno.getText());
        try {
            team.setDataInicio(DataHelper.stringToDate(inputDtInicio.getText()));
            team.setDataFim(DataHelper.stringToDate(inputDtFim.getText()));
            try {
                Team persistedTeam = teamService.createTeam(team, (Teacher) user);
                JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar turma: " + ex.getMessage());
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data inválida: " + ex.getMessage() + ". Tente inserir no formato dd/mm/aaaa");
        }

    }
}
