package net.school.cafeteria;

import net.school.cafeteria.menue.MenueItem;
import net.school.persons.caferteria_manager.CafeteriaManager;
import net.school.persons.learners.Learner;
import net.school.persons.teachers.Teacher;

public class Cafeteria {
	
	private CafeteriaManager cafeManager;
	
	public Cafeteria(CafeteriaManager cafeManager) {
		
		this.cafeManager = cafeManager;
		
	}
	
	public String buy(Learner learner, MenueItem mi) {
		if(learner.getTokens() >= mi.getCost()) {
			learner.deductTokens(mi.getCost());
			
			cafeManager.addTokens(mi.getCost());
			cafeManager.newSale(learner, mi);
			
			return learner.getFirstName() + " bought " + mi.toString() + " for " + mi.getCost() + " tokens";
		}
		
		return "Not enough tokens";
	}
	
	public String buy(Teacher teacher, MenueItem mi) {
		if(teacher.qualifiesForDiscount()) {
			int newPrice = mi.getCost()  - (int) (mi.getCost() * 0.25);
			if(teacher.getTokens() >= newPrice) {
				teacher.deductTokens(newPrice);
				
				cafeManager.addTokens(newPrice);
				cafeManager.newSale(teacher, mi);
				
				return teacher.getFirstName() + " bought " + mi.toString() + " for " + newPrice + " tokens";
			} else
				return "Not enough tokens";
		}

		if(teacher.getTokens() >= mi.getCost()) {
			teacher.deductTokens(mi.getCost());
			
			cafeManager.addTokens(mi.getCost());
			cafeManager.newSale(teacher, mi);
			
			return teacher.getFirstName() + " bought " + mi.toString() + " for " + mi.getCost() + " tokens";
		} else
			return "Not enough tokens";

	}
}
