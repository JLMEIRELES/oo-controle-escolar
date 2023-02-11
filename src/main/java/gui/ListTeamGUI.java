package gui;

import dao.TeacherDAO;
import gui.button.ButtonEditor;
import gui.button.ButtonRenderer;
import helper.ButtonHelper;
import model.Teacher;
import model.Team;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListTeamGUI extends JFrame{

    private JList<String> TeamList;
    private JPanel listAPanel;
    private JComboBox<String> TeamBox;
    private JButton confirmaButton;
    private JButton turnBackButton;
    private JTable teamTable;
    private DefaultListModel<String> teamListModel;
    private DefaultTableModel teamTableModel;

    private TeacherDAO teacherDAO = new TeacherDAO();


    public ListTeamGUI(User user, JFrame pastFrame) {
            setTitle("Listar Turmas");
            setSize(1000, 800);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            TeamBox = new JComboBox<>();

            JPanel listAPanel = new JPanel();

            teamListModel = new DefaultListModel<>();
            TeamList = new JList<>(teamListModel);
            JScrollPane scrollPane = new JScrollPane(TeamList);
            add(scrollPane, BorderLayout.CENTER);

            teamTableModel = new DefaultTableModel(new Object[]{"Código", "Nome", "Abrir"}, 0);
            teamTable = new JTable(teamTableModel);
            JScrollPane scrollPaneTable = new JScrollPane(teamTable);
            add(scrollPaneTable, BorderLayout.SOUTH);

            loadTeamList((Teacher) user);

            turnBackButton.addActionListener(ButtonHelper.buttonToTurnBack(this, pastFrame));

    }


        private void loadTeamList(Teacher teacher) {
           List<Team> teams =  teacherDAO.getTeams(teacher);
            for (Team team : teams) {
                teamTableModel.addRow(new Object[] {team.getCodigo(), team.getNome(), "Abrir"});
                teamTable.getColumn("Abrir").setCellRenderer(new ButtonRenderer());
                teamTable.getColumn("Abrir").setCellEditor(
                        new ButtonEditor(new JCheckBox(), this, team));
                JScrollPane scroll = new JScrollPane(teamTable);
                getContentPane().add(scroll);
                //setSize(400, 100);
            }
        }
}

