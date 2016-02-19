import java.util.Scanner;

public class ProjectEuler {
    static boolean DEBUG = true;

	public static void main(String[] args) {
		boolean doAgain = true;
		double result = 0;
        String strResult = "";
		Scanner reader = new Scanner(System.in);
		int problem = 0;
		do
		{
            result = -1;
			try {
				System.out.print("Which problem do you want to run? ('0' to quit): ");
				String str = reader.nextLine();
				problem = Integer.parseInt(str);
                double start = System.currentTimeMillis();
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
                else if (problem == 12) strResult = problem12(500);
                else if (problem == 13) strResult = problem13(2);
					
				else throw new Exception();
                double end = System.currentTimeMillis();
                if (problem != 0) System.out.println("Problem " + problem + " was solved in " + ((end - start) / 1000) + " seconds.");
                if (doAgain && result != -1) System.out.printf("result: %.0f\n", result);
                else if (doAgain) {
                    System.out.println(strResult);
                }
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
                int gridij = grid[i][j];
                double temp = 0;
                double backDiag = 0; //backwards diagonal
                double horizontal = gridij * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                double vertical = gridij * grid[i+1][j] * grid[i+2][j] * grid[i+3][j];
                double diagonal = gridij * grid[i+1][j+1] * grid[i+2][j+2] * grid[i+3][j+3];
                if (i >= 3 && i <= 16 && j >= 3 && j <=16) {
                    backDiag = gridij * grid[i+1][j-1] * grid[i+2][j-2] * grid[i+3][j-3];
                }
                temp = Math.max(Math.max(backDiag, horizontal), Math.max(vertical, diagonal));
                if (temp > maxProduct) {
                    maxProduct = temp;
                }
            }
        }
        return maxProduct;
        
    }
    
    /* PROBLEM 12
    The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
    
    1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
    
    Let us list the factors of the first seven triangle numbers:
    
    1: 1
    3: 1,3
    6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28
    We can see that 28 is the first triangle number to have over five divisors.
    
    What is the value of the first triangle number to have over five hundred divisors?*/
    private static String problem12(int minDivisors) {
        int numDivisors = 0;
        int n = 1;
        int nthTriangleNumber = 0;
        while (numDivisors <= minDivisors) {
            numDivisors = 0;
            nthTriangleNumber += n;
            n++;
            //if (DEBUG) System.out.println(nthTriangleNumber);
            for (int i = 1; i*i <= nthTriangleNumber; i++) {
                if (nthTriangleNumber % i == 0) {
                    numDivisors += 2;
                }
            }
            if(DEBUG && numDivisors > 400) System.out.println("nthTriangle Number = " + nthTriangleNumber + " numDivisors =  " + numDivisors);
        }
        //return nthTriangleNumber;
        return nthTriangleNumber + " has " + numDivisors + " divisors";
    }
    
