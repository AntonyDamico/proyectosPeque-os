package blackjack;

import java.util.Random;

public class Cards {
	int cardA, cardB, cardC, sum, choice;
	Random random = new Random();
	
	//constructor
	public Cards() {
		cardA = random.nextInt(11 - 2)+2;
		cardB = random.nextInt(9)+2;
		sum = cardA + cardB;
	}
	
	//methods
	
	//Deals a new card and adds it to the total
	public void deal() {
		cardC = random.nextInt(9)+2;
		sum += cardC;
	}
	
	//Sends the value of the card A
	public int getCardA(){
		return cardA;
	}
	
	//Sends the value of the card B
	public int getCardB(){
		return cardB;
	}
	
	//Sends the value of the card C
		public int getCardC(){
			return cardC;
	}
	
	
	//Sends the value of the total
	public int getSum(){
		return sum;
	}
	


	
	
	
	
}
