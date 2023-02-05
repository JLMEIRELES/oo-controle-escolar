package gui;

import dao.StudentDAO;
import model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

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

    public ListNotesGUI() {
        setTitle("Listar Estudantes");
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        studentsBox = new JComboBox<>();
        bimestreBox = new JComboBox<>(new String[] {"Semestre 1", "Semestre 2"});

        JPanel listAPanel = new JPanel();
        listAPanel.add(new JLabel("Nome do Aluno: "));
        listAPanel.add(studentsBox);
        listAPanel.add(new JLabel("Semestre: "));
        listAPanel.add(bimestreBox);

        add(listAPanel, BorderLayout.NORTH);

//        studentListModel = new DefaultListModel<>();
//        studentList = new JList<>(studentListModel);
//        JScrollPane scrollPane = new JScrollPane(studentList);
//        add(scrollPane, BorderLayout.CENTER);

        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        add(scrollPane, BorderLayout.CENTER);

        studentTableModel = new DefaultTableModel(new Object[]{"Nome", "Matrícula", "Semestre 1", "Semestre 2", "Editar"}, 0);
        studentTable = new JTable(studentTableModel);
        JScrollPane scrollPaneTable = new JScrollPane(studentTable);
        add(scrollPaneTable, BorderLayout.SOUTH);

        loadStudentList();


    }


    private void loadStudentList() {
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.list();
        for (Student student : students) {
            studentsBox.addItem(student.getNome());
            studentTableModel.addRow(new Object[] {student.getNome(), student.getMatricula(), "2", "2"});
        }
    }

    public static void main(String[] args) {
        ListNotesGUI frame = new ListNotesGUI();
        frame.setVisible(true);
    }
}