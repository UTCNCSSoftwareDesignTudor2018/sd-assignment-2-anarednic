package appStart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Course;
import model.Enrolment;
import model.Student;
import model.Teacher;
import mongoDB.EstablishConnection;
import repo.CourseRepo;
import repo.EnrolmentRepo;
import repo.StudentRepo;
import repo.TeacherRepo;
import view.FirstFrame;

public class AppStart {
	
	public static void main(String[] args) {
		//create reports Mongo
		/**/EstablishConnection con= new EstablishConnection();
		con.createSingleReport();/**/
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
		
        new FirstFrame();
        
		StudentRepo srepo = new StudentRepo();
		Student s = new Student();
		s.setName("Ana-Rednic");
		s.setCnp("290606");
		s.setEmail("ana_rednic@yahoo.com");
		s.setGroup("30432");
		s.setIdentificationNr("20453");
		srepo.insertStudent(s);
		
		Student s2 = new Student();
		s2.setName("Paula Suciu");
		s2.setCnp("294503");
		s2.setEmail("paula.suciu@gmail.com");
		s2.setGroup("30234");
		s2.setIdentificationNr("23421");
		srepo.insertStudent(s2);

		Student s3 = new Student();
		s3.setName("Ioana Cutean");
		s3.setCnp("289032");
		s3.setEmail("cutean_ioana@yahoo.com");
		s3.setGroup("30235");
		s3.setIdentificationNr("23432");
		srepo.insertStudent(s3);
		
		TeacherRepo trepo=new TeacherRepo();
		
		Teacher t=new Teacher();
		t.setName("Tudor Vlad");
		t.setEmail("tudor.vlad@cs.utcluj.ro");
		trepo.insertTeacher(t);
		
		Teacher t2=new Teacher();
		t2.setName("Rodica Potolea");
		t2.setEmail("rodica_pot@cs.utcluj.ro");
		trepo.insertTeacher(t2);
		
		Teacher t3=new Teacher();
		t3.setName("Camelia Lemnaru");
		t3.setEmail("camelia.v@cs.utcluj.ro");
		trepo.insertTeacher(t3);

		CourseRepo crepo = new CourseRepo();
		
		Course c=new Course();
		c.setName("SD");
		c.setTeacher(t);
		crepo.insertCourse(c);
		
		Course c2=new Course();
		c2.setName("LP");
		c2.setTeacher(t2);
		crepo.insertCourse(c2);
		
		Course c3=new Course();
		c3.setName("DMP");
		c3.setTeacher(t3);
		crepo.insertCourse(c3);
		
		EnrolmentRepo erepo = new EnrolmentRepo();
		
		Enrolment e=new Enrolment();
		e.setGrade(9);
		e.setStudent(s);
		e.setCourse(c);
		erepo.insertEnrolment(e);
		
		Enrolment e2=new Enrolment();
		e2.setGrade(10);
		e2.setStudent(s2);
		e2.setCourse(c2);
		erepo.insertEnrolment(e2);
		
		Enrolment e3=new Enrolment();
		e3.setGrade(5);
		e3.setStudent(s3);
		e3.setCourse(c3);
		erepo.insertEnrolment(e3);
	}
}
