package net.school.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDb 
{
	
	private Connection conn;
	
	final String getTeacherQuery = "SELECT * FROM teacher WHERE email=?";
	final String checkIfTeacherExistQuery = "SELECT * FROM teacher_exist(?)";
	
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
	}
	
	public int getTeacherLessonCount(String email)
	{
		int teacherLessonCount = -1;
		
		ResultSet rs = null;
		
		if(teacherExist(email))
		{					
			try 
			{
				pstmt = conn.prepareStatement(getTeacherQuery);
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
			pstmt = conn.prepareStatement(getTeacherQuery);
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
