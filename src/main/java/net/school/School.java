package net.school;

import java.time.LocalTime;
import java.util.ArrayList;

import net.school.cafeteria.Cafeteria;
import net.school.curriculum.lessons.AfrikaansLesson;
import net.school.curriculum.lessons.EnglishLesson;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.lessons.LifeSciencesLesson;
import net.school.curriculum.lessons.MathLesson;
import net.school.curriculum.subjects.Subject;
import net.school.persons.caferteria_manager.CafeteriaManager;
import net.school.persons.learners.Learner;
import net.school.persons.principal.Principal;
import net.school.persons.teachers.Teacher;

public class School {
	
	Principal principal = new Principal("John", "Snith", "");
	
	CafeteriaManager cafeMan = new CafeteriaManager("Bill", "Meyers", "");

	Cafeteria cafe = new Cafeteria(cafeMan);
	
	ArrayList<Teacher> teachers = new ArrayList<>();
	ArrayList<Learner> learners = new ArrayList<>();
	ArrayList<Lesson> lessons = new ArrayList<>();
	
	public School() {
		teachers.add( new Teacher("Linda", "Carl", ""));
		teachers.add( new Teacher("Nkosi", "Jones", ""));
		teachers.add( new Teacher("Bill", "James", ""));
		
		learners.add( new Learner("Thaabit", "Jacobs", ""));
		learners.add( new Learner("Mike", "Brown", ""));
		learners.add( new Learner("Mihlaya", "Ayapa", ""));
		learners.add( new Learner("Amanda", "Mrsg", ""));
		learners.add( new Learner("Jim", "Jones", ""));
		learners.add( new Learner("Sbu", "Jones", ""));
		
		lessons.add( new MathLesson(teachers.get(0), LocalTime.of(10, 30)));
		lessons.add( new EnglishLesson(teachers.get(1), LocalTime.of(11, 45)));
		lessons.add( new AfrikaansLesson(teachers.get(0), LocalTime.of(12, 00)));
		lessons.add( new MathLesson(teachers.get(1), LocalTime.of(1, 30)));
		lessons.add( new LifeSciencesLesson(teachers.get(2), LocalTime.of(2, 45)));
		
		teachers.get(0).addQualifiedSubject(Subject.MATH);
		teachers.get(0).addQualifiedSubject(Subject.AFRIKAANS);
		
		teachers.get(1).addQualifiedSubject(Subject.ENGLISH);
		
		teachers.get(2).addQualifiedSubject(Subject.LIFE_SCIENCES);
		
		learners.get(0).addSubject(Subject.MATH);
		learners.get(0).addSubject(Subject.LIFE_SCIENCES);
		learners.get(0).addSubject(Subject.AFRIKAANS);
		
		
		learners.get(1).addSubject(Subject.MATH);
		learners.get(1).addSubject(Subject.GEOGRAPHY);
		learners.get(1).addSubject(Subject.LIFE_SCIENCES);
		
		
		learners.get(2).addSubject(Subject.MATH);
		learners.get(2).addSubject(Subject.ENGLISH);
		learners.get(2).addSubject(Subject.LIFE_SCIENCES);
		
		
		learners.get(3).addSubject(Subject.MATH);
		learners.get(3).addSubject(Subject.GEOGRAPHY);
		learners.get(3).addSubject(Subject.LIFE_SCIENCES);
		
		
		learners.get(4).addSubject(Subject.MATH);
		learners.get(4).addSubject(Subject.ENGLISH);
		learners.get(4).addSubject(Subject.LIFE_SCIENCES);
	}
	
	
}
