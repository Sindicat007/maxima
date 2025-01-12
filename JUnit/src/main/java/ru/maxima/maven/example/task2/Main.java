package ru.maxima.maven.example.task2;

public class Main {
    public static void main(String[] args) {
        printValues();
    }

    public static void printValues() {
        for (CardSuit cardSuit : CardSuit.values()) {
            System.out.printf("Масть: %s, Цвет: %s %n", cardSuit, cardSuit.getColor());
        }
    }
}
