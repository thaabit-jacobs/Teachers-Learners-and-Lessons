package net.school;

import net.school.cafeteria.menue.MenueItem;

public class SchoolDay {
	
	public static void main(String[] args) {
		School sch = new School();
		
		//Math class
		System.out.println("Math lesson");
		System.out.println(sch.learners.get(0).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(1).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(2).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(3).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(4).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.teachers.get(0).teach(sch.lessons.get(0)));
		System.out.println(sch.lessons.get(0).end());
		System.out.print("\n");
		
		//English class
		System.out.println("English lesson");
		System.out.println(sch.learners.get(0).attendLesson(sch.lessons.get(1)));
		System.out.println(sch.learners.get(1).attendLesson(sch.lessons.get(1)));
		System.out.println(sch.learners.get(2).attendLesson(sch.lessons.get(1)));
		System.out.println(sch.learners.get(3).attendLesson(sch.lessons.get(1)));
		System.out.println(sch.learners.get(4).attendLesson(sch.lessons.get(1)));
		System.out.println(sch.teachers.get(1).teach(sch.lessons.get(1)));
		System.out.println(sch.lessons.get(1).end());
		System.out.print("\n");
		
		System.out.print("\n");
		
		//Life Science class
		System.out.println("Life Science lesson");
		System.out.println(sch.learners.get(0).attendLesson(sch.lessons.get(4)));
		System.out.println(sch.learners.get(1).attendLesson(sch.lessons.get(4)));
		System.out.println(sch.learners.get(2).attendLesson(sch.lessons.get(4)));
		System.out.println(sch.learners.get(3).attendLesson(sch.lessons.get(4)));
		System.out.println(sch.learners.get(4).attendLesson(sch.lessons.get(4)));
		System.out.println(sch.teachers.get(2).teach(sch.lessons.get(4)));
		System.out.println(sch.lessons.get(4).end());
		System.out.print("\n");
		
		//Lunch break
		System.out.println("Break");
		System.out.println(sch.cafe.buy(sch.teachers.get(1), MenueItem.BREAKFAST));
		System.out.println(sch.cafe.buy(sch.learners.get(0), MenueItem.DRINK));
		System.out.println(sch.cafe.buy(sch.learners.get(1), MenueItem.AFTERNOON_SNACK));
		System.out.println(sch.cafe.buy(sch.learners.get(1), MenueItem.DRINK));
		System.out.println(sch.cafe.buy(sch.teachers.get(2), MenueItem.LUNCH));
		
		//Math lesson
		System.out.print("\n");
		System.out.println("Math lesson");
		System.out.println(sch.learners.get(0).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(1).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(2).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(3).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.learners.get(4).attendLesson(sch.lessons.get(0)));
		System.out.println(sch.teachers.get(0).teach(sch.lessons.get(0)));
		System.out.println(sch.lessons.get(0).end());
		System.out.print("\n");
		
		//Afrkiaans lesson
		System.out.print("\n");
		System.out.println("Afrikaans lesson");
		System.out.println(sch.learners.get(0).attendLesson(sch.lessons.get(2)));
		System.out.println(sch.learners.get(1).attendLesson(sch.lessons.get(2)));
		System.out.println(sch.learners.get(2).attendLesson(sch.lessons.get(2)));
		System.out.println(sch.learners.get(3).attendLesson(sch.lessons.get(2)));
		System.out.println(sch.learners.get(4).attendLesson(sch.lessons.get(2)));
		System.out.println(sch.teachers.get(0).teach(sch.lessons.get(2)));
		System.out.println(sch.lessons.get(2).end());
		System.out.print("\n");
		
		//Buy notes
		System.out.println(sch.learners.get(3).askForNotes(sch.learners.get(4), sch.lessons.get(1)));
		System.out.print("\n");
		
		//Learner end of day
		System.out.println(sch.learners.get(4).status());
		System.out.print("\n");
		
		//Learner end of day
		System.out.println(sch.learners.get(3).status());
		
		System.out.print("\n");
		
		////principal end of day
		System.out.println(sch.principal.status());
		
		System.out.print("\n");
		
		//caferteria manager end of day
		System.out.println(sch.cafeMan.status());
	}

}
