package net.school.person;

import java.util.ArrayList;

import net.school.curriculum.subjects.Subject;
import net.school.person.consumer.Consumer;

public class Accademic extends Consumer{
	
	public Accademic(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	public boolean registerNewSubject(Subject subject, ArrayList<Subject> listOfSubjects) {
		if(isSubjectRegsitered(subject, listOfSubjects))
			return false;
		
		return listOfSubjects.add(subject);
	}
	
	public boolean isSubjectRegsitered(Subject subject, ArrayList<Subject> listOfSubjects){
		for(Subject sub: listOfSubjects)
			if(sub == subject)
				return true;
		
		return false;
	}
}
