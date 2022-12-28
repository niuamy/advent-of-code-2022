package Day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Rucksack {

    /**
     *  Populate mapping of characters to their point value based on problem statement.
     *  a -> 1
     *  b -> 2
     *  ...
     *  z -> 26
     *  A -> 27
     *  ...
     *  Z -> 52
     * 
     * @return populated map
     */
    public static Map<Character, Integer> populateMap() {
        Map<Character, Integer> map = new HashMap<>();
        String s = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < s.length(); i++) {
            // a -> 97
            map.put(s.charAt(i), s.charAt(i) - 96);
            // A -> 65
            // A - 64 + 26
            map.put(Character.toUpperCase(s.charAt(i)), Character.toUpperCase(s.charAt(i)) - 64 + 26);
        }

        return map;
    }

    /**
     *  Find character that is repeated in both the first and second half of the string.
     * 
     * @param s original string
     * @return duplicate character
     */
    public static char findDuplicateChar(String s) {
        if (s == null) return ' ';

        int start = 0;
        int end = s.length();
        int mid = start + (end - start) / 2;

        String a = s.substring(0, mid);
        String b = s.substring(mid);

        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) != -1) return a.charAt(i);
        }

        return ' ';
    }

    /**
     * Find duplicate character between 3 strings.
     * 
     * @param a first string
     * @param b second string
     * @param c third string
     * @return duplicate character
     */
    public static char findDuplicateChar(String a, String b, String c) {
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (b.indexOf(ch) != -1 && c.indexOf(ch) != -1) return ch;
        }

        return ' ';
    }

    public static void main(String[] args) {
        BufferedReader reader;

		try {
            Map<Character, Integer> map = populateMap();
            int total = 0;
			reader = new BufferedReader(new FileReader("Day3/input.txt"));
			String line = reader.readLine();

            while (line != null) {
                String line2 = reader.readLine();
                String line3 = reader.readLine();
                char c = findDuplicateChar(line, line2, line3);
                int points = map.getOrDefault(c, 0);
                total += points;
                line = reader.readLine();
            }

            reader.close();
            System.out.println("Total: " + total);

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
