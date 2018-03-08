package Secuence;
import java.util.Scanner;

public class Secuence {

	//Method for the collatz
	public int collatz(double number) {
		if(number % 2 == 0) {
			return  (int) (number/2);
		} else {
			return (int) ((3*number) + 1);
		}
	}
	
	public String even() {
		return "The number is even so I take half: ";
	}
	
	public String odd() {
		return "The number is odd, so I make 3n+1: ";
	}
	
	public static void main(String[] args) {
		int numb;
		int cont = 0;
		Scanner input = new Scanner(System.in);
		Secuence test = new Secuence();
		
		System.out.print("Number: "); //Getting user input
		numb = input.nextInt();
		
		while(numb != 1) {
			if (numb % 2 == 0) {
				System.out.print(test.even());
			} else {
				System.out.print(test.odd());
			}
			numb = test.collatz(numb); // using the collatz method on the input
			System.out.println(numb);
			cont++;
		}
		System.out.println("It took " + cont + " secuences");
		
		
		input.close();
	}

}
