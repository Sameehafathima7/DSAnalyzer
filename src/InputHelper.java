
import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    // Keeps asking until the user types a valid whole number
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }
}
