import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NewLanguageConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        String inputString = scanner.nextLine();
        scanner.close();

        if (hasDuplicateCharacters(sequence)) {
            System.out.println("New Language Error");
        } else {
            String convertedString = convertToNewLanguage(sequence, inputString);
            System.out.println(convertedString);
        }
    }

    private static boolean hasDuplicateCharacters(String sequence) {
        Set<Character> seen = new HashSet<>();
        for (char c : sequence.toCharArray()) {
            if (!seen.add(c)) {
                return true; // Duplicate character found
            }
        }
        return false; // No duplicate characters
    }

    private static String convertToNewLanguage(String sequence, String inputString) {
        Map<Character, Integer> charToPosition = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // Populate charToPosition map with the sequence
        for (int i = 0; i < sequence.length(); i++) {
            charToPosition.put(sequence.charAt(i), i);
        }

        for (char c : inputString.toCharArray()) {
            // Ignore spaces
            if (c == ' ') {
                result.append(' ');
            } else if (charToPosition.containsKey(Character.toLowerCase(c))) {
                // Convert the character based on its position in the sequence
                int position = charToPosition.get(Character.toLowerCase(c));
                char newChar = sequence.charAt(position);
                result.append(Character.isUpperCase(c) ? Character.toUpperCase(newChar) : newChar);
            }
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "NewLanguageConverter []";
    }
}