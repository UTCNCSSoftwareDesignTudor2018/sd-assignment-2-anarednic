package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Enrolment;

public class EnrolmentRepo {
	public void insertEnrolment(Enrolment e){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.merge(e);
        eniEntityManager.getTransaction().commit();
        eniEntityManager.close();
        entityManagerFactory.close();
    }
	public List<Enrolment> viewAllEnrolments(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager eniEntityManager = entityManagerFactory.createEntityManager();
        eniEntityManager.getTransaction().begin();
        eniEntityManager.flush();  
        List<Enrolment> listEnrolments = eniEntityManager.createQuery("SELECT e FROM Enrolment e").getResultList();
	    eniEntityManager.getTransaction().commit();
	    eniEntityManager.close();
        entityManagerFactory.close();
	    return listEnrolments;
    }
}
