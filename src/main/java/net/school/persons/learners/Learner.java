package net.school.persons.learners;

import java.util.ArrayList;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;

public class Learner extends Person {
	
	private ArrayList<Subject> registeredSubjects;
	
	private int tokens;
	
	private boolean attendingLesson;
	
	public Learner(String firstName, String lastName, String email, ArrayList<Subject> registeredSubjects) {
		
		super(firstName, lastName, email);
		
		this.registeredSubjects = registeredSubjects;
	}
	
	public boolean getAttendingLesson() {
		return attendingLesson;
	}
	
	public void setAttendingLesson(boolean attending) {
		attendingLesson = true;
	}
	
	public int getTokens() {
		return tokens;
	}
	
	public String attendLesson(Lesson lesson) {
		if(attendingLesson)
			return this.getFullName() + " already attending a lesson";
			
		if(registeredSubjects.size() < 3) 
			return this.getFullName() + " must be registered for 3 or more subjects to attend lesson";
		
		for(Subject sub: registeredSubjects)
			if(lesson.getSubject() == sub) {
				setAttendingLesson(true);
				lesson.addLearnerLesson(this);
				tokens += 3; 
				return this.getFullName() + " attending lesson";
			}
		
		return this.getFullName() + " not registered for lesson";
	}
}
