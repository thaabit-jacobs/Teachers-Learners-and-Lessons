package net.school.persons;

public interface Spendable {
	
	int getTokens();
	
	void deductTokens(int amount);
	
	void addTokens(int amount);
	
}
