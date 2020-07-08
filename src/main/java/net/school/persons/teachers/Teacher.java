package net.school.persons.teachers;

import java.util.ArrayList;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;
import net.school.persons.Spendable;

public class Teacher extends Person implements Spendable{
	
	private int token;
	
	private int lessonsTaught;
	
	private ArrayList<Subject> qualifiedSubjects;
	
	public Teacher(String firstName, String lastName, String email) {
		
		super(firstName, lastName, email);
		
		qualifiedSubjects = new ArrayList<>();
	}
	
	public int getTokens() {
		return token;
	}
	
	public void deductTokens(int amount) {
		token -= amount;
	}
	
	public void addTokens(int amount) {
		token += amount;
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
