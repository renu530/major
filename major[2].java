import java.security.SecureRandom;
import java.util.Scanner;

public class major {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Study Comrade Password Services :)");
            System.out.println("Enter 1 - Password Generator");
            System.out.println("Enter 2 - Password Strength Check");
            System.out.println("Enter 3 - Useful Information");
            System.out.println("Enter 4 - Quit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    generatePassword(scanner);
                    break;
                case 2:
                    // Placeholder for password strength check
                    System.out.println("Password Strength Check feature is not implemented in this version.");
                    break;
                case 3:
                    displayUsefulInformation();
                    break;
                case 4:
                    System.out.println("Closing the program bye bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    private static void generatePassword(Scanner scanner) {
        System.out.println("Hello, welcome to the Password Generator :) answer the following questions by Yes or No");

        boolean includeLowercase = getYesNoInput(scanner, "Do you want Lowercase letters \"abcd...\" to be used?");
        boolean includeUppercase = getYesNoInput(scanner, "Do you want Uppercase letters \"ABCD...\" to be used?");
        boolean includeNumbers = getYesNoInput(scanner, "Do you want Numbers \"1234...\" to be used?");
        boolean includeSymbols = getYesNoInput(scanner, "Do you want Symbols \"!@#$...\" to be used?");

        System.out.print("Great! Now enter the length of the password: ");
        int length = scanner.nextInt();

        String password = generateRandomPassword(includeLowercase, includeUppercase, includeNumbers, includeSymbols, length);
        System.out.println("Your generated password -> " + password);
    }

    private static boolean getYesNoInput(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes");
    }

    private static String generateRandomPassword(boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols, int length) {
        StringBuilder characters = new StringBuilder();
        if (includeLowercase) characters.append(LOWERCASE);
        if (includeUppercase) characters.append(UPPERCASE);
        if (includeNumbers) characters.append(DIGITS);
        if (includeSymbols) characters.append(SYMBOLS);

        if (characters.length() == 0) {
            return "No character types selected!";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    private static void displayUsefulInformation() {
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences, usernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }
}

