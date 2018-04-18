package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Student;

public class StudentRepo {

	public void insertStudent(Student s){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();       
        eniEntityManager.persist(s);
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
        }
	public void updateStudent(Student s){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();  
        eniEntityManager.find(Student.class, s.getId());
    	//s.setStatus("ACTIVE");
    	//eniEntityManager.commit();
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
        }
	public void deleteStudent(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();   
        Student s = new Student();
        s.setId(id);
        eniEntityManager.find(Student.class, s.getId());
      //  eniEntityManager.remove(s);
        eniEntityManager.detach(s);
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
        }
	public List<Student> viewAllStudents(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();  
        List<Student> listStudents = eniEntityManager.createQuery("SELECT s FROM Student s").getResultList();
	    eniEntityManager.getTransaction().commit();
	    eniEntityManager.close();
        entityManagerFactory.close();
        return listStudents;
    }
}
