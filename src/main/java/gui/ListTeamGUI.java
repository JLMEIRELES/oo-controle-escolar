package gui;

import model.Team;
import dao.TeamDAO;
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

    public ListTeamGUI() {
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

            teamTableModel = new DefaultTableModel(new Object[]{"Nome"}, 0);
            teamTable = new JTable(teamTableModel);
            JScrollPane scrollPaneTable = new JScrollPane(teamTable);
            add(scrollPaneTable, BorderLayout.SOUTH);

            loadTeamList();
        }


        private void loadTeamList() {
            TeamDAO dao = new TeamDAO();
            List<Team> teams = dao.list();

            for (Team team : teams) {
                teamTableModel.addRow(new Object[] {team.getCodigo(), team.getNome(),1});
            }
        }

        public static void main(String[] args) {
            gui.ListNotesGUI frame = new gui.ListNotesGUI();
            frame.setVisible(true);
        }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

