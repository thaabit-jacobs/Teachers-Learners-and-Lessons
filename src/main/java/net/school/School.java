package net.school;

import java.time.LocalTime;
import java.util.ArrayList;

import net.school.cafeteria.Cafeteria;
import net.school.curriculum.lessons.Lesson;
import net.school.curriculum.subjects.Subject;
import net.school.person.Principal;
import net.school.person.consumer.*;

public class School {
	Principal principal = new Principal("John", "Snith", "");
	
	private CafeteriaManager cafeMan = new CafeteriaManager("Bill", "Meyers", "");

	Cafeteria cafe = new Cafeteria(cafeMan);

	ArrayList<Teacher> teachers = new ArrayList<>();
	ArrayList<Learner> learners = new ArrayList<>();
	private ArrayList<Lesson> lessons = new ArrayList<>();
	
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
		learners.add( new Learner("Joshua", "Smith", ""));
		
		lessons.add( new Lesson(teachers.get(0), Subject.MATH, LocalTime.of(10, 30)));
		lessons.add( new Lesson(teachers.get(1), Subject.ENGLISH, LocalTime.of(11, 45)));
		lessons.add( new Lesson(teachers.get(2), Subject.LIFE_SCIENCES, LocalTime.of(1, 30)));
		lessons.add( new Lesson(teachers.get(1), Subject.MATH, LocalTime.of(2, 45)));
		lessons.add( new Lesson(teachers.get(0), Subject.AFRIKAANS, LocalTime.of(3, 30)));
		
		teachers.get(0).registerNewSubject(Subject.MATH);
		teachers.get(0).registerNewSubject(Subject.AFRIKAANS);
		
		teachers.get(1).registerNewSubject(Subject.MATH);
		teachers.get(1).registerNewSubject(Subject.ENGLISH);
		
		teachers.get(2).registerNewSubject(Subject.LIFE_SCIENCES);
		
		learners.get(0).registerNewSubject(Subject.MATH);
		learners.get(0).registerNewSubject(Subject.ENGLISH);
		learners.get(0).registerNewSubject(Subject.LIFE_SCIENCES);
		
		
		learners.get(1).registerNewSubject(Subject.MATH);
		learners.get(1).registerNewSubject(Subject.ENGLISH);
		learners.get(1).registerNewSubject(Subject.AFRIKAANS);
		
		
		learners.get(2).registerNewSubject(Subject.MATH);
		learners.get(2).registerNewSubject(Subject.ENGLISH);
		learners.get(2).registerNewSubject(Subject.AFRIKAANS);
		
		
		learners.get(3).registerNewSubject(Subject.MATH);
		learners.get(3).registerNewSubject(Subject.ENGLISH);
		learners.get(3).registerNewSubject(Subject.LIFE_SCIENCES);
		
		
		learners.get(4).registerNewSubject(Subject.MATH);
		learners.get(4).registerNewSubject(Subject.ENGLISH);
		learners.get(4).registerNewSubject(Subject.AFRIKAANS); 
	}
	
	protected ArrayList<Teacher> getTeacher(){
		return teachers;
	}
	
	protected ArrayList<Learner> getLearner(){
		return learners;
	}
	
	protected ArrayList<Lesson> getLesson(){
		return lessons;
	}
	
	protected Principal getPrincipal() {
		return principal;
	} 
	
	protected CafeteriaManager getCafeteriaManager() {
		return cafeMan;
	}
	
	protected Cafeteria getCafeteria() {
		return cafe;
	}
	
	protected Lesson getLesson(Subject subject, String teachersName) {
		for(Lesson les: lessons)
			if(les.getSubject() == subject && les.getTeacher().getFirstName().equalsIgnoreCase(teachersName))
				return les;
		
		return null;
	}
	
	protected Teacher getTeacher(String name) {
		for(Teacher teach: teachers)
			if(teach.getFirstName().equalsIgnoreCase(name))
				return teach;
		
		return null;
	}
	
	protected Learner getLearner(String name) {
		for(Learner learn: learners)
			if(learn.getFirstName().equalsIgnoreCase(name))
				return learn;
		
		return null;
	}
}
