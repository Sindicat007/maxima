package javaCollectionAPI.task4;

import java.util.*;

/**
 * 4. Разработать программу для анализа текста
 * <p>
 * Задача:
 * Создайте программу, которая анализирует текст и выполняет следующие действия:
 * <p>
 * Выводит уникальные слова.++
 * <p>
 * Находит и выводит самые часто встречающиеся слова.
 * <p>
 * Считает и выводит частоту встречаемости каждого слова.++
 * <p>
 * Требования к реализации:
 * <p>
 * Программа должна считывать текст из файла или консоли.
 * <p>
 * Используйте HashMap для подсчета частоты слов. Ключ — слово, значение — количество его вхождений.
 * <p>
 * Для вывода уникальных слов используйте Set.
 * <p>
 * Реализуйте метод для нахождения самых часто встречающихся слов.
 */

public class TextAnalyzator {
    Map<String, Integer> wordsToCount;
    String[] s;

    public TextAnalyzator(String text) {
        this.s = textFormat(text.toLowerCase());
        this.wordsToCount = new HashMap<>();
    }

    public void startAnalyze() {
        wordsCounter();
        uniqueWords();
        maxEntryWords();
    }

    private void wordsCounter() {
        if (s.length == 0) {
            System.out.println("Список слов пуст");
            return;
        }
        for (String str : s) {
            if (wordsToCount.containsKey(str)) {
                wordsToCount.put(str, wordsToCount.get(str) + 1);
            } else {
                wordsToCount.put(str, 1);
            }
        }
        System.out.printf("Частота слов: %n");
        for (Map.Entry<String, Integer> entry : wordsToCount.entrySet()) {
            System.out.printf("%s %d %n", entry.getKey(), entry.getValue());
        }
    }

    private void maxEntryWords() {
        if (wordsToCount.isEmpty()) {
            System.out.println("Список слов пуст");
            return;
        }
        int maxWordsInList = Collections.max(wordsToCount.values());
        System.out.println("Самые частые слова: ");
        for (Map.Entry<String, Integer> word : wordsToCount.entrySet()) {
            if (word.getValue() == maxWordsInList) {
                System.out.printf("%s: %d ", word.getKey(), word.getValue());
            }
        }
    }

    private void uniqueWords() {
        Set<String> uniqueWords = wordsToCount.keySet();
        System.out.printf("Уникальные слова: %s %n", uniqueWords);
    }

    private static String[] textFormat(String words) {
        if (words.isEmpty()) {
            return new String[0];
        }
        String[] result;
        String s;
        s = words.replaceAll("[^A-Za-zА-Яа-я]", " ").trim();
        result = s.split(" {1,}");
        return result;
    }
}
