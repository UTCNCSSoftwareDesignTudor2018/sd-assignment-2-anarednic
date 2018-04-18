package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
	@Column(name="name")
	private String name;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Enrolment> getEnrolments() {
		return enrolments;
	}
	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}
	@ManyToOne
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course", cascade=CascadeType.ALL)
	private List<Enrolment> enrolments = new LinkedList<>();
	
	public Course() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
