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
					return peformTransaction(teach, mi, teach.discountedPrice(mi.getCost()));
				else 
					return peformTransaction(teach, mi, mi.getCost());
			} else {
				return peformTransaction(con, mi, mi.getCost());
		}
	}
		
		return "Only teachers or learners can make purchases";
	}
	
	protected String peformTransaction(Consumer con, MenueItem mi, int amount) {
		if(con.hasEnoughTokens(amount)) {
			con.deductTokens(amount);
			updateCafeteriaManagerTokensAndSales(amount, mi, con);
			return con.getFirstName() + " bought " + mi.toString();
		} else
			return "Not enough tokens";
	}
	
	protected boolean isTeacherOrIsLeanrner(Consumer con) {
		return con instanceof Teacher || con instanceof Learner;
	}
	
	protected void updateCafeteriaManagerTokensAndSales(int amount, MenueItem mi, Consumer con) {
		cafeManager.addTokens(amount);
		cafeManager.newSale(con, mi);
	}
}
