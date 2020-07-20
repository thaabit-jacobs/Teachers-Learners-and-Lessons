package net.school.curriculum.lessons;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.person.Principal;
import net.school.person.consumer.Learner;
import net.school.person.consumer.Teacher;

public class Lesson {
	
	private static int cancelledLessonCount;
	
	private static HashMap<Subject, Integer> dailyLessons = new HashMap<>();
	
	private Teacher teacher;
	
	private Subject subject;
	
	private LocalTime time;
	
	private LessonStatus status;
	
	private ArrayList<Learner> learnersAttendingLesson;
	
	public Lesson(Teacher teacher, Subject subject, LocalTime time) {
		this.teacher = teacher;
		
		this.subject = subject;
		
		this.time = time;
		
		status = LessonStatus.PENDING;
		
		learnersAttendingLesson = new ArrayList<>();
		
		incrementDailyLessonCount();
	}
	
	public int getCancelledLessonCount(Principal prin) {
		return cancelledLessonCount;
	}
	
	public HashMap<Subject, Integer> getDailyLessonCount(Principal prin) {
		return dailyLessons;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public LessonStatus getLessonStatus() {
		return status;
	}
	
	public ArrayList<Learner> getLearnersAttendingLesson(){
		return learnersAttendingLesson;
	}
	
	public boolean attendLesson(Learner learner) {
		if(learner.canAttendLesson(subject)) {
			learner.setIsAttendLesson(true);
			return learnersAttendingLesson.add(learner);
		}
			
		return false;
	}
	
	protected boolean isLessonCancelled() {
		if(learnersAttendingLesson.size() < 5) {
			this.status = LessonStatus.CANCELLED;
			incrementCancelledLessonCount();
			setAttendingToFalse();
			return true;
		}
		
		return false;
	}
	
	protected String start() {
		if(!isLessonCancelled() && status == LessonStatus.PENDING) {
			this.status = LessonStatus.ACTIVE;
			return "Lesson has started";
		}
		
		return "Lesson is " + status.toString().toLowerCase();
	}
	
	protected String end() {
		if(status == LessonStatus.ACTIVE) {
			this.status = LessonStatus.COMPLETED;
			return "Lesson has completed";
		}
		
		return "Lesson is " + status.toString().toLowerCase();
	}
	
	public String teachLesson() {
		if(teacher.isSubjectRegsitered(subject))
			return start();
		
		return "Teacher is not qualified to teach " + subject.toString();
	}
	
	public String endLesson() {
		String endMsg = end();
		
		if(status == LessonStatus.COMPLETED) {
			updateLearnersAttendingInfo();
			teacher.addTokens(5);
			return "Lesson has completed";
		}
			
		return endMsg;
	}
	
	protected void addTokensToLearners() {
		for(Learner learner:learnersAttendingLesson)
			learner.addTokens(3);
	}
	
	protected void addNotesToLearners() {
		for(Learner learner:learnersAttendingLesson) 
			learner.getNotes().put(subject, AquiredType.ATTENDED_LESSON);
	}
	
	protected void setAttendingToFalse() {
		for(Learner l: learnersAttendingLesson) 
			l.setIsAttendLesson(false);
	}
	
	protected void incrementDailyLessonCount() {
		if(dailyLessons.containsKey(subject)) {
			int currentLessonCount = dailyLessons.get(subject);
			dailyLessons.put(subject, currentLessonCount + 1);
		} else 
			dailyLessons.put(subject, 1);
	}
	
	protected void incrementCancelledLessonCount() {
		cancelledLessonCount++;
	}
	
	protected void updateLearnersAttendingInfo() {
		addTokensToLearners();
		addNotesToLearners();
		setAttendingToFalse();
	}
	
}
