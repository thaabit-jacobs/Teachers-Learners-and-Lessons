package net.school;

import net.school.cafeteria.menue.MenueItem;
import net.school.curriculum.subjects.Subject;

public class SchoolDay {
	
	public static void main(String[] args) {
		School sch = new School();
		
		//MATH LESSON
		System.out.println("Math lesson");
		sch.getLesson(Subject.MATH, "Linda").attendLesson(sch.getLearner("Thaabit"));
		sch.getLesson(Subject.MATH, "Linda").attendLesson(sch.getLearner("Mike"));
		sch.getLesson(Subject.MATH, "Linda").attendLesson(sch.getLearner("Mihlaya"));
		sch.getLesson(Subject.MATH, "Linda").attendLesson(sch.getLearner("Amanda"));
		sch.getLesson(Subject.MATH, "Linda").attendLesson(sch.getLearner("Jim"));
		System.out.println(sch.getLesson(Subject.MATH, "Linda").teachLesson());
		System.out.println(sch.getLesson(Subject.MATH, "Linda").endLesson());
		System.out.print("\n");
		
		//ENGLISH LESSON
		System.out.println("English lesson");
		sch.getLesson(Subject.ENGLISH, "Nkosi").attendLesson(sch.getLearner("Thaabit"));
		sch.getLesson(Subject.ENGLISH, "Nkosi").attendLesson(sch.getLearner("Mike"));
		sch.getLesson(Subject.ENGLISH, "Nkosi").attendLesson(sch.getLearner("Mihlaya"));
		sch.getLesson(Subject.ENGLISH, "Nkosi").attendLesson(sch.getLearner("Amanda"));
		sch.getLesson(Subject.ENGLISH, "Nkosi").attendLesson(sch.getLearner("Jim"));
		System.out.println(sch.getLesson(Subject.ENGLISH, "Nkosi").teachLesson());
		System.out.println(sch.getLesson(Subject.ENGLISH, "Nkosi").endLesson());
		System.out.print("\n");

		//BREAK
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Thaabit"), MenueItem.BREAKFAST));
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Amanda"), MenueItem.BREAKFAST));
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Mihlaya"), MenueItem.BREAKFAST));
		System.out.println(sch.getCafeteria().buy(sch.getTeacher("Nkosi"), MenueItem.BREAKFAST));
		System.out.print("\n");
		
		//LIFE SCIENCE LESSON
		System.out.println("Life Science lesson");
		sch.getLesson(Subject.LIFE_SCIENCES, "Bill").attendLesson(sch.getLearner("Thaabit"));
		sch.getLesson(Subject.LIFE_SCIENCES, "Bill").attendLesson(sch.getLearner("Mike"));
		sch.getLesson(Subject.LIFE_SCIENCES, "Bill").attendLesson(sch.getLearner("Mihlaya"));
		sch.getLesson(Subject.LIFE_SCIENCES, "Bill").attendLesson(sch.getLearner("Amanda"));
		sch.getLesson(Subject.LIFE_SCIENCES, "Bill").attendLesson(sch.getLearner("Jim"));
		System.out.println(sch.getLesson(Subject.LIFE_SCIENCES, "Bill").teachLesson());
		System.out.println(sch.getLesson(Subject.LIFE_SCIENCES, "Bill").endLesson());
		System.out.println(sch.getLesson(Subject.LIFE_SCIENCES, "Bill").getLessonStatus());
		System.out.print("\n");
		
		//Lunch break
		System.out.println("Break");
		System.out.println(sch.cafe.buy(sch.teachers.get(0), MenueItem.AFTERNOON_SNACK));
		System.out.println(sch.cafe.buy(sch.learners.get(0), MenueItem.DRINK));
		System.out.println(sch.cafe.buy(sch.learners.get(1), MenueItem.AFTERNOON_SNACK));
		System.out.println(sch.cafe.buy(sch.learners.get(1), MenueItem.DRINK));
		System.out.println(sch.cafe.buy(sch.teachers.get(2), MenueItem.DRINK));
		System.out.print("\n");

		//MATH LESSON
		System.out.println("Math lesson");
		sch.getLesson(Subject.MATH, "Nkosi").attendLesson(sch.getLearner("Thaabit"));
		sch.getLesson(Subject.MATH, "Nkosi").attendLesson(sch.getLearner("Mike"));
		sch.getLesson(Subject.MATH, "Nkosi").attendLesson(sch.getLearner("Mihlaya"));
		sch.getLesson(Subject.MATH, "Nkosi").attendLesson(sch.getLearner("Amanda"));
		sch.getLesson(Subject.MATH, "Nkosi").attendLesson(sch.getLearner("Jim"));
		System.out.println(sch.getLesson(Subject.MATH, "Nkosi").teachLesson());
		System.out.println(sch.getLesson(Subject.MATH, "Nkosi").endLesson());
		System.out.print("\n");
		
		//AFRIKAANS LESSON
		System.out.println("Afrikaans lesson");
		sch.getLesson(Subject.AFRIKAANS, "Linda").attendLesson(sch.getLearner("Thaabit"));
		sch.getLesson(Subject.AFRIKAANS, "Linda").attendLesson(sch.getLearner("Mike"));
		sch.getLesson(Subject.AFRIKAANS, "Linda").attendLesson(sch.getLearner("Mihlaya"));
		sch.getLesson(Subject.AFRIKAANS, "Linda").attendLesson(sch.getLearner("Amanda"));
		sch.getLesson(Subject.AFRIKAANS, "Linda").attendLesson(sch.getLearner("Jim"));
		System.out.println(sch.getLesson(Subject.AFRIKAANS, "Linda").teachLesson());
		System.out.println(sch.getLesson(Subject.AFRIKAANS, "Linda").endLesson());
		System.out.println(sch.getLesson(Subject.AFRIKAANS, "Linda").getLessonStatus());
		System.out.print("\n");
		
		//LUNCH
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Thaabit"), MenueItem.AFTERNOON_SNACK));
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Mike"), MenueItem.LUNCH));
		System.out.println(sch.getCafeteria().buy(sch.getLearner("Jim"), MenueItem.LUNCH));
		System.out.println(sch.getCafeteria().buy(sch.getTeacher("Bill"), MenueItem.AFTERNOON_SNACK));
		System.out.println(sch.getCafeteria().buy(sch.getTeacher("Linda"), MenueItem.AFTERNOON_SNACK));
		System.out.print("\n");
		
		//LEARNER END OF DAY CHECK
		sch.getLearner("Mike").endOfDayStatus();
		System.out.print("\n");

		//Learner end of day
		sch.learners.get(2).endOfDayStatus();
		System.out.print("\n");
		
		////principal end of day
		sch.principal.endOfDayStatus(sch.getLesson(Subject.AFRIKAANS, "Linda"));

		sch.getLearner("Thaabit").endOfDayStatus();
		System.out.print("\n");
		
		//CAFETERIAMANAGER END OF DAY
		sch.getCafeteriaManager().endOfDayStatus();
		System.out.print("\n");
		
		//PRINCIPAL END OF DAY
		sch.getPrincipal().endOfDayStatus(sch.getLesson(Subject.AFRIKAANS, "Linda"));
	}
}
