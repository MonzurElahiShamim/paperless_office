/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Other;

import java.util.HashMap;

/**
 *
 * @author Monzur Elahi Shamim
 */
public class Converter {

	// HashMap for English to Bangla
	private static final HashMap<Character, Character> banglaNumeralsMap = new HashMap<>();

	static {
		// Populate the map with English to Bangla numeral mappings
		banglaNumeralsMap.put('0', '\u09E6');
		banglaNumeralsMap.put('1', '\u09E7');
		banglaNumeralsMap.put('2', '\u09E8');
		banglaNumeralsMap.put('3', '\u09E9');
		banglaNumeralsMap.put('4', '\u09EA');
		banglaNumeralsMap.put('5', '\u09EB');
		banglaNumeralsMap.put('6', '\u09EC');
		banglaNumeralsMap.put('7', '\u09ED');
		banglaNumeralsMap.put('8', '\u09EE');
		banglaNumeralsMap.put('9', '\u09EF');
	}

	// HashMap for Bangla to English
	private static final HashMap<Character, Character> englishNumeralsMap = new HashMap<>();

	static {
		// Populate the map with Bangla to English numeral mappings
		englishNumeralsMap.put('\u09E6', '0');
		englishNumeralsMap.put('\u09E7', '1');
		englishNumeralsMap.put('\u09E8', '2');
		englishNumeralsMap.put('\u09E9', '3');
		englishNumeralsMap.put('\u09EA', '4');
		englishNumeralsMap.put('\u09EB', '5');
		englishNumeralsMap.put('\u09EC', '6');
		englishNumeralsMap.put('\u09ED', '7');
		englishNumeralsMap.put('\u09EE', '8');
		englishNumeralsMap.put('\u09EF', '9');
	}

	public static String toBanglaNumerals(String englishNumerals) {
		StringBuilder banglaNumerals = new StringBuilder();
		for (char digit : englishNumerals.toCharArray()) {
			// Convert each English digit to Bangla numeral
			if (Character.isDigit(digit) && banglaNumeralsMap.containsKey(digit)) {
				banglaNumerals.append(banglaNumeralsMap.get(digit));
			} else {
				// If the character is not a digit, keep it as is
				banglaNumerals.append(digit);
			}
		}
		return banglaNumerals.toString();
	}

	public static String toEnglishNumerals(String banglaNumerals) {
		StringBuilder englishNumerals = new StringBuilder();
		for (char digit : banglaNumerals.toCharArray()) {
			// Convert each Bangla numeral to English digit
			if (englishNumeralsMap.containsKey(digit)) {
				englishNumerals.append(englishNumeralsMap.get(digit));
			} else {
				// If the character is not a Bangla numeral, keep it as is
				englishNumerals.append(digit);
			}
		}
		return englishNumerals.toString();
	}

}
