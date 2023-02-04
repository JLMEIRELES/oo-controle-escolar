package gui;

import dao.StudentDAO;
import model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListNotesGUI extends JFrame {

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JFormattedTextField formattedTextField1;
    private JButton confirmaButton;
    private JTable studentTable;
    private DefaultTableModel model;
    public ListNotesGUI(List<Student> students) {

        setTitle("Student List");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Matrícula");

        for (Student student : students) {
            model.addRow(new Object[] {student.getNome(), student.getMatricula()});
        }

        studentTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.list();
        ListNotesGUI frame = new ListNotesGUI(students);
        frame.setVisible(true);
    }
    private void createUIComponents() {
        // Initialize components with "Custom Create" option here
    }
}
