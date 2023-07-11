package word.counter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = getInputFromUser(scanner);
        int totalWords = countWords(input);
        System.out.println("Total words: " + totalWords);
        scanner.close();
    }

    public static String getInputFromUser(Scanner scanner) {
        System.out.println("Enter text or provide the path to a file:");
        String input = "";

        // Read user input
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine().trim();

            // Check if user input is a valid file path
            File file = new File(userInput);
            if (file.isFile()) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    StringBuilder fileContent = new StringBuilder();
                    while (fileScanner.hasNextLine()) {
                        fileContent.append(fileScanner.nextLine()).append("\n");
                    }
                    input = fileContent.toString();
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            } else {
                input = userInput;
            }
        }

        return input;
    }

    public static int countWords(String input) {
        // Split input into an array of words using space or punctuation as delimiters
        String[] words = input.split("[\\p{Space}\\p{Punct}]+");
        int wordCount = words.length;

        return wordCount;
    }
}
