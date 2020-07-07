package net.school.persons.learners;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
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
	
	private HashMap<Lesson, AquiredType> notes;
	
	private boolean attendingLesson;
	
	public Learner(String firstName, String lastName, String email) {
		
		super(firstName, lastName, email);
		
		registeredSubjects = new ArrayList<>();
		
		notes = new HashMap<>();
	}
	
	public boolean getAttendingLesson() {
		return attendingLesson;
	}
	
	public HashMap<Lesson, AquiredType> getNotes() {
		return notes;
	}
	
	public String attendLesson(Lesson lesson) {
			if(hasThreeOrMoreSubjects() && registeredForSubject(lesson.getSubject()) && !attendingLesson) {
				lesson.addLearnerLesson(this);
				addTokens(3);
				notes.put(lesson, AquiredType.ATTENDED_LESSON);
				attendingLesson = true;
				return getFirstName() + " added to lesson";
			}
			
		return getFirstName() + " could not be added to lesson";
	}
	
	public String askForNotes(Learner learner, Lesson lesson) {
		if(hasLessonNotes(learner, lesson)) {
			if(registeredForSubject(lesson.getSubject())) {
				if(getTokens() > 2) {
					notes.put(lesson, AquiredType.BOUGHT);
					deductTokens(2);
					return "Bought lesson notes for 2 tokens";
				} else
					return "Not enough tokens";
				
			} else {
				if(getTokens() > 5) {
					notes.put(lesson, AquiredType.BOUGHT);
					deductTokens(5);
					return "Bought lesson notes for 5 tokens";
				} else
					return "Not enough tokens";
			}	
		}
		
		return learner.getFirstName() + " does not have lesson notes";
	}
	
	public boolean addSubject(Subject sub) {
		if(registeredSubjects.add(sub))
			return true;
		
		return false;
	}
	
	public boolean hasThreeOrMoreSubjects() {
		if(registeredSubjects.size() >= 3)
			return true;
		
		return false;
	}
	
	public boolean registeredForSubject(Subject subject) {
		for(Subject sub: registeredSubjects)
			if(sub == subject)
				return true;
		
		return false;
	}
	
	public boolean hasLessonNotes(Learner learner, Lesson lesson) {
		Set<Map.Entry<Lesson, AquiredType>> set = learner.getNotes().entrySet();
		
		for(Map.Entry<Lesson, AquiredType> me: set)
			if(me.getKey().equals(lesson))
				return true;
		
		return false;
	}
	
	public String status() {
		Set<Map.Entry<Lesson, AquiredType>> set = notes.entrySet();
		String status = "";
		
		for(Map.Entry<Lesson, AquiredType> me: set)
			status += me.getKey() + " : " + me.getValue() + "\n"; 
		
		status += "Tokens : " + getTokens();
		
		return status;
	}
	
	public void setAttendingLesson(boolean attending) {
		attendingLesson = attending;
	}
}
