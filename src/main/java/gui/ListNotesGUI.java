package gui;

import dao.StudentDAO;
import gui.button.ButtonEditor;
import gui.button.ButtonRenderer;
import model.*;
import dao.NotesDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class ListNotesGUI extends JFrame {

    private JComboBox<String> studentsBox;
    private JComboBox<String> bimestreBox;
    private JList<String> studentList;
    private JTable studentTable;
    private JButton confirmaButton;
    private JPanel listAPanel;
    private JFormattedTextField noteBox;
    private DefaultListModel<String> studentListModel;
    private DefaultTableModel studentTableModel;

    private NotesDAO notesDAO = new NotesDAO();

    public ListNotesGUI(Team team, JFrame pastFrame) {
        setTitle("Listar Estudantes");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        studentsBox = new JComboBox<>();
        bimestreBox = new JComboBox<>(new String[] {"Semestre 1", "Semestre 2"});

        JPanel listAPanel = new JPanel();

        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        add(scrollPane, BorderLayout.CENTER);

        studentTableModel = new DefaultTableModel(new Object[]{"Nome", "Matrícula", "Nota"}, 0);
        studentTable = new JTable(studentTableModel);
        JScrollPane scrollPaneTable = new JScrollPane(studentTable);
        add(scrollPaneTable, BorderLayout.SOUTH);

        loadStudentList(team);


        studentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = studentTable.rowAtPoint(e.getPoint());
                    int column = studentTable.columnAtPoint(e.getPoint());
                    // Get the value of the selected cell
                    Object value = studentTable.getValueAt(row, column);
                    // Do something with the value, such as display it in a dialog
                    JOptionPane.showMessageDialog(ListNotesGUI.this, value);
                }
            }
        });
    }



    private void loadStudentList(Team team) {
       List<?> list =  notesDAO.getTeamNotes(team);
        for (Object object : list) {
            Object[] array = (Object[]) object;
            studentTableModel.addRow(new Object[] {array[0], array[1], array[2]});
            JScrollPane scroll = new JScrollPane(studentTable);
            getContentPane().add(scroll);
            setSize(400, 100);
        }
    }

}