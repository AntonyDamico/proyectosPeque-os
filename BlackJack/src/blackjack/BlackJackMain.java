package blackjack;

import java.util.Scanner;

public class BlackJackMain {

	public static void main(String[] args) {
		String choice = "hit";
		Scanner input = new Scanner(System.in);
		Cards cardsPlayer = new Cards();
		Cards cardsDealer = new Cards();
		
		System.out.println("            Welcome to my blackjack program!\n");
		
		//Player's cards
		System.out.println("You get a " + cardsPlayer.getCardA() + " and a " + cardsPlayer.getCardB());
		System.out.println("Your total is " + cardsPlayer.getSum() + "\n");
		
		//Dealer's cards
		System.out.println("The dealer has a " + cardsDealer.getCardA() + " and a hidden card \nHis total is hidden too \n");
		
		//First Choice to hit or stay
		System.out.print("Hit or Stay: ");
		choice = input.nextLine();
		
		//Main loops of the game
		
		//Player loop
		while(choice.toUpperCase().equals("HIT")) {
			
			//Deals a card to the player
			cardsPlayer.deal();
			//Prints the cards shown and the new total
			System.out.println("\nYou drew a " + cardsPlayer.getCardC());
			System.out.println("Your total is " + cardsPlayer.getSum() + "\n");
			
			//Test if the total is less than 21
			if(cardsPlayer.getSum() < 21) {
				System.out.print("Hit or Stay: ");
				choice = input.nextLine();
			} else {
				break;
			}
		}
		
		//Choice to see if you win, lost or it's the dealer's turn
		if(cardsPlayer.getSum() < 21) {
			//dealer's turn
			System.out.println("\nThe dealer's hidden card was a " + cardsDealer.getCardB());
			while(cardsDealer.getSum() < 17) {
				cardsDealer.deal();
				System.out.println("The dealer drew a " + cardsDealer.getCardC());
				System.out.println("The dealer's total  is " + cardsDealer.getSum() + "\n");
			}
			System.out.println("You get " + cardsPlayer.getSum() + " and the dealer got " + cardsDealer.getSum());
			
			//Determining who won
			if(cardsDealer.getSum() < 21) {
				
				if(cardsDealer.getSum() > cardsPlayer.getSum()) {
					System.out.println("You lose");
				} else if(cardsDealer.getSum() < cardsPlayer.getSum()) {
					System.out.println("You win");
				} else {
					System.out.println("You tied");
				}
				
			} else if(cardsDealer.getSum() == 21) {
				System.out.println("The dealer got 21. You lose");
			} else if (cardsDealer.getSum() > 21) {
				System.out.println("The dealer got more than 21 you win!");
			}
			
			
		} else if(cardsPlayer.getSum() == 21) {
			//You get 21
			System.out.println("You get 21, you win!");
			
		} else if(cardsPlayer.getSum() > 21) {
			//More than 21
			System.out.println("You have more than 21. You lose.");
		}
		
		
		
		input.close();
	}
}
