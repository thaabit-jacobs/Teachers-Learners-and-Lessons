package net.school.persons.teachers;

import java.util.ArrayList;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;

public class Teacher extends Person {
	
	private ArrayList<Subject> qualifiedSubjects;
	
	private int tokens;
	
	public Teacher(String firstName, String lastName, String email, ArrayList<Subject> qualifiedSubjects) {
		
		super(firstName, lastName, email);
		
		this.qualifiedSubjects = qualifiedSubjects;
	}
	
	public ArrayList<Subject> getQualifiedSubjects() {
		return qualifiedSubjects;
	}
	
	public int getTokens() {
		return tokens;
	}
	
	public String teach(Lesson lesson) {
		if(qualifiedSubjects.contains(lesson.getSubject())) {
			if(lesson.getLearnersAttending().size() < 5)
				return "Lesson has been cancelled";
			
			tokens += 5;
			return "Teaching " + lesson.getSubject().toString();
		}
		
		
		return "Teacher is not qualified to teach " + lesson.getSubject().toString();
	}
}
