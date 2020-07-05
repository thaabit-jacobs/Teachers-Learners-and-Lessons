package net.school.curriculum.lessons;

import java.time.LocalTime;

import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

public class LifeSciencesLesson extends Lesson{
	
	public LifeSciencesLesson(Teacher teacher, LocalTime time) {
		super(teacher, time, Subject.LIFE_SCIENCES);
	}
}
