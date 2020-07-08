package net.school.persons.principal;

import java.time.LocalTime;
import java.util.HashMap;

import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.GeographyLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.Person;
import net.school.persons.learners.Learner;
import net.school.persons.teachers.Teacher;

public class Principal extends Person {
	
	private static int cancelledLessonsForTheDay;
	
	private static HashMap<Subject , Integer> LessonCount = new HashMap<Subject , Integer>();
	
	public Principal(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		LessonCount.put(Subject.MATH, 0);
		LessonCount.put(Subject.AFRIKAANS, 0);
		LessonCount.put(Subject.ENGLISH, 0);
		LessonCount.put(Subject.BUSSINESS_STUDIES, 0);
		LessonCount.put(Subject.GEOGRAPHY, 0);
		LessonCount.put(Subject.PHYSICAL_EDUCATIONS, 0);
		LessonCount.put(Subject.LIFE_SCIENCES, 0);
	}
	
	public static void incrementCancelledLessonCount() {
		cancelledLessonsForTheDay++;
	}
	
	public int getCancelledLessonCount() {
		return cancelledLessonsForTheDay;
	}
	
	public static void incrementLessonCount(Lesson lesson) {
		int currentLessonCount = LessonCount.get(lesson.getSubject());
		LessonCount.put(lesson.getSubject(), currentLessonCount + 1);
	}
	
	public HashMap<Subject , Integer> getLessonCount() {
		return LessonCount;
	}
}
