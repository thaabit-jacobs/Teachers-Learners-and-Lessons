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

public class LearnerDb
{
	private final Map<Subject, Integer> subjectKey;

	private Connection conn;
	
	private Statement stmt;
	private PreparedStatement pstmt;
	
	final String getLearnerWithEmail = "SELECT * FROM learner WHERE email=?;";
	
	public LearnerDb()
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			
			this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "thaabit", "1234");
		}  catch(ClassNotFoundException fe)
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
	
	public int getLearnerId(String email)
	{
		int learnerId = 0;
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(getLearnerWithEmail);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			learnerId = rs.getInt("id");
			
			return learnerId;
		} catch (SQLException e) 
		{
			System.out.println("Unable to get learner");
			System.out.println(e);
		}
		
		return learnerId;
	}
}
