package net.school.curriculum.lessons;

import java.time.LocalTime;

import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

public class PhyscialEducationsLesson extends Lesson{

	public PhyscialEducationsLesson(Teacher teacher, LocalTime time) {
		super(teacher, time, Subject.PHYSICAL_EDUCATIONS);
	}
}
