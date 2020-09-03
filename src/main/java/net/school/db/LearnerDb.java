package net.school.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.school.curriculum.notes.AquiredType;
import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Learner;

public class LearnerDb
{
	
	private List<Subject> registeredSubjects;
	
	private final Map<Subject, Integer> subjectKey;
	private final Map<Integer, Subject> subjectIdKey;

	private Connection conn;
	
	private Statement stmt;
	private PreparedStatement pstmt;
	
	final String deleteSubjectQuery = "DELETE FROM learner_subject WHERE learner_id=? and subject_id=?;";
	final String getLearnerWithEmail = "SELECT * FROM learner WHERE email=?;";
	final String getLearnerWithId = "SELECT * FROM learner WHERE id=?;";
	final String checkIfLearnerExistQuery = "SELECT * FROM learner_exist(?)";
	final String isSubjectREgistered = "SELECT * FROM is_sub_registered_learner(?, ?);";
	final String isRegisteredThreeOrMoreSubjectsQuery = "SELECT * FROM has_three_more_subjects(?);"; 
	final String addNewSubjectToLearnerQuery = "INSERT INTO learner_subject (learner_id, subject_id) VALUES (?, ?)";
	final String getLearnerRegisteredSubjects = "SELECT * FROM learner_subject WHERE learner_id=?";
	final String addNewLessonNotesQuery = "INSERT INTO lesson_notes (learner_id, subject_id, aquired_id) values(?, ?,?);";
	final String learnerHasLessonNotesQuery = "SELECT * FROM has_lesson_notes(?, ?);";
	final String deleteLesonNotes = "DELETE FROM lesson_notes WHERE learner_id=? AND subject_id=?;";
	
	
	private boolean isAttendingLesson;
	
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
		
		subjectIdKey = new HashMap<>();
		subjectIdKey.put(1,Subject.MATH);
		subjectIdKey.put(2, Subject.ENGLISH);
		subjectIdKey.put(3, Subject.AFRIKAANS);
		subjectIdKey.put(4, Subject.LIFE_SCIENCES);
		subjectIdKey.put(5, Subject.GEOGRAPHY);
		subjectIdKey.put(6, Subject.BUSSINESS_STUDIES);
		subjectIdKey.put(7, Subject.PHYSICAL_EDUCATIONS);
		
		registeredSubjects = new ArrayList<>();
	}
	
	public ArrayList<Subject> getRegisteredSubjects(String learnerEmail)
	{
		int learnerId =  getLearnerId(learnerEmail);
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(getLearnerRegisteredSubjects);
			pstmt.setInt(1, learnerId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
				registeredSubjects.add(subjectIdKey.get(rs.getInt("subject_id")));
			
			rs.close();
			pstmt.close();
			
			return new ArrayList(registeredSubjects);
				
		} catch (SQLException e) 
		{
			System.out.println("Unable to get registered subjects");
			System.out.println(e);
		}
		
		return null;
	}
	
	public boolean getIsAttendingLesson() {
		return isAttendingLesson;
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
	
	public boolean isRegisteredThreeOrMoreSubjects(String learnerEmail)
	{
		int learnerId =  getLearnerId(learnerEmail);
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(isRegisteredThreeOrMoreSubjectsQuery);
			pstmt.setInt(1, learnerId);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			int numberOfRegisteredSubjects = rs.getInt("has_three_more_subjects");
			
			return numberOfRegisteredSubjects >= 3? true :false;	
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get learner ro subject");
			System.out.println(e);
		}
		
		return false;
	}
	
	public boolean canAttendLesson(String learnerEmail, Subject subject)
	{
		int subjectId = subjectKey.get(subject);
		
		return isRegisteredThreeOrMoreSubjects(learnerEmail) &&  isRegisteredSubject(learnerEmail, subject) && !getIsAttendingLesson();
	}
	
	public void setAttendLesson(boolean attendingLesson)
	{
		this.isAttendingLesson = attendingLesson;
	}
	
	public void deleteSubject(String learnerEmail, Subject subject)
	{
		int learnerId = getLearnerId(learnerEmail);
		int subjectId = subjectKey.get(subject);
		
		try
		{
			pstmt = conn.prepareStatement(deleteSubjectQuery);
			pstmt.setInt(1, learnerId);
			pstmt.setInt(2, subjectId);
			
			pstmt.executeUpdate();
			
			pstmt.close();
		}  catch (SQLException e) 
		{
			System.out.println("Unable to get learner ro subject");
			System.out.println(e);
		}
	}
	
	public boolean registerNewSubject(String learnerEmail, Subject subject)
	{
		int learnerId = getLearnerId(learnerEmail);
		int subjectId = subjectKey.get(subject);
		
		ResultSet rs = null;
		
		if(!isRegisteredSubject(learnerEmail, subject))
		{
			try
			{
				pstmt = conn.prepareStatement(addNewSubjectToLearnerQuery);
				pstmt.setInt(1, learnerId);
				pstmt.setInt(2, subjectId);
				
				pstmt.executeUpdate();
				pstmt.close();
				
				return true;
			}  catch (SQLException e) 
			{
				System.out.println("Could register new subject");
				System.out.println(e);
			}
		}
		
		return false;		
	}
	
	public boolean learnerHasLessonNotes(Learner learner, Subject subject)
	{
		int learnerId = getLearnerId(learner.getEmail());
		int subjectId = subjectKey.get(subject);
		boolean hasNotes = false;
		
		ResultSet rs = null;
		
		try
		{
			pstmt = conn.prepareStatement(learnerHasLessonNotesQuery);
			pstmt.setInt(1, learnerId);
			pstmt.setInt(2, subjectId);
			
			rs = pstmt.executeQuery();
			
			hasNotes = rs.getBoolean(1);
			
			rs.close();
			pstmt.close();
			
			return hasNotes;
		}  catch (SQLException e) 
		{
			System.out.println("Could not getlesson notes");
			System.out.println(e);
		}
		
		return hasNotes;
	}
	
	public boolean addNewLessonNotes(Learner learner, Subject subject, AquiredType aquired)
	{
		int learnerId = getLearnerId(learner.getEmail());
		int subjectId = subjectKey.get(subject);
		int aquiredId = aquired.toString() == "BOUGHT" ? 1:2;
		
		if(learnerHasLessonNotes(learner, subject))
			return false;
		
		try
		{
			pstmt = conn.prepareStatement(addNewLessonNotesQuery);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 2);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}  catch (SQLException e) 
		{
			System.out.println("Could not getlesson notes");
			System.out.println(e);
		}
		
		return false;
	}
	public boolean deleteLessonNotes(Learner learner, Subject subject)
	{
		int learnerId = getLearnerId(learner.getEmail());
		int subjectId = subjectKey.get(subject);
		
		try
		{
			pstmt = conn.prepareStatement(deleteLesonNotes);
			pstmt.setInt(1, learnerId);
			pstmt.setInt(2, subjectId);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			return true;
			
		}  catch (SQLException e) 
		{
			System.out.println("Could not delete lesson notes");
			System.out.println(e);
		}
		
		return false;
	}
}
