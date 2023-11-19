package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data1/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		// TODO
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNext()) {
			String word = sc.next();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		// TODO
		return this.map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
		System.out.println(map.entrySet());

	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
		Map<String, Integer> re = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		re.putAll(map);
		System.out.println(re);

	}

	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp obj = new MyWordCountApp();
		obj.loadData();
		System.out.println(obj.countUnique());
		obj.printWordCounts();
		obj.printWordCountsAlphabet();
	}
}
