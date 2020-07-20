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
				if(teach.qualiesfyForDiscount())
					return peformTransactionDiscount(teach, mi);
				else 
					return peformTransaction(teach, mi);
				
			} else {
				Learner learn = (Learner)con;
				return peformTransaction(learn, mi);
		}
	}
		
		return "Only teachers or learners can make purchases";
	}
	
	public String peformTransaction(Consumer con, MenueItem mi) {
		if(con.hasEnoughTokens(mi.getCost())) {
			con.deductTokens(mi.getCost());
			updateCafeteriaManagerTokensAndSales(mi.getCost(), mi, con);
			return con.getFirstName() + " bought " + mi.toString();
		} else
			return "Not enough tokens";
	}
	
	public String peformTransactionDiscount(Teacher teach, MenueItem mi) {
		if(teach.hasEnoughTokens(mi.getCost())) {
			teach.deductTokens(teach.discountedPrice(mi.getCost()));
			updateCafeteriaManagerTokensAndSales(teach.discountedPrice(mi.getCost()), mi, teach);
			return teach.getFirstName() + " bought " + mi.toString();
		} else
			return "Not enough tokens";
	}
	
	public boolean isTeacherOrIsLeanrner(Consumer con) {
		return con instanceof Teacher || con instanceof Learner ? true:false;
	}
	
	public void updateCafeteriaManagerTokensAndSales(int amount, MenueItem mi, Consumer con) {
		cafeManager.addTokens(amount);
		cafeManager.newSale(con, mi);
	}
}
