package numberGame;
import java.util.Scanner;
import java.util.Random;

public class numberGame {

	public static void main(String[] args) {
		int lowval, highval, tries, guess;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Select the lower value: ");
		lowval = input .nextInt();
		
		System.out.print("Select the higher value: ");
		highval = input.nextInt();
		
		System.out.print("Select the number of tries: ");
		tries = input.nextInt();
		
		Random rand = new Random();
		
		int number = rand.nextInt(highval - lowval + 1) + lowval;
		
		
		for(int i = 0; i < tries; i++) {
			System.out.println("\n" + (i+1) + " attempt");
			guess = input.nextInt();
			if(guess == number) {	
				lowval = guess;
				break;
			} else if(guess > number) {
				System.out.println("Lower");
			} else {
				System.out.println("Higher");
			}
		}
		if (lowval == number) {
			System.out.println("\n" + "You win!");
			System.out.println("The number was " + number);
		}else {
			System.out.println("\n" + "You lost");
			System.out.println("The number was " + number);
		}
		input.close();
	}

}
