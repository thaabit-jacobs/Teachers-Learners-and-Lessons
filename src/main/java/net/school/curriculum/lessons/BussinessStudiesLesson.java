package net.school.curriculum.lessons;

import java.time.LocalTime;

import net.school.curriculum.subjects.Subject;
import net.school.persons.teachers.Teacher;

public class BussinessStudiesLesson extends Lesson{
	
	public BussinessStudiesLesson(Teacher teacher, LocalTime time) {
		super(teacher, time, Subject.BUSSINESS_STUDIES);
	}
}
