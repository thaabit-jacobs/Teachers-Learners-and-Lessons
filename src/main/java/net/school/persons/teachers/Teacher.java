package net.school.persons.teachers;

import java.util.ArrayList;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Consumer;

public class Teacher extends Consumer{
	
	private int lessonsTaught;
	
	private ArrayList<Subject> qualifiedSubjects;
	
	public Teacher(String firstName, String lastName, String email) {
		
		super(firstName, lastName, email);
		
		qualifiedSubjects = new ArrayList<>();
	}
	
	public String teach(Lesson lesson) {
		if(isQualifiedToTeachSubject(lesson.getSubject())) {
			lessonsTaught++;
			
			addTokens(5);
			
			return lesson.start();
		}
		
		return getFirstName() + " is not qualified to teach lesson";
	}
	
	public boolean isQualifiedToTeachSubject(Subject subject) {
		for(Subject sub: qualifiedSubjects)
			if(sub == subject)
				return true;
		
		return false;
	}
	
	public boolean addQualifiedSubject(Subject subject) {
		if(qualifiedSubjects.add(subject))
			return true;
		
		return false;
	}
	
	public boolean qualifiesForDiscount() {
		if(lessonsTaught >= 5)
			return true;
		
		return false;
	}
}
