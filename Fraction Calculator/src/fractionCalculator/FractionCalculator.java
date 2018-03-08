package fractionCalculator;


import java.util.Scanner;

public class FractionCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Fraction fraction1;
		Fraction fraction2;
		Fraction fraction3 = null;
		String ans;
		
		
		System.out.println("Welcome to my fraction calculator");
		System.out.println("Please enter your fractions in the form a/b where a and b are both integers");
		
		
		while(true) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.print("Please enter an operation +, -, *, /, = or Q to quit: ");
			ans = getOperation(input);
			
			if(ans.equals("Q")) {
				System.out.println("Good Bye");
				break;
				
			} else {
				
				System.out.print("Please enter your first fraction in the form a/b where a and b are both integers: ");
				fraction1 = getFraction(input);
				
				System.out.print("Please enter your second fraction in the form a/b where a and b are both integers: ");
				fraction2 = getFraction(input);
				
				if(ans.equals("+")) {
					fraction3 = fraction1.add(fraction2);
				} else if(ans.equals("-")){
					fraction3 = fraction1.subtract(fraction2);
				} else if(ans.equals("*")) {
					fraction3 = fraction1.multiply(fraction2);
				} else if(ans.equals("/")) {
					fraction3 = fraction1.divide(fraction2);
				}
				
				fraction3.toLowestTerms();
				System.out.println(fraction1.toString() + " " + ans + " " + fraction2.toString() + " = " + fraction3.toString());
			}
			
				
		}//end while
		
		
		
		
		
	}
	
	//Gets the input from the user
	public static String getOperation(Scanner input) {
		String ans = "";
		
		while(true) {
			ans = input.nextLine();
			
			if(checkValidInputOperation(ans)) {
				return ans;
			} else {
				System.out.print("Invalid Input, try again: ");
			}// End If
		} //End While
		
	}
	
	//Checks if the input is valid
	public static boolean checkValidInputOperation(String input) {
		
		if(input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("Q")){
			return true;
		}
		return false;
	}
	
	public static boolean validFraction(String stringFraction) {
		
		
		return false;
	}
	
	public static Fraction getFraction(Scanner input) {
		String stringFraction = input.nextLine();
		validFraction(stringFraction);
		
		String[] arrayFraction = stringFraction.split("/");
		
		int numerator = Integer.parseInt(arrayFraction[0]);
		int denominator = Integer.parseInt(arrayFraction[1]);
		
		Fraction fraction = new Fraction(numerator, denominator);
		return fraction;
	}
	
	

}
