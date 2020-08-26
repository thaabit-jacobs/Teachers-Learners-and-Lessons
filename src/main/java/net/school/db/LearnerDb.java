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
	final String getLearnerWithId = "SELECT * FROM learner WHERE id=?;";
	final String checkIfLearnerExistQuery = "SELECT * FROM learner_exist(?)";
	final String isSubjectREgistered = "SELECT * FROM is_sub_registered_learner(?, ?);";
	
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
			
			rs.close();
			pstmt.close();
			
			return learnerId;
		} catch (SQLException e) 
		{
			System.out.println("Unable to get learner");
			System.out.println(e);
		}
		
		return learnerId;
	}
	
	public String getLearnerEmail(int learnerId)
	{
		String learnerEmail = "";
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(getLearnerWithId);
			pstmt.setInt(1, learnerId);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			learnerEmail = rs.getString("email");
			
			rs.close();
			pstmt.close();
			
			return learnerEmail;
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get learner");
			System.out.println(e);
		}
		
		return learnerEmail;
	}
	
	public boolean learnerExist(String email)
	{
		boolean learnerExist = false;
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(checkIfLearnerExistQuery);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			learnerExist = rs.getBoolean(1);
			
			rs.close();
			pstmt.close();
			
			return learnerExist;
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get learner");
			System.out.println(e);
		}
		
		return learnerExist;
	}
	
	public boolean isRegisteredSubject(String learnerEmail, Subject subject)
	{
		boolean registeredSubject = false;
		
		int learnerId =  getLearnerId(learnerEmail);
		int subjectId = subjectKey.get(subject);
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(isSubjectREgistered);
			pstmt.setInt(1, learnerId);
			pstmt.setInt(2, subjectId);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			registeredSubject = rs.getBoolean(1);
			
			rs.close();
			pstmt.close();
			
			return registeredSubject;
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get learner ro subject");
			System.out.println(e);
		}
		
		return registeredSubject;
	}
}
