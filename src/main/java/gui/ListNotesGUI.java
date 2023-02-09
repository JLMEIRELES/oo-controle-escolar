package gui;

import dao.StudentDAO;
import model.Student;
import dao.NotesDAO;
import model.Note;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        JScrollPane scrollPane = new JScrollPane(studentList);
        add(scrollPane, BorderLayout.CENTER);

        studentTableModel = new DefaultTableModel(new Object[]{"Nome", "Matrícula", "Semestre 1", "Semestre 2"}, 0);
        studentTable = new JTable(studentTableModel);
        JScrollPane scrollPaneTable = new JScrollPane(studentTable);
        add(scrollPaneTable, BorderLayout.SOUTH);

        loadStudentList();


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


    private void loadStudentList() {
        StudentDAO dao = new StudentDAO();
        NotesDAO daoNote = new NotesDAO();
        List<Student> students = dao.list();

        for (Student student : students) {
            studentTableModel.addRow(new Object[] {student.getNome(), student.getMatricula(), daoNote.findNoteByStudentId(student.getId(),1),daoNote.findNoteByStudentId(student.getId(),2)});
        }
    }

    public static void main(String[] args) {
        ListNotesGUI frame = new ListNotesGUI();
        frame.setVisible(true);
    }
}