package view;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Course;
import model.Enrolment;
import model.Student;
import model.Teacher;
import repo.CourseRepo;
import repo.EnrolmentRepo;
import repo.StudentRepo;
import repo.TeacherRepo;

public class TeacherView {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_sname;
	private JTextField textField_semail;
	private JTextField textField_scnp;
	private JTextField textField_sidnr;
	private JTextField textField_sgroup;
	private JTextField textField_TeacherName;
	private JTextField textField_TeacherEmail;
	private JTextField textField_courseName;
	private JTextField textField_idt;
	private JTextField textField_ids;
	private JTextField textField_idc;
	private JTextField textField_grade;
	private JTextField textField_student;
	private JTextField textField_course;
	public JButton btnDeleteTeacher = new JButton("Delete Teacher");
	public JButton btnAddTeacher = new JButton("Add Teacher");
	public JButton btnAddStudent = new JButton("Add Student");
	public JButton btnAddCourse = new JButton("Add Course");
	public JButton btnUpdateTeacher = new JButton("Update Teacher");
	public JButton btnUpdateStudent = new JButton("Update Student");
	public JButton btnDeleteStudent = new JButton("Delete Student");
	public JButton btnUpdateCourse = new JButton("Update Course");
	public JButton btnDeleteCourse = new JButton("Delete Course");
	public JButton btnSubmit = new JButton("Submit");

