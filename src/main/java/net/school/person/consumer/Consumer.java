package net.school.person.consumer;

import net.school.person.Person;

public class Consumer extends Person{
	
	private int tokens;
	
	public Consumer(String firstName, String lastName, String email) {
		super(firstName, lastName, email);
	}
	
	public int getTokens() {
		return tokens;
	}
	
	public void deductTokens(int amount) {
		tokens -= amount;
	}
	
	public void addTokens(int amount) {
		tokens += amount;
	}
	
	public boolean hasEnoughTokens(int saleAmount) {
		return getTokens() >= saleAmount ? true:false;
	}
	
}
