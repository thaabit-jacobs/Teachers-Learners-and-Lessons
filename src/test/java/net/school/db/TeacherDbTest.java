package net.school.db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class TeacherDbTest {

	private TeacherDb db = new TeacherDb();
	
	
	@Test
	void shouldReturnTeacherId() {
		int teacherId = db.getTeacherId("lindas@gmail.com");
		assertEquals(1, teacherId);
	}
	
	@Test
	void shoudlReturnZeroForTeacherEmailTHatdoesNotExist()
	{
		int teacherId = db.getTeacherId("lind@gmail.com");
		assertEquals(0, teacherId);
	}

	@Test
	void shouldReturnTrueForValidEmail()
	{
		boolean teacherExist = db.teacherExist("lindas@gmail.com");
		assertTrue(teacherExist);
	}
	
	@Test
	void shouldReturnFalseForValidEmail()
	{
		boolean teacherExist = db.teacherExist("lind@gmail.com");
		assertFalse(teacherExist);
	}
	
	@Test
	void shouldReturnTeacherLessonCount()
	{
		int teacherLessonCount = db.getTeacherLessonCount("lindas@gmail.com");
		assertEquals(0, teacherLessonCount);
	}
	
	@Test
	void shouldReturnTeacherLessonCountOfMinusOneForInvalidEmail()
	{
		int teacherLessonCount = db.getTeacherLessonCount("lind@gmail.com");
		assertEquals(-1, teacherLessonCount);
	}
	
	@Test
	void shouldReturnTEacherEmailForValidId()
	{
		String teacherEmail = db.getTeacherEmail(1);
		assertEquals("lindas@gmail.com", teacherEmail);
	}
		
	
	@Test
	void shouldReturnEmptyStringForInvalidIdEmail()
	{
		String teacherEmail = db.getTeacherEmail(10);
		assertEquals("", teacherEmail);
	}
}
