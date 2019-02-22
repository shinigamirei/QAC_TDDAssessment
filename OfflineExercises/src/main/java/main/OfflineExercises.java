package main;

import java.util.ArrayList;
import java.util.List;

public class OfflineExercises {

	// Given a string, return a string where// for every char in the original//
	// string,// there are three chars.// multChar("The") → "TTThhheee"////
	// multChar("AAbb") → "AAAAAAbbbbbb"// multChar("Hi-There") →//
	// "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String multstring = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < 3; j++)
				multstring += input.charAt(i);
		}

		return multstring;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int firstBertEndIndex = 0;
		int lastBertStartIndex = 0;
		int lastBertChecker = 0;

		String capsInput = input.toUpperCase();

		firstBertEndIndex = (capsInput.indexOf("BERT") + 4);
		lastBertStartIndex = capsInput.indexOf("BERT", firstBertEndIndex);
		if (lastBertStartIndex == -1) {
			return "";
		}
		while (lastBertChecker != -1) {
			lastBertChecker = capsInput.indexOf("BERT", lastBertStartIndex + 1);
			if (lastBertChecker != -1)// if another instance of bert is there, change the index of the last bert
				lastBertStartIndex = capsInput.indexOf("BERT", lastBertStartIndex + 1);
		}
		
		String regularBert = input.substring(firstBertEndIndex, lastBertStartIndex);
		
		String reverseBert = "";
		
		for (int i = 1; i <= regularBert.length(); i++) {
			reverseBert += (regularBert.charAt(regularBert.length() - i ));
		}
			

		return reverseBert;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {

		int largest = 0;
		int mid = 0;
		int smallest = 0;

		if (a > b && a > c) {
			largest = a;
		} else if (a < b && a < c) {
			smallest = a;
		} else {
			mid = a;
		}

		if (b > a && b > c) {
			largest = b;
		} else if (b < a && b < c) {
			smallest = b;
		} else {
			mid = b;
		}

		if (c > a && c > b) {
			largest = c;
		} else if (c < b && c < a) {
			smallest = c;
		} else {
			mid = c;
		}
		if (largest - mid == mid - smallest)
			return true;
		else
			return false;
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {

		int sideLengths = (input.length() - a) / 2;
		String front = input.substring(0, sideLengths);
		String end = input.substring(input.length() - (sideLengths), input.length());
		String result = front.concat(end);

		return result;
	}

	// Given a string, return true if it ends in "dev". Ignore Case////
	// endsDev("ihatedev") → true// endsDev("wehateDev") → true////
	// endsDev("everoyonehatesdevforreal") → false// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {

		if (input.charAt(input.length() - 1) == 'v' || input.charAt(input.length() - 1) == 'V')
			if (input.charAt(input.length() - 2) == 'e' || input.charAt(input.length() - 2) == 'E')
				if (input.charAt(input.length() - 3) == 'd' || input.charAt(input.length() - 3) == 'D')
					return true;
		return false;

	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {

		int largest = 0;
		int currentBlock = 0;
		char currentChar = ' ';

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == currentChar)
				currentBlock++;
			else {
				currentChar = input.charAt(i);
				if (currentBlock > largest)
					largest = currentBlock;
				currentBlock = 1;
			}
		}

		return largest;

	}

	// given a string - return the number of times "am" appears in the String//
	// ignoring case -// BUT ONLY WHEN the word "am" appears without being followed
	// or proceeded by// other letters//// amISearch("Am I in Amsterdam") → 1//
	// amISearch("I am in Amsterdam am I?") → 2// amISearch("I have been in
	// Amsterdam") → 0

	public int amISearch(String arg1) {// this gets ugly
		int count = 0;

		for (int i = 0; i < arg1.length(); i++) {
			if (arg1.charAt(i) == 'a' || arg1.charAt(i) == 'A') {
				try {
					if (arg1.charAt(i + 1) == 'm' || arg1.charAt(i + 1) == 'M') {
						try {
							if (arg1.charAt(i - 1) == ' ') {
								try {
									if (arg1.charAt(i + 2) == ' ')
										count++;
								} catch (StringIndexOutOfBoundsException e) {
									count++;// Electively a space
								}
							}
						} catch (StringIndexOutOfBoundsException e) {
							try {
								if (arg1.charAt(i + 2) == ' ')
									count++;
							} catch (StringIndexOutOfBoundsException f) {
								count++;// Electively a space
							}
						}
					}
				} catch (StringIndexOutOfBoundsException e) {
					// count won increase as no value after a
				}
			}
		}
		return count;
	}

	// given a number// if this number is divisible by 3 return "fizz"// if this
	// number is divisible by 5 return "buzz"// if this number is divisible by both
	// 3 and 5return "fizzbuzz"// fizzBuzz(3) → "fizz"// fizzBuzz(10) → "buzz"//
	// fizzBuzz(15) → "fizzbuzz"

	public String fizzBuzz(int arg1) {

		if (arg1 % 3 == 0) {

			if (arg1 % 5 == 0) {
				return "fizzbuzz";
			}
			return "fizz";
		} else if (arg1 % 5 == 0)
			return "buzz";

		return null;

	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") → 14
	// largest("15 72 80 164") → 11
	// largest("555 72 86 45 10") → 15

	public int largest(String arg1) {
		List<Integer> values = new ArrayList<Integer>();
		int highest = 0;
		int current = 0;
		String[] split = arg1.split(" ");

		for (int i = 0; i < split.length; i++) {
			current = 0;
			for (int j = 0; j < split[i].length(); j++) {
				if (split[i].charAt(j) == '1')
					current += 1;
				else if (split[i].charAt(j) == '2')
					current += 2;
				else if (split[i].charAt(j) == '3')
					current += 3;
				else if (split[i].charAt(j) == '4')
					current += 4;
				else if (split[i].charAt(j) == '5')
					current += 5;
				else if (split[i].charAt(j) == '6')
					current += 6;
				else if (split[i].charAt(j) == '7')
					current += 7;
				else if (split[i].charAt(j) == '8')
					current += 8;
				else if (split[i].charAt(j) == '9')
					current += 9;
				else if (split[i].charAt(j) == '0')
					current += 0;
			}
			if (current > highest)
				highest = current;
		}
		return highest;
	}

}
