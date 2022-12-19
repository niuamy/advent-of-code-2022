package Day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RockPaperScissors {

    /**
     * Converts the move to an int where:
     * Rock == A == X == 1
     * Paper == B == Y == 2
     * Scissors == C == Z == 3
     * 
     * @param c the move to convert
     * @return the move as an int
     */
    public static int getMove(char c) {
        if (c == 'A' || c == 'X') return 1;
        if (c == 'B' || c == 'Y') return 2;
        return 3;
    }

    /**
     * Gets the result of the match such that:
     * win = 1
     * tie = 0
     * lose = -1
     * 
     * @param opponent the opponents move
     * @param user the users move
     * @return the result of the match
     */
    public static int getResult(int opponent, int user) {
        if (opponent == user) return 0;
        if (opponent == 1 && user == 3) return -1;
        if (opponent == 2 && user == 1) return -1;
        if (opponent == 3 && user == 2) return -1;
        return 1; 
    }

    /**
     * Gets the point count based on result of match and player's move.
     * 
     * @param win whether the player won the game
     * @param move which move the player played
     * @return the total point value earned by the player in this turn
     */
    public static int getPoints(int win, int move) {
        int total = move;
        if (win == 1) total += 6;
        if (win == 0) total += 3;
        return total;
    }

    public static void main(String[] args) {
		BufferedReader reader;

		try {
            int total = 0;
			reader = new BufferedReader(new FileReader("Day2/input.txt"));
			String line = reader.readLine();

            while (line != null) {
                int opponent = getMove(line.charAt(0));
                int user = getMove(line.charAt(2));
                int win = getResult(opponent, user);
                total += getPoints(win, user);
                line = reader.readLine();
            }

            reader.close();
            System.out.println("Total points: " + total);

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
