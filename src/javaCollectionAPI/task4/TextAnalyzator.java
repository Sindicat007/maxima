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
    Map<String, Integer> map;
    String[] s;

    public TextAnalyzator(String text) {
        this.s = textFormat(text.toLowerCase());
        this.map = new HashMap<>();
    }

    public void startAnalyze() {
        wordsCounter();
        UniqueWords();
        maxEntry();
    }

    private void wordsCounter() {
        if (s.length != 0) {
            for (String str : s) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            System.out.printf("Частота слов: %n");
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.printf("%s %d %n", entry.getKey(), entry.getValue() );
            }
        } else System.out.println("Список слов пуст");
    }

    private void maxEntry() {
        if (!map.isEmpty()) {
            int bufferMax = Collections.max(map.values());
            StringBuilder maxWord = new StringBuilder();
            for (Map.Entry<String, Integer> valMax : map.entrySet()) {
                if (valMax.getValue() == bufferMax) {
                    maxWord.append(valMax.getKey()).append(": ").append(bufferMax).append(" ");
                }
            }
            System.out.printf("Самые частые слова: %s %n", maxWord);
        } else System.out.println("Список слов пуст");
    }

    private void UniqueWords() {
        Set<String> uniqueWords = map.keySet();
        System.out.printf("Уникальные слова: %s %n", uniqueWords);
    }

    private static String[] textFormat(String words) {
        String[] result;
        String s;
        if (words.isEmpty()) {
            return new String[0];
        }
        s = words.replaceAll("[^A-Za-zА-Яа-я]", " ").trim();
        result = s.split(" {1,}");
        return result;
    }
}
