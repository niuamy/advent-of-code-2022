import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCount {
    public static void main(String[] args) {
        int sum = 0;
        List<Integer> calories = new ArrayList<>();

        // https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();

			while (line != null) {
                if (!line.equals("")) {
                    int val = Integer.valueOf(line);
                    sum += val;
                } else {
                    calories.add(sum);
                    sum = 0;
                }
				// read next line
				line = reader.readLine();
			}

			reader.close();

            Collections.sort(calories, Collections.reverseOrder());
            
            int max = 0;

            for (int i = 0; i < 3; i++) {
               max += calories.get(i);
            }

            System.out.println(max);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}