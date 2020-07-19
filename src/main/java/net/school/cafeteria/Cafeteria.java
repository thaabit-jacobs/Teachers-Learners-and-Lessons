package net.school.cafeteria;

import net.school.cafeteria.menue.MenueItem;
import net.school.person.consumer.CafeteriaManager;
import net.school.person.consumer.Consumer;
import net.school.person.consumer.Learner;
import net.school.person.consumer.Teacher;

public class Cafeteria {
	
	private CafeteriaManager cafeManager;
	
	public Cafeteria(CafeteriaManager cafeManager) {
		this.cafeManager = cafeManager;
	}
	
	public String buy(Consumer con, MenueItem mi) {
		if(isTeacherOrIsLeanrner(con)) {
			if(con instanceof Teacher) {
				Teacher teach = (Teacher)con;
				
				if(teach.qualiesfyForDiscount()) {
					if(teach.hasEnoughTokens(mi.getCost())) {
						teach.deductTokens(teach.discountedPrice(mi.getCost()));
						cafeManager.addTokens(teach.discountedPrice(mi.getCost()));
						cafeManager.newSale(teach, mi);
						return teach.getFirstName() + " bought " + mi.toString();
					} else
						return "Not enough tokens";
					
				} else {
					if(teach.hasEnoughTokens(mi.getCost())) {
						teach.deductTokens(mi.getCost());
						cafeManager.addTokens(mi.getCost());
						cafeManager.newSale(teach, mi);
						return teach.getFirstName() + " bought " + mi.toString();
					} else
						return "Not enough tokens";
				}
				
			} else {
				Learner learn = (Learner)con;
				
				if(learn.hasEnoughTokens(mi.getCost())) {
					learn.deductTokens(mi.getCost());
					cafeManager.addTokens(mi.getCost());
					cafeManager.newSale(learn, mi);
					return learn.getFirstName() + " bought " + mi.toString();
				} else
					return "Not enough tokens";
			}
		}
		
		return "Only teachers or learners can make purchases";
	}
	
	public boolean isTeacherOrIsLeanrner(Consumer con) {
		return con instanceof Teacher || con instanceof Learner ? true:false;
	}
}
