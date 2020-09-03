package net.school.person.consumer;

import java.util.ArrayList;
import java.util.HashMap;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;

public class Learner extends Consumer {
	
	private boolean isAttendingLesson;
	
	private ArrayList<Subject> registeredSubjects;
	
	private HashMap<Subject, AquiredType> notes;
	
	public Learner(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		registeredSubjects = new ArrayList<>();
		
		notes = new HashMap<>();
	}
	
	public HashMap<Subject, AquiredType> getNotes(){
		return notes;
	}
	
	public boolean getIsAttendingLesson() {
		return isAttendingLesson;
	}
	
	protected ArrayList<Subject> getRegisteredSubjects(){
		return registeredSubjects;
	}
	
	public boolean canAttendLesson(Subject subject) {
		return isSubjectRegsitered(subject) && isRegisteredForThreeOrMoreSubjects() && !getIsAttendingLesson();
	}
	
	public boolean registerNewSubject(Subject subject) {
		if(isSubjectRegsitered(subject))
			return false;
		
		return getRegisteredSubjects().add(subject);
	}
	
	protected boolean isSubjectRegsitered(Subject subject){
		for(Subject sub: getRegisteredSubjects())
			if(sub == subject)
				return true;
		
		return false;
	}
	
	protected boolean isRegisteredForThreeOrMoreSubjects() {
		return getRegisteredSubjects().size() >= 3;
	}
	
	public boolean learnerHasLessonNotes(Learner learner, Subject subject) {
		return learner.getNotes().get(subject)  != null;
	}
	
	public String askNotes(Learner learner, Subject subject) {
		if(learnerHasLessonNotes(learner, subject)) {
			if(this.isSubjectRegsitered(subject)) 
				return performTransaction(2, subject);
			else
				return performTransaction(5, subject);
		}
	
		return "Learner does not have lesson notes";
	}
	
	protected String performTransaction(int amount, Subject subject) {
		if(this.hasEnoughTokens(amount)) {
			updateLearnerTokensAndLessonNotes(amount, subject);
			return "Bought lesson notes";
		}
		
		return "Not enough tokens";
	}
	
	public void setIsAttendLesson(boolean isAttending) {
		isAttendingLesson = isAttending;
	}
	
	public void addNewLessonNotes(Subject subject, AquiredType aquired) {
		notes.put(subject, aquired);
	}
	
	public void endOfDayStatus() {
		notes.forEach((subject, type) -> System.out.println(subject + ":" + type));
		System.out.println("Tokens :" + this.getTokens());
	}
	
	protected void updateLearnerTokensAndLessonNotes(int amount, Subject subject) {
		this.deductTokens(amount);
		this.addNewLessonNotes(subject, AquiredType.BOUGHT);
	}
	
	
}
