package gui;

import dao.TeacherDAO;
import gui.button.ButtonEditor;
import gui.button.ButtonRenderer;
import model.Teacher;
import model.Team;
import dao.TeamDAO;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListTeamGUI extends JFrame{

    private JList<String> TeamList;
    private JPanel listAPanel;
    private JComboBox<String> TeamBox;
    private JButton confirmaButton;
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

            teamTableModel = new DefaultTableModel(new Object[]{"Código", "Nome", ""}, 0);
            teamTable = new JTable(teamTableModel);
            JScrollPane scrollPaneTable = new JScrollPane(teamTable);
            add(scrollPaneTable, BorderLayout.SOUTH);

            loadTeamList((Teacher) user);
        }


        private void loadTeamList(Teacher teacher) {
           List<Team> teams =  teacherDAO.getTeams(teacher);
            for (Team team : teams) {
                teamTableModel.addRow(new Object[] {team.getCodigo(), team.getNome()});
                teamTable.getColumn("").setCellRenderer(new ButtonRenderer());
                teamTable.getColumn("").setCellEditor(
                        new ButtonEditor(new JCheckBox(), this, team));
                JScrollPane scroll = new JScrollPane(teamTable);
                getContentPane().add(scroll);
                setSize(400, 100);
            }
        }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

