package net.school;

import java.time.LocalTime;

import net.school.curriculum.lessons.AfrikaansLesson;
import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.LifeSciencesLesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

public class School {
	
	private Principal principal = new Principal("John", "Snith", "");
	
	private Teacher linda = new Teacher("Linda", "Carl", "");
	private Teacher nkosi = new Teacher("Nkosi", "Jones", "");
	private Teacher bill = new Teacher("Bill", "James", "");
	
	private Lesson math1 = new MathLesson(linda, LocalTime.of(10, 30));
	private Lesson english = new EnglishLesson(nkosi, LocalTime.of(11, 45));
	private Lesson afrikaans = new AfrikaansLesson(bill, LocalTime.of(12, 00));
	private Lesson math2 = new MathLesson(nkosi, LocalTime.of(1, 30));
	private Lesson lifeSci = new LifeSciencesLesson(linda, LocalTime.of(2, 45));
	
	private Learner thaabit = new Learner("Thaabit", "Jacobs", "");
	private Learner mike = new Learner("Mike", "Brown", "");
	private Learner ayapha = new Learner("Mihlaya", "Ayapa", "");
	private Learner amanda = new Learner("Amanda", "Mrsg", "");
	private Learner jim = new Learner("Jim", "Jones", "");
	
	public School() {
		
		linda.addQualifiedSubject(Subject.MATH);
		linda.addQualifiedSubject(Subject.AFRIKAANS);
		
		nkosi.addQualifiedSubject(Subject.ENGLISH);
		
		bill.addQualifiedSubject(Subject.LIFE_SCIENCES);
		
		thaabit.addSubject(Subject.MATH);
		thaabit.addSubject(Subject.LIFE_SCIENCES);
		thaabit.addSubject(Subject.AFRIKAANS);
		
		
		mike.addSubject(Subject.MATH);
		mike.addSubject(Subject.GEOGRAPHY);
		mike.addSubject(Subject.AFRIKAANS);
		
		
		ayapha.addSubject(Subject.MATH);
		ayapha.addSubject(Subject.ENGLISH);
		ayapha.addSubject(Subject.AFRIKAANS);
		
		
		amanda.addSubject(Subject.MATH);
		amanda.addSubject(Subject.GEOGRAPHY);
		amanda.addSubject(Subject.LIFE_SCIENCES);
		
		
		jim.addSubject(Subject.MATH);
		jim.addSubject(Subject.GEOGRAPHY);
		jim.addSubject(Subject.LIFE_SCIENCES);
	}
}
