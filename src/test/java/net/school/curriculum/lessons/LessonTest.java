package net.school.curriculum.lessons;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Learner;
import net.school.person.consumer.Teacher;

class LessonTest {
	
	private LocalTime time = LocalTime.of(13, 45);
	
	private Teacher jones = new Teacher("Jones", "John", "jones@gmail.com");
	
	private Lesson math = new Lesson(jones, Subject.MATH, time);
	
	private Learner mikey = new Learner("Mikey", "March", "mikey@gmail.com");
	private Learner job = new Learner("Job", "Done", " ");
	private Learner sean = new Learner("Sean", "Evans", " ");
	private Learner kate = new Learner("Kate", "Break", " ");
	private Learner sam = new Learner("Sam", "Smith", " ");
	
	@Test
	void shouldReturnFlaseWhenLearnerNotRegisteredForSubjectOrAttendingAnotherLesson() {
		assertEquals(false, math.attendLesson(mikey));
	}
	
	@Test
	void shouldReturnTrueWhenLearnerAttendingLesson() {
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		assertEquals(true, math.attendLesson(mikey));
	}
	
	@Test
	void shouldReturnTrueWhenLearnersAttendingIsLessThanFive() {		
		assertEquals(true, math.isLessonCancelled());
	}
	
	@Test
	void shouldReturnFalseWhenLearnersAttendingIsMoreThanOrEqualToFive() {
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		assertEquals(false, math.isLessonCancelled());
	}
	
	@Test
	void shouldReturnLessonNotStartedWhenStartingCancelledLessonAndStatusIsNotPending() {
		assertEquals("Lesson has not been started", math.start());
	}
	
	@Test
	void shouldReturnLessonHasBeenStartingWhenStartingCancelledLessonAndStatusIsNotPending() {
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		assertEquals("Lesson has started", math.start());
	}
	
	@Test
	void shouldReturnLessonCouldNotBeCompletedWhenStatusIsNotActive() {
		assertEquals("Lesson has not been completed", math.end());
	}
	
	@Test
	void shouldReturnLessonCompletedWhenStatusIsActive() {
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		math.start();
		
		assertEquals("Lesson has completed", math.end());
	}
	
	@Test
	void shouldReturnLessonHasStartedhenTaughtByTeacher() {
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		jones.registerNewSubject(Subject.MATH);
		
		assertEquals("Lesson has started", math.teachLesson());
	}
	
	@Test
	void shouldAddTokensToAllLearnersAttending(){
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		math.addTokensToLearners();
		
		assertEquals(3, math.getLearnersAttendingLesson().get(2).getTokens());
	}
	
	@Test
	void shouldSetAtteningToFalseToAllLearnersAttending(){
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		math.setAttendingToFalse();
		
		assertEquals(false, math.getLearnersAttendingLesson().get(2).getIsAttendingLesson());
	}
	
	@Test
	void shouldAddNotesToAllLearnersAttending(){
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		math.addNotesToLearners();
		
		assertEquals(AquiredType.ATTENDED_LESSON, math.getLearnersAttendingLesson().get(2).getNotes().get(Subject.MATH));
	}
	
	@Test
	void shouldReturnTeacherNotQualifiedForTeachingSubjectthatTeacherNotQualifiedFor(){
		assertEquals("Teacher is not qualified to teach MATH", math.teachLesson());
	}
	
	@Test
	void shouldReturnLessonHasStartedIfTeacherRegisteredForSubject(){
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		jones.registerNewSubject(Subject.MATH);
		
		assertEquals("Lesson has started", math.teachLesson());
	}
	
	@Test
	void shouldReturnLessonCompletedWhenLessonIsEnded(){
		mikey.registerNewSubject(Subject.MATH);
		mikey.registerNewSubject(Subject.AFRIKAANS);
		mikey.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		job.registerNewSubject(Subject.MATH);
		job.registerNewSubject(Subject.AFRIKAANS);
		job.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sean.registerNewSubject(Subject.MATH);
		sean.registerNewSubject(Subject.AFRIKAANS);
		sean.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		kate.registerNewSubject(Subject.MATH);
		kate.registerNewSubject(Subject.AFRIKAANS);
		kate.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		sam.registerNewSubject(Subject.MATH);
		sam.registerNewSubject(Subject.AFRIKAANS);
		sam.registerNewSubject(Subject.BUSSINESS_STUDIES);
		
		math.attendLesson(job);
		math.attendLesson(mikey);
		math.attendLesson(sean);
		math.attendLesson(sam);
		math.attendLesson(kate);
		
		jones.registerNewSubject(Subject.MATH);
		
		math.teachLesson();
		
		assertEquals("Lesson has completed", math.endLesson());
	}
}
