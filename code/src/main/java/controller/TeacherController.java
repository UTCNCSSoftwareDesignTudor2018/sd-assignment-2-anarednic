package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.Course;
import model.Enrolment;
import model.Student;
import model.Teacher;
import repo.CourseRepo;
import repo.EnrolmentRepo;
import repo.StudentRepo;
import repo.TeacherRepo;
import view.TeacherView;

public class TeacherController {
	TeacherView tview = new TeacherView();
	StudentRepo srepo = new StudentRepo();
	TeacherRepo trepo = new TeacherRepo();
	CourseRepo crepo = new CourseRepo();
	EnrolmentRepo erepo = new EnrolmentRepo();
	public TeacherController() {
		this.tview.setActionListenerAddTeacher(new AddTeacherListener());
		this.tview.setActionListenerAddStudent(new AddStudentListener());
		this.tview.setActionListenerAddCourse(new AddCourseListener());
		this.tview.setActionListenerDeleteTeacher(new DeleteTeacherListener());
		this.tview.setActionListenerDeleteStudent(new DeleteStudentListener());
		this.tview.setActionListenerDeleteCourse(new DeleteCourseListener());
		this.tview.setActionListenerUpdateTeacher(new UpdateTeacherListener());
		this.tview.setActionListenerUpdateStudent(new UpdateStudentListener());
		this.tview.setActionListenerUpdateCourse(new UpdateCourseListener());
		this.tview.setActionListenerSubmitGrade(new SubmitListener());
	}
	   
	   class AddTeacherListener implements ActionListener{ 
		   public void actionPerformed(ActionEvent arg0) {
				try {
					if ((tview.getTextField_TeacherName().getText().isEmpty())||(tview.getTextField_TeacherEmail().getText().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Please introduce all data");					
					} else {
					String regex_email="^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
					Pattern p =Pattern.compile(regex_email);
					Matcher m = p.matcher(tview.getTextField_TeacherEmail().getText());
					if(m.find()==false) {
						JOptionPane.showMessageDialog(null, "Invalid Teacher E-mail");					
					}else
					{
						Teacher t = new Teacher();
						t.setName(tview.getTextField_TeacherName().getText());
						t.setEmail(tview.getTextField_TeacherEmail().getText());
						trepo.insertTeacher(t);
					}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	   }
	   
	   class UpdateTeacherListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					/**/
				int idt = Integer.parseInt(textField_idt.getText());
				Teacher new_teacher=new Teacher();
				new_teacher = teacherlogic.viewTeacher(idt);
				new_teacher.setEmail(textField_TeacherEmail.getText());
				new_teacher.setName(textField_TeacherName.getText());
				new_teacher.setPassword(textField_TeacherPassword.getText());
				teacherlogic.updateTeacher(new_teacher);/**/
				}
				catch (Exception e1) {
				}
			}
	   }

	   class DeleteTeacherListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					trepo.deleteTeacher(Integer.parseInt(tview.getTextField_idt().getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		   }
	    }
	   
	   class AddStudentListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					if ((tview.getTextField_sname().getText().isEmpty())||(tview.getTextField_semail().getText().isEmpty())||(tview.getTextField_sidnr().getText().isEmpty())||(tview.getTextField_sgroup().getText().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Please introduce all data");					
					} else {
					String regex_email="^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
					Pattern p =Pattern.compile(regex_email);
					Matcher m = p.matcher(tview.getTextField_semail().getText());
					if(m.find()==false) {
						JOptionPane.showMessageDialog(null, "Invalid Student E-mail");					
					}else {
						Student s = new Student();
						s.setName(tview.getTextField_sname().getText());
						s.setEmail(tview.getTextField_semail().getText());
						s.setIdentificationNr(tview.getTextField_sidnr().getText());
						s.setCnp(tview.getTextField_scnp().getText());
						s.setGroup(tview.getTextField_sgroup().getText());
						srepo.insertStudent(s);
					}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	   }
	   
	   class UpdateStudentListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {/**/
				int ids = Integer.parseInt(textField_ids.getText());
				Student new_student=new Student();
				new_student = studentlogic.viewStudent(ids);
				new_student.setEmail(textField_semail.getText());
				new_student.setName(textField_sname.getText());
				new_student.setPassword(textField_spass.getText());
				new_student.setCNP(textField_scnp.getText());
				new_student.setIdentificationNr(textField_sidnr.getText());
				new_student.setGroup(textField_sgroup.getText());
				studentlogic.updateStudent(new_student);/**/
				}
				catch (Exception e1) {
				}
			}
	   }
	   
	   class DeleteStudentListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					srepo.deleteStudent(Integer.parseInt(tview.getTextField_ids().getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	   }
	   
	   class AddCourseListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					Course c = new Course();
					c.setName(tview.getTextField_courseName().getText());
					crepo.insertCourse(c);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	   }
	   
	   class UpdateCourseListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
				/**/int idc = Integer.parseInt(tview.getTextField_idc().getText());
				Course new_course=new Course();
				new_student = studentlogic.viewStudent(ids);
				new_student.setEmail(textField_semail.getText());
				new_student.setName(textField_sname.getText());
				new_student.setPassword(textField_spass.getText());
				new_student.setCNP(textField_scnp.getText());
				new_student.setIdentificationNr(textField_sidnr.getText());
				new_student.setGroup(textField_sgroup.getText());
				studentlogic.updateStudent(new_student);/**/
				}
				catch (Exception e1) {
				}
			}
	   }
	   
	   class DeleteCourseListener implements ActionListener{
		   public void actionPerformed(ActionEvent e) {
				try {
					crepo.deleteCourse(Integer.parseInt(tview.getTextField_idc().getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	   }
	   
	   class SubmitListener implements ActionListener{
		   public void actionPerformed(ActionEvent arg0) {
				try {
					Course new_c = new Course();
					new_c.setId(Integer.parseInt(tview.getTextField_course().getText()));
					Student new_s=new Student();
					new_s.setId(Integer.parseInt(tview.getTextField_student().getText()));
					Enrolment new_e = new Enrolment();
					new_e.setCourse(new_c);
					new_e.setStudent(new_s);
					new_e.setGrade(Integer.parseInt(tview.getTextField_grade().getText()));
					erepo.insertEnrolment(new_e);
				} catch (Exception e) {}
			}
	   }
}
