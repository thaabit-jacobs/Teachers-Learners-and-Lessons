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
	
	private EnumMap<Subject, AquiredType> notes;
	
	public Learner(String firstName, String lastName, String email) {
		
		super(firstName, lastName, email);
		
		registeredSubjects = new ArrayList<>();
		
		notes = new EnumMap<Subject, AquiredType>(Subject.class);
	}
	
	public boolean addSubject(Subject sub) {
		return registeredSubjects.add(sub);
	}
	
	/*
	public EnumMap<Subject, AquiredType> getNotes(){
		return notes;
	}*/
	
	public boolean canAttendLesson() {
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
	
	public String status() {
		Set<Map.Entry<Subject, AquiredType>> set = notes.entrySet();
		String status = "";
		
		for(Map.Entry<Subject, AquiredType> me: set)
			status += me.getKey() + " : " + me.getValue() + "\n"; 
		
		status += "Tokens : " + getTokens();
		
		return status;
	}
}