	public TeacherView() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(221, 160, 221));
		frame.setBounds(100, 100, 720, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 302, 619, 232);
		frame.getContentPane().add(tabbedPane);
		
		// first tab
		final TeacherRepo trepo = new TeacherRepo();
		String[] teacher_cols = {"id","name","e-mail"};
		List<Teacher> teacher_list = trepo.viewAllTeachers();
		Object[][] teacher_data = null;
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Teachers", null, scrollPane, null);
		tabbedPane.setBackgroundAt(0, new Color(173, 255, 47));
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
		tabbedPane.setBackgroundAt(1, new Color(220, 20, 60));
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
		tabbedPane.setBackgroundAt(2, new Color(30, 144, 255));
		table_2 = new JTable(new DefaultTableModel(course_data, course_cols));
		scrollPane_2.setColumnHeaderView(table_2);
		scrollPane_2.setViewportView(table_2);
		DefaultTableModel model_order_table_2 = (DefaultTableModel) table_2.getModel();
		for(int i=0;i<course_list.size();i++)
			model_order_table_2.addRow(new Object[]{course_list.get(i).getId(),course_list.get(i).getName()/*,trepo.getTeacherNameByID(course_list.get(i).getTeacher())*/});			
		
		// fourth tab
		final EnrolmentRepo erepo = new EnrolmentRepo();
		String[] grade_cols = {"id","course","student","grade"};
		List<Enrolment> enrolment_list = erepo.viewAllEnrolments();
		Object[][] grade_data = null;
		JScrollPane scrollPane_3 = new JScrollPane();
		tabbedPane.addTab("Grades", null, scrollPane_3, null);
		tabbedPane.setBackgroundAt(3, new Color(199, 21, 133));
		table_3 = new JTable(new DefaultTableModel(grade_data, grade_cols));
		scrollPane_3.setColumnHeaderView(table_3);
		scrollPane_3.setViewportView(table_3);
		DefaultTableModel model_order_table_3 = (DefaultTableModel) table_3.getModel();
		for(int i=0;i<enrolment_list.size();i++)
			model_order_table_3.addRow(new Object[]{enrolment_list.get(i).getId(),enrolment_list.get(i).getCourse()/*.getName()*/,enrolment_list.get(i).getStudent()/*.getName()*/,enrolment_list.get(i).getGrade()});			
		
		// add a new student
		JLabel lblAddANew = new JLabel("Add a new Student");
		lblAddANew.setForeground(new Color(0, 0, 0));
		lblAddANew.setBackground(new Color(186, 85, 211));
		lblAddANew.setBounds(490, 40, 106, 14);
		frame.getContentPane().add(lblAddANew);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(478, 80, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(478, 105, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("CNP:");
		lblNewLabel_1.setBounds(478, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdentificationNumber = new JLabel("Identification Nr: ");
		lblIdentificationNumber.setBounds(478, 155, 137, 14);
		frame.getContentPane().add(lblIdentificationNumber);
		
		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(478, 180, 46, 14);
		frame.getContentPane().add(lblGroup);
		
		textField_sname = new JTextField();
		textField_sname.setBounds(550, 77, 100, 20);
		frame.getContentPane().add(textField_sname);
		textField_sname.setColumns(10);
		
		textField_semail = new JTextField();
		textField_semail.setBounds(550, 102, 100, 20);
		frame.getContentPane().add(textField_semail);
		textField_semail.setColumns(10);
		
		textField_scnp = new JTextField();
		textField_scnp.setBounds(550, 127, 100, 20);
		frame.getContentPane().add(textField_scnp);
		textField_scnp.setColumns(10);
		
		textField_sidnr = new JTextField();
		textField_sidnr.setBounds(611, 152, 39, 20);
		frame.getContentPane().add(textField_sidnr);
		textField_sidnr.setColumns(10);
		
		textField_sgroup = new JTextField();
		textField_sgroup.setBounds(550, 180, 100, 20);
		frame.getContentPane().add(textField_sgroup);
		textField_sgroup.setColumns(10);
		
		btnAddStudent.setBackground(new Color(255, 215, 0));
		btnAddStudent.setBounds(522, 205, 128, 23);
		frame.getContentPane().add(btnAddStudent);

		// add a new teacher
		JLabel lblNewLabel = new JLabel("Add a new Teacher");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(153, 50, 204));
		lblNewLabel.setBounds(57, 40, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel labelName = new JLabel("Name:");
		labelName.setBounds(31, 80, 46, 14);
		frame.getContentPane().add(labelName);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(31, 105, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_TeacherName = new JTextField();
		textField_TeacherName.setBounds(98, 77, 100, 20);
		frame.getContentPane().add(textField_TeacherName);
		textField_TeacherName.setColumns(10);
		
		textField_TeacherEmail = new JTextField();
		textField_TeacherEmail.setBounds(98, 102, 100, 20);
		frame.getContentPane().add(textField_TeacherEmail);
		textField_TeacherEmail.setColumns(10);
		
		btnAddTeacher.setBackground(new Color(255, 140, 0));
		btnAddTeacher.setForeground(new Color(0, 0, 0));
		btnAddTeacher.setBounds(70, 133, 128, 23);
		frame.getContentPane().add(btnAddTeacher);
	
	// add a new course
	JLabel lblAddANew_1 = new JLabel("Add a new Course");
	lblAddANew_1.setForeground(new Color(0, 0, 0));
	lblAddANew_1.setBounds(266, 40, 105, 14);
	frame.getContentPane().add(lblAddANew_1);
	
	textField_courseName = new JTextField();
	textField_courseName.setBounds(307, 77, 100, 20);
	frame.getContentPane().add(textField_courseName);
	textField_courseName.setColumns(10);
	
	JLabel lblName_1 = new JLabel("Name:");
	lblName_1.setBounds(251, 80, 46, 14);
	frame.getContentPane().add(lblName_1);
	
	btnAddCourse.setBackground(new Color(30, 144, 255));
	btnAddCourse.setBounds(277, 130, 128, 26);
	frame.getContentPane().add(btnAddCourse);
	
	//// updates and deletes
	JLabel lblId = new JLabel("ID:");
	lblId.setBounds(31, 152, 29, 14);
	frame.getContentPane().add(lblId);
	
	textField_idt = new JTextField();
	textField_idt.setBounds(31, 177, 29, 20);
	frame.getContentPane().add(textField_idt);
	textField_idt.setColumns(10);
	
	btnDeleteTeacher.setBackground(new Color(255, 140, 0));
	btnDeleteTeacher.setBounds(70, 205, 128, 23);
	frame.getContentPane().add(btnDeleteTeacher);
	
	btnUpdateTeacher.setBackground(new Color(255, 140, 0));
	btnUpdateTeacher.setBounds(70, 171, 128, 23);
	frame.getContentPane().add(btnUpdateTeacher);
	
	btnUpdateStudent.setBackground(new Color(255, 215, 0));
	btnUpdateStudent.setBounds(522, 239, 128, 23);
	frame.getContentPane().add(btnUpdateStudent);
	
	btnDeleteStudent.setBackground(new Color(255, 215, 0));
	btnDeleteStudent.setBounds(522, 273, 128, 23);
	frame.getContentPane().add(btnDeleteStudent);
	
	JLabel lblId_1 = new JLabel("ID:");
	lblId_1.setBounds(478, 209, 46, 14);
	frame.getContentPane().add(lblId_1);
	
	textField_ids = new JTextField();
	textField_ids.setBounds(478, 231, 29, 20);
	frame.getContentPane().add(textField_ids);
	textField_ids.setColumns(10);
	
	btnUpdateCourse.setBackground(new Color(30, 144, 255));
	btnUpdateCourse.setBounds(279, 171, 128, 23);
	frame.getContentPane().add(btnUpdateCourse);
	
	btnDeleteCourse.setBackground(new Color(30, 144, 255));
	btnDeleteCourse.setBounds(279, 205, 128, 23);
	frame.getContentPane().add(btnDeleteCourse);
	
	JLabel lblId_2 = new JLabel("ID:");
	lblId_2.setBounds(230, 155, 46, 14);
	frame.getContentPane().add(lblId_2);
	
	textField_idc = new JTextField();
	textField_idc.setBounds(230, 177, 29, 20);
	frame.getContentPane().add(textField_idc);
	textField_idc.setColumns(10);
	
	// give grades
	JLabel lblGiveGrade = new JLabel("Give grade");
	lblGiveGrade.setBounds(49, 265, 78, 14);
	frame.getContentPane().add(lblGiveGrade);
	
	textField_grade = new JTextField();
	textField_grade.setBounds(119, 259, 35, 20);
	frame.getContentPane().add(textField_grade);
	textField_grade.setColumns(10);
	
	JLabel lblToStudent = new JLabel("to student");
	lblToStudent.setBounds(164, 265, 67, 14);
	frame.getContentPane().add(lblToStudent);
	
	textField_student = new JTextField();
	textField_student.setBounds(230, 259, 35, 20);
	frame.getContentPane().add(textField_student);
	textField_student.setColumns(10);

	JLabel lblAtCourse = new JLabel("at course");
	lblAtCourse.setBounds(273, 262, 61, 14);
	frame.getContentPane().add(lblAtCourse);
	
	textField_course = new JTextField();
	textField_course.setBounds(344, 262, 32, 20);
	frame.getContentPane().add(textField_course);
	textField_course.setColumns(10);
	
	btnSubmit.setBackground(new Color(220, 20, 60));
	btnSubmit.setBounds(391, 261, 78, 23);
	frame.getContentPane().add(btnSubmit);
	}

	public JTextField getTextField_sname() {
		return textField_sname;
	}

	public JTextField getTextField_semail() {
		return textField_semail;
	}

	public JTextField getTextField_scnp() {
		return textField_scnp;
	}

	public JTextField getTextField_sidnr() {
		return textField_sidnr;
	}

	public JTextField getTextField_sgroup() {
		return textField_sgroup;
	}

	public JTextField getTextField_TeacherName() {
		return textField_TeacherName;
	}

	public JTextField getTextField_TeacherEmail() {
		return textField_TeacherEmail;
	}

	public JTextField getTextField_courseName() {
		return textField_courseName;
	}

	public JTextField getTextField_idt() {
		return textField_idt;
	}
	
	public JTextField getTextField_ids() {
		return textField_ids;
	}

	public JTextField getTextField_idc() {
		return textField_idc;
	}

	public JTextField getTextField_grade() {
		return textField_grade;
	}

	public JTextField getTextField_student() {
		return textField_student;
	}

	public JTextField getTextField_course() {
		return textField_course;
	}

	// action listeners
	public void setActionListenerAddTeacher(ActionListener e) {
		this.btnAddTeacher.addActionListener(e);
	}
	public void setActionListenerUpdateTeacher(ActionListener e) {
		this.btnUpdateTeacher.addActionListener(e);
	}
	public void setActionListenerDeleteTeacher(ActionListener e) {
		this.btnDeleteTeacher.addActionListener(e);
	}
	public void setActionListenerAddStudent(ActionListener e) {
		this.btnAddStudent.addActionListener(e);
	}
	public void setActionListenerUpdateStudent(ActionListener e) {
		this.btnUpdateStudent.addActionListener(e);
	}
	public void setActionListenerDeleteStudent(ActionListener e) {
		this.btnDeleteStudent.addActionListener(e);
	}
	public void setActionListenerAddCourse(ActionListener e) {
		this.btnAddCourse.addActionListener(e);
	}
	public void setActionListenerUpdateCourse(ActionListener e) {
		this.btnUpdateCourse.addActionListener(e);
	}
	public void setActionListenerDeleteCourse(ActionListener e) {
		this.btnDeleteCourse.addActionListener(e);
	}
	public void setActionListenerSubmitGrade(ActionListener e) {
		this.btnSubmit.addActionListener(e);
	}
}
