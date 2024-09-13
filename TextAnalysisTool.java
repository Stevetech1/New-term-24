import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalysisTool {
    public static void main(String[] args) {
        // Step 1: User input - Ask for a paragraph or lengthy text.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph or lengthy text: ");
        String text = scanner.nextLine().toLowerCase(); // Make the text case-insensitive

        // Step 2: Character count - Total number of characters
        int characterCount = text.length();
        System.out.println("Total number of characters: " + characterCount);

        // Step 3: Word count - Split the text into words by spaces
        String[] words = text.split("\\s+"); // Split by whitespace
        int wordCount = words.length;
        System.out.println("Total number of words: " + wordCount);

        // Step 4: Most common character
        Map<Character, Integer> charFrequency = new HashMap<>();
        char mostCommonChar = ' ';
        int maxFrequency = 0;

        for (char c : text.toCharArray()) {
            if (c != ' ') { // Ignore spaces
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                if (charFrequency.get(c) > maxFrequency) {
                    maxFrequency = charFrequency.get(c);
                    mostCommonChar = c;
                }
            }
        }
        System.out.println("Most common character: " + mostCommonChar);

        // Step 5: Character frequency - Ask for a character input
        System.out.println("Enter a character to check its frequency: ");
        char inputChar = scanner.nextLine().toLowerCase().charAt(0);
        int inputCharFrequency = charFrequency.getOrDefault(inputChar, 0);
        System.out.println("Frequency of '" + inputChar + "': " + inputCharFrequency);

        // Step 6: Word frequency - Ask for a word input
        System.out.println("Enter a word to check its frequency: ");
        String inputWord = scanner.nextLine().toLowerCase();
        int wordFrequency = 0;
        for (String word : words) {
            if (word.equals(inputWord)) {
                wordFrequency++;
            }
        }
        System.out.println("Frequency of '" + inputWord + "': " + wordFrequency);

        // Step 7: Unique words - Using a set to find unique words
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Number of unique words: " + wordFrequencyMap.size());
        
        // Closing the scanner resource
        scanner.close();
    }
}
