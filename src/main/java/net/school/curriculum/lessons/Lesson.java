package net.school.curriculum.lessons;

import java.time.LocalTime;
import java.util.ArrayList;

import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

public class Lesson {
	
	private Teacher teacher;
	
	private LocalTime time;
	
	private Subject subject;
	
	private LessonStatus lessonStatus;
	
	private ArrayList<Learner> learnersAttending;
	
	public Lesson(Teacher teacher, LocalTime time, Subject subject) {
		
		this.teacher = teacher;
		
		this.time = time;
		
		this.subject = subject;
		
		this.learnersAttending = new ArrayList<> ();
		
		this.lessonStatus = LessonStatus.PENDING;
		
		Principal.incrementLessonCount(this);
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
	
	public LessonStatus getLessonStatus() {
		return lessonStatus;
	}
	
	public void setLessonStatus(LessonStatus ls) {
		lessonStatus = ls;
	}
	
	public void setAttendingToFalse() {
		for(Learner l: learnersAttending) 
			l.setAttendingLesson(false);
	}
	
	public boolean addLearnerLesson(Learner learner) {
		if(learnersAttending.add(learner))
			return true;
		
		return false;
	}
	
	public boolean isCancelled() {
		if(learnersAttending.size() < 5) {
			lessonStatus = LessonStatus.CANCELLED;
			
			return true;
		}
			
		return false;
	}
	
	public String start() {
		if(isCancelled()) {
			setAttendingToFalse();
			
			Principal.incrementCancelledLessonCount();
			
			return "Lesson has been cancelled";
		}
			
		
		lessonStatus = LessonStatus.ACTIVE;
		
		return "Lesson has been started";
	}
	
	public String end() {
		if(lessonStatus == LessonStatus.ACTIVE) {
			lessonStatus = LessonStatus.COMPLETED;
			
			setAttendingToFalse();
			
			return "Lesson is finished";
		}
		
		return "Lesson is " + getLessonStatus();
	}
}
