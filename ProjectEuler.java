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
					System.out.println("Goodbye!");
					doAgain = false;
				}
				else if (problem == 1) result = problem1();
				else if (problem == 2) result = problem2();
				else if (problem == 3) result = problem3();
				else if (problem == 4) result = problem4();
				else if (problem == 5) result = problem5();
				else if (problem == 6) result = problem6();
				else if (problem == 7) result = problem7();
                else if (problem == 8) result = problem8();
                else if (problem == 9) result = problem9();
                else if (problem == 10) result = problem10();
                else if (problem == 11) result = problem11();
					
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
	
	private static int problem7() {
		int primesFound = 0, i = 1;
		while (primesFound <= 10001) {
			if (isPrime(i)) primesFound++;
			if (primesFound < 10001) i++;
		}
		return i;
	}
	
	private static double problem8() {
        long max = 0;
        String str = "73167176531330624919225119674426574742355349194934" +
        "96983520312774506326239578318016984801869478851843" +
        "85861560789112949495459501737958331952853208805511" +
        "12540698747158523863050715693290963295227443043557" +
        "66896648950445244523161731856403098711121722383113" +
        "62229893423380308135336276614282806444486645238749" +
        "30358907296290491560440772390713810515859307960866" +
        "70172427121883998797908792274921901699720888093776" +
        "65727333001053367881220235421809751254540594752243" +
        "52584907711670556013604839586446706324415722155397" +
        "53697817977846174064955149290862569321978468622482" +
        "83972241375657056057490261407972968652414535100474" +
        "82166370484403199890008895243450658541227588666881" +
        "16427171479924442928230863465674813919123162824586" +
        "17866458359124566529476545682848912883142607690042" +
        "24219022671055626321111109370544217506941658960408" +
        "07198403850962455444362981230987879927244284909188" +
        "84580156166097919133875499200524063689912560717606" +
        "05886116467109405077541002256983155200055935729725" +
        "71636269561882670428252483600823257530420752963450";
        
        for (int i = 0; i < str.length() - 13; i++) {
            long temp = 1;
            for (int j = 0 + i; j < 13 + i; j++) {
                int currNum = Integer.parseInt(str.substring(j, j+1));
                temp = temp * currNum;
            }
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println("max = " + max);
		return 0;
	}
    
    /* PROBLEM 9
     A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     
     a2 + b2 = c2
     For example, 32 + 42 = 9 + 16 = 25 = 52.
     
     There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     Find the product abc.*/
    private static double problem9() {
        for (int c = 10; c < 1000; c++) {
            for (int b = 1; b < c; b++) {
                for (int a = 0; a < b; a++) {
                    if (a + b + c == 1000 && (a*a) + (b*b) == (c*c)) {
                        System.out.println("a: " + a + " b: " + b + " c: " + c);
                        return a * b * c;
                    }
                }
            }
        }
        return 0;
    }
    
    /* PROBLEM 10
     The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     
     Find the sum of all the primes below two million.*/
    private static double problem10() {
        double sumOfPrimes = 0;
        //System.out.print("Primes below 2,000,000:");
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                //System.out.print(" " + i);
                sumOfPrimes = sumOfPrimes + i;
            }
        }
        System.out.println();
        return sumOfPrimes;
    }
    
    /* PROBLEM 11
     In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
        **Numbers reproduced below in String numbers**
     The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
     
     What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?*/
    private static double problem11() {
        double maxProduct = 0;
        int[][] grid = new int[][] {
            {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
            {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 0},
            {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
            {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
            {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
            {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
            {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
            {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
            {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
            {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
            {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
            {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
            {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
            {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
            {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
            {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
            {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
            {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
            {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
            {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48}
        };
        
        for (int i = 0; i <= 16; i++) {
            for (int j = 0; j <= 16; j++) {
                double horizontal = grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                double vertical = grid[i][j] * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                double diagonal = grid[i][j] * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                if (horizontal > maxProduct && horizontal > vertical && horizontal > diagonal) {
                    maxProduct = horizontal;
                }
                if (vertical > maxProduct && vertical > horizontal && vertical > diagonal) {
                    maxProduct = vertical;
                }
                if (diagonal > maxProduct && diagonal > vertical && diagonal > horizontal) {
                    maxProduct = diagonal;
                }
            }
        }
        return maxProduct;
        
    }
    
    //-------------------Helper Functions (in alphabetical order)----------------------
    private static boolean isPalindrome(int n) {
        String input = Integer.toString(n);
        String reverse = new StringBuilder(input).reverse().toString();
        return input.equals(reverse);
    }
    
    private static boolean isPrime(int n) {
        if (n == 2) return true;
        else if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i+= 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    private static void readIntoArray(int[][] arr, int x, int y) {
        
    }
    
    private static int sum (int n) {
        return (n * (n + 1)) / 2;
    }
    
    private static int sumOfSquares(int n) {
        return ( (n * (n+1) * (2 * n + 1)/6) );
    }

}
