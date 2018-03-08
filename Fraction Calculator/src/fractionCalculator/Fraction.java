package fractionCalculator;

public class Fraction {
	private int numerator;
	private int denominator;
	
	
	//Constructor for when you get a value for both
	public Fraction(int numerator, int denominator) {
		//If the denominator is 0
		if(denominator == 0) {
			throw new IllegalArgumentException("The denominator can't be 0");
		} // End if
		
		//if the denominator is negative
		if(denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		} //End if
		
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	//Constructor for when you get a value for just the denominator
	public Fraction(int numerator) {
		this(numerator, 1);
	}
	
	//Constructor for when you don't get any parameters
	public Fraction() {
		this(0, 1);
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public String toString() {
		if(denominator != 1) {
			return numerator + "/" + denominator;
		} else {
			return numerator + "";
		}
		
	}
	
	public double toDouble() {
		return (double)numerator/denominator;
	}
	
	//Adds the current fraction to the one in the argument and returns a new one
	public Fraction add(Fraction fraction) {
		int newNumerator;
		int comDenominator;
		
		comDenominator = denominator * fraction.denominator;
		newNumerator = (numerator * fraction.denominator) + (denominator * fraction.numerator);
		
		Fraction sum = new Fraction(newNumerator, comDenominator);
		return sum;
	}
	
	//Subtracts the current fraction to the one in the argument and returns a new one
	public Fraction subtract(Fraction fraction) {
		int newNumerator;
		int comDenominator;
		
		comDenominator = denominator * fraction.denominator;
		newNumerator = (numerator * fraction.denominator) - (denominator * fraction.numerator);
		
		Fraction resta = new Fraction(newNumerator, comDenominator);
		return resta;
	}
	
	//Multiplies the current fraction to the one in the argument and returns a new one
	public Fraction multiply(Fraction fraction) {
		int newNumerator;
		int newDenominator;
		
		newNumerator = numerator * fraction.numerator;
		newDenominator = denominator * fraction.denominator;
		
		Fraction product = new Fraction(newNumerator, newDenominator);
		return product;
	}
	
	//Divides the current fraction to the one in the argument and returns a new one
	public Fraction divide(Fraction fraction) {
		int newNumerator;
		int newDenominator;
		
		newNumerator = numerator * fraction.denominator;
		newDenominator = denominator * fraction.numerator;
		
		Fraction product = new Fraction(newNumerator, newDenominator);
		return product;
	}
	
	//Tells whether both fractions are the same 
	public boolean equals(Object fraction) {	
		Fraction fract = (Fraction) fraction; 
		return (numerator == fract.numerator) && (denominator == fract.denominator);
	}
	
	//Converts the fractions to its lowest terms
	public void toLowestTerms() {
		int gcd;

		gcd = gcd(numerator, denominator);
		
		numerator /= gcd;
		denominator /= gcd;
	}
	
	public static int gcd(int a, int b) {
		int reminder;
		
		do{
			reminder = a % b;
			a = b;
			b = reminder;
		} while(b != 0);
		
		return a;
	}
	
	

}
