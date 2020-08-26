package net.school.person.consumer;

import java.util.ArrayList;

import net.school.curriculum.subjects.Subject;
import net.school.db.TeacherDb;

public class Teacher extends Consumer{
	
	private final TeacherDb db = new TeacherDb();
	
	public Teacher(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	public TeacherDb getTeacherDb() {
		return db;
	}
	
	public int getTeacherLessonCount() {
		return db.getTeacherLessonCount(this.getEmail());
	}
	
	public boolean registerNewSubject(Subject subject) {		
		return db.registerNewSubject(this.getEmail(), subject);
	}
	
	public boolean isSubjectRegsitered(Subject subject){
		return db.isRegisteredForSubject(this.getEmail(), subject);
	}
	
	public boolean qualiesfyForDiscount() {
		return db.doesQualifyForDiscount(this.getEmail());
	}
	
	public int discountedPrice(int price) {
		return (int) (price - (price * 0.25));
	}
	
	public void incrementLessonCount() {
		db.updateLessonCount(this.getEmail());
	}
}
