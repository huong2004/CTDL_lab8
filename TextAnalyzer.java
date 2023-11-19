package lab8_map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		// TODO

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;

			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				String word = tokens.nextToken();

				if (!tokens.hasMoreTokens()) {
					add(word, -index);
				} else {
					add(word, index);
				}

				index++;
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if (map.containsKey(word)) {
			ArrayList<Integer> values = map.get(word);
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);
		}

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		// TODO
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		// TODO
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String word = entry.getKey();
			ArrayList<Integer> positions = entry.getValue();

			System.out.print("Word: " + word + ", Positions: ");

			for (Integer position : positions) {
				System.out.print(position + " ");
			}

			System.out.println();
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		// TODO
		int max = 0;
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> positions = entry.getValue();
			int occurrences = positions.size();

			if (occurrences > max) {
				max = occurrences;
				sb.setLength(0);
				sb.append(entry.getKey());
			} else if (occurrences == max) {
				sb.append(", ").append(entry.getKey());
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) throws IOException {
		final String fileName = "data1/fit.txt";

		TextAnalyzer obj = new TextAnalyzer();
		obj.load(fileName);

		obj.displayWords();
		obj.displayText();
		System.out.println(obj.mostFrequentWord());

	}
}
