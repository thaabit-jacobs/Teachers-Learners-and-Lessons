package net.school.person;

import java.util.HashMap;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;

public class Principal extends Person{
	
	public Principal(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	public int getCancelledLessonCount(Lesson lesson) {
		return lesson.getCancelledLessonCount(this);
	}
	
	public HashMap<Subject, Integer> getDailyLessonCount(Lesson lesson){
		return lesson.getDailyLessonCount(this);
	} 
	
	public void endOfDayStatus(Lesson lesson) {
		getDailyLessonCount(lesson).forEach((subject, type) -> System.out.println(subject + ":" + type));
		System.out.println("Cancelled Lessons :" + getCancelledLessonCount(lesson));
	}
}
