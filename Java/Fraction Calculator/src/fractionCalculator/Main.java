package fractionCalculator;

public class Main {

	public static void main(String[] args) {
		
		Fraction frac1 = new Fraction(2,-3);
		Fraction frac2 = new Fraction(-6,-4);
		Fraction frac3;
		
		frac3 = frac1.add(frac2);
		
		System.out.println(frac1.toString());
		System.out.println(frac2.toString());
		System.out.println(frac3.toString());
		
		System.out.println("\n");
		
		frac2.toLowestTerms();
		System.out.println(frac2.toString());
		System.out.println(frac2.toDouble());
		
		
		System.out.println(frac1.equals(frac2));

	}

}
