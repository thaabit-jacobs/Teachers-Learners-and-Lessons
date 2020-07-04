package net.school.curriculum.lessons;

import java.time.LocalTime;
import java.util.ArrayList;

import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.teachers.Teacher;

public class Lesson {
	
	private Teacher teacher;
	
	private LocalTime time;
	
	private Subject subject;
	
	private ArrayList<Learner> learnersAttending;
	
	public Lesson(Teacher teacher, LocalTime time, Subject subject) {
		
		this.teacher = teacher;
		
		this.time = time;
		
		this.subject = subject;
		
		this.learnersAttending = new ArrayList<> ();
		
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public ArrayList<Learner> getLearnersAttending() {
		return learnersAttending;
	}
	
	public boolean addLearnerLesson(Learner learner) {
		return learnersAttending.add(learner);
	}
}
