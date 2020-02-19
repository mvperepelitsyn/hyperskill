import javax.annotation.processing.SupportedSourceVersion;
import javax.print.attribute.standard.JobKOctets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;

import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;


import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.util.HashMap;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

// 928-449-8466 374-366-9058
// 374-366-9058

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, n, k;
		Random theThing = new Random();
		a = scan.nextInt();
		b = scan.nextInt();
		n = scan.nextInt();
		k = scan.nextInt();
		int overallMinMax = Integer.MAX_VALUE;
		int minimalSeed = -1;
		HashMap<Integer, Integer> map= new HashMap<>();
		for (int i = a, max, l = 0; i <= b; i++, l++) {
			max = 0;
			theThing.setSeed(i);
			for (int j = 0, tmp; j < n; j++) {
				tmp = theThing.nextInt(k);
				if (tmp > max) {
					max = tmp;
				}
			}
			map.put(i, max);
		}
		for (var elem : map.entrySet()) {
			if (elem.getValue() < overallMinMax) {
				overallMinMax = elem.getValue();
				minimalSeed = elem.getKey();
			}
		}
		System.out.println(minimalSeed + "\n" + overallMinMax);

	}
}

//public class Main {
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		LinkedHashMap<String, String> flashCard = new LinkedHashMap<>();
//		System.out.println(1 | 2 >> 3);
//		System.out.println("Input the number of cards:");
//		int size = Integer.parseInt(scan.nextLine());
//		String tmpKey = null, tmpValue;
//		for (int i = 0; i < size; i++) {
//			System.out.println("The card #" + (i + 1) + ":");
//			outerloop:
//			while (true) {
//				tmpKey = scan.nextLine();
//				if (!flashCard.containsKey(tmpKey)) {
//					System.out.println("The definition of the card #" + (i + 1) + ":");
//					while (true) {
//						tmpValue = scan.nextLine();
//						if (!flashCard.containsValue(tmpValue)) {
//							flashCard.put(tmpKey, tmpValue);
//							break outerloop;
//						} else {
//							System.out.println("The definition \"" + tmpValue + "\" already exists. Try again:");
//						}
//					}
//				} else {
//					System.out.println("The card \"" + tmpKey + "\" already exists. Try again:");
//				}
//			}
//		}
//		for (var elem : flashCard.entrySet()) {
//			System.out.println("Print the definition of \"" + elem.getKey() + "\":");
//			tmpValue = scan.nextLine();
//			if (tmpValue.equals(elem.getValue())) {
//				System.out.println("Correct answer.");
//			} else if (flashCard.containsValue(tmpValue)) {
//				for (var element : flashCard.entrySet()) {
//					if (element.getValue().equals(tmpValue)) {
//						tmpKey = element.getKey();
//						break;
//					}
//				}
//				System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\", you've just " +
//						"written the definition of \"" + tmpKey + "\".");
//			} else {
//				System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\".");
//			}
//		}
//
////		FlashCard[] flashCards = new FlashCard[size];
////		for (int i = 0; i < size; i++) {
////			flashCards[i] = new FlashCard();
////			System.out.println("The card #" + (i + 1) + ":");
////			flashCards[i].setMeaning(scan.nextLine());
////			System.out.println("The definition of the card #" + (i + 1) + ":");
////			flashCards[i].setDefin(scan.nextLine());
////		}
////		for (int i = 0; i < size; i++) {
////			System.out.println("Print the definition of \"" + flashCards[i].getMeaning() + "\":");
////			if (scan.nextLine().equals(flashCards[i].getDefin())) {
////				System.out.println("Correct answer.");
////			} else {
////				System.out.println("Wrong answer. The correct one is \"" + flashCards[i].getDefin() + "\".");
////			}
////		}
//	}
//}