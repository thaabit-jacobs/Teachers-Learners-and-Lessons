package net.school.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import net.school.curriculum.subjects.Subject;

public class TeacherDb 
{
	private final Map<Subject, Integer> subjectKey;
	
	private Connection conn;
	
	final String getTeacherWithEmailQuery = "SELECT * FROM teacher WHERE email=?";
	final String getTeacherWithIdQuery = "SELECT * FROM teacher WHERE id=?";
	final String checkIfTeacherExistQuery = "SELECT * FROM teacher_exist(?)";
	final String isSubjectRegistered = "SELECT * FROM is_subject_registered(?, ?)";
	final String addNewSubjectToTEacherQuery = "INSERT INTO teacher_subject (teacher_id, subject_id) VALUES (?, ?)";
	final String deleteRowFromTeacherAndSubjectQuery = "DELETE FROM teacher_subject WHERE teacher_id=? AND subject_id=?";
	final String updateLessonTaughtCount = "UPDATE teacher SET 	lessons_taught=? where id=?";
	
	private Statement stmt;
	private PreparedStatement pstmt;
	
	public TeacherDb()
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "thaabit", "1234");
		} catch(ClassNotFoundException fe)
		{
			System.out.println("Could load drivers");
		} catch (SQLException e) 
		{
			System.out.println("Could not connect to database");
		}
		
		subjectKey = new HashMap<>();
		subjectKey.put(Subject.MATH, 1);
		subjectKey.put(Subject.ENGLISH, 2);
		subjectKey.put(Subject.AFRIKAANS, 3);
		subjectKey.put(Subject.LIFE_SCIENCES, 4);
		subjectKey.put(Subject.GEOGRAPHY, 5);
		subjectKey.put(Subject.BUSSINESS_STUDIES, 6);
		subjectKey.put(Subject.PHYSICAL_EDUCATIONS, 7);
		
	}
	
	public int getTeacherLessonCount(String email)
	{
		int teacherLessonCount = -1;
		
		ResultSet rs = null;
		
		if(teacherExist(email))
		{					
			try 
			{
				pstmt = conn.prepareStatement(getTeacherWithEmailQuery);
				pstmt.setString(1, email);
				
				rs = pstmt.executeQuery();
				
				rs.next();
				
				teacherLessonCount = rs.getInt("lessons_taught");
				
				rs.close();
				pstmt.close();
				
				return teacherLessonCount;
				
			} catch (SQLException e) 
			{
				System.out.println("Unable to get teacher");
				System.out.println(e);
			}
		}
		
		return teacherLessonCount;
	}
	
	public int getTeacherId(String email)
	{
		int teacherId = 0;
		
		ResultSet rs = null;
				
		try 
		{
			pstmt = conn.prepareStatement(getTeacherWithEmailQuery);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			teacherId = rs.getInt("id");
			
			rs.close();
			pstmt.close();
			
			return teacherId;
			
		} catch (SQLException e) 
		{
			System.out.println("Unable to get teacher");
			System.out.println(e);
		}
		
		return 0;
	}
	
	public String getTeacherEmail(int id)
	{
		String teacherEmail = "";
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(getTeacherWithIdQuery);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			teacherEmail = rs.getString("email");
			
			rs.close();
			pstmt.close();
			
			return teacherEmail;
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get teacher");
			System.out.println(e);
		}
		
		return teacherEmail;
	}
	
	public boolean teacherExist(String email)
	{
		
		ResultSet rs = null;
		
		boolean teacher_exist = false;
		
		try 
		{
			pstmt = conn.prepareStatement(checkIfTeacherExistQuery);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			teacher_exist = rs.getBoolean(1);
			
			rs.close();
			pstmt.close();
			
			return teacher_exist;
			
		} catch (SQLException e) 
		{
			System.out.println("Unable to get teacher");
			System.out.println(e);
		}
		
		return false;
	}
	
	public boolean isRegisteredForSubject(String teacherEmail, Subject subject)
	{
		boolean subject_registered = false;
		
		ResultSet rs = null;
		
		int teacherId = getTeacherId(teacherEmail);
		int subjectId = subjectKey.get(subject);
		
		try
		{

			
			pstmt = conn.prepareStatement(isSubjectRegistered);
			pstmt.setInt(1, teacherId);
			pstmt.setInt(2, subjectId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			subject_registered = rs.getBoolean(1);
			
			rs.close();
			pstmt.close();
			
			return subject_registered;
			
		} catch (SQLException e) 
		{
			System.out.println("Unable to check if subject registered");
			System.out.println(e);
		}
		
		return subject_registered;
	}
	
	public boolean registerNewSubject(String teacherEmail, Subject subject)
	{	
		ResultSet rs = null;
		
		int teacherId = getTeacherId(teacherEmail);
		int subjectId = subjectKey.get(subject);
		
		try
		{
			if(!isRegisteredForSubject(teacherEmail, subject)) {
				pstmt = conn.prepareStatement(addNewSubjectToTEacherQuery);
				pstmt.setInt(1, teacherId);
				pstmt.setInt(2, subjectId);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				
				return true;
			} 
			
			return false;
		}  catch (SQLException e) 
		{
			System.out.println("Unable to register to subject");
			System.out.println(e);
		}
		
		return false;
	}
	
	public boolean deleteSubjectFromTeacher(String teacherEmail, Subject subject)
	{	
		ResultSet rs = null;
		
		int teacherId = getTeacherId(teacherEmail);
		int subjectId = subjectKey.get(subject);
		
		try
		{
				pstmt = conn.prepareStatement(deleteRowFromTeacherAndSubjectQuery);
				pstmt.setInt(1, teacherId);
				pstmt.setInt(2, subjectId);
				
				pstmt.executeUpdate();
				
				pstmt.close();
				
				return true;
			
		}  catch (SQLException e) 
		{
			System.out.println("Unable to delete subject");
			System.out.println(e);
		}
		
		return false;
	}
	}
