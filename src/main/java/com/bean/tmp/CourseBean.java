package com.bean.tmp;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "course")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class CourseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID courseId;

	String courseName;

	@ManyToMany(mappedBy = "courses")
	Set<StudentBean> students;

	public UUID getCourseId() {
		return courseId;
	}

	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentBean> students) {
		this.students = students;
	}

}