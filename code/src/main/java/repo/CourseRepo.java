package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Course;

public class CourseRepo {
	public void insertCourse(Course c){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.merge(c);
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
    }
	public void updateCourse(Course c){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();  
        eniEntityManager.find(Course.class, c.getId());
    	//c.setStatus("ACTIVE");
    	//eniEntityManager.commit();
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
        }
	public void deleteCourse(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();   
        Course c = new Course();
        c.setId(id);
        eniEntityManager.find(Course.class, c.getId());
        eniEntityManager.remove(c);
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
        }
	public List<Course> viewAllCourses(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();  
        List<Course> listCourses = eniEntityManager.createQuery("SELECT c FROM Course c").getResultList();
	    eniEntityManager.getTransaction().commit();
	    eniEntityManager.close();
        entityManagerFactory.close();
        return listCourses;
    }
}
