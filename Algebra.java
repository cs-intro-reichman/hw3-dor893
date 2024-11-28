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
		System.out.println("times test : " + times(3, 4));
		System.out.println("div cheak: " + div(12, 3));
		System.out.println("div cheak: " + div(-15, 3));
	
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

		int time = 0;

		int abs = 0;

		if(x1 == 0 || x2 == 0) {

			return 0;

		}

		if(x1 == 1 && x2 == 1) {

			return 1;
		}

		if(x1 > 0 && x2 > 0) {

			for(int j = 0; j < x2; j++) {

				time = plus(time, plus(0, x1));
			}
		abs = time;
		}

		if(x1 < 0 && x2 > 0) {

			for(int j = 0; j < x2; j++) {

				time = plus(time, plus(0, x1));

		    }
		abs = time;
		}

		if(x1 > 0 && x2 < 0) {

			for(int j = 0; j < x1; j++) {

				time = plus(time, plus(0, x2));
	
			}
		abs = time;
		}

		if(x1 < 0 && x2 < 0) {

			for(int j = x2; j < 0; j++){

				time = plus(time, plus(0, x1));
			}
		abs = minus(0, time);
		}

	return abs;
			
	} 


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		
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

		int counter = 0;

		int divResult = 0;

		if(x1 > 0 && x2 < 0) {

			int calc = x1;

			int twoX = minus(0, x2);

			while (calc > twoX) {

				calc = minus(calc, minus(0, x2));

				counter++;
	
			}
		divResult = minus(0, counter);
	    }

		if(x1 < 0 && x2 > 0) { 

			int oneX = minus(0, x1);

			int calc = oneX;

			while (calc >= x2) {

				calc = minus(calc,x2);

				counter++;	
	
			}
		divResult = minus(0, counter);
	    }

		if(x1 > 0 && x2 > 0) {

			int calc = x1;

			while (calc >= x2) {

				calc = minus(calc, x2);

				counter++;
	
			}
		divResult = counter;
	    }

		if(x1 < 0 && x2 < 0) { 

			int oneX = minus(0, x1);

			int twoX = minus(0, x2);

			int calc = oneX;

			while (calc >= twoX) {

				calc = minus(calc,twoX);

				counter++;	
	
			}
		divResult = counter;
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
		
	int left = 0;
    
	int right = x;

	int result = 0;

    while (left <= right) {
        
		int mid = (left + right) / 2;
        
		int midSprt = times(mid, mid);


        if (midSprt == x) {
            
			return mid;
        }

        else if (midSprt < x) {
            
			left = mid + 1;

			result = mid;
            
        }

        else {
            
			right = mid - 1;
        }
    }

    return result;
}
}
