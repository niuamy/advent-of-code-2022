package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CampCleanup {

    /**
     * Parses the input string based off the input.
     * Ex input string = "12-23,456-678"
     * 
     * @param s input string to parse
     * @return parsed input string as a matrix
     */
    public static int[][] parse(String s) {
        String regex = "(\\d+)-(\\d+),(\\d+)-(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        while (matcher.find()) {
            a = Integer.valueOf(matcher.group(1));
            b = Integer.valueOf(matcher.group(2));
            c = Integer.valueOf(matcher.group(3));
            d = Integer.valueOf(matcher.group(4));
        } 

        return new int[][]{{a,b},{c,d}};
    }

    /**
     * Checks whether one number pair is enclosed in the other.
     * Ex: {[2,3], [1,5]} => true
     * > {[1,2], [3,4]} => false
     * 
     * @param nums the number pairings
     * @return true if one number pairing is enclosed in another, false otherwise
     */
    public static boolean contained(int[][] nums) {
        int a = nums[0][0];
        int b = nums[0][1];
        int c = nums[1][0];
        int d = nums[1][1];

        if (a <= c && b >= d) return true;
        if (c <= a && d >= b) return true;
        return false;
    }

    public static void main(String[] args) {
        BufferedReader reader;

        try {
            int count = 0;
            reader = new BufferedReader(new FileReader("Day4/input.txt"));
            String line = reader.readLine();

            while (line != null) {
                int[][] nums = parse(line);
                if (contained(nums)) count++;
                line = reader.readLine();
            }

            reader.close();
            System.out.println("Total enclosed: " + count);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
