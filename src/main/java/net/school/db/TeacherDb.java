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
	private final Map<Integer, Subject> subjectKey;
	
	private Connection conn;
	
	final String getTeacherWithEmailQuery = "SELECT * FROM teacher WHERE email=?";
	final String getTeacherWithIdQuery = "SELECT * FROM teacher WHERE id=?";
	final String checkIfTeacherExistQuery = "SELECT * FROM teacher_exist(?)";
	final String isSubjectRegistered = "";
	
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
		subjectKey.put(1, Subject.MATH);
		subjectKey.put(2, Subject.ENGLISH);
		subjectKey.put(3, Subject.AFRIKAANS);
		subjectKey.put(4, Subject.LIFE_SCIENCES);
		subjectKey.put(5, Subject.GEOGRAPHY);
		subjectKey.put(6, Subject.BUSSINESS_STUDIES);
		subjectKey.put(7, Subject.PHYSICAL_EDUCATIONS);
		
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
}
