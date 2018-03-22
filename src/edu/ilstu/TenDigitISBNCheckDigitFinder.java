package edu.ilstu;

import java.util.Scanner;

/**
 * This program finds the check digit for a ten digit ISBN number given the first nine relevant digits of the ISBN number. 
 * 
 * @author Christopher Runyan
 */
public class TenDigitISBNCheckDigitFinder {
	static String returnCheckDigitGivenNineDigitISBNFragment(String nineDigitISBNFragment) {
		String toReturn = "E";
		int totalBeforeCheckDigit = 0;
		
		if(nineDigitISBNFragment.length() == 9) {
			for(int i=0, j = 10; i<9; i++, j--) {
				totalBeforeCheckDigit += (Integer.parseInt(Character.toString(nineDigitISBNFragment.charAt(i))) * j);
			}
			
			int checkDigit = 11-(totalBeforeCheckDigit%11);
			if(checkDigit == 10) {
				return "X";
			}
			else {
				return Integer.toString(checkDigit);
			}
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String input="";
		
		System.out.print("Enter the first nine digits of the ISBN number to find the tenth number, which is a check digit: ");
		input = kb.nextLine();
		
		try {
			Double.parseDouble(input);
			
			if(input.length() == 9) {
				String checkDigit = returnCheckDigitGivenNineDigitISBNFragment(input);
				
				if(!checkDigit.equals("E")) {
					System.out.println("Check digit: " + checkDigit);
					System.out.println("Full ISBN: " + input + checkDigit);
				}
				else {
					System.out.println("An unknown error has occurred.");
				}
			}
			else {
				System.out.println("Invalid input (improper length).");
			}
		}
		catch(Exception e) {
			System.out.println("Invalid input (not integers).");
			System.exit(1);
		}
		
		kb.close();
	}
}
