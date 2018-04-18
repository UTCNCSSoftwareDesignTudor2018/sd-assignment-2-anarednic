package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Course;
import model.Enrolment;
import model.Student;
import repo.EnrolmentRepo;
import repo.StudentRepo;
import repo.TeacherRepo;
import view.StudentView;

public class StudentController {
	StudentRepo srepo = new StudentRepo();
	StudentView sview = new StudentView();
	TeacherRepo trepo = new TeacherRepo();
	public StudentController() {
		this.sview.setActionListenerEnroll(new EnrollListener());
	}
	class EnrollListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			EnrolmentRepo erepo=new EnrolmentRepo();
			Course new_c = new Course();
			new_c.setId(Integer.parseInt(sview.getTextField_course().getText()));
			Student new_s=new Student();
			new_s.setId(Integer.parseInt(sview.getTextField_student().getText()));
			Enrolment new_e = new Enrolment();
			new_e.setCourse(new_c);
			new_e.setStudent(new_s);
			erepo.insertEnrolment(new_e);
		}
	}

}
