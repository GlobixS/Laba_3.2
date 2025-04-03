package com.itproger;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текстовий рядок:");
        String input = scanner.nextLine();
        scanner.close();

        int uppercaseCount = countUppercaseLetters(input);
        System.out.println("Кількість великих літер: " + uppercaseCount);

        List<String> shortestWords = findShortestWords(input);
        System.out.println("Слова з найменшою кількістю літер: " + shortestWords);

        String modifiedText = removeLowercaseWords(input);
        System.out.println("Текст після видалення слів, що починаються з малої літери:");
        System.out.println(modifiedText);
    }

    public static int countUppercaseLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> findShortestWords(String text) {
        String[] words = text.split("\\s+");
        int minLength = Integer.MAX_VALUE;
        List<String> shortestWords = new ArrayList<>();

        for (String word : words) {
            int length = word.length();
            if (length < minLength) {
                minLength = length;
                shortestWords.clear();
                shortestWords.add(word);
            } else if (length == minLength) {
                shortestWords.add(word);
            }
        }
        return shortestWords;
    }

    public static String removeLowercaseWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!Character.isLowerCase(word.charAt(0))) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }
}
