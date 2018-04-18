package view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Course;
import model.Enrolment;
import model.Student;
import model.Teacher;
import repo.CourseRepo;
import repo.EnrolmentRepo;
import repo.StudentRepo;
import repo.TeacherRepo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentView {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_student;
	private JTextField textField_course;
	public JButton btnEnroll = new JButton("Enroll");

	public StudentView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(50, 205, 50));
		frame.setBounds(100, 100, 720, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(39, 127, 619, 232);
		frame.getContentPane().add(tabbedPane);
		
		// first tab
		final TeacherRepo trepo = new TeacherRepo();
		String[] teacher_cols = {"id","name","e-mail"};
		List<Teacher> teacher_list = trepo.viewAllTeachers();
		Object[][] teacher_data = null;
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Teachers", null, scrollPane, null);
		tabbedPane.setBackgroundAt(0, new Color(138, 43, 226));
		table = new JTable(new DefaultTableModel(teacher_data, teacher_cols));
		DefaultTableModel model_order_table = (DefaultTableModel) table.getModel();
		for(int i=0;i<teacher_list.size();i++)
			model_order_table.addRow(new Object[]{teacher_list.get(i).getId(),teacher_list.get(i).getName(),teacher_list.get(i).getEmail()});			
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		// second tab
		final StudentRepo srepo = new StudentRepo();
		String[] student_cols = {"id","name","email","cnp","group","identification nr"};
		List<Student> student_list = srepo.viewAllStudents();
		Object[][] student_data = null;
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Students", null, scrollPane_1, null);
		tabbedPane.setBackgroundAt(1, new Color(244, 164, 96));
		table_1 = new JTable(new DefaultTableModel(student_data, student_cols));
		scrollPane_1.setColumnHeaderView(table_1);
		scrollPane_1.setViewportView(table_1);
		DefaultTableModel model_order_table_1 = (DefaultTableModel) table_1.getModel();
		for(int i=0;i<student_list.size();i++)
			model_order_table_1.addRow(new Object[]{student_list.get(i).getId(),student_list.get(i).getName(),student_list.get(i).getEmail(),student_list.get(i).getCnp(),student_list.get(i).getGroup(),student_list.get(i).getIdentificationNr()});			
		
		// third tab
		final CourseRepo crepo = new CourseRepo();
		String[] course_cols = {"id","name","teacher"};
		List<Course> course_list = crepo.viewAllCourses();
		Object[][] course_data = null;
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Courses", null, scrollPane_2, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 215, 0));
		table_2 = new JTable(new DefaultTableModel(course_data, course_cols));
		scrollPane_2.setColumnHeaderView(table_2);
		scrollPane_2.setViewportView(table_2);
		DefaultTableModel model_order_table_2 = (DefaultTableModel) table_2.getModel();
		for(int i=0;i<course_list.size();i++)
			model_order_table_2.addRow(new Object[]{course_list.get(i).getId(),course_list.get(i).getName(),course_list.get(i).getTeacher()/*.getName()*/});	
		
		JLabel lblEnroll = new JLabel("Enroll student");
		lblEnroll.setBounds(39, 44, 88, 14);
		frame.getContentPane().add(lblEnroll);
		
		textField_student = new JTextField();
		textField_student.setBounds(143, 41, 32, 20);
		frame.getContentPane().add(textField_student);
		textField_student.setColumns(10);
		
		JLabel lblwriteHereOnly = new JLabel("(write here only your ID, not your colleagues')");
		lblwriteHereOnly.setBounds(143, 63, 305, 14);
		frame.getContentPane().add(lblwriteHereOnly);
		
		JLabel lblToCourse = new JLabel("to course");
		lblToCourse.setBounds(197, 44, 62, 14);
		frame.getContentPane().add(lblToCourse);
		
		textField_course = new JTextField();
		textField_course.setBounds(287, 41, 32, 20);
		frame.getContentPane().add(textField_course);
		textField_course.setColumns(10);
		
		btnEnroll.setBackground(new Color(199, 21, 133));
		btnEnroll.setBounds(359, 40, 89, 23);
		frame.getContentPane().add(btnEnroll);		
	}

	public JTextField getTextField_student() {
		return textField_student;
	}

	public void setTextField_student(JTextField textField_student) {
		this.textField_student = textField_student;
	}

	public JTextField getTextField_course() {
		return textField_course;
	}

	public void setTextField_course(JTextField textField_course) {
		this.textField_course = textField_course;
	}
	public void setActionListenerEnroll(ActionListener e) {
		this.btnEnroll.addActionListener(e);
	}
}