    /* PROBLEM 13
    Work out the first ten digits of the sum of the following one-hundred 50-digit numbers. [numbers reproduced below].*/
    private static String problem13(int numDigits) {
        int nthDigitSum = 0;
        String strNthDigitSum = "";
        String strNumber = "37107287533902102798797998220837590246510135740250463769376774900097126481248969700780504170182605387432498619952474105947423330951305812372661730962991942213363574161572522430563301811072406154908250230675882075393461711719803104210475137780632466768926167069662363382013637841838368417873436172675728112879812849979408065481931592621691275889832738442742289174325203219235894228767964876702721893184745144573600130643909116721685684458871160315327670386486105843025439939619828917593665686757934951621764571418565606295021572231965867550793241933316490635246274190492910143244581382266334794475817892575867718337217661963751590579239728245598838407582035653253593990084026335689488301894586282278288018119938482628201427819413994056758715117009439035398664372827112653829987240784473053190104293586865155060062958648615320752733719591914205172558297169388870771546649911559348760353292171497005693854370070576826684624621495650076471787294438377604532826541087568284431911906346940378552177792951453612327252500029607107508256381565671088525835072145876576172410976447339110607218265236877223636045174237069058518606604482076212098132878607339694128114266041808683061932846081119106155694051268969251934325451728388641918047049293215058642563049483624672216484350762017279180399446930047329563406911573244438690812579451408905770622942919710792820955037687525678773091862540744969844508330393682126183363848253301546861961243487676812975343759465158038628759287849020152168555482871720121925776695478182833757993103614740356856449095527097864797581167263201004368978425535399209318374414978068609844840309812907779179908821879532736447567559084803087086987551392711854517078544161852424320693150332599594068957565367821070749269665376763262354472106979395067965269474259770973916669376304263398708541052684708299085211399427365734116182760315001271653786073615010808570091499395125570281987460043753582903531743471732693212357815498262974255273730794953759765105305946966067683156574377167401875275889028025717332296191766687138199318110487701902712526768027607800301367868099252546340106163286652636270218540497705585629946580636237993140746255962240744869082311749777923654662572469233228109171419143028819710328859780666976089293863828502533340334413065578016127815921815005561868836468420090470230530811728164304876237919698424872550366387845831148769693215490281042402013833512446218144177347063783299490636259666498587618221225225512486764533677201869716985443124195724099139590089523100588229554825530026352078153229679624948164195386821877476085327132285723110424803456124867697064507995236377742425354112916842768655389262050249103265729672370191327572567528565324825826546309220705859652229798860272258331913126375147341994889534765745501184957014548792889848568277260777137214037988797153829820378303147352772158034814451349137322665138134829543829199918180278916522431027392251122869539409579530664052326325380441000596549391598795936352974615218550237130764225512118369380358038858490341698116222072977186158236678424689157993532961922624679571944012690438771072750481023908955235974572318970677254791506150550495392297953090112996751986188088225875314529584099251203829009407770775672113067397083047244838165338735023408456470580773088295917476714036319800818712901187549131054712658197623331044818386269515456334926366572897563400500428462801835170705278318394258821455212272512503275512160354698120058176216521282765275169129689778932238195734329339946437501907836945765883352399886755061649651847751807381688378610915273579297013376217784275219262340194239963916804498399317331273132924185707147349566916674687634660915035914677504995186714302352196288948901024233251169136196266227326746080059154747183079839286853520694694454072476841822524674417161514036427982273348055556214818971426179103425986472045168939894221798260880768528778364618279934631376775430780936333301898264209010848802521674670883215120185883543223812876952786713296124747824645386369930090493103636197638780396218407357239979422340623539380833965132740801111666627891981488087797941876876144230030984490851411606618262936828367647447792391803351109890697907148578694408955299065364044742557608365997664579509666024396409905389607120198219976047599490197230297649139826800329731560371200413779037855660850892521673093931987275027546890690370753941304265231501194809377245048795150954100921645863754710598436791786391670211874924319957006419179697775990283006991536871371193661495281130587638027841075444973307840789923115535562561142322423255033685442488917353448899115014406480203690680639606723221932041495354150312888033953605329934036800697771065056663195481234880673210146739058568557934581403627822703280826165707739483275922328459417065250945123252306082291880205877731971983945018088807242966198081119777158542502016545090413245809786882778948721859617721078384350691861554356628840622574736922845095162084960398013400172393067166682355524525280460972253503534226472524250874054075591789781264330331690";
        
        while(strNthDigitSum.length() < numDigits) {
            for (int i = 0; i < strNumber.length(); i++) {
                nthDigitSum += Integer.parseInt(strNumber.substring(i, i+1));
                strNthDigitSum = Integer.toString(nthDigitSum);
            }
        }
        return "The first " + numDigits + " digits of the sum are " + strNthDigitSum + ".";
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
    
    private static int sum (int n) {
        return (n * (n + 1)) / 2;
    }
    
    private static int sumOfSquares(int n) {
        return ( (n * (n+1) * (2 * n + 1)/6) );
    }

}
