package net.school.person.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.db.LearnerDb;

public class Learner extends Consumer {
	
	private final LearnerDb db = new LearnerDb();
	
	private boolean isAttendingLesson;
	
	public Learner(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	public Map<Subject, AquiredType> getNotes(){
		return db.getNotes(this);
	}
	
	public boolean getIsAttendingLesson() {
		return isAttendingLesson;
	}
	
	protected ArrayList<Subject> getRegisteredSubjects(){
		return db.getRegisteredSubjects(getEmail());
	}
	
	public boolean canAttendLesson(Subject subject) {
		return db.canAttendLesson(getEmail(), subject);
	}
	
	public boolean registerNewSubject(Subject subject) {
		return db.registerNewSubject(getEmail(), subject);
	}
	
	protected boolean isSubjectRegsitered(Subject subject){
		return db.isRegisteredSubject(getEmail(), subject);
	}
	
	protected boolean isRegisteredForThreeOrMoreSubjects() {
		return db.isRegisteredThreeOrMoreSubjects(getEmail());
	}
	
	public boolean learnerHasLessonNotes(Learner learner, Subject subject) {
		return db.learnerHasLessonNotes(learner, subject);
	}
	
	public String askNotes(Learner learner, Subject subject) {
		return db.askNotes(this, learner, subject);
	}
	
	protected String performTransaction(int amount, Subject subject) {
		return db.performTransaction(this, subject, amount);
	}
	
	public void setIsAttendLesson(boolean isAttending) {
		isAttendingLesson = isAttending;
	}
	
	public void endOfDayStatus() {
		db.endOfDayStatus(this);
	}
	
	protected void updateLearnerTokensAndLessonNotes(int amount, Subject subject) {
		db.deductTokens(this, amount);
		db.addNewLessonNotes(this, subject, AquiredType.BOUGHT);
	}
	
	
}
