import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalorieCount {
    public static void main(String[] args) {
        int max = 0;
        int current = 0;

        // https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("input.txt"));
			String line = reader.readLine();

			while (line != null) {
                if (!line.equals("")) {
                    int val = Integer.valueOf(line);
                    current += val;
                } else {
                    max = Math.max(max, current);
                    current = 0;
                }
				// read next line
				line = reader.readLine();
			}

			reader.close();

            System.out.println("Max: " + max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}