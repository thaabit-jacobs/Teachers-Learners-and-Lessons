package net.school.persons.learners;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import net.school.curriculum.lessons.AfrikaansLesson;
import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;
import net.school.persons.teachers.Teacher;

public class Learner extends Person {
	
	private ArrayList<Subject> registeredSubjects;
	
	private int tokens;
	
	private boolean attendingLesson;
	
	private EnumMap<Subject, AquiredType> notes;
	
	public Learner(String firstName, String lastName, String email, ArrayList<Subject> registeredSubjects) {
		
		super(firstName, lastName, email);
		
		this.registeredSubjects = registeredSubjects;
		
		notes = new EnumMap<Subject, AquiredType>(Subject.class);
	}
	
	public boolean getAttendingLesson() {
		return attendingLesson;
	}
	
	public void setAttendingLesson(boolean attending) {
		attendingLesson = attending;
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
				
				notes.put(sub, AquiredType.ATTENDED_LESSON);
				
				tokens += 3; 
				return this.getFullName() + " attending lesson";
			}
		
		return this.getFullName() + " not registered for lesson";
	}
	
	public EnumMap<Subject, AquiredType> getNotes(){
		return notes;
	}
	
	public String askNotes(Learner learner, Subject subject) {
		Set<Map.Entry<Subject, AquiredType>> set = learner.getNotes().entrySet();
		
		for(Map.Entry<Subject, AquiredType> mapEntry: set) 
			if(mapEntry.getKey() == subject) 
				for(Subject registeredsub: registeredSubjects)
					if(registeredsub == subject) {
						if(tokens < 2)
							return "Not Enough tokens";
						else {
							tokens -= 2;
							notes.put(subject, AquiredType.BOUGHT);
							return "Bought notes for " + subject.toString() + " cost 2 tokens";
						}
						
					} else {
						if(tokens < 5)
							return "Not Enough tokens";
						else {
							tokens -= 5;
							notes.put(subject, AquiredType.BOUGHT);
							return "Bought notes for " + subject.toString() + " cost 5 tokens";
					}
				}
		
		return learner.getFullName() + " has no notes on " + subject.toString();
	}
	
	public String status() {
		Set<Map.Entry<Subject, AquiredType>> set = notes.entrySet();
		String status = "";
		
		for(Map.Entry<Subject, AquiredType> me: set)
			status += me.getKey() + " : " + me.getValue() + "\n"; 
		
		status += "Tokens : " + tokens;
		
		return status;
	}
}
