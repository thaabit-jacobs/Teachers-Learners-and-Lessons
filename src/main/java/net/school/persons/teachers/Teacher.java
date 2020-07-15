package net.school.persons.teachers;

import java.util.ArrayList;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.LessonStatus;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Consumer;

public class Teacher extends Consumer{
	
	private int lessonsTaught;
	
	private ArrayList<Subject> qualifiedSubjects;
	
	public Teacher(String firstName, String lastName, String email) {
		
		super(firstName, lastName, email);
		
		qualifiedSubjects = new ArrayList<>();
	}
	
	public void incrementLessonTaught() {
		lessonsTaught++;
	}
	public ArrayList<Subject> getQualifiedSubjects(){
		return qualifiedSubjects;
	}
	
	public String teach(Lesson lesson) {
		if(lesson.isQualifiedToTeachSubject()) {			
			return lesson.start();
		}
		
		return getFirstName() + " is not qualified to teach lesson";
	}
	
	public String endLesson(Lesson lesson) {
		if(lesson.getLessonStatus() == LessonStatus.ACTIVE) {
			return lesson.end();
		}
		
		return "Lesson could not be finished";
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
