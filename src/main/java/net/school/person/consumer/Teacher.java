package net.school.person.consumer;

import java.util.ArrayList;

import net.school.curriculum.subjects.Subject;

public class Teacher extends Consumer{
	
	private int teacherLessonCount;
	
	private ArrayList<Subject> qualifiedSubjects;
	
	public Teacher(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		qualifiedSubjects = new ArrayList<>();
	}
	
	public int getTeacherLessonCount() {
		return teacherLessonCount;
	}
	
	public boolean registerNewSubject(Subject subject) {
		if(isSubjectRegsitered(subject))
			return false;
		
		return qualifiedSubjects.add(subject);
	}
	
	public boolean isSubjectRegsitered(Subject subject){
		for(Subject sub: qualifiedSubjects)
			if(sub == subject)
				return true;
		
		return false;
	}
	
	public boolean qualiesfyForDiscount() {
		return teacherLessonCount >= 5 ? true:false;
	}
	
	public int discountedPrice(int price) {
		return (int) (price - (price * 0.25));
	}
	
	public void incrementLessonCount() {
		teacherLessonCount++;
	}
}
