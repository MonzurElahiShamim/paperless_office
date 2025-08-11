package Other;


import java.util.*;

public class NumberToWordsConverter {

	private static final String[] units = {"", "এক", "দুই", "তিন", "চার", "পাঁচ", "ছয়", "সাত", "আট", "নয়",
		"দশ", "এগারো", "বারো", "তেরো", "চোদ্দো", "পনেরো", "ষোলো", "সতেরো", "আঠারো", "উনিশ",
		"বিশ", "একুশ", "বাইশ", "তেইশ", "চব্বিশ", "পঁচিশ", "ছাব্বিশ", "সাতাশ", "আটাশ", "উনত্রিশ",
		"ত্রিশ", "একত্রিশ", "বত্রিশ", "তেত্রিশ", "চৌত্রিশ", "পঁয়ত্রিশ", "ছত্রিশ", "সাঁইত্রিশ", "আটত্রিশ", "উনচল্লিশ",
		"চল্লিশ", "একচল্লিশ", "বিয়াল্লিশ", "তেতাল্লিশ", "চুয়াল্লিশ", "পঁয়তাল্লিশ", "ছেচল্লিশ", "সাতচল্লিশ", "আটচল্লিশ", "উনপঞ্চাশ",
		"পঞ্চাশ ", "একান্ন", "বাহান্ন", "তিপ্পান্ন", "চুয়ান্ন", "পঞ্চান্ন", "ছাপ্পান্ন", "সাতান্ন", "আটান্ন", "উনষাট",
		"ষাট", "একষট্টি", "বাষট্টি", "তেষট্টি", "চৌষট্টি ", "পঁয়ষট্টি", "ছেষট্টি", "সাতষট্টি", "আটষট্টি", "উনসত্তর",
		"সত্তর", "একাত্তর", "বাহাত্তর", "তিয়াত্তর", "চুয়াত্তর", "পঁচাত্তর", "ছিয়াত্তর", "সাতাত্তর", "আটাত্তর", "উনআশি",
		"আশি", "একাশি", "বিরাশি", "তিরাশি", "চুরাশি", "পঁচাশি", "ছিয়াশি", "সাতাশি", "আটাশি", "উননব্বই ",
		"নব্বই", "একানব্বই ", "বিরানব্বই ", "তিরানব্বই ", "চুরানব্বই ", "পঁচানব্বই ", "ছিয়ানব্বই", "সাতানব্বই", "আটানব্বই", "নিরানব্বই"};

	private static final String[] thousands = {"", "হাজার", "লাখ", "কোটি"};

	public static String convertToWords(long number) {
		// Base case: if the number is 0, return "শূন্য"
		if (number == 0) {
			return "শূন্য";
		}

		String words = "";

		// Handle negative numbers
		if (number < 0) {
			words = "ঋণাত্মক ";
			number = -number;
		}

		// Convert each group of three digits into words
		int i = 0;
		int div = 1000;
		while (number > 0) {
			if (number % div != 0) {
				words = convertGroupToWords((int) (number % div)) +" "+ thousands[i] + " " + words;
			}
			number /= div;
			i++;
			div = 100;
		}

		return words.trim();
	}

	private static String convertGroupToWords(int number) {
		if (number == 0) {
			return "";
		}

		String words = "";

		// Convert hundreds place
		if (number / 100 > 0) {
			words += units[number / 100] + " শত ";
		}

		// Convert tens and ones place
		int remainder = number % 100;
		if (remainder > 0) {
				words += units[remainder];
			}
		

		return words;
	}

	public static void main(String[] args) {
		long number = 198756;
		String words = convertToWords(number);
		System.out.println("Number in words: " + words);
	}
}
