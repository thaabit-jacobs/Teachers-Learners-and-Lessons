package net.school.persons.principal;

import java.util.HashMap;

import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;

public class Principal extends Person{
	
	private int cancelledLessons;
	
	private HashMap<Subject , Integer> lessonCount;
	
	public Principal(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		lessonCount = new HashMap<>();
	}
	
	public void incrementCancelledLessonCount() {
		cancelledLessons++;
	}
	
	public void incrementLessonCount(Lesson lesson) {
		if(lessonCount.containsKey(lesson.getSubject())) {
			int currentLessonCount = lessonCount.get(lesson.getSubject());
			lessonCount.put(lesson.getSubject(), currentLessonCount + 1);
		} else {
			int currentLessonCount = 1;
			lessonCount.put(lesson.getSubject(), currentLessonCount);
		}
	}
}
