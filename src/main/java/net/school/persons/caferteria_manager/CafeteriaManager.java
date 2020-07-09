package net.school.persons.caferteria_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.school.cafeteria.menue.MenueItem;
import net.school.persons.Person;
import net.school.persons.Spendable;

public class CafeteriaManager extends Person{
	
	private int totalTokens;
	
	private HashMap<Spendable, ArrayList<MenueItem>> sales;
	
	public CafeteriaManager(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		
		sales = new HashMap<>();
		
	}
	
	public void addTokens(int amount) {
		totalTokens += amount;
	}
	
	public int getTokens() {
		return totalTokens;
	}
	
	public HashMap<Spendable, ArrayList<MenueItem>> getSales(){
		return sales;
	}
	
	public void newSale(Spendable s, MenueItem mi) {
		if(sales.containsKey(s)) {
			ArrayList<MenueItem> menueItem  = sales.get(s);
			
			menueItem.add(mi);
			
			sales.put(s, menueItem);
		} else {
			ArrayList<MenueItem> menue = new ArrayList<MenueItem>();
			
			menue.add(mi);
			
			sales.put(s, menue); 
		}
			
	}
	
	public String status() {
		Set<Map.Entry<Spendable, ArrayList<MenueItem>>> set = sales.entrySet();
		String status = "";
		
		System.out.println("Cafeteria manager");
		for(Map.Entry<Spendable, ArrayList<MenueItem>> me: set) {
			Person p  = (Person)me.getKey();
			status += p.getFirstName()  + " " + p.getLastName() +  " bought " + " : " + me.getValue() + "\n"; 
		}
			
		
		status += "Total Tokens : " + getTokens();
		
		return status;
	}
}
