import java.util.Scanner;

public class ProjectEuler {

	public static void main(String[] args) {
		boolean doAgain = true;
		double result = 0;
		Scanner reader = new Scanner(System.in);
		int problem = 0;
		do
		{
			try {
				System.out.print("Which problem do you want to run? ('0' to quit): ");
				String str = reader.nextLine();
				problem = Integer.parseInt(str);
				
				if (problem == 0) {
					System.out.print("Goodbye!");
					doAgain = false;
				}
				else if (problem == 1) result = problem1();
				else if (problem == 2) result = problem2();
				else if (problem == 3) result = problem3();
				else if (problem == 4) result = problem4();
				else if (problem == 5) result = problem5();
				else if (problem == 6) result = problem6();
				else if (problem == 7) result = problem7();
					
				else throw new Exception();
				if (doAgain) System.out.printf("result: %.0f\n", result);
					//break;
			}
			catch (Exception e) {
				System.out.println("Invalid problem number");
			}
		} while(doAgain);
		reader.close();
	}

	private static int problem1() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) sum += i;
		}
		//System.out.println("sum = "+sum);
		return sum;
	}
	
	private static int problem2() {
		int sum = 2, num1 = 1, num2 = 2, next = 3;
		
		while(next <= 4000000) {
			if(next % 2 == 0) sum += next;
			num1 = num2;
			num2 = next;
			next = num1 + num2;
		}
	
		return sum;
	}
	
	private static double problem3() {
		double n = 600851475143L;
		double lastFactor, factor, maxFactor;
		if (n % 2 == 0) {
			lastFactor = 2;
			n = n/2;
			while (n % 2 == 0) {
				n = n/2;
			}
		} else {
			lastFactor = 1;
		}
		factor = 3;
		maxFactor = Math.sqrt(n);
		
		while (n > 1 && factor <= maxFactor) {
			if (n % factor == 0) {
				n = n/factor;
				lastFactor = factor;
				while (n % factor == 0) {
					n = n/factor;
				}
				maxFactor = Math.sqrt(n);
			}
			factor = factor + 2;
		}
		
		if (n == 1) {
			return lastFactor;
		} else {
			return n;
		}
	}
	
	private static int problem4() {
		int maxPalindrome = 0;
		int maxNum = 999;
		for (int i = 100; i <= maxNum; i++) {
			for (int j = 100; j <= maxNum; j++) {
				int val = i * j;
				if (isPalindrome(val) && val > maxPalindrome) maxPalindrome = val;
			}
		}
		return maxPalindrome;
	}
	
	private static boolean isPalindrome(int n) {
		String input = Integer.toString(n);
		String reverse = new StringBuilder(input).reverse().toString();
		return input.equals(reverse);
	}
	
	private static int problem5() {
		int smallestMultiple = 20;
		boolean found = false;
		
		while (!found) {
			found = true;
			for (int i = 2; i <= 20; i++) {
				if (smallestMultiple % i != 0) {
					found = false;
					break;
				}
			}
			if (!found) smallestMultiple += 20;
		}
		return smallestMultiple;
	}
	
	private static int problem6() {
		int sumOfSquares = sumOfSquares(100), squareOfSums = sum(100);
		squareOfSums = squareOfSums * squareOfSums;
		
		return squareOfSums - sumOfSquares;
		
	}
	
	private static int sumOfSquares(int n) {
		return ( (n * (n+1) * (2 * n + 1)/6) );
	}
	
	private static int sum (int n) {
		return (n * (n + 1)) / 2;
	}
	
	private static int problem7() {
		int primesFound = 0, i = 1;
		//System.out.println(primesFound <= 10001);
		while (primesFound <= 10001) {
			if (isPrime(i)) primesFound++;
			if (primesFound < 10001) i++;
		}
		return i;
	}
	
	private static boolean isPrime(int n) {
		if (n % 2 == 0) return false;
		
		for (int i = 3; i * i <= n; i+= 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	private static int problem8() {
		return 0;
	}

}
