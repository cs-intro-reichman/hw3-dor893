/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		String oneString = preProcesswithoutspaces(str1);

		String twoString = preProcesswithoutspaces(str2);

		boolean anagram = false;

		if(oneString.length() == 0 && twoString.length() == 0) {

			anagram = true;
		}

		if (oneString.length() != twoString.length()) {

			anagram = false;

		} else {

			for(int i = 0; i < oneString.length(); i++){

				char charOne = oneString.charAt(i);
		
		     while (twoString.length() > 0) {

			    for(int t = 0; t < twoString.length(); t++) {

				    if(twoString.charAt(t) == charOne) {

						twoString = twoString.substring(0, t) + twoString.substring(t + 1); // delete the tested char

					    anagram = true;

				    }
			    }
		     }
		    }
		}

		return anagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) { 

		String newString = "";

		for(int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			int asciiOfchar = c;

				if(asciiOfchar >= 65 && asciiOfchar <= 90) { // upper case

					c = (char) (c + 32);

					newString += c;
				
				} else if ((asciiOfchar >= 97 && asciiOfchar <= 122) || asciiOfchar == 32) { //lower case or tab

					newString += c;
				}
		}
	return newString;
	
	} 

	public static String preProcesswithoutspaces(String str) { 

		String newString = "";

		for(int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			int asciiOfchar = c;

				if(asciiOfchar >= 65 && asciiOfchar <= 90) { // upper case

					c = (char) (c + 32);

					newString += c;
				
				} else if (asciiOfchar >= 97 && asciiOfchar <= 122) { //lower case or tab

					newString += c;
				}
		}
	return newString;
	
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		String remainingString = preProcesswithoutspaces(str);

		String anagram = "";

		while (remainingString.length() > 0) {

		int randomIndex = (int) (Math.random() * remainingString.length()); 

		char c = remainingString.charAt(randomIndex);

		anagram += c;

		remainingString = remainingString.substring(0, randomIndex) + remainingString.substring(randomIndex + 1);
	    
	    }

    return anagram;
	
	}
}
