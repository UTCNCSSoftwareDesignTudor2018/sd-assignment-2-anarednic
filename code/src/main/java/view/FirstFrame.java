package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

import controller.StudentController;
import controller.TeacherController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstFrame {

	private JFrame frame;

	public FirstFrame() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(219, 112, 147));
		frame.setBounds(100, 100, 354, 218);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherController c =new TeacherController();
			}
		});
		btnTeacher.setBackground(new Color(0, 255, 0));
		btnTeacher.setBounds(34, 116, 106, 33);
		frame.getContentPane().add(btnTeacher);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentController s = new StudentController();
			}
		});
		btnStudent.setBackground(Color.ORANGE);
		btnStudent.setBounds(192, 116, 106, 33);
		frame.getContentPane().add(btnStudent);
		
		JLabel lblWelcomeToUtcn = new JLabel("Welcome to UTCN server!");
		lblWelcomeToUtcn.setBounds(87, 21, 176, 26);
		frame.getContentPane().add(lblWelcomeToUtcn);
		
		JLabel lblPleaseChooseYour = new JLabel("Please choose your status:");
		lblPleaseChooseYour.setBounds(34, 76, 176, 14);
		frame.getContentPane().add(lblPleaseChooseYour);
	}
}
