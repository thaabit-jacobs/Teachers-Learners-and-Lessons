package net.school.person.consumer;

import java.util.ArrayList;
import java.util.HashMap;

//import net.school.curriculum.lessons.Lesson;
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
	
	public boolean registerNewSubject(Subject subject) {
		if(isSubjectRegsitered(subject))
			return false;
		
		return registeredSubjects.add(subject);
	}
	
	public boolean isSubjectRegsitered(Subject subject){
		for(Subject sub: registeredSubjects)
			if(sub == subject)
				return true;
		
		return false;
	}
	
	public boolean isRegisteredForThreeOrMoreSubjects() {
		return registeredSubjects.size() >= 3 ? true:false;
	}
	
	public boolean learnerHasLessonNotes(Learner learner, Subject subject) {
		return learner.getNotes().get(subject)  != null ? true:false;
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
	
	public String performTransaction(int amount, Subject subject) {
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
	
	public void updateLearnerTokensAndLessonNotes(int amount, Subject subject) {
		this.deductTokens(amount);
		this.addNewLessonNotes(subject, AquiredType.BOUGHT);
	}
}
