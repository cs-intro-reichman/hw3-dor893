// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}


	// Returns x1 + x2
	public static int plus(int x1, int x2) {

		if(x2 < 0) {

			int i = x2;

			while (i < 0) {

				x1--;

				i++;
			}

		} else {

			for(int i = 0; i < x2; i++){

				x1++;
			}
		}
	
		return x1;  
	}

	public static int minus(int x1, int x2) {

		if(x2 < 0) {

			int i = x2;

			while (i < 0) {

				x1++;

				i++;
			}

		
		} else {
		
		    for(int i = 0; i < x2; i++) {

			x1 --;

		    }
		}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {

		if(x1 < 0 && x2 < 0) {

				int i = x2;
	
				while (i < 0) {
	
					x1--;
	
					i++;
				}



		// שניהם קטנים מאפס
		// איקס ראשון גדול מאפס ואיקס שני קטן מאפס
		// איקס שני גדול מאפס ואיקס ראשון שלילי



		if(x1 == 0 || x2 == 0) {

			return 0;

		}

		int multiplicationResult = 0;

		for(int i = 0; i < x2; i++) {

			multiplicationResult = plus(multiplicationResult, x1);
		
		}

		return multiplicationResult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {

		//זוגי אי זוגי על החזקה -  לבנות מודול שבה אני מחסרת ממספר עד שאני מגיעה לשארית קטנה מהמחלק וזו פונקציה מודול שאני משתמשת בה פה לפונקציה הזאת כדי להחליק אם התוצאה חיובית או שלילית וחזקה של 0 זה 1
		
		if (x == 1 || n == 0) {

			return 1;

		}
		
		if(x == 0) {

			return 0;

		}

		int powResult = 1;

		for (int i = 0; i < n; i++) {

			powResult = times(powResult , x);

		}

		return powResult;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {

		if(x1 == 0) {

			return 0;

		}

		if(x1 == x2) {

			return 1;

		} 

		int divResult = 0;
		
		int minusFordiv = x1;

		while (minusFordiv > x2) {

			minusFordiv = minus(minusFordiv, x2);

			divResult++;

		}
		return divResult;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		int div = div(x1, x2);

		int multiplication = times(div, x2);

		int module = minus(x1, multiplication);

		return module;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		
		int sprt = pow(x, div(1, 2));

		return sprt;
	}	  	  
}