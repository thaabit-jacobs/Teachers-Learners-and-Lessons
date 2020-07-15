package net.school.curriculum.lessons;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import net.school.curriculum.notes.AquiredType;
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
	
	public ArrayList<Learner> getLearnerAttending() {
		return learnersAttending;
	}
	
	public void setLessonStatus(LessonStatus ls) {
		lessonStatus = ls;
	}
	
	public void setAttendingToFalse() {
		for(Learner l: learnersAttending) 
			l.setAttendingLesson(false);
	}
	
	public boolean addLearnerLesson(Learner learner) {
		if(learner.hasThreeOrMoreSubjects() && learner.registeredForSubject(subject) && !learner.getAttendingLesson()) {
			return learnersAttending.add(learner);
		}
		
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
			
			addTokensToLearners();
			
			addNotesToLearners();
			
			teacher.addTokens(5);
			
			teacher.incrementLessonTaught();
			
			return "Lesson is finished";
		}
		
		return "Lesson is " + getLessonStatus();
	}
	
	public boolean isQualifiedToTeachSubject() {
		for(Subject sub: teacher.getQualifiedSubjects())
			if(sub == this.getSubject())
				return true;
		
		return false;
	}
	
	public void addTokensToLearners() {
		for(Learner learner:learnersAttending)
			learner.addTokens(3);
	}
	
	public void addNotesToLearners() {
		for(Learner learner:learnersAttending) 
			learner.getNotes().put(this, AquiredType.ATTENDED_LESSON);
	}
}
