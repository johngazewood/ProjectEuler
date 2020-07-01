package problem21thru30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import utility.Print;

public class Problem22 {

	public static void main(String[] args) {
		
		System.out.println("value of COLIN = " + (((int) 'C') - 64));
		System.out.println("value of COLIN = " + (((int) 'O') - 64));
		System.out.println("value of COLIN = " + stringToLong("COLIN"));
		LinkedList<String> names = readInNames();
		long answer = scoreNames(names);
		Print.answer(answer);
	}

	static long scoreNames(LinkedList<String> names) {
		long sum = 0;
		Collections.sort(names);
		for (int index = 0; index < names.size(); index++) {
			long value = stringToLong(names.get(index));
			sum += (value * (index+1));
		}
		
		return sum;
	}

	static long stringToLong(String string) {
		long value = 0;
		for (int index = 0; index < string.length(); index++) {
			char c = string.charAt(index);
			value += ((int) c) - 64;
		}
		
		return value;
	}

	static LinkedList<String> readInNames() {
		File file = new File("src/main/resources/names.txt");
		LinkedList<String> names = new LinkedList<String>();
		String string = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				string = string+scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		string = string.replace("\"", "");
		names.addAll(Arrays.asList(string.split(",")));
		
		return names;
	}

}
